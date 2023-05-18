package com.example.markettotable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Purchase extends AppCompatActivity {
    TextView price,total,food_name,amount_text;
    ImageView plus,minus,food_image;
    Button checkout;
    Foods food;
    int amount = 1;
    int Total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        price = findViewById(R.id.price);
        food_name = findViewById(R.id.food_name);
        total = findViewById(R.id.total);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        food_image = findViewById(R.id.img);
        amount_text = findViewById(R.id.amount);
        checkout = findViewById(R.id.checkout);


        String name = getIntent().getStringExtra("food_name");
        food_name.setText(name);
        String cost = getIntent().getStringExtra("price");
        price.setText("₱"+cost);
        total.setText("₱"+cost);
        int path = getIntent().getIntExtra("food_image",-1);
        food_image.setImageResource(path);
        //TODO: Change implementation
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount += 1;
                amount_text.setText(String.valueOf(amount));
                Total = amount * Integer.parseInt(cost);
                total.setText("₱"+Total);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amount> 1){
                    amount -= 1;
                    amount_text.setText(String.valueOf(amount));
                    Total = amount * Integer.parseInt(cost);
                    total.setText("₱"+Total);
                }
            }
        });


        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checkout = new Intent(getApplicationContext(),Receipt.class);
                checkout.putExtra("foodname",name);
                checkout.putExtra("total",String.valueOf(Total));
                checkout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(checkout);
            }
        });



    }
}