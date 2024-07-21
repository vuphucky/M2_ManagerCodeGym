package model.repo;

import model.Teacher;

import java.util.List;

public interface IsTeacherRepo {
    List<Teacher> findAll();
    void add (Teacher teacher);
    Teacher findTeacher(String id);
    void updateTeacher(String id, Teacher teacher);
    void removeTeacher(String id);
}
