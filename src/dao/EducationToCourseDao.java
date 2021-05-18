package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagmentproject.domain.Course;
import schoolmanagmentproject.domain.Education;

public class EducationToCourseDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void addExistingEducationToExistingCourse(String educationName, String courseName) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Education> q = em.createQuery("SELECT e FROM Education e WHERE e.name =:n", Education.class);
            q.setParameter("n", educationName);

            TypedQuery<Course> q2 = em.createQuery("SELECT c FROM Course c WHERE c.name =:n", Course.class);
            q2.setParameter("n", courseName);

            Education education = q.getSingleResult();
            Course course = q2.getSingleResult();

            education.addCourse(course);

            em.getTransaction().begin();
            em.merge(education);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("The data you inserted is not correct.");
        }
        em.close();
    }

    void addNewEducationToExistingCourse(String newEducationName, String courseName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addExistingEducationToNewCourse(String educationName, String newCourseName) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Education> q = em.createQuery("SELECT e FROM Education e WHERE e.name =:n", Education.class);
            q.setParameter("n", educationName);
            Education education = q.getSingleResult();

            Course course = new Course(newCourseName);

            education.addCourse(course);

            em.getTransaction().begin();
            em.persist(course);
            em.merge(education);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("The ID you inserted is not correct.");
        }
        em.close();
    }

    void addNewEducationToNewCourse(String newEducationName, String newCourseName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void removeEducationFromCourse(String educationName, String courseName) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Education> q = em.createQuery("SELECT e FROM Education e WHERE e.name =:n", Education.class);
        q.setParameter("n", educationName);
        Education education = q.getSingleResult();

        TypedQuery<Course> q2 = em.createQuery("SELECT c FROM Course c WHERE c.name =:n", Course.class);
        q.setParameter("n", courseName);
        Course course = q2.getSingleResult();

        education.removeCourse(course);

        em.getTransaction().begin();
        em.merge(education);
        em.getTransaction().commit();
        em.close();
    }
}
