package model.repo;

import model.Teacher;

import java.util.List;

public interface IsTeacherRepo {
    List<Teacher> findAll();
    void add (Teacher teacher);
    Teacher findTeacher(int id);
    void updateTeacher(int id, Teacher teacher);
    void removeTeacher(int id);
}
