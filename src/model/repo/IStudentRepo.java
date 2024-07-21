package model.repo;

import model.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> findAll();
    void add(Student student);
    Student findStudent(String id);
    void updateStudent(String id, Student student);
    void removeStudent(String id);
}
