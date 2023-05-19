package com.example.markettotable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class OpenStore extends AppCompatActivity {
    TextView store;
    RecyclerView recycle_store;
    TinyDb tinyDb;
    ArrayList<Foods> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_store);

        store = findViewById(R.id.store_label);
        String name = getIntent().getStringExtra("store");
        store.setText(name);
        createList();
        buildRecycler();

    }


    private void buildRecycler(){
        recycle_store  = findViewById(R.id.recycle_foods);
        recycle_store.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recycle_store.setAdapter(new FoodsListAdapter(getApplicationContext(), dataList));


    }

    private void createList(){
        dataList = new ArrayList<>();
        dataList.add(new Foods("Chicken Adobo","50", R.drawable.adobo,new Store("Montemayor",R.drawable.store_img)));
        dataList.add(new Foods("Pork Adobo","50", R.drawable.pork_adobo,new Store("Jhundie's Tapsilogan",R.drawable.store_img)));
        dataList.add(new Foods("Barbecue","50", R.drawable.barbecue,new Store("All Boys",R.drawable.store_img)));
        dataList.add(new Foods("Fried Checken","50", R.drawable.fried_chicken,new Store("All Boys",R.drawable.store_img)));
        dataList.add(new Foods("Pork Sisig","50", R.drawable.sisig,new Store("Montemayor",R.drawable.store_img)));
        dataList.add(new Foods("Tinolang Manok","50", R.drawable.tinolang_manok,new Store("Montemayor",R.drawable.store_img)));
        dataList.add(new Foods("Lumpia","50", R.drawable.lumpia,new Store("All Boys",R.drawable.store_img)));
        dataList.add(new Foods("Dinuguan","50", R.drawable.dinuguan,new Store("All Boys",R.drawable.store_img)));



    }
}