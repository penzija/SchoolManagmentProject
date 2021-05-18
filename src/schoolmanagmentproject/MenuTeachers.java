package schoolmanagmentproject;

import static schoolmanagmentproject.Main.mainMenuMethods;

public class MenuTeachers {

    static Tools tools = new Tools();
    static boolean loop = true;

    public static void menuTeachers() {
        loop=true;
        while (loop) {
            System.out.println("===========================================");
            System.out.println("               Menu teachers");
            System.out.println("===========================================");
            System.out.println("1.Add teacher");
            System.out.println("2.Remove a teacher");
            System.out.println("3.Show all teachers");
            System.out.println("4.Update teacher name");
            System.out.println("=================================");
            System.out.println("0. GO BACK TO MAIN MENU");
            System.out.println("========================================");
            System.out.print("Make your choice: ");
            int select = tools.readInt();
            System.out.println("");

            switch (select) {
                case 1:
                    mainMenuMethods.addTeacher();                               // OK
                    break;
                case 2:
                    mainMenuMethods.deleteTeacher();                            // OK
                    break;
                case 3:
                    mainMenuMethods.showAllTeachers();                          //OK
                    break;
                case 4:
                    mainMenuMethods.updateTeacher();
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
