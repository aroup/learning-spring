package com.turing.hibernate.demo;

import com.turing.hibernate.entity.Employee;
import com.turing.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDemo {
    public static void main(String[] args) {
        // create Session factory

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory()) {
            // opening session
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Adding an employee to the database");
            Employee theEmployee = new Employee("Aroup","Goldar","Backpack");
            Employee secondEmployee = new Employee("Devjani", "Chowdhury", "Turing");

            System.out.println("Saving the two students");
            session.save(theEmployee);
            session.save(secondEmployee);

            session.getTransaction().commit();

            System.out.println("Searching for an employee:");
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee searchedEmployee = session.get(Employee.class,1);
            System.out.println("Got employee with id:" + 1 + searchedEmployee);
            session.getTransaction().commit();
            System.out.println("Done!");

            System.out.println("Searching for an employee with a company:");
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> theEmployees = session.createQuery("from Employee where company='Turing'").getResultList();
            displayEmployees(theEmployees);
            session.getTransaction().commit();
            System.out.println("Searching complete!");

            System.out.println("Deleting the employee");
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee targetEmployee = session.get(Employee.class,1);
            session.delete(targetEmployee);
            session.getTransaction().commit();
            System.out.println("Deleting employee");


            System.out.println("Updating an employee");
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Employee set company='CMOSHMC' where id=2").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Updating an employee");
        }
    }

    private static void displayEmployees(List<Employee> theEmployees) {
        for(Employee tempEmployee: theEmployees) {
            System.out.println(tempEmployee);
        }
    }
}
