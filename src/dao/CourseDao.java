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

    void remove(int id) {
        EntityManager em = emf.createEntityManager();

        Course c = em.find(Course.class, id);

        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();

        em.close();
    }

    void update(int id, String newName) {
        EntityManager em = emf.createEntityManager();

        Course c = em.find(Course.class, id);

        if (c == null) {
            System.out.println("There is no course with that id.");
        }

        System.out.println(c);

        em.getTransaction().begin();

        c.setName(newName);

        em.getTransaction().commit();

        em.close();
    }

    void showAll() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> c = q.getResultList();

        for (Course course : c) {
            System.out.println(course);

        }

        em.close();
    }

}
