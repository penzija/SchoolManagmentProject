package schoolmanagmentproject;

import static schoolmanagmentproject.Main.mainMenuMethods;

public class MenuStudents {

    static Tools tools = new Tools();
    static boolean loop = true;

    static void menuStudents() {
        loop = true;
        while (loop) {
            System.out.println("===========================================");
            System.out.println("              Menu students");
            System.out.println("===========================================");
            System.out.println("1. Add student");
            System.out.println("");
            System.out.println("2. Add existing course to existing student");
            System.out.println("3. Add existing course to new student");
            System.out.println("4. Add new course to existing student");
            System.out.println("5. Add a new course to a new student");
            System.out.println("");
            System.out.println("6. Remove a student");
            System.out.println("7. Remove a course from a student");

            System.out.println("8. Show all students");
            System.out.println("9. Update student name");
            System.out.println("10.Show all courses of a student");
            System.out.println("11.Show the education of a student");
            System.out.println("12.Show all students of a course");
            System.out.println("=================================");
            System.out.println("0. BACK TO MAIN MENU");
            System.out.println("========================================");
            System.out.print("Make your choice: ");
            int select = tools.readInt();

            switch (select) {
                case 1:
                    mainMenuMethods.addStudent();
                    break;
                case 2:
                    mainMenuMethods.addExistingStudentToExistingCourse();
                    break;
                case 3:
                    mainMenuMethods.addNewStudentToExistingCourse();
                    break;
                case 4:
                    mainMenuMethods.addExistingStudentToNewCourse();
                    break;
                case 5:
                    mainMenuMethods.addNewStudentToNewCourse();
                    break;
                case 6:
                    mainMenuMethods.deleteStudent();
                    break;
                case 7:
                    mainMenuMethods.removeStudentFromCourse();
                    break;
                case 8:
                    mainMenuMethods.showAllStudents();
                    break;
                case 9:
                    mainMenuMethods.updateStudent();                                // 
                    break;
                case 10:
                    mainMenuMethods.showAllCoursesOfStudent();                     // 
                    break;
                case 11:
                    mainMenuMethods.showEducationOfStudent();                    // NOT OK
                    break;
                case 12:
                    mainMenuMethods.showAllStudentsOfCourse();                      //
                    break;
                case 0:
                    loop = false;
                    Main.menu();
                    break;
                default:
                    System.out.println("No such choice!");
            }
        }
    }
}
