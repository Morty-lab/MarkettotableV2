package com.example.markettotable;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.ArrayList;

public class Homepage extends AppCompatActivity{
    FirebaseAuth auth;
    FirebaseUser user;
    RecyclerView food_recycler;
    ArrayList<Foods> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        createList();
        buildRecycler();

        if(user == null){
            Intent login = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(login);
            finish();

        buildRecycler();
        }

    }
    private void buildRecycler(){
        food_recycler = findViewById(R.id.recycle_foods);
        food_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        food_recycler.setAdapter(new FoodsListAdapter(getApplicationContext(), dataList));
    }

    private void createList(){
        dataList = new ArrayList<>();
        dataList.add(new Foods("Caldereta","50", R.drawable.pop_2,1));
        dataList.add(new Foods("Afritada","50", R.drawable.pizza,1));
        dataList.add(new Foods("Mechado","50", R.drawable.pop_3,1));
        dataList.add(new Foods("Caldereta","50", R.drawable.icon,1));
        dataList.add(new Foods("Caldereta","50", R.drawable.icon,1));
        dataList.add(new Foods("Caldereta","50", R.drawable.icon,1));
    }

    }



