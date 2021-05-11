package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagmentproject.domain.Student;

public class StudentDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void create(String name) {
        Student student = new Student(name);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    void delete(int id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, id);

        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

    void update(int id, String newName) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);
        student.setName(newName);

        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    void showAll() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = q.getResultList();

        for (Student student : students) {
            System.out.println(student);
        }
        em.close();
    }

}
