package schoolmanagmentproject;

import java.util.Scanner;

public class JessicaMenu {

    static Scanner sc = new Scanner(System.in);
    static Boolean loop = true;
    static MainMenuMethods mainMenuMethods = new MainMenuMethods();

    public static void main(String[] args) {
        while (loop) {
            menu();
        }
    }

    private static void menu() {
        System.out.println("\n========================================");
        System.out.println("               Menu Courses                 ");
        System.out.println("==========================================");
        System.out.println("1. Add course");
        System.out.println("2. Add existing course to new teacher");
        System.out.println("3. Add existing course to existing teacher");
        System.out.println("4. Add new course to existing teacher");
        System.out.println("5. Add new teacher and course");
        System.out.println("6. Remove a course from a teacher");
        System.out.println("7. Remove a course");
        System.out.println("8. Show all courses");
        System.out.println("9. Update course name");
        System.out.println("10.Show all courses of a teacher");
        System.out.println("11.Show all teachers of a course");
        System.out.println("12.Remove a teacher from a course");
        System.out.println("===========================================");
        System.out.println("               Menu Educations");
        System.out.println("===========================================");
        System.out.println("13.Add Education");
        System.out.println("14.Remove Education");
        System.out.println("15.Add existing education with existing student");
        System.out.println("16.Add existing education with existing teacher");
        System.out.println("17.Add Education to new student");
        System.out.println("18.Add Education to a new teacher");
        System.out.println("19.Remove a course from education");
        System.out.println("20.Add course to education");
        System.out.println("21.Update eduaction name");
        System.out.println("22.Show all eductions");
        System.out.println("23.Update education information");
        System.out.println("24.Show information about a specific education");
        System.out.println("25.Remove students from a education");
        System.out.println("===========================================");
        System.out.println("               Menu teachers");
        System.out.println("===========================================");
        System.out.println("26.Add teacher");
        System.out.println("27.Add existing course to new teacher");
        System.out.println("28.Add existing course to existing teacher");
        System.out.println("29.Remove a teacher");
        System.out.println("30.Remove a course from a teacher");
        System.out.println("31.Show all teachers");
        System.out.println("32.Update teacher name");
        System.out.println("33.Show all courses of a teacher");
        System.out.println("34.Show all teachers of a course");
        System.out.println("35.Remove a teacher from a course");
        System.out.println("===========================================");
        System.out.println("              Menu students");
        System.out.println("===========================================");
        System.out.println("36.Add student");
        System.out.println("37.Add existing course to new student");
        System.out.println("38.Add existing course to existing student");
        System.out.println("39.Remove a student");
        System.out.println("40.Remove a course from a student");
        System.out.println("41.Show all students");
        System.out.println("42.Update teacher name");
        System.out.println("43.Show all courses of a student");
        System.out.println("44.Show all students of a course");
        System.out.println("45.Remove a student from a course");
        System.out.println("=================================");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Make your choice:");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                mainMenuMethods.addCourse();                                //OK
                break;
            case 2:
//                addExistingCourseToNewTeacher();
                break;
            case 3:
                mainMenuMethods.addExistingCourseToExistingTeacher();       //OK
                break;
            case 4:
                mainMenuMethods.addNewCourseToExistingTeacher();            //ONE RED LINE IN DAO
                break;
            case 5:
                mainMenuMethods.addNewTeacherAndNewCourse();                //OK
                break;
            case 6:
                mainMenuMethods.removeACourseFromTeacher();                 //OK
                break;
            case 7:
                mainMenuMethods.removeACourse();                            //OK

                break;
            case 8:
                mainMenuMethods.showAllCourses();                           //OK
                break;
            case 9:
                mainMenuMethods.updateCourseName();                         //OK
                break;

            case 10:
                mainMenuMethods.showAllCoursesOfATeacher();                 //OK
                break;

            case 11:
//                showAllTeachersOfACourse();
                break;

            case 12:
                mainMenuMethods.RemoveATeacherFromACourse();                //OK
                break;

            case 13:
                mainMenuMethods.addEducation();                             //OK
                break;
            case 14:
                mainMenuMethods.removeEducation();                          //OK
                break;
            case 15:
                mainMenuMethods.addExistingEducationWithExistingStudent(); //RED LINE IN DAO
                break;
            case 16:
                mainMenuMethods.addExistingEducationWithExistingTeacher();  //OK
                break;
            case 26:
                mainMenuMethods.addTeacher();                               //OK       
                break;
            case 36:
                mainMenuMethods.addStudent();                               //OK
                break;

            case 0:
                loop = false;
                break;
            default:
                System.out.println("No such choice!");
        }
    }

