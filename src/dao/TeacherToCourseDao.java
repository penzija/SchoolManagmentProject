package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagmentproject.domain.Course;
import schoolmanagmentproject.domain.Teacher;

public class TeacherToCourseDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void addExistingCourseToExistingTeacher(int teacherId, String courseName) {
        EntityManager em = emf.createEntityManager();

        try {
            Teacher teacher = em.find(Teacher.class, teacherId);

            TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c WHERE c.name =:nameCourse", Course.class);
            q.setParameter("nameCourse", courseName);
            Course course = q.getSingleResult();

            em.getTransaction().begin();
            teacher.addCourse(course);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("The data you entered is incorrect.");
        }
    }

    void addNewCourseToExistingTeacher(int teacherId, String nameCourse) {
        EntityManager em = emf.createEntityManager();

        Course course = new Course(nameCourse);

        try {
            Teacher exTeacher = em.find(Teacher.class, teacherId);

            exTeacher.addCourse(course);

            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Error! no teacher found with this ID.");
        }
    }

    void addExistingCourseToNewTeacher(String courseName, String teacherName) {
        EntityManager em = emf.createEntityManager();

        Teacher newTeacher = new Teacher(teacherName);
        try {
            TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c WHERE c.name =:n", Course.class);
            q.setParameter("n", courseName);

            Course exCourse = q.getSingleResult();

            exCourse.setTeacher(newTeacher);
            newTeacher.addCourse(exCourse);

            em.getTransaction().begin();
            em.persist(newTeacher);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Error! No course with this name.");
        }
    }

    void addNewTeacherAndNewCourse(String teacherName, String courseName) {
        EntityManager em = emf.createEntityManager();

        Teacher teacher = new Teacher(teacherName);
        Course course = new Course(courseName);

        teacher.addCourse(course);

        em.getTransaction().begin();
        em.persist(teacher);
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    void removeTeacherFromCourse(int teacherId, String courseName) {
        EntityManager em = emf.createEntityManager();

        try {
            Teacher teacher = em.find(Teacher.class, teacherId);

            TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c WHERE c.name =:n", Course.class);
            q.setParameter("n", courseName);
            Course course = q.getSingleResult();

            teacher.removeCourse(course);

            em.getTransaction().begin();
            em.merge(teacher);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println("The input you entered is not correct.");
            System.out.println("");
        }
    }

    void showAllCoursesOfATeacher(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Teacher t = em.find(Teacher.class, id);

            System.out.println("The teacher " + t.getId() + ", " + t.getName() + ", has the following courses:");
            System.out.println("");

            List<Course> courses = t.getCourses();
            if (courses == null) {
                for (Course course : courses) {
                    System.out.println("ID: " + course.getId() + " NAME: " + course.getName());
                }
            } else {
                System.out.println("This teacher has currently no courses to teach.");
            }
            em.close();
        } catch (Exception e) {
            System.out.println("There is no teacher with this ID.");
        }
    }

    void showTheTeacherOfTheCourse(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Course course = em.find(Course.class, id);

            System.out.println("This course has the teacher:");
            System.out.println("");

            if (course.getTeacher() == null) {
                System.out.println("No teachers attached to this course!");
            } else {
                System.out.println(course.getTeacher());
            }
        } catch (Exception e) {
            System.out.println("There is no course with this ID.");
        }
    }
}
