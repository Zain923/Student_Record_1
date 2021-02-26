package com.example.student_record;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class profile extends Fragment {
    View view;
    TextView email,uid;
    FirebaseAuth auth;
    Button logout,editProfile;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        email=view.findViewById(R.id.profile_email);
        uid=view.findViewById(R.id.profile_Uid);
        auth=FirebaseAuth.getInstance();
        email.setText(auth.getCurrentUser().getEmail());
        uid.setText(auth.getCurrentUser().getUid());
        logout=view.findViewById(R.id.profile_btn_logout);
        editProfile=view.findViewById(R.id.profile_btn_edit);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(getActivity(),MainActivity.class));
            }

        });
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Edit_Profile.class));
            }
        });
    }

}