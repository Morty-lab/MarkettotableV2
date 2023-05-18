package com.example.markettotable;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Receipt extends AppCompatActivity {

    TextView recepient,total,delivery_fee,grand_total,food_name;
    FirebaseAuth auth;
    FirebaseUser user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        recepient = findViewById(R.id.recepient);
        total = findViewById(R.id.order_total);
        delivery_fee = findViewById(R.id.delivery_fee);
        grand_total = findViewById(R.id.grand_total);
        food_name = findViewById(R.id.food_name);

        food_name.setText(getIntent().getStringExtra("foodname"));
        recepient.setText(user.getEmail());
        String order_total = getIntent().getStringExtra("total");
        total.setText(order_total);
        double fee = Integer.parseInt(order_total) * .40;
        delivery_fee.setText(String.valueOf(fee));
        double grand = fee + Integer.parseInt(order_total);
        grand_total.setText(String.valueOf(grand));



    }
}