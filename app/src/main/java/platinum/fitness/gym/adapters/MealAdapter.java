package platinum.fitness.gym.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import platinum.fitness.gym.MainActivity2;
import platinum.fitness.gym.R;
import platinum.fitness.gym.models.Meal;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder> {
    private List<Meal> drawerList;

    public MealAdapter(List<Meal> drawerList) {
        this.drawerList = drawerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singlemeal, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {

        Meal meal = drawerList.get(position);
        holder.textView.setText(meal.getMeal());
        holder.imageView.setImageResource(meal.getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                if(position == 0){
                    intent.putExtra("ITEM", "Legs");
                }else if(position == 1){
                    intent.putExtra("ITEM", "Triceps");
                }else if (position == 2){
                    intent.putExtra("ITEM", "Abs");
                }else if(position == 3){
                    intent.putExtra("ITEM", "Swimming");
                }
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return drawerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private  ImageView imageView;
        private CardView cardView;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            imageView = (ImageView) view.findViewById(R.id.imageView2);
            textView = (TextView) view.findViewById(R.id.textView2);
            cardView = (CardView)view.findViewById(R.id.cardview);
        }


    }


}
