package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject Hibernate SessionFactory
    // Field-Injection (not recommended)
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        // get current Hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create query
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

        // get customer list from query by executing it
        @SuppressWarnings("UnnecessaryLocalVariable")
        List<Customer> customers = theQuery.getResultList();

        // return result
        return customers;
    }

}
