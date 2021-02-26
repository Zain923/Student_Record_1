package com.example.student_record;

public class Students_Marks {
    String id,name;
    int obtainMarks,total;

    public Students_Marks(String id, String name, int obtainMarks, int total) {
        this.id = id;
        this.name = name;
        this.obtainMarks = obtainMarks;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getObtainMarks() {
        return obtainMarks;
    }

    public void setObtainMarks(int obtainMarks) {
        this.obtainMarks = obtainMarks;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
