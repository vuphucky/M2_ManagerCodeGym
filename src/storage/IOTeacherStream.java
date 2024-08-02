package storage;

import model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOTeacherStream {
    private static final String TEACHER_PATH = "data/teacher.csv";
    public static List<Teacher> readFromFile(){
        List<Teacher> listTeacher = new ArrayList<>();
        try(FileReader fileReader = new FileReader(TEACHER_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String temp;
            String[] arrTeacherData;
            while ((temp = bufferedReader.readLine()) != null){
                arrTeacherData = temp.split(",");
//                int id,String name, String email, String phoneNumber, int age, String level
                listTeacher.add(new Teacher(Integer.parseInt(arrTeacherData[0]),arrTeacherData[1], arrTeacherData[2],arrTeacherData[3],Integer.parseInt(arrTeacherData[4]), arrTeacherData[5]));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return listTeacher;
    }

    public static void writeTeacherToFile(Teacher teacher){
        try(FileWriter fileWriter = new FileWriter(TEACHER_PATH,true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            bufferedWriter.write(teacher.convertToLine());
            bufferedWriter.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
