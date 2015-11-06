package shapiro.presidents;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PresidentRecycleViewAdapter
        extends RecyclerView.Adapter<PresidentViewHolder> {

    private PresidentList presidents;

    public PresidentRecycleViewAdapter(PresidentList presidents) {
        this.presidents = presidents;
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
           public void onClick(View v) {
               Context context = holder.itemView.getContext();
               Intent intent = new Intent(context, DetailActivity.class);
               intent.putExtra("POSITION", position);
               intent.putExtra("PRESIDENTS", presidents);
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return presidents.size();
    }
}
