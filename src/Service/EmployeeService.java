package Service;

import model.Employee;

public interface  EmployeeService {
    boolean register();
    Employee findById(long id);
    void employees();

    void findByName();

    void getEmployees();

    boolean update();

    boolean delete();

    String totalEmployee();
    boolean update(long id,Employee employee);
    boolean delete(long id);

}
