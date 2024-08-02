package model.service.student_serviec;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void add(Student student);

    Student findStudent(int id);
    void updateStudent(int id, Student student);
    void removeStudent(int id);
}
