package storage;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOStudentStream {
    private static final String STUDENT_PATH = "data/student.csv";
    public static List<Student> convertFormFile(){
        List<Student> listStudent = new ArrayList<>();
        try(FileReader fileReader = new FileReader(STUDENT_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String temp;
            String [] arrStudentData;
            while ((temp = bufferedReader.readLine()) != null){
                arrStudentData = temp.split(",");
//                int id,String name, String email, String phoneNumber, int  age, String className
                listStudent.add(new Student(Integer.parseInt(arrStudentData[0]), arrStudentData[1],arrStudentData[2],arrStudentData[3], Integer.parseInt(arrStudentData[4]), arrStudentData[5] ));
            }


        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return listStudent;
    }

    public static void saveStudentToFile(Student student){
        try(FileWriter fileWriter = new FileWriter(STUDENT_PATH,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            bufferedWriter.write(student.convertToLine());
            bufferedWriter.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
