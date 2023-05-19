package com.example.markettotable;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<Storeholder> {
    Context context;
    ArrayList<Store> stores;

    public StoreAdapter(Context context, ArrayList<Store> stores) {
        this.context = context;
        this.stores = stores;
    }

    @NonNull
    @Override
    public Storeholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Storeholder(LayoutInflater.from(context).inflate(R.layout.store_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Storeholder holder, int position) {
        holder.store.setText(stores.get(position).getName());
        holder.image.setImageResource(stores.get(position).getImg());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_store = new Intent(context,OpenStore.class);
                open_store.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                open_store.putExtra("store",stores.get(holder.getAdapterPosition()).getName());

                context.startActivity(open_store);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }
}

class Storeholder extends RecyclerView.ViewHolder{
    ImageView image;
    TextView store;

    public Storeholder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.img);
        store = itemView.findViewById(R.id.store);
    }
}