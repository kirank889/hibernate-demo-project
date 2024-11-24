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

        // retriving data from database.
        // get () - it returns Null if object does not exist. It effect the performance of the application.
        // load() - it will throw the ObjectNotFoundException if object does not exist. It gives better performance.

        Employee employee1 = session.get(Employee.class,1 );
        System.out.println(employee1);

        // delete a record.
        Employee employee2 = session.get(Employee.class, 1);
        session.delete(employee);
        transaction.commit();

        // update a record.

        // close the connection
        session.close();
    }
}
