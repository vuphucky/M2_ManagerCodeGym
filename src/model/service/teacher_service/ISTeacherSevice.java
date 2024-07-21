package model.service.teacher_service;

import model.Student;
import model.Teacher;

import java.util.List;

public interface ISTeacherSevice {
     List<Teacher> findAll();
     void add(Teacher teacher);
     Teacher findTeacher(String id);
     void updateTeacher(String id, Teacher teacher);
     void removeTeacher(String id);
}
