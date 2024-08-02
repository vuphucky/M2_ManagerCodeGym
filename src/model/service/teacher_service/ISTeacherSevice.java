package model.service.teacher_service;

import model.Student;
import model.Teacher;

import java.util.List;

public interface ISTeacherSevice {
     List<Teacher> findAll();
     void add(Teacher teacher);
     Teacher findTeacher(int id);
     void updateTeacher(int id, Teacher teacher);
     void removeTeacher(int id);
}
