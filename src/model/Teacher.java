package model;

import java.time.LocalDate;

public class Teacher extends Person  {
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Teacher(int id,String name, String email, String phoneNumber, int age, String level) {
        super(id,name, email, phoneNumber, age);
        this.level = level;
    }

    public String convertToLine(){
        return super.getId() + "," + super.getName() + "," + super.getEmail() + "," + super.getPhoneNumber()
                + "," + super.getAge() + "," + level;
    }

    @Override
    public String toString() {
        return super.toString() + " cap bac: " + level ;
    }
}
