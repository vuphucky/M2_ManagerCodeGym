package controller;

import model.Student;
import model.service.student_serviec.IStudentService;
import model.service.student_serviec.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private IStudentService iStudentService = new StudentService();
    private Scanner scanner = new Scanner(System.in);

    public void displayStudentFunctional() {
        int choice;
        do {
            System.out.println("Quan ly hoc vien: \n" +
                    "1.Hien thi danh sachh hoc vien \n" +
                    "2.Them moi hoc vien \n" +
                    "3.Chinh sua thong tin hoc vien. \n" +
                    "4.Xoa hoc vien \n" +
                    "5.Tro ve trang chu \n" +
                    "Nhap lua chon cua ban");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayStudent();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

        public void displayStudent() {
            List<Student> students = iStudentService.findAll();
            for (Student s : students) {
                if (s != null) {
                    System.out.println(s);
                }
            }
        }

        public void addStudent() {
//        String name, String email, String phoneNumber, LocalDate birthday, String className
            System.out.println("Nhap id hoc vien:");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhap ten hoc vien:");
            String name = scanner.nextLine();
            System.out.println("Nhap email hoc sinh:");
            String email = scanner.nextLine();
            System.out.println("Nhap so dien thoai hoc vien:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Nhap tuoi hoc vien:");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhap lop hoc vien:");
            String className = scanner.nextLine();
            Student student = new Student(id, name, email, phoneNumber, age, className);

            iStudentService.add(student);
        }


        public void updateStudent() {
            System.out.println("Nhap id hoc vien can sua: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Student student = iStudentService.findStudent(id);
            if (student == null) {
                System.out.println("Id nay khong ton tai");
                return;
            } else {
                System.out.println("Nhap ten moi cua hoc vien:");
                String name = scanner.nextLine();
                System.out.println("Nhap email moi cua hoc sinh:");
                String email = scanner.nextLine();
                System.out.println("Nhap so dien thoai moi cua hoc vien:");
                String phoneNumber = scanner.nextLine();
                System.out.println("Nhap tuoi moi cua hoc vien:");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhap lop hoc moi vien:");
                String className = scanner.nextLine();

                Student updateStudent = new Student(id, name, email, phoneNumber, age, className);
                iStudentService.updateStudent(id, updateStudent);
            }
        }
        public void removeStudent(){
            System.out.println("Nhap id hoc vien can xoa: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            iStudentService.removeStudent(id);
        }

    }

