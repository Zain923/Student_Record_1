package com.example.student_record;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AssessmentAdaptor extends RecyclerView.Adapter<AssessmentAdaptor.ViewHolder> implements Filterable {
    ArrayList<Students_Marks> Students_Markss;
    ArrayList<Students_Marks> filterStudents_Marks;
    ArrayList<String> obtainMarksList;
    //ItemSelected activity;
    Context context;
    public AssessmentAdaptor(Context context, ArrayList<Students_Marks> studnets) {
        this.Students_Markss = studnets;
        //activity = (ItemSelected) context;
        filterStudents_Marks = studnets;
        obtainMarksList = new ArrayList<String>();
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView student_id_assesment;
        TextView student_name_assessment;
        TextView student_assesment_total;
        EditText add_assesment_obtain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            student_id_assesment = itemView.findViewById(R.id.student_id_assesment);
            student_name_assessment = itemView.findViewById(R.id.student_name_assessment);
            student_assesment_total = itemView.findViewById(R.id.student_assesment_total);
            add_assesment_obtain = itemView.findViewById(R.id.add_assesment_obtain);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index_selected = filterStudents_Marks.indexOf((Students_Marks) itemView.getTag());
                    //activity.onClickItem(index_selected);
                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public AssessmentAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_assesment_layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssessmentAdaptor.ViewHolder holder, int position) {

        System.out.println(Students_Markss.get(position).getTotal()+" - ");
        holder.student_name_assessment.setText(Students_Markss.get(position).getName());
        holder.student_id_assesment.setText((Students_Markss.get(position).getId()));
        holder.student_assesment_total.setText(String.valueOf(Students_Markss.get(position).getTotal()));
        holder.add_assesment_obtain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ModalClass.assessmentModals.get(ModalClass.assessmentModals.size()-1).students_marks.get(position).setObtainMarks(Integer.parseInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    @Override
    public int getItemCount() {
        return filterStudents_Marks.size();
    }

}
