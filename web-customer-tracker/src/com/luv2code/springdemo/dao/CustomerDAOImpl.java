package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // Field-Injection (not recommended)
    /*@Autowired
    private SessionFactory sessionFactory;
     */

    private SessionFactory sessionFactory;

    // need to inject Hibernate SessionFactory
    @Autowired
    public void CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    /**
     * "@Transactional" is moved to service-layer ("CustomerServiceImpl")
     *
     * @return Customer
     */
    @Override
    public List<Customer> getCustomers() {

        // get current Hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // get customer list from query by executing it
        @SuppressWarnings("UnnecessaryLocalVariable")
        List<Customer> customers = theQuery.getResultList();

        return customers;
    }


    @Override
    public Customer getCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class, id);
    }


    /**
     * saveOrUpdate identifies if to use "update" or "save", based on existence of id
     */
    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        // version1
        /*
        Customer customer = currentSession.get(Customer.class, id);
        currentSession.delete(customer);
        */

        // version2
        Query query =
                currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);

        query.executeUpdate();

    }

}
