package com.example.student_record;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView bottomNavigationView=findViewById(R.id.botton_nav);
        View navController=findViewById(R.id.fragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListner);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListner=
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFrag=null;
                    switch (item.getItemId()){
                        case R.id.home2:
                            selectedFrag=new Home();
                            break;
                        case R.id.profile:
                            selectedFrag=new profile();
                            break;
                        case R.id.ass_:
                            selectedFrag=new add_assesment_frag();
                            break;
                        case R.id.student:
                            selectedFrag=new student();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment,selectedFrag).commit();
                    return true;
                }
            };
}