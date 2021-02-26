package com.example.student_record;

import java.util.ArrayList;

public class AssessmentModal {
    String name;
    String marks,weightage;
    ArrayList <Students_Marks> students_marks ;

    public AssessmentModal(String name, String marks, String weightage) {
        this.name = name;
        this.marks = marks;
        this.weightage = weightage;
        setArray();
    }
    private void setArray(){
        int size = ModalClass.studnets.size();
        students_marks = new ArrayList<Students_Marks>();
        System.out.println(marks+" Ma ");
        for (int i = 0; i<size ; i++){
            students_marks.add(new Students_Marks(ModalClass.studnets.get(i).getId(),ModalClass.studnets.get(i).getName(),0,Integer.parseInt(marks)));
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getWeightage() {
        return weightage;
    }

    public void setWeightage(String weightage) {
        this.weightage = weightage;
    }

    public ArrayList<Students_Marks> getStudents_marks() {
        return students_marks;
    }

    public void setStudents_marks(ArrayList<Students_Marks> students_marks) {
        this.students_marks = students_marks;
    }
}
