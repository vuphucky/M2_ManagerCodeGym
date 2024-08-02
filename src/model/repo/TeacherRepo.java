package model.repo;

import model.Teacher;
import storage.IOTeacherStream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepo implements IsTeacherRepo {
    private final static List<Teacher> listTeacher;

    static {
        listTeacher = new ArrayList<>();
        Teacher t1 = new Teacher(1, "Luan Phan", "luanphan@codegym","0912345687", 29,"Tutor");
        Teacher t2 = new Teacher(2,"Kieu Anh", "kieuanh@codegym", "098123654",30, "Tutor");
        listTeacher.add(t1);
        listTeacher.add(t2);
    }

    @Override
    public List<Teacher> findAll() {

        return IOTeacherStream.readFromFile();
    }

    @Override
    public void add(Teacher teacher) {

        IOTeacherStream.writeTeacherToFile(teacher);
        System.out.println("them moi thanh cong: " + teacher);
    }

    @Override
    public Teacher findTeacher(int id) {
        for (Teacher t: listTeacher){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    @Override
    public void updateTeacher(int id, Teacher teacher) {
      Teacher t = findTeacher(id);
      t.setName(teacher.getName());
      t.setEmail(teacher.getEmail());
      t.setPhoneNumber(teacher.getPhoneNumber());
      t.setAge(teacher.getAge());
      t.setLevel(teacher.getLevel());
        System.out.println("thong tin cap nhat thanh cong " + t);
    }

    @Override
    public void removeTeacher(int id) {
       listTeacher.removeIf(teacher -> teacher.getId() == id);
                System.out.println("Xoa giang vien thanh cong");
            }
}
