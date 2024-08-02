package controller;

import model.Teacher;
import model.service.teacher_service.ISTeacherSevice;
import model.service.teacher_service.TeacherService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TeacherController {
    private Scanner scanner = new Scanner(System.in);
    private ISTeacherSevice isTeacherSevice = new TeacherService();

    public void displayTeacherFunctional(){
        int choice;
        do {
            System.out.println("Quan ly giang vien: \n"+
                    "1. Hien thi danh sach giang vien \n" +
                    "2. Them noi giang vien \n" +
                    "3. Chinh sua giang vien \n" +
                    "4. Xoa giang vien \n" +
                    "5. Tro ve trang chu \n" +
                    "Nhap lua chon cua ban: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    displayTeacher();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    updateTeacher();
                    break;
                case 4:
                    removeTeacher();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }


    public void displayTeacher(){
        List<Teacher> teachers = isTeacherSevice.findAll();
        for (Teacher t: teachers){
            if(t != null){
                System.out.println(t);
            }
        }
    }

    public void addTeacher(){
        System.out.println("Nhap id giang vien:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap ten giang vien:");
        String name = scanner.nextLine();
        System.out.println("Nhap email giang vien:");
        String email = scanner.nextLine();
        System.out.println("Nhap so dien thoai giang vien:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhap tuoi giang vien:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap xep hang giang vien:");
        String level = scanner.nextLine();
        Teacher teacher = new Teacher(id,name,email,phoneNumber,age,level);

        isTeacherSevice.add(teacher);
    }

    public void updateTeacher(){
        System.out.println("Nhap id giang vien can sua: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Teacher teacher = isTeacherSevice.findTeacher(id);
        if (teacher == null){
            System.out.println("Id nay khong ton tai");
            return;
        } else {
            System.out.println("Nhap ten moi cua giang vien:");
            String name = scanner.nextLine();
            System.out.println("Nhap email moi cua giang vien:");
            String email = scanner.nextLine();
            System.out.println("Nhap so dien thoai moi cua giang vien:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Nhap tuoi moi cua giang vien:");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhap xep hang moi cua giang vien:");
            String level = scanner.nextLine();

            Teacher updateTeacher = new Teacher(id,name,email,phoneNumber,age,level);
            isTeacherSevice.updateTeacher(id, updateTeacher);
        }
    }
    public void removeTeacher(){
        System.out.println("Nhap id giang vien can xoa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        isTeacherSevice.removeTeacher(id);

    }
}
