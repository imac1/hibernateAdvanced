package classesDemo;

import entityDemo.Instructor;
import entityDemo.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") //
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();


        try {
            // begin transaction
            session.beginTransaction();

// get the instr by their primary key
            int theId = 5;

            // delete instructor
            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("found instructor " + tempInstructor);
            if (tempInstructor != null) {
                System.out.println("deleting instructor " + tempInstructor);
                // this will also delete the details
                // because of the cascading connections in the tables
                session.delete(tempInstructor);
            }


// commit transaction
            session.getTransaction().commit();
            System.out.println("process acomplished");
        } finally {
            factory.close();
        }
    }
}


