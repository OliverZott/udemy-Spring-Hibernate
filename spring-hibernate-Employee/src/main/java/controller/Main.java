package main.java.controller;

import main.java.dao.EmployeeDaoImpl;
import main.java.entity.Employee;
import main.java.service.EmployeeServiceImpl;

public class Main {


    public static void main(String[] args) {

        /* Example Creating and adding Employee to DB */
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Employee emp1 = new Employee("Olli", "Zott", "Velosauraus.Inc");

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeDao);
        employeeService.createEmployee(emp1);


    }
}

