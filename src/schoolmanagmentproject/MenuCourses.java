package schoolmanagmentproject;

import static schoolmanagmentproject.Main.mainMenuMethods;

public class MenuCourses {

    static Tools tools = new Tools();
    static boolean loop = true;

    public static void menuCourses() {
        loop = true;
        while (loop) {
            System.out.println("===========================================");
            System.out.println("               Menu Courses                 ");
            System.out.println("===========================================");
            System.out.println("1. Add course");
            System.out.println("");
            System.out.println("2. Add existing course to existing teacher");
            System.out.println("3. Add new course to existing teacher");
            System.out.println("4. Add existing course to new teacher");
            System.out.println("5. Add a new teacher and a new course");
            System.out.println("");
            System.out.println("6. Remove a course from a teacher / Remove a teacher from a course");
            System.out.println("7. Remove a course");
            System.out.println("");
            System.out.println("8. Show all courses");
            System.out.println("9. Update course name");
            System.out.println("10.Show all courses of a teacher");
            System.out.println("11.Show the teacher of a course");
            System.out.println("===========================================");
            System.out.println("0. GO BACK TO MAIN MENU");
            System.out.println("===========================================");
            System.out.println("");
            System.out.print("Make your choice: ");
            int choice = tools.readInt();
            System.out.println("");

            switch (choice) {
                case 1:
                    mainMenuMethods.addCourse();                            // OK
                    break;
                case 2:
                    mainMenuMethods.addExistingCourseToExistingTeacher();   // OK
                    break;
                case 3:
                    mainMenuMethods.addNewCourseToExistingTeacher();        // OK
                    break;
                case 4:
                    mainMenuMethods.addExistingCourseToNewTeacher();        // OK
                    break;
                case 5:
                    mainMenuMethods.addNewTeacherAndNewCourse();            // OK
                    break;
                case 6:
                    mainMenuMethods.removeTeacherFromCourse();              // OK
                    break;
                case 7:
                    mainMenuMethods.removeCourse();                         // OK
                    break;
                case 8:
                    mainMenuMethods.showAllCourses();                       // OK
                    break;
                case 9:
                    mainMenuMethods.updateCourseName();                     // OK
                    break;
                case 10:
                    mainMenuMethods.showAllCoursesOfATeacher();             // OK
                    break;
                case 11:
                    mainMenuMethods.showTheTeacherOfTheCourse();            // OK
                    break;
                case 0:
                    loop = false;
                    Main.menu();
                    break;
                default:
                    System.out.println("No such choice!");
                    break;
            }
        }
    }
}
