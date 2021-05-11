package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagmentproject.domain.Teacher;

class TeacherDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void create(String name) {
        Teacher teacher = new Teacher(name);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }

    void delete(int id) {
        EntityManager em = emf.createEntityManager();
        Teacher teacher = em.find(Teacher.class, id);

        em.getTransaction().begin();
        em.remove(teacher);
        em.getTransaction().commit();
        em.close();
    }

     void update(int id, String newName) {
        EntityManager em = emf.createEntityManager();

        Teacher teacher = em.find(Teacher.class, id);
        teacher.setName(newName);

        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
        em.close();
    }
    void showAll() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> q = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        List<Teacher> teachers = q.getResultList();

        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        em.close();
    }

}
