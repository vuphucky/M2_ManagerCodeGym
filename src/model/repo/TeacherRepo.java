package model.repo;

import model.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepo implements IsTeacherRepo {
    private final static List<Teacher> listTeacher;

    static {
        listTeacher = new ArrayList<>();
        Teacher t1 = new Teacher("T01", "Luan Phan", "luanphan@codegym","0912345687", 29,"Tutor");
        Teacher t2 = new Teacher("T02","Kieu Anh", "kieuanh@codegym", "098123654",30, "Tutor");
        listTeacher.add(t1);
        listTeacher.add(t2);
    }

    @Override
    public List<Teacher> findAll() {

        return listTeacher;
    }

    @Override
    public void add(Teacher teacher) {

        listTeacher.add(teacher);
    }

    @Override
    public Teacher findTeacher(String id) {
        for (Teacher t: listTeacher){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    @Override
    public void updateTeacher(String id, Teacher teacher) {
      Teacher t = findTeacher(id);
      t.setName(teacher.getName());
      t.setEmail(teacher.getEmail());
      t.setPhoneNumber(teacher.getPhoneNumber());
      t.setAge(teacher.getAge());
      t.setLevel(teacher.getLevel());
        System.out.println("thong tin cap nhat thanh cong " + t);
    }

    @Override
    public void removeTeacher(String id) {
        for (Teacher t:listTeacher){
            if (t.getId() == id){
                listTeacher.remove(t);
                System.out.println("Xoa giang vien thanh cong");
            }
        }

    }
}
