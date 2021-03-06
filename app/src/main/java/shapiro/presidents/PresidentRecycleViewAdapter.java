package shapiro.presidents;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PresidentRecycleViewAdapter
        extends RecyclerView.Adapter<PresidentViewHolder> {

    private OnPresidentSelectedListener listener;
    private PresidentList presidents;
    private int[] images;

    public PresidentRecycleViewAdapter(PresidentList presidents, int[] images, OnPresidentSelectedListener listener) {
        this.presidents = presidents;
        this.images = images;
        this.listener = listener;
    }

    @Override
    public PresidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.president_list_item, parent, false);



        return new PresidentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PresidentViewHolder holder, final int position) {
        holder.bind(presidents.get(position));

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               listener.onSelect(presidents, images, position);
           }
       });
    }

    @Override
    public int getItemCount() {
        return presidents.size();
    }


}
