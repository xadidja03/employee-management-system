package model;

import java.time.LocalDate;

public class Employee extends Personal {
    private static long id;
    String department;
    String position;
    Double salary;

    public Employee(String name, String surname, LocalDate birthday, String department, String position, Double salary){
        ++this.id;

    }

    public Employee(String name, String surname, String birthday, String department, String position, Double salary) {
        super(name, surname, LocalDate.parse(birthday));
        this.department = department;
        this.position = position;
        this.salary = salary;
        ++this.id;

    }

    public static long getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }



    public void setSalary(Double salary) {
        this.salary = salary;

    }

    @Override
    public String toString() {
        return "Name: "+ getName() +
                "\nSurname: "+ getSurname()+"\nBirthday: "+getBirthday()+
                "\nDepartment: " + department+ "\nPosition: " +
                position+
                "\nSalary: "+ salary;
    }
}
