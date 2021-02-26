package com.example.student_record;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email,pass;
    Button login,signup;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.signin_email);
        pass=findViewById(R.id.signin_pass);
        login=findViewById(R.id.btn_login);
        signup=findViewById(R.id.btn_signup);
        auth=FirebaseAuth.getInstance();

        if(auth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(), Dashboard.class));
            this.finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().isEmpty())
                {
                    email.setError("Enter Email");
                }else if(pass.getText().toString().isEmpty()){
                    pass.setError("Enter Password");
                }else{
                    findViewById(R.id.loading).setVisibility(View.VISIBLE);
                    auth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            findViewById(R.id.loading).setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), Dashboard.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            findViewById(R.id.loading).setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();
                            pass.setText("");
                        }
                    });
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Signup.class));
            }
        });
    }
}
