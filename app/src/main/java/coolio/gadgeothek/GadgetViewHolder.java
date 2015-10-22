package coolio.gadgeothek;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class GadgetViewHolder extends RecyclerView.ViewHolder {
    RecyclerView rv;
    TextView name;
    TextView manufacturer;
    TextView price;
    TextView condition;

    GadgetViewHolder(View itemView) {
        super(itemView);
        rv = (RecyclerView)itemView.findViewById(R.id.gadget_recyclerView);
        name = (TextView)itemView.findViewById(R.id.gadget_name);
        manufacturer = (TextView)itemView.findViewById(R.id.gadget_manufacturer);
        price = (TextView)itemView.findViewById(R.id.gadget_price);
        condition = (TextView)itemView.findViewById(R.id.gadget_condition);
    }
}