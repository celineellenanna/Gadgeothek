package coolio.gadgeothek;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ch.hsr.mge.gadgeothek.domain.Loan;

public class LoanAdapter extends RecyclerView.Adapter<LoanViewHolder>{

    List<Loan> loan;

    LoanAdapter(List<Loan> loan){
        this.loan = loan;
    }

    @Override
    public int getItemCount() {
        return loan.size();
    }

    @Override
    public LoanViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.loan_row, viewGroup, false);
        return new LoanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LoanViewHolder loanViewHolder, int i) {

        SimpleDateFormat format = new SimpleDateFormat("dd. MMM yyyy");

        loanViewHolder.name.setText(loan.get(i).getGadget().getName());
        loanViewHolder.manufacturer.setText(loan.get(i).getGadget().getManufacturer());
        String date = format.format(loan.get(i).getPickupDate());
        loanViewHolder.loanDate.setText(date);
        date = format.format(loan.get(i).overDueDate());
        loanViewHolder.returnDate.setText(date);
        loanViewHolder.daysLeft.setText(""+loan.get(i).getDaysToReturn());

        if(!loan.get(i).isOverdue()){
            loanViewHolder.daysLeft.setBackgroundColor(Color.parseColor("#ff0000"));
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
