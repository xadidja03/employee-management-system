package Service.impl;

import global.GlobalData;
import model.Employee;

import java.time.LocalDate;
import java.util.Scanner;

import static util.InputUtil.*;

public class EmployeeService implements Service.EmployeeService {


    public Employee fillEmployee() {
        String name = inputRequiredString("Enter the name: ");
        String surname = inputRequiredString("Enter the surname: ");
        LocalDate birthday = birthday();
        String department = inputRequiredString("Enter the department: ");
        String position = inputRequiredString("Enter the position: ");
        Double salary = inputRequiredDouble("Enter the salary: ");

        Employee employee = new Employee(name, surname, birthday, department, position, salary);

        return employee;

    }

    private LocalDate birthday() {
        System.out.println("Enter the birthdate(years,month,day) : ");
            String str=new Scanner(System.in).nextLine();
            String[] str1=str.split(" ");
            int day=Integer.parseInt(str1[0]);
            int month=Integer.parseInt(str1[1]);
            int year=Integer.parseInt(str1[2]);

            return LocalDate.of(day,month,year);




    }

    @Override
    public boolean register() {
        int count = inputRequiredInteger("How many register employee: ");
        if (GlobalData.employees != null) {
            Employee[] tempEmployees = GlobalData.employees;
            GlobalData.employees = new Employee[count + tempEmployees.length];
            for (int i = 0, k = 0; i < GlobalData.employees.length; i++) {
                if (i < tempEmployees.length) {
                    GlobalData.employees[i] = tempEmployees[i];

                } else {
                    System.out.println("---------------");
                    System.out.println(++k + ". Employee");
                    GlobalData.employees[i] = fillEmployee();
                    System.out.println("---------------");
                }
            }

        } else {
            GlobalData.employees = new Employee[count];
            for (int i = 0; i < count; i++) {
                System.out.println("---------------");
                System.out.println(i + 1 + ". Employee");
                GlobalData.employees[i] = fillEmployee();
                System.out.println("---------------");
            }
            System.out.println("Registered is successfully!");
            System.out.println("Total employees: " + GlobalData.employees.length);
        }
        return false;
    }

    @Override
    public Employee findById(long id) {
        return null;
    }

    @Override
    public void employees() {

    }

    @Override
    public void findByName() {
        String name = inputRequiredString("Search by name: ");
        if (GlobalData.employees == null) {
            System.err.println("Doesnt't exist employee");
        } else {
            for (int i = 0, k = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getName().contains(name)) {
                    System.out.println(++k + ". Employee");
                    System.out.println(GlobalData.employees[i]);
                    System.out.println("---------------");
                }
            }
        }
    }

    @Override
    public void getEmployees() {
        if (GlobalData.employees == null) {
            System.err.println("Warning: Employee list is empty! ");
        } else {
            for (int i = 0; i < GlobalData.employees.length; i++) {
                System.out.println("---------------");
                System.out.println(i + 1 + ". Employee");
                System.out.println(GlobalData.employees[i]);
                System.out.println("---------------");
            }
        }
    }

    @Override
    public boolean update() {
        boolean isUpdated = false;
        if (GlobalData.employees == null) {
            System.err.println("Employee doesn't exist!");
            return isUpdated;
        } else {
            long id = inputRequiredLong("How many employee do you want to update? : ");
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getId() == id) {
                    String input = inputRequiredString("Which fields do you want to change: ");
                    String[] inputFields = input.toLowerCase().split(",");
                    for (int j = 0; j < inputFields.length; j++) {
                        isUpdated = true;
                        if (inputFields[j].contains("name")) {
                            GlobalData.employees[i].setName(inputRequiredString("Update the name: "));
                        }
                        if (inputFields[j].contains("surname") && !inputFields[i].equals("name")) {
                            GlobalData.employees[i].setSurname(inputRequiredString("Update the surname: "));
                        }
                        if (inputFields[j].contains("department")) {
                            GlobalData.employees[i].setDepartment(inputRequiredString("Update the department: "));
                        }
                        if (inputFields[j].contains("position")) {
                            GlobalData.employees[i].setPosition(inputRequiredString("Update the position: "));
                        }
                        if (inputFields[j].contains("salary")) {
                            GlobalData.employees[i].setSalary(inputRequiredDouble("Update the salary: "));
                        } else {
                            isUpdated = false;
                            System.err.println("Invalid fields name!");
                        }

                        if (isUpdated) {
                            System.out.println("Updated successfully!");
                        }
                    }
                }
            }
        }
        return isUpdated;
    }

    @Override
    public boolean delete() {
        boolean isDeleted = false;
        if (GlobalData.employees == null) {
            System.err.println("Employee doesn't exist!");
            return isDeleted;
        } else {
            long id = inputRequiredLong("Which is update employee: ");
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getId() == id) {
                    Employee[] tempEmployees = GlobalData.employees;
                    GlobalData.employees = new Employee[tempEmployees.length - 1];

                    for (int j = 0; j < GlobalData.employees.length; j++) {
                        if (tempEmployees[j].getId() >= id) {
                            isDeleted = true;
                            GlobalData.employees[j] = tempEmployees[j + 1];
                        } else {
                            GlobalData.employees[j] = tempEmployees[j];
                        }
                    }
                }
            }
        }
        return isDeleted;
    }

    @Override
    public String totalEmployee() {
        System.out.println("Employee list count: ");
        if (GlobalData.employees == null) {
            System.err.print(0);
        } else {
            System.out.print(GlobalData.employees.length);
        }
        return null;
    }

    @Override
    public boolean update(long id, Employee employee) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

}