//    private static void showAllTeachers() {
//
//        EntityManager em = emf.createEntityManager();
//
//        TypedQuery<Teacher> q = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
//
//        List<Teacher> t = q.getResultList();
//
//        for (Teacher teacher : t) {
//            System.out.println(teacher);
//            
//        }
//
//        em.close();
//    }
//
//
//    private static void removeATeacher() {
//
//        EntityManager em = emf.createEntityManager();
//        
//        System.out.println("Teacher id:");
//        Long id = sc.nextLong();
//        sc.nextLine();
//        
//        Teacher t = em.find(Teacher.class, id);
//        
//        em.getTransaction().begin();
//        em.remove(t);
//        em.getTransaction().commit();
//        em.close();
//    }
//
//
//    }
//    private static void addExistingCourseToExistingTeacher2() {
//        
////       EntityManager em = emf.createEntityManager();
//        
//        System.out.println("Teacher id:");
//        Long teacherId = sc.nextLong();
//        sc.nextLine();
//
//        System.out.println("Course:");
//        String course = sc.nextLine();
//        
//        Functions.addExistingCourseToExistingTeacher2(teacherId, course);
//
////        Teacher teacher = em.find(Teacher.class, teacherId); 
////        
////        TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c WHERE c.name =:nameCourse", Course.class);
////        q.setParameter("nameCourse", course);
////        Course c = q.getSingleResult();
////        
////
////        em.getTransaction().begin();
////        teacher.addCourse(c);
////        em.getTransaction().commit();
//
//        
////        em.close();
//
//    }
//
//    private static void updateTeacherName() {
//
//        EntityManager em = emf.createEntityManager();
//        
//        System.out.println("Teacher Id:");
//        Long id = sc.nextLong();
//        sc.nextLine();
//
//        Teacher t = em.find(Teacher.class, id);
//
//        if (t != null) {
//            System.out.println(t);
//
//            System.out.println("New name:");
//            String newName = sc.nextLine();
//
//            em.getTransaction().begin();
//
//            t.setName(newName);
//
//            em.getTransaction().commit();
//
//        } else {
//            System.out.println("There is no teacher with that id.");
//        }
//
//        em.close();
//private static void addExistingCourseToNewTeacher() {
//
//          EntityManager em = emf.createEntityManager();
//
//        System.out.println("Course id:");
//        Long courseId = sc.nextLong();
//        sc.nextLine();
//        
//        System.out.println("Teacher name:");
//        String name = sc.nextLine();
//        
//        TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c WHERE c.id =:courseId", Course.class);
//        q.setParameter("courseId", courseId);
//        Course c = q.getSingleResult();
//     
//
//        Teacher t = new Teacher(name);
//        
//        
//        
//        t.addCourse(c);
//
//        em.getTransaction().begin();
//        em.persist(t);
//        em.getTransaction().commit();
//        
//        TypedQuery<Teacher> q2 = em.createQuery("SELECT t FROM Teacher t WHERE t.name=:teacherName", Teacher.class);
//        q2.setParameter("teacherName", name);
//        List<Teacher> t2 = q2.getResultList();
//        
//        System.out.println(t2);
//        
//        em.close();
//    }
    //   private static void showAllTeachersOfACourse() {
    //   }
}
