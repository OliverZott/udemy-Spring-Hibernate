package main.java.service;

import main.java.dao.EmployeeDaoImpl;
import main.java.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDaoImpl employeeDao;

    public EmployeeServiceImpl(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void createEmployee(Employee employee) {
        this.employeeDao.addEmployee(employee);
    }

    @Override
    public Employee readEmployee(int id) {
        return this.employeeDao.getEmployee(id);
    }
}
