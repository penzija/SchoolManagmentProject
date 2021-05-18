package schoolmanagmentproject;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagmentproject.domain.Course;
import schoolmanagmentproject.domain.Education;
import schoolmanagmentproject.domain.Teacher;

public class Statistics {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void statistics() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> q = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        List<Teacher> amount = q.getResultList();

        TypedQuery<Course> q2 = em.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> amountCourse = q2.getResultList();

        TypedQuery<Education> q3 = em.createQuery("SELECT e FROM Education e", Education.class);
        List<Education> amountEducation = q3.getResultList();

        double teacher = amount.size();
        double course = amountCourse.size();
        double education = amountEducation.size();

        int teacherInt = amount.size();
        int courseInt = amountCourse.size();
        int educationInt = amountEducation.size();

        System.out.println("Number of teachers: " + teacherInt);
        System.out.println("Number of courses: " + courseInt);

        System.out.println("");
        System.out.println("The average number of courses per teacher is: " + course / teacher);
        System.out.println("");

        System.out.println("Number of educations: " + educationInt);
        System.out.println("");
        System.out.println("The average number of courses per education is: " + course / education);
        System.out.println("");
    }

}
