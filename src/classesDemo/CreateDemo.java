package classesDemo;

import entityDemo.Instructor;
import entityDemo.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
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
// create the objects
//Instructor tempInstructor =
//        new Instructor("d", "m", "dm@gm.com");
//InstructorDetail tempInstructorDetail =
//        new InstructorDetail("instrytbc", "swimming");
//            // associate the objects
//            tempInstructor.setInstructorDetail(tempInstructorDetail);
            Instructor tempInstructor =
                    new Instructor("a", "b", "ab@gm.com");
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://youtube.com", "guitar");
            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            // save the instructor
// this will save all associated obj due to cascadeType.All
            session.beginTransaction();
session.save(tempInstructor);
            //start a transacton
            System.out.println("saving instructor" + tempInstructor);

            // save the student obj

// commit transaction
            session.getTransaction().commit();
            System.out.println("process acomplished");
        } finally {
            factory.close();
        }
    }
}


