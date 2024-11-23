package com.kiran;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // create configuration object.
        Configuration config = new Configuration();

        // read the configuration object.
        config.configure("hibernate.cfg.xml");

        // create factory
        SessionFactory sessionFactory = config.buildSessionFactory();

        // open the session.
        Session session = sessionFactory.openSession();

        // Begin the transaction.
        Transaction transaction = session.beginTransaction();

        // create the object
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John");
        employee.setEmail("j@gmail.com");

        // save the object
        session.persist(employee);

        // commit
        transaction.commit();

        // close the connection
        session.close();
    }
}
