package com.example.markettotable;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodsListAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    ArrayList<Foods> food;

    public FoodsListAdapter(Context context, ArrayList<Foods> food) {
        this.context = context;
        this.food = food;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.foodname.setText(food.get(position).getFoodname());
        holder.price.setText(food.get(position).getPrice());
        holder.imageView.setImageResource(food.get(position).getPath());
        holder.order.setOnClickListener(v -> {
            Intent purchase = new Intent(context,Purchase.class);
            purchase.putExtra("food_image",food.get(holder.getAdapterPosition()).getPath());
            purchase.putExtra("food_name",food.get(holder.getAdapterPosition()).getFoodname() );
            purchase.putExtra("price",food.get(holder.getAdapterPosition()).getPrice());
            purchase.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(purchase);
        });
    }

    @Override
    public int getItemCount() {
        return food.size();
    }


}

class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView foodname, price;
    Button order;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.img);
        foodname = itemView.findViewById(R.id.food_name);
        price = itemView.findViewById(R.id.price);
        order = itemView.findViewById(R.id.open);
    }
}
