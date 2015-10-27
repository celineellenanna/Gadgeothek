package coolio.gadgeothek;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;


public class RegistrationFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public RegistrationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_registration, container, false);
        final EditText name = (EditText) root.findViewById(R.id.nameinput);
        final EditText email = (EditText) root.findViewById(R.id.emailinput);
        final EditText studentid = (EditText) root.findViewById(R.id.studentidinput);
        final EditText password1 = (EditText) root.findViewById(R.id.password1input);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            if(!isValidEmail(s.toString()))
            {
                email.setError("E-Mail address not valid!");
            }
            }
        });
        password1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() < 8 ){
                    password1.setError("Password is to short!");
                }
            }
        });



        root.findViewById(R.id.registerbutton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LibraryService.register(email.getText().toString(), password1.getText().toString(), name.getText().toString(), studentid.getText().toString(), new Callback<Boolean>() {
                    @Override
                    public void onCompletion(Boolean input) {
                        Toast.makeText(getActivity(), "Registration successful", Toast.LENGTH_SHORT).show();

                        MainActivity activity = (MainActivity) getActivity();
                        activity.switchTo(new LoginFragment());
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(getActivity(),"Registration failed",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        root.findViewById(R.id.resetbutton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                name.setText("");
                email.setText("");
                password1.setText("");
                studentid.setText("");

            }
        });
        return root;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }



}
