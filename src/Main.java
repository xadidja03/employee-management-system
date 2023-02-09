import Service.EmployeeService;
import Service.ManagementService;
import Service.impl.ManagementServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            ManagementServiceImpl managementService = new ManagementServiceImpl();
            managementService.management();



        }
    }
}