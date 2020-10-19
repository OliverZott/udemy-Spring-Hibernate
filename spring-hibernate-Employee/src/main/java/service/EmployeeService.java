package main.java.service;

import main.java.entity.Employee;

public interface EmployeeService {

    void createEmployee(Employee employee);

    Employee readEmployee(int id);

}
