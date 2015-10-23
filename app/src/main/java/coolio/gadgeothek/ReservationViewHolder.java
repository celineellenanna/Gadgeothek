package coolio.gadgeothek;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class ReservationViewHolder extends RecyclerView.ViewHolder {
    RecyclerView rv;
    TextView name;
    TextView manufacturer;
    TextView waiting_position;
    TextView available;

    ReservationViewHolder(View itemView) {
        super(itemView);
        rv = (RecyclerView)itemView.findViewById(R.id.reservation_recyclerView);
        name = (TextView)itemView.findViewById(R.id.reservation_name);
        manufacturer = (TextView)itemView.findViewById(R.id.reservation_manufacturer);
        waiting_position = (TextView)itemView.findViewById(R.id.reservation_waiting_position);
        available = (CheckBox)itemView.findViewById(R.id.reservation_available);
    }
}