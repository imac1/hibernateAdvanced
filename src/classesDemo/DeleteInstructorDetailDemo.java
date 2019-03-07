package classesDemo;

import entityDemo.Instructor;
import entityDemo.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {
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
            //get the instructor detail object
 int theId = 6;
 InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            //print the instructor detail
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            //print the associated instructor

            System.out.println("the associated instructor for " +
                    "tempInstructorDetail is: " + tempInstructorDetail.getInstructor());
 // delete the instructor detail
            System.out.println("deleting the instructor detail: ");
            session.delete(tempInstructorDetail);
            // remove the associated reference
            // break the bi-directional reference
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

// commit transaction
            session.getTransaction().commit();
            System.out.println("process acomplished");
        } finally {
            session.close();
            factory.close();
        }
    }
}


