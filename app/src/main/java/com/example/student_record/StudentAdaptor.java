package com.example.student_record;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdaptor extends RecyclerView.Adapter<StudentAdaptor.ViewHolder> implements Filterable {
    ArrayList<MyStudnet> MyStudnets;
    ArrayList<MyStudnet> filterMyStudnet;
    //ItemSelected activity;
    Context context;
    public StudentAdaptor(Context context, ArrayList<MyStudnet> studnets) {
        this.MyStudnets = studnets;
        //activity = (ItemSelected) context;
        filterMyStudnet = studnets;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView student_record_st_id;
        TextView student_record_name;
        TextView student_record_section;
        TextView student_record_Marks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            student_record_st_id = itemView.findViewById(R.id.student_record_st_id);
            student_record_name = itemView.findViewById(R.id.student_record_name);
            student_record_section = itemView.findViewById(R.id.student_record_section);
            student_record_Marks = itemView.findViewById(R.id.student_record_Marks);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index_selected = filterMyStudnet.indexOf((MyStudnet) itemView.getTag());
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
    public StudentAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdaptor.ViewHolder holder, int position) {
        System.out.println(filterMyStudnet.get(position).getId());
        System.out.println(filterMyStudnet.get(position).getName());
        System.out.println(filterMyStudnet.get(position).getSection());
        holder.student_record_name.setText(MyStudnets.get(position).getName());
        holder.student_record_st_id.setText((MyStudnets.get(position).getId()));
        holder.student_record_section.setText(MyStudnets.get(position).getSection());
        holder.student_record_Marks.setText("0");
    }

    @Override
    public int getItemCount() {
        return filterMyStudnet.size();
    }
}
