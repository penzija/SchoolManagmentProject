package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagmentproject.domain.Education;

public class EducationDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void add(String name) {
        EntityManager em = emf.createEntityManager();

        Education e = new Education(name);

        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    void remove(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            Education e = em.find(Education.class, id);

            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("No education with this ID.");
        }
    }

    void update(int id, String newName) {
        EntityManager em = emf.createEntityManager();
        try {
            Education education = em.find(Education.class, id);
            education.setName(newName);

            em.getTransaction().begin();
            em.merge(education);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("There is no course with that id.");
        }
        em.close();
    }

    void showAll() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Education> q = em.createQuery("SELECT e FROM Education e", Education.class);
        List<Education> e = q.getResultList();

        for (Education education : e) {
            System.out.println("ID: " + education.getId() + " NAME: " + education.getName());
        }
        em.close();
    }
}
