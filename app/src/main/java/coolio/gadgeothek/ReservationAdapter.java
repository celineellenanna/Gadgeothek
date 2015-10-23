package coolio.gadgeothek;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ch.hsr.mge.gadgeothek.domain.Reservation;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationViewHolder>{

    List<Reservation> reservation;

    ReservationAdapter(List<Reservation> reservation){
        this.reservation = reservation;
    }

    @Override
    public int getItemCount() {
        return reservation.size();
    }

    @Override
    public ReservationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reservation_row, viewGroup, false);
        return new ReservationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ReservationViewHolder reservationViewHolder, int i) {
        reservationViewHolder.name.setText(reservation.get(i).getGadget().getName());
        reservationViewHolder.manufacturer.setText(reservation.get(i).getGadget().getManufacturer());
        reservationViewHolder.waiting_position.setText((reservation.get(i).getWatingPosition()+1)+".");
        //TODO:Checkbox implementieren
        //reservationViewHolder.available.setChecked(reservation.get(i).isReady());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
