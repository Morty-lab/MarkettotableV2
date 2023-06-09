    package com.example.markettotable;

    import static com.example.markettotable.R.id.button_sign_up;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.text.TextUtils;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.Toast;

    import com.google.android.gms.tasks.OnCompleteListener;
    import com.google.android.gms.tasks.Task;
    import com.google.firebase.auth.AuthResult;
    import com.google.firebase.auth.FirebaseAuth;
    import com.google.firebase.auth.FirebaseUser;


    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        Button login,signup;
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

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mAuth = FirebaseAuth.getInstance();
            login = findViewById(R.id.login);
            login.setOnClickListener(this);
            signup = findViewById(button_sign_up);
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent signup = new Intent(getApplicationContext(), SignUp.class);
                    startActivity(signup);
                }
            });
            email = findViewById(R.id.email);
            password = findViewById(R.id.password);


        }


        @Override
        public void onClick(View v) {
            String email_add, login_password;
            email_add = String.valueOf(email.getText());
            login_password = String.valueOf(password.getText());
            if (v.getId() == R.id.login) {
                if (check()) {
                    mAuth.signInWithEmailAndPassword(email_add, login_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(MainActivity.this, "Login Successful.", Toast.LENGTH_SHORT).show();
                                Intent login = new Intent(getApplicationContext(), Homepage.class);
                                startActivity(login);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }

        }

        public boolean check(){
            String email_add,login_password;
            email_add = String.valueOf(email);
            login_password = String.valueOf(password.getText());
            if(TextUtils.isEmpty( email_add) ||  TextUtils.isEmpty( login_password)){
                Toast.makeText(getApplicationContext(),"Enter Credentials",Toast.LENGTH_SHORT).show();
                return  false;
            }

            return true;
        }


    }





