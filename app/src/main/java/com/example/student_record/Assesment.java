package com.example.student_record;

public class Assesment {
    String name,studentID;
    int weightage,total,obtain;

    public Assesment()
    {
        weightage=0;
        total=0;
    }
    public Assesment(String name, String studentID, int weightage, int total,int obtain) {
        this.name = name;
        this.studentID = studentID;
        this.weightage = weightage;
        this.total = total;
        this.obtain=obtain;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getObtain() {
        return obtain;
    }

    public void setObtain(int obtain) {
        this.obtain = obtain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getWeightage() {
        return weightage;
    }

    public void setWeightage(int weightage) {
        this.weightage = weightage;
    }
}
