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
import android.widget.Toast;

public class student extends Fragment {

    View view;
    EditText add_student_section,add_student_name,add_student_id;
    Button add_student_btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_student, container, false);
        return  view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        add_student_section = view.findViewById(R.id.add_student_section);
        add_student_name = view.findViewById(R.id.add_student_name);
        add_student_id = view.findViewById(R.id.add_student_id);
        add_student_btn = view.findViewById(R.id.add_student_btn);
        add_student_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModalClass.studnets.add(new MyStudnet(add_student_name.getText().toString(),add_student_id.getText().toString(),add_student_section.getText().toString()));
                System.out.println((ModalClass.studnets.size()));
                clearForm();
                Toast.makeText(getContext(),"Successfully Added",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clearForm(){
        add_student_section.setText("");
        add_student_name.setText("");;
        add_student_id.setText("");;
    }
}