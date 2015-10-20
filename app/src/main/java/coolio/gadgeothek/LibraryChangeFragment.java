package coolio.gadgeothek;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import ch.hsr.mge.gadgeothek.service.LibraryService;


public class LibraryChangeFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

     public LibraryChangeFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_library_change, container, false);
        final Button button = (Button) view.findViewById(R.id.submit_library);
        final EditText text = (EditText) view.findViewById(R.id.library_text);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                LibraryService.setServerAddress(text.getText().toString());
                Toast toast = Toast.makeText(getActivity(), "Bibliothek erfolgreich gewechselt", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        return view;
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
