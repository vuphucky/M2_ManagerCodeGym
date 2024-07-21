package model;

import model.service.student_serviec.IStudentService;

import java.time.LocalDate;

public class Student extends Person  {
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Student(String id,String name, String email, String phoneNumber, int  age, String className) {
        super(id,name, email, phoneNumber, age);
        this.className = className;
    }

    @Override
    public String toString() {
        return super.toString() + " lop: " + className;
    }
}
