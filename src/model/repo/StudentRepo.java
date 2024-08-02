package model.repo;

import model.Student;
import storage.IOStudentStream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class StudentRepo implements IStudentRepo {
    private final static List<Student> list;

    static {
        list = new ArrayList<>();
//        Student s1 = new Student(1, "Minh juan", "minhjuan@gmail", "0123456789", 22, "C05");
//        Student s2 = new Student(2, "Van Chuyen", "chuyengay@gmail", "7894561230", 21, "C05");
//        list.add(s1);
//        list.add(s2);

    }

    @Override
    public List<Student> findAll() {

        return IOStudentStream.convertFormFile();
    }

    @Override
    public void add(Student student) {

        IOStudentStream.saveStudentToFile(student);
        System.out.println("them moi thanh cong " + student);
    }

    @Override
    public Student findStudent(int id) {
        for (Student st : list) {
            if (st.getId() == id) {
                return st;
            }
        }
        return null;
    }

    @Override
    public void updateStudent(int id, Student student) {
        Student st = findStudent(id);
        st.setName(student.getName());
        st.setEmail(student.getEmail());
        st.setPhoneNumber(student.getPhoneNumber());
        st.setAge(student.getAge());
        st.setClassName(student.getClassName());
        System.out.println("Thong tin cap nhat thanh cong " + st);
        IOStudentStream.saveStudentToFile(student);
    }

    @Override
    public void removeStudent(int id) {
       list.removeIf(student -> student.getId() == id);
        System.out.println("xoa hoc vien thanh cong");
    }
}
