package coolio.gadgeothek;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class LoanViewHolder extends RecyclerView.ViewHolder {
    RecyclerView rv;
    TextView name;
    TextView manufacturer;
    TextView loanDate;
    TextView returnDate;
    TextView daysLeft;

    LoanViewHolder(View itemView) {
        super(itemView);
        rv = (RecyclerView)itemView.findViewById(R.id.loan_recyclerView);
        name = (TextView)itemView.findViewById(R.id.loan_name);
        manufacturer = (TextView)itemView.findViewById(R.id.loan_manufacturer);
        loanDate = (TextView)itemView.findViewById(R.id.loan_date);
        returnDate = (TextView)itemView.findViewById(R.id.loan_return_date);
        daysLeft = (TextView)itemView.findViewById(R.id.loan_days_left);
    }
}