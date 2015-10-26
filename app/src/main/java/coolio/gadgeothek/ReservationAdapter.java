package coolio.gadgeothek;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import ch.hsr.mge.gadgeothek.domain.Reservation;
import ch.hsr.mge.gadgeothek.service.Callback;
import ch.hsr.mge.gadgeothek.service.LibraryService;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationViewHolder>{

    List<Reservation> reservation;
    MainActivity mainActivity;

    ReservationAdapter(List<Reservation> reservation, MainActivity mainActivity){
        this.reservation = reservation;
        this.mainActivity = mainActivity;
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
    public void onBindViewHolder(final ReservationViewHolder reservationViewHolder, final int i) {
        reservationViewHolder.name.setText(reservation.get(i).getGadget().getName());
        reservationViewHolder.manufacturer.setText(reservation.get(i).getGadget().getManufacturer());
        if(reservation.get(i).isReady()){
            reservationViewHolder.waiting_position.setText("Verfügbar");
        }else{
            reservationViewHolder.waiting_position.setText((reservation.get(i).getWatingPosition()+1)+". in Warteschlange");
        }
        reservationViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LibraryService.deleteReservation(reservation.get(i), new Callback<Boolean>() {
                    @Override
                    public void onCompletion(Boolean input) {
                        mainActivity.switchTo(new ReservationFragment());
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(mainActivity, "Fehler bei Löschung", Toast.LENGTH_SHORT).show();
                    }
                });
                Log.d(reservation.get(i).getGadget().getName(), " clicked!");
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
