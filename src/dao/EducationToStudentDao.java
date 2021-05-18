package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagmentproject.domain.Education;
import schoolmanagmentproject.domain.Student;

public class EducationToStudentDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void addExistingEducationToExistingStudent(String educationName, int studentId) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Education> q = em.createQuery("SELECT e FROM Education e WHERE e.name =:n", Education.class);
            q.setParameter("n", educationName);
            Education education = q.getSingleResult();

            Student student = em.find(Student.class, studentId);

            education.addStudent(student);

            em.getTransaction().begin();
            em.merge(education);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            System.out.println("");
            System.out.println("The data you entered is not correct.");
        }
    }

    void addExistingEducationeToNewStudent(int educationId, String studentName) {
        EntityManager em = emf.createEntityManager();

        Education e = em.find(Education.class, educationId);

        Student s = new Student(studentName);

        s.setEducation(e);

        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }

    void removeEducationFromStudent(int educationId, int studentId) {
        EntityManager em = emf.createEntityManager();

        Education e = em.find(Education.class, educationId);
        Student student = em.find(Student.class, studentId);

        e.removeStudent(student);

        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        em.close();

    }

    void showEducationOfStudent(int studentId) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, studentId);
        System.out.println("");
        System.out.println("The student " + student.getName() + " has the education ");
        System.out.println("");
        System.out.println(student.getEducation());

        em.close();
    }
}
