package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagmentproject.domain.Course;

public class CourseDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void add(String nameCourse) {
        EntityManager em = emf.createEntityManager();

        Course c = new Course(nameCourse);

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }

    void remove(String courseName) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c WHERE c.name =:n", Course.class);
            q.setParameter("n", courseName);

            Course c = q.getSingleResult();

            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("This course does not exist!");
        }
    }

    void removeById(int courseId) {
        EntityManager em = emf.createEntityManager();

        try {
            Course course = em.find(Course.class, courseId);

            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("A course with this ID does not exist!");
        }
    }

    void update(int id, String newName) {
        EntityManager em = emf.createEntityManager();

        try {
            Course course = em.find(Course.class, id);

            em.getTransaction().begin();
            course.setName(newName);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            System.out.println("There is no course with that id.");
            System.out.println("");
        }
    }

    void showAll() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> c = q.getResultList();

        for (Course course : c) {
            System.out.println("ID: " + course.getId() + " NAME: " + course.getName());
        }
        em.close();
    }
}
