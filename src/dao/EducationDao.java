package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

        Education e = em.find(Education.class, id);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();

        em.close();
    }

}
