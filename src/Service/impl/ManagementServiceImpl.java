package Service.impl;

import Service.ManagementService;
import util.MenuUtil;

public class ManagementServiceImpl implements ManagementService {
    @Override
    public void management() {
        EmployeeService employeeService = new EmployeeService();

        while (true) {
            int option = MenuUtil.entryApp();
            switch (option) {
                case 0:
                    System.out.println("Good bye!\n");
                    System.exit(-1);
                case 1:
                    employeeService.register();
                    break;
                case 2:
                    employeeService.getEmployees();
                    break;
                case 3:
                    employeeService.update();
                    break;
                case 4:
                    employeeService.delete();
                    break;
                case 5:
                    employeeService.totalEmployee();
                    break;
                case 6:
                    employeeService.findByName();
                    break;
                default:
                    System.err.println("Invalid option!");
            }

        }
    }
}
