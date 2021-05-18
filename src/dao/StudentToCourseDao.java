package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagmentproject.domain.Course;
import schoolmanagmentproject.domain.Student;

public class StudentToCourseDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void addExistingStudentToExistingCourse(int studentId, String courseName) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, studentId);

        TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c WHERE c.name =:name", Course.class);
        q.setParameter("name", courseName);
        Course course = q.getSingleResult();

        student.addCourse(course);

        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    void addNewStudentToExistingCourse(String newName, String courseName) {
        EntityManager em = emf.createEntityManager();

        Student student = new Student(newName);

        TypedQuery<Course> q = em.createQuery(" SELECT c FROM Course c WHERE c.name=:n", Course.class);
        q.setParameter("n", courseName);
        Course course = q.getSingleResult();

        student.addCourse(course);

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    void addExistingStudentToNewCourse(int studentId, String newCourseName) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, studentId);
        Course course = new Course(newCourseName);

        student.addCourse(course);

        em.getTransaction().begin();
        em.persist(course);
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    void addNewStudentToNewCourse(String newName, String newCourseName) {
        EntityManager em = emf.createEntityManager();

        Student student = new Student(newName);
        Course course = new Course(newCourseName);

        student.addCourse(course);

        em.getTransaction().begin();
        em.persist(student);
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    void removeStudentFromCourse(int studentId, String nameCourse) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c WHERE c.name =:n", Course.class);
        q.setParameter("n", nameCourse);

        Course course = q.getSingleResult();
        Student student = em.find(Student.class, studentId);

        student.removeCourse(course);

        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    void showAllCoursesOfStudent(int studentId) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, studentId);

        System.out.println("The Student with id " + student.getId() + ", with name " + student.getName() + ", has the following courses:");
        List<Course> courses = student.getCourses();
        for (Course course : courses) {
            System.out.println("ID " + course.getId() + " " + course.getName());
        }
        em.close();
    }

    void showAllStudentsOfCourse(String courseName) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c WHERE c.name=:n", Course.class);
        q.setParameter("n", courseName);

        Course course = q.getSingleResult();

        for (Student student : course.getStudents()) {
            System.out.println("ID: " + student.getId() + " NAME: " + student.getName());
        }

    }
}
