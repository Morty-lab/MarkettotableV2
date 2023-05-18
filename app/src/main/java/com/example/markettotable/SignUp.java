package com.example.markettotable;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    Button sign_up,login;
    EditText email,password;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent login = new Intent(getApplicationContext(),Homepage.class);
            startActivity(login);
            finish();
        }
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        sign_up = findViewById(R.id.signup);
        sign_up.setOnClickListener(this);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }

    @Override
    public void onClick(View v) {
        String email_add,pass;
        email_add = email.getText().toString();
        pass = password.getText().toString();
        if(v.getId() == R.id.signup) {


            if (TextUtils.isEmpty(email_add) || TextUtils.isEmpty(pass)) {
                Toast.makeText(getApplicationContext(), "Enter Credentials ", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                mAuth.createUserWithEmailAndPassword(email_add, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(SignUp.this, "Account Created", Toast.LENGTH_SHORT).show();
                                    Intent BackToLogin = new Intent(SignUp.this, MainActivity.class);
                                    startActivity(BackToLogin);
                                    finish();


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(SignUp.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }

        }

        if(v.getId() == R.id.login){
            Intent BackToLoginPage = new Intent(this, MainActivity.class);
            startActivity(BackToLoginPage);
        }



    }
}