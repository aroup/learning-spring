package com.turing.hibernate.demo;

import com.turing.hibernate.entity.Course;
import com.turing.hibernate.entity.Instructor;
import com.turing.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            // create some courses
            // add courses to instructor
            // save the course

            int theId=1;

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    +  "join fetch i.courses "
                    +  "where i.id = :theInstructorId "
                    , Instructor.class);

            query.setParameter("theInstructorId", theId);
            Instructor tempInstructor = query.getSingleResult();

            System.out.println("LOG: The temp instructor: " + tempInstructor);

            session.getTransaction().commit();
            System.out.println("LOG: We are closing the session");

            System.out.println("LOG: The data of courses:" + tempInstructor.getCourses());
        } finally {
            factory.close();
        }
    }
}
