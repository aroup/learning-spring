package com.turing.hibernate.demo;

import  com.turing.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create a session

        try (factory) {
            Session session = factory.getCurrentSession();
            // start a transaction
            session.beginTransaction();


            List<Student> theStudents = session.createQuery("from Student").getResultList();

            System.out.println("\n\nAll students: ");
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='duck'").getResultList();

            System.out.println("\n\nAll students with last name = duck ");

            displayStudents(theStudents);


            System.out.println("\n\nAll students with last name Goldar 1 and first name Daffy: ");
            theStudents = session.createQuery("from Student s where" +
                    " s.lastName='Goldar 1' OR" +
                    " s.firstName= 'Daffy'").getResultList();

            displayStudents(theStudents);


            theStudents = session.createQuery("from Student s where s.email like '%aroup%'").getResultList();
            System.out.println("Get the students with like email: ");
            displayStudents(theStudents);
            // commit the transaction
            session.getTransaction().commit();


        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent: theStudents) {
            System.out.println(tempStudent);
        }
    }
}
