package schoolmanagmentproject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.exceptions.PersistenceUnitLoadingException;
import schoolmanagmentproject.domain.Course;
import schoolmanagmentproject.domain.Student;

public class LukaMenu {

    static boolean loop = true;
    static Tools tools = new Tools();
    static MainMenuMethods mainMenuMethods = new MainMenuMethods();
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public static void main(String[] args) {

        while (loop) {
            menu();
        }
    }

    private static void menu() {

        System.out.println("===========================================");
        System.out.println("               Menu teachers");
        System.out.println("===========================================");
        System.out.println("26.Add teacher");
        System.out.println("29.Remove a teacher");
        System.out.println("x. Update a teacher's name");
        System.out.println("31.Show all teachers");

        System.out.println("3. Add existing teacher to existing course");
        System.out.println("2. Add a new teacher to an existing course");
        System.out.println("4. Add an existing teacher to a new course");
        System.out.println("5. Add new course and a new teacher");

        System.out.println("6. Remove the teacher from a course");

        System.out.println("11.Show the teacher of a course");

        System.out.println("===========================================");
        System.out.println("               Menu Educations");
        System.out.println("===========================================");
        System.out.println("13.Add Education");
        System.out.println("14.Remove education");
        System.out.println("21.Update education name");
        System.out.println("22.Show all educations");

        System.out.println("15.Add existing education to existing student");
        System.out.println("x.Add a new education to an existing student");
        System.out.println("17.Add an existing education to a new student");
        System.out.println("x.Add a new education to a new student");

        System.out.println("x.Add existing education to existing course");
        System.out.println("x.Add a new education to an existing course");
        System.out.println("x.Add an existing education to a new course");
        System.out.println("x.Add a new education to a new course");

        System.out.println("25.Remove an education from a student");
        System.out.println("19.Remove an education from a course");

        System.out.println("x.Education -> show all courses");
        System.out.println("x.Education -> show all students");

        System.out.println("===========================================");
        System.out.println("              Menu students");
        System.out.println("===========================================");
        System.out.println("36.Add student");
        System.out.println("39.Remove a student");
        System.out.println("x.Update student data");
        System.out.println("41.Show all students");

        System.out.println("38.Add existing course to existing student");
        System.out.println("x.Add a new course to a existing student");
        System.out.println("37.Add existing course to new student");
        System.out.println("x.Add a new course to a new student");

        System.out.println("40.Remove a student from a course");

        System.out.println("x. Students -> show all educations");
        System.out.println("44.Students -> show all courses");

        System.out.println("\n========================================");
        System.out.println("               Courses Menu                ");
        System.out.println("==========================================");
        System.out.println("1. Add course");
        System.out.println("7. Remove a course");
        System.out.println("9. Update course name");
        System.out.println("8. Show all courses");

        System.out.println("x. Course -> show the teacher");
        System.out.println("x. Course -> show all students");
        System.out.println("x. Course -> show all educations");

        System.out.println("=================================");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Make your choice: ");
        int choice = tools.readInt();
        System.out.println("");

        switch (choice) {

            case 1:
                mainMenuMethods.addStudent();
                break;
            case 2:
                mainMenuMethods.deleteStudent();
                break;
            case 3:
                mainMenuMethods.updateStudent();
                break;

            case 4:
                mainMenuMethods.showAllStudents();
                EntityManager em = emf.createEntityManager();

                Student student = new Student("Anamarija");
                Course course = new Course("entropy");
                student.addCourse(course);
                em.getTransaction().begin();
                em.persist(student);
                em.persist(course);
                em.getTransaction().commit();
                em.close();
                break;
            case 5:
                mainMenuMethods.addTeacher();
                break;
            case 6:
                mainMenuMethods.deleteTeacher();
                break;
            case 7:
                mainMenuMethods.updateTeacher();
                break;

            case 8:
                mainMenuMethods.showAllTeachers();
                break;

            case 0:
                loop = false;
                break;

            default:
                System.out.println("No such choice!");
        }

//        Add educations of different kind
//• Update education information2
//• Show information about a specific education
//• Show all educations
//• Update course information
//• Show information about a specific course
//• Show all courses
//• Remove a course
//• 
//• 
//• Show information about a specific student
//• 
//• 
//• Add courses to educations
//• List all courses in an education
//• remove courses from educations
//• Add students to educations
//• remove students from an education
//• List all students in an education
    }

}
