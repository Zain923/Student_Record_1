package com.example.student_record;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Home extends Fragment {
    RecyclerView.LayoutManager studentsLayoutManager;
    static StudentAdaptor adaptorForStudentList;
    RecyclerView student_record_list_rv;
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return  view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        student_record_list_rv = (RecyclerView) view.findViewById(R.id.student_record_list_rv);
        adaptorForStudentList = new StudentAdaptor(getContext(),ModalClass.studnets);
        studentsLayoutManager = new LinearLayoutManager(this.getActivity());
        student_record_list_rv.setLayoutManager(studentsLayoutManager);
        student_record_list_rv.setAdapter(adaptorForStudentList);
    }
}