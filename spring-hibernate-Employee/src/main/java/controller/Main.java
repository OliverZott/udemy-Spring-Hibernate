package main.java.controller;

import main.java.dao.EmployeeDaoImpl;
import main.java.entity.Employee;
import main.java.service.EmployeeServiceImpl;

@SuppressWarnings("DanglingJavadoc")
public class Main {


    public static void main(String[] args) {

        // Can be eliminated by using Spring (@Repository and @Autowired functionality)
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeDao);


        /* Example Creating and adding Employee to DB */
        /**
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Employee emp1 = new Employee("Olli", "Zott", "Velosauraus.Inc");

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeDao);
        employeeService.createEmployee(emp1);
         //*/


        /* Example retrieving single employee by ID */
        Employee employeeResult = employeeService.readEmployee(2);
        System.out.println("\n\nEmployee from DB: " + employeeResult);



    }
}

