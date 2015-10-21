package coolio.gadgeothek;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ch.hsr.mge.gadgeothek.domain.Gadget;

public class GadgetRVAdapter extends RecyclerView.Adapter<GadgetViewHolder>{

    List<Gadget> gadgets;

    GadgetRVAdapter(List<Gadget> gadgets){
        this.gadgets = gadgets;
    }

    @Override
    public int getItemCount() {
        return gadgets.size();
    }

    @Override
    public GadgetViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gadget_row, viewGroup, false);
        return new GadgetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GadgetViewHolder gadgetViewHolder, int i) {
        gadgetViewHolder.name.setText(gadgets.get(i).getName());
        gadgetViewHolder.manufacturer.setText(gadgets.get(i).getManufacturer());
        gadgetViewHolder.condition.setText(gadgets.get(i).getCondition().toString());
        gadgetViewHolder.price.setText(""+gadgets.get(i).getPrice());
        //gadgetViewHolder.inventoryNumber.setText(gadgets.get(i).getInventoryNumber());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
