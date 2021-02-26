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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Edit_Profile extends AppCompatActivity {

    EditText email,pass,passconfirm;
    Button edit_profile;
    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__profile);
        email=findViewById(R.id.edit_profile_email);
        pass=findViewById(R.id.edit_profile_pass);
        passconfirm=findViewById(R.id.edit_profile_pass_confirm);
        edit_profile=findViewById(R.id.edit_profile_btn_update);
        auth=FirebaseAuth.getInstance();
        email.setText(auth.getCurrentUser().getEmail());
        edit_profile.setOnClickListener(new View.OnClickListener() {
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
                    user.updateEmail(email.getText().toString());
                    user.updatePassword(pass.getText().toString());
                    auth.updateCurrentUser(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getApplicationContext(),"User Updaded Successfully",Toast.LENGTH_SHORT).show();
                        }
                    });
                    finish();
                }
            }
        });

    }
}