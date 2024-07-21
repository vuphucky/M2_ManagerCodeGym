package model.repo;

import model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class StudentRepo implements IStudentRepo {
    private final static List<Student> list;

    static {
        list = new ArrayList<>();
        Student s1 = new Student("ST1", "Minh juan", "minhjuan@gmail", "0123456789", 22, "C05");
        Student s2 = new Student("ST2", "Van Chuyen", "chuyengay@gmail", "7894561230", 21, "C05");
        list.add(s1);
        list.add(s2);

    }

    @Override
    public List<Student> findAll() {
        return list;
    }

    @Override
    public void add(Student student) {

        list.add(student);
    }

    @Override
    public Student findStudent(String id) {
        for (Student st : list) {
            if (st.getId() == id) {
                return st;
            }
        }
        return null;
    }

    @Override
    public void updateStudent(String id, Student student) {
        Student st = findStudent(id);
        st.setName(student.getName());
        st.setEmail(student.getEmail());
        st.setPhoneNumber(student.getPhoneNumber());
        st.setAge(student.getAge());
        st.setClassName(student.getClassName());
        System.out.println("Thong tin cap nhat thanh cong " + st);
    }

    @Override
    public void removeStudent(String id) {
       list.removeIf(student -> student.getId() == id);
        System.out.println("xoa hoc vien thanh cong");
    }
}
