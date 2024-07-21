package model.service.student_serviec;

import model.Student;
import model.repo.IStudentRepo;
import model.repo.StudentRepo;

import java.util.List;

public class StudentService implements IStudentService{
   private IStudentRepo iStudentRepo = new StudentRepo();
    @Override
    public List<Student> findAll() {
        return iStudentRepo.findAll();
    }

    @Override
    public void add(Student student) {
        iStudentRepo.add(student);
    }

    @Override
    public Student findStudent(String id) {
        return iStudentRepo.findStudent(id);
    }

    @Override
    public void updateStudent(String id, Student student) {
       iStudentRepo.updateStudent(id,student);
    }

    @Override
    public void removeStudent(String id) {
         iStudentRepo.removeStudent(id);
    }
}
