package schoolmanagmentproject;

import dao.StudentMethods;
import dao.TeacherMethods;

public class MainMenuMethods {

    static Tools tools = new Tools();

    void addStudent() {
        System.out.print("Insert the name of the student: ");
        String name = tools.readText();

        StudentMethods.add(name);
    }

    void deleteStudent() {
        System.out.print("Insert the ID of the student you want to delete: ");
        int id = tools.readInt();

        StudentMethods.delete(id);
    }

    void updateStudent() {
        System.out.print("Insert the ID of the student you want to modify: ");
        int id = tools.readInt();

        System.out.println("Insert the new name: ");
        String newName = tools.readText();

        StudentMethods.Update(id, newName);
    }

    void showAllStudents() {
        StudentMethods.showAll();
    }

    void addTeacher() {
        System.out.print("Insert the name of the teacher: ");
        String name = tools.readText();

        TeacherMethods.create(name);
    }

    void deleteTeacher() {
        System.out.print("Insert the ID of the teacher you want to delete: ");
        int id = tools.readInt();

        TeacherMethods.delete(id);
    }

    void updateTeacher() {
        System.out.print("Insert the ID of the teacher you want to modify: ");
        int id = tools.readInt();

        System.out.println("Insert the new name: ");
        String newName = tools.readText();

        TeacherMethods.update(id, newName);
    }

    void showAllTeachers() {
        TeacherMethods.showAll();
    }
}
