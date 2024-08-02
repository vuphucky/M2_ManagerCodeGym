package model.repo;

import model.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> findAll();
    void add(Student student);
    Student findStudent(int id);
    void updateStudent(int id, Student student);
    void removeStudent(int id);
}
