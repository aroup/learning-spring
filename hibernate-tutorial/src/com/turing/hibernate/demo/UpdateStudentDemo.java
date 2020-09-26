package com.turing.hibernate.demo;

import com.turing.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        // create session factory

        // create a session

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            int studentId = 1;
            System.out.println("Deleting the student id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);
            session.delete(myStudent);

            session.createQuery("delete from Student where id=2").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
