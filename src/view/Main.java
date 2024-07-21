package view;

import controller.StudentController;
import controller.TeacherController;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();
//        studentController.displayStudent();
        int choice;
        do{
            System.out.println("Quan ly codegym: \n" +
                    "1. Quan ly hoc vien. \n" +
                    "2. Quan ly giang vien. \n" +
                    "3. Thoat chuong trinh. \n" +
                    "Nhap lua chon cua ban: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    studentController.displayStudentFunctional();
                    break;
                case 2:
                    teacherController.displayTeacherFunctional();
                    break;
                case 3:
                    System.exit(1);
                    break;
            }
        } while (true);
    }
}