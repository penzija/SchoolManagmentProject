package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagmentproject.domain.Course;
import schoolmanagmentproject.domain.Teacher;

public class SharedCourseTeacherDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void addExistingCourseToExistingTeacher(int teacherId, String course) {
        EntityManager em = emf.createEntityManager();

        Teacher teacher = em.find(Teacher.class, teacherId);

        TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c WHERE c.name =:nameCourse", Course.class);
        q.setParameter("nameCourse", course);
        Course c = q.getSingleResult();

        em.getTransaction().begin();
        teacher.addCourse(c);
        em.getTransaction().commit();

        em.close();
    }

    void addNewCourseToExistingTeacher(int teacherId, String nameCourse) { // I THINK HERE THERE IS SOMETHING HERE TO CORRECT... (Luka)
        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> q = em.createQuery("SELECT t FROM Teacher t WHERE t.id =:teacherId", Teacher.class);
        q.setParameter("teacherId", teacherId);
        Teacher t = q.getSingleResult();

        Course c = new Course(nameCourse);

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();

        em.close();
    }

    void addNewTeacherAndNewCourse(String teacherName, String courseName) {
        EntityManager em = emf.createEntityManager();

        Teacher t = new Teacher(teacherName);

        Course c = new Course(courseName);

        em.getTransaction().begin();
        em.persist(t);
        em.persist(c);
        em.getTransaction().commit();

        em.close();
    }

    void removeACourseFromTeacher(int courseId, String name) {
        EntityManager em = emf.createEntityManager();

        em.find(Course.class, courseId);

        TypedQuery<Teacher> q = em.createQuery("SELECT t FROM Teacher t WHERE t.name =:tName", Teacher.class);
        q.setParameter("tName", name);
        Teacher t = q.getSingleResult();

        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();

        em.close();
    }

    void showAllCoursesOfATeacher(int id) {
        EntityManager em = emf.createEntityManager();

        Teacher t = em.find(Teacher.class, id);

        System.out.println(t.getCourses());

        em.close();
    }

    void RemoveATeacherFromACourse(String teacherName, int courseId) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c WHERE c.id =:cId", Course.class);
        q.setParameter("cId", courseId);
        Course id = q.getSingleResult();

        em.getTransaction().begin();
        em.remove(id);
        em.getTransaction().commit();

        em.close();
    }
}
