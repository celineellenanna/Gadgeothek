package coolio.gadgeothek;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;

public class LoginFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText name = (EditText) root.findViewById(R.id.mailInput);
        final EditText password = (EditText) root.findViewById(R.id.passwordInput);
        root.findViewById(R.id.loginbutton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                LibraryService.login(name.getText().toString(), password.getText().toString(), new Callback<Boolean>() {
                    @Override
                    public void onCompletion(Boolean input) {
                        Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_SHORT).show();

                        MainActivity activity = (MainActivity) getActivity();
                        activity.switchTo(new GadgetFragment());
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(getActivity(),"Login failed",Toast.LENGTH_SHORT).show();
                    }
                });
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

}
