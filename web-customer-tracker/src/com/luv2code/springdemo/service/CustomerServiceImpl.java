package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDao = customerDAO;
    }

    // delegates calls to CustomerDao
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return this.customerDao.getCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return this.customerDao.getCustomer(id);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        this.customerDao.saveCustomer(customer);
    }
}
