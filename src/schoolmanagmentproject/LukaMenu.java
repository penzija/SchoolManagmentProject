package schoolmanagmentproject;

public class LukaMenu {

    static boolean loop = true;
    static Tools tools = new Tools();
    static MainMenuMethods mainMenuMethods = new MainMenuMethods();

    public static void main(String[] args) {

        while (loop) {
            menu();
        }
    }

    private static void menu() {

        System.out.println("\n========================================");
        System.out.println("                 Menu                 ");
        System.out.println("========================================");
        System.out.println("STUDENT MANAGMENT");
        System.out.println("1.Add a student");
        System.out.println("2.Remove a student");
        System.out.println("3.Update student information");
        System.out.println("4.Show all students");
        System.out.println("");
        System.out.println("TEACHER MANAGMENT");
        System.out.println("5.Add a teacher");
        System.out.println("6.Remove a teacher");
        System.out.println("7.Update teacher information");
        System.out.println("8.Show all teachers");
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
