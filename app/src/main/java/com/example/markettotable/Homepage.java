package com.example.markettotable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.ArrayList;

public class Homepage extends AppCompatActivity{
    FirebaseAuth auth;
    FirebaseUser user;
    RecyclerView food_recycler,store_recycler;
    ArrayList<Foods> dataList;
    ArrayList<Store> stores;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        createList();
        buildRecycler();
        String [] options = {String.valueOf(user.getEmail()),"logout"};
        spinner = findViewById(R.id.spinner);

        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_spinner_item,options);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (options[position]== "logout") {
                    FirebaseAuth.getInstance().signOut();
                    Intent back = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(back);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        if(user == null){
            Intent login = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(login);
            finish();

        }

    }
    private void buildRecycler(){
        food_recycler = findViewById(R.id.recycle_foods);
        food_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        food_recycler.setAdapter(new FoodsListAdapter(getApplicationContext(), dataList));

        store_recycler = findViewById(R.id.store_recycler);
        store_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        store_recycler.setAdapter(new StoreAdapter(getApplicationContext(),stores));

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

        stores = new ArrayList<>();
        stores.add(new Store("Jhundie's Tapsilogan",R.drawable.store_img));
        stores.add(new Store("Montemayor",R.drawable.store_img));
        stores.add(new Store("All Boys",R.drawable.store_img));
    }

}



