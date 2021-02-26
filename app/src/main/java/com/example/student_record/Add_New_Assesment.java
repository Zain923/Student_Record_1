package com.example.student_record;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Add_New_Assesment extends AppCompatActivity {

    View student_assesments_add_list_layout;
    View student_assesments_add_layout;
    Button creat_assesment_btn, save_assment_btn;

    TextView add_assesment_weightage,add_assesment_total,add_assesment_name;

    RecyclerView.LayoutManager assessmentsLayoutManager;
    static AssessmentAdaptor adaptorForAssessmentList;
    RecyclerView assessment_record_list_rv;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__new__assesment);
        init();
        student_assesments_add_list_layout.setVisibility(View.GONE);
        creat_assesment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student_assesments_add_layout.setVisibility(View.GONE);
                student_assesments_add_list_layout.setVisibility(View.VISIBLE);
                ModalClass.assessmentModals.add(new AssessmentModal(add_assesment_name.getText().toString(),add_assesment_total.getText().toString(),add_assesment_weightage.getText().toString()));
                assessment_record_list_rv = findViewById(R.id.student_assesments_add_list);
                adaptorForAssessmentList = new AssessmentAdaptor(getApplicationContext(),ModalClass.assessmentModals.get(ModalClass.assessmentModals.size()-1).getStudents_marks());
                assessmentsLayoutManager = new LinearLayoutManager(getApplicationContext());
                assessment_record_list_rv.setLayoutManager(assessmentsLayoutManager);
                assessment_record_list_rv.setAdapter(adaptorForAssessmentList);
            }
        });
        save_assment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Marks ");
                for (int i=0;i< ModalClass.assessmentModals.get(ModalClass.assessmentModals.size()-1).students_marks.size()-1; i++){
                    System.out.println("Marks "+ModalClass.assessmentModals.get(ModalClass.assessmentModals.size()-1).students_marks.get(i).getObtainMarks());
                }
                Add_New_Assesment.this.finish();
                startActivity(new Intent(getApplicationContext(),Dashboard.class));
            }
        });
    }
    void init(){
        student_assesments_add_list_layout = findViewById(R.id.student_assesments_add_list_layout);
        student_assesments_add_layout = findViewById(R.id.student_assesments_add_layout);
        save_assment_btn = findViewById(R.id.save_assment_btn);
        creat_assesment_btn = findViewById(R.id.creat_assesment_btn);

        add_assesment_weightage = findViewById(R.id.add_assesment_weightage);
        add_assesment_total = findViewById(R.id.add_assesment_total);
        add_assesment_name = findViewById(R.id.add_assesment_name);
    }

}