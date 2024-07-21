package model.service.teacher_service;

import model.Teacher;
import model.repo.IsTeacherRepo;
import model.repo.TeacherRepo;

import java.util.List;

public class TeacherService implements ISTeacherSevice {
    private IsTeacherRepo isTeacherRepo = new TeacherRepo();
    public List<Teacher> findAll(){
        return isTeacherRepo.findAll();
    }

    @Override
    public void add(Teacher teacher) {
        isTeacherRepo.add(teacher);
    }

    @Override
    public Teacher findTeacher(String id) {
        return isTeacherRepo.findTeacher(id);
    }

    @Override
    public void updateTeacher(String id, Teacher teacher) {
        isTeacherRepo.updateTeacher(id, teacher);
    }

    @Override
    public void removeTeacher(String id) {
          isTeacherRepo.removeTeacher(id);
    }
}
