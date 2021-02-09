package platinum.fitness.gym.adapters;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import platinum.fitness.gym.MainActivity3;
import platinum.fitness.gym.R;
import platinum.fitness.gym.models.Barbeque_Menu;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MenuAdapter  extends  RecyclerView.Adapter<MenuAdapter.Viewholder>{

    public List<Barbeque_Menu> menuList;

    public MenuAdapter(List<Barbeque_Menu> menuList) {
        this.menuList = menuList;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singlemenu, parent, false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.Viewholder holder, int position) {
        final Barbeque_Menu barbeque_menu = menuList.get(position);
        holder.textView.setText(barbeque_menu.menu_item);
        holder.imageView.setImageResource(barbeque_menu.getImage());
        holder.textView1.setText(String.valueOf(barbeque_menu.price));
        holder.textView2.setText(barbeque_menu.type);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = BitmapFactory.decodeResource(view.getResources(), barbeque_menu.getImage());
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();
                int u = barbeque_menu.getImage();
                Intent intent = new Intent(view.getContext(), MainActivity3.class);
                intent.putExtra("MENUITEM",barbeque_menu.menu_item);
                intent.putExtra("PRICE",barbeque_menu.price);
                intent.putExtra("TYPE",barbeque_menu.type);
                intent.putExtra("IMAGE",u);

                view.getContext().startActivity(intent);


            }
        });
    }


    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        private TextView textView1;
        private TextView textView2;
        private ConstraintLayout cardView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.tt);
            textView1 = itemView.findViewById(R.id.tt1);
            textView2 = itemView.findViewById(R.id.tt2);
            cardView = itemView.findViewById(R.id.car);
        }
    }
}
