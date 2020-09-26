package com.turing.hibernate.demo;

import com.turing.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating new Student Object... ");
            Student tempStudent = new Student("Daffy","duck","duffyduck@gmail.com");

            // start a transaction
            session.beginTransaction();
            // save the student
            System.out.println("Saving the student...");
            session.save(tempStudent);

            // commit the transaction
            session.getTransaction().commit();

            // find out the student's primary key
            System.out.println("Saved Student. Generated id: " + tempStudent.getId());

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: Primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + myStudent);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
