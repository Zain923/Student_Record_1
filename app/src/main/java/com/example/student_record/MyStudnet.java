package com.example.student_record;

public class MyStudnet {
    String name,id,section;

    public MyStudnet(String name, String id, String section) {
        this.name = name;
        this.id = id;
        this.section = section;
    }
    public MyStudnet(){
        name="";
        id="";
        section="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
