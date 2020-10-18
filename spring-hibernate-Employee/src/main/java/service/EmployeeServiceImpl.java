package main.java.service;

import main.java.dao.EmployeeDaoImpl;
import main.java.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDaoImpl employeeDao;

    public EmployeeServiceImpl(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void createEmployee(Employee employee) {
        this.employeeDao.addEmployee(employee);
    }
}
