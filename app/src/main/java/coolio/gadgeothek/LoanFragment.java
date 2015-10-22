package coolio.gadgeothek;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import ch.hsr.mge.gadgeothek.domain.Gadget;
import ch.hsr.mge.gadgeothek.domain.Loan;
import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;


public class LoanFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public LoanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loan, container, false);
        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.loan_recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        LibraryService.getLoansForCustomer(new Callback<List<Loan>>() {
            @Override
            public void onCompletion(List<Loan> input) {
                LoanAdapter adapter = new LoanAdapter(input);
                rv.setAdapter(adapter);
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getActivity(), "Get gadget failed", Toast.LENGTH_SHORT).show();
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
