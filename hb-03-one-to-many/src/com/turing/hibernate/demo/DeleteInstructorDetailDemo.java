package com.turing.hibernate.demo;

import com.turing.hibernate.entity.Instructor;
import com.turing.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create a session

        try (factory; Session session = factory.getCurrentSession()) {
            // start a transaction
            session.beginTransaction();
            int theId = 3;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
            System.out.println("The tempInstructorDetail - " + tempInstructorDetail);
            System.out.println("the associated instructor - " + tempInstructorDetail.getInstructor());
            tempInstructorDetail.getInstructor().setInstructorDetail(null);
            // commit the transaction
            session.delete(tempInstructorDetail);

            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
