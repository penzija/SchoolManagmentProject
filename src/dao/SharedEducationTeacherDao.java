package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import schoolmanagmentproject.domain.Education;
import schoolmanagmentproject.domain.Teacher;

public class SharedEducationTeacherDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void addExistingEducationWithExistingTeacher(int educationId, int id) {

        EntityManager em = emf.createEntityManager();

        Education e = em.find(Education.class, educationId);

        Teacher t = em.find(Teacher.class, id);

//        TypedQuery<Teacher> q = em.createQuery("SELECT t FROM Teacher t WHERE t.name =:nameTeacher", Teacher.class);
//        q.setParameter("nameTeacher", name);
//        Teacher t = q.getSingleResult();
//        
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();

        em.close();
    }

}
