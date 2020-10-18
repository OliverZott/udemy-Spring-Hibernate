package main.java.dao;

import main.java.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void addEmployee(Employee employee) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
