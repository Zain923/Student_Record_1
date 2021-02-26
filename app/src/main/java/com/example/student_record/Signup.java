package com.example.student_record;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Signup extends AppCompatActivity {

    EditText email,pass,passconfirm;
    Button signup;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email=findViewById(R.id.signup_email);
        pass=findViewById(R.id.signup_pass);
        passconfirm=findViewById(R.id.signup_pass_confirm);
        signup=findViewById(R.id.signup_btn_signup);
        auth=FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().isEmpty())
                {
                    email.setError("Enter Email");
                }else if(pass.getText().toString().isEmpty()){
                    pass.setError("Enter Password");
                }else if(!pass.getText().toString().equals(passconfirm.getText().toString())){
                    passconfirm.setError("Password not Matched");
                }else{
                    findViewById(R.id.loading).setVisibility(View.VISIBLE);
                    auth.createUserWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            findViewById(R.id.loading).setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_LONG).show();
                            auth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString());
                            startActivity(new Intent(getApplicationContext(), Dashboard.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            findViewById(R.id.loading).setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"Signup Faild!!"+e.toString(),Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}