package schoolmanagmentproject;

public class Main {

    static boolean loop = true;
    static Tools tools = new Tools();
    static MainMenuMethods mainMenuMethods = new MainMenuMethods();
    static Statistics statistics = new Statistics();

    public static void main(String[] args) {
        while (loop) {
            menu();
        }
    }

    public static void menu() {
        System.out.println("===========================================");
        System.out.println("        SCHOOL MANAGMENT PROGRAM");
        System.out.println("===========================================");
        System.out.println("1. Courses menu");
        System.out.println("2. Educations menu");
        System.out.println("3. Teachers menu");
        System.out.println("4. Students menu");
        System.out.println("5. Various statistics");
        System.out.println("0. Exit");
        int select = tools.readInt();
        System.out.println("");

        switch (select) {
            case 1:
                MenuCourses.menuCourses();
                break;
            case 2:
                MenuEducation.menuEducation();
                break;
            case 3:
                MenuTeachers.menuTeachers();
                break;
            case 4:
                MenuStudents.menuStudents();
                break;
            case 5:
                statistics.statistics();
                break;
            case 0:
                loop = false;
                break;
            default:
                System.out.println("No such choice!");
                break;
        }
    }
}
