package schoolmanagmentproject;

import static schoolmanagmentproject.Main.mainMenuMethods;

public class MenuEducation {

    static Tools tools = new Tools();
    static boolean loop = true;

    public static void menuEducation() {
        loop = true;
        while (loop) {
            System.out.println("===========================================");
            System.out.println("               Menu Educations");
            System.out.println("===========================================");
            System.out.println("1.Add education");
            System.out.println("");
            System.out.println("2.Add existing education to existing student");
            System.out.println("3.Add an existing education to a new student");
            System.out.println("4.Add an existing course to an existing education");
            System.out.println("5.Add a new course to an existing education");
            System.out.println("");
            System.out.println("6.Remove education");
            System.out.println("7.Remove a course from education");
            System.out.println("8.Remove students from a education");
            System.out.println("");
            System.out.println("9.Update education name");
            System.out.println("10.Show all educations");
            System.out.println("=================================");
            System.out.println("0. GO BACK TO MAIN MENU");
            System.out.println("========================================");
            System.out.print("Make your choice: ");
            int select = tools.readInt();
            System.out.println("");

            switch (select) {
                case 1:
                    mainMenuMethods.addEducation();                             //
                    break;
                case 2:
                    mainMenuMethods.addExistingEducationToExistingStudent();
                    break;
                case 3:
                    mainMenuMethods.addExistingEducationToNewStudent();       //
                    break;
                case 4:
                    mainMenuMethods.addExistingEducationToExistingCourse();     // OK
                    break;
                case 5:
                    mainMenuMethods.addExistingEducationToNewCourse();              // OK
                    break;
                case 6:
                    mainMenuMethods.removeEducation();                              // OK
                    break;
                case 7:
                    mainMenuMethods.removeEducationFromCourse();                //
                    break;
                case 8:
                    mainMenuMethods.removeEducationFromStudent();         //
                    break;
                case 9:
                    mainMenuMethods.updateEducation();                          // OK
                    break;
                case 10:
                    mainMenuMethods.showAllEducations();                        // OK
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
