package schoolmanagmentproject;

import dao.EducationMethods;
import dao.CourseMethods;
import dao.StudentMethods;
import dao.TeacherMethods;
import dao.SharedCourseTeacherMethods;
import dao.SharedEducationStudentMethods;
import dao.SharedEducationTeacherMethods;

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

    void addCourse() {
        System.out.println("Name course :");
        String nameCourse = tools.readText();

        CourseMethods.add(nameCourse);
    }

    void removeACourse() {
        System.out.println("Course id:");
        int id = tools.readInt();

        CourseMethods.remove(id);
    }

    void updateCourseName() {
        System.out.println("Course Id:");
        int id = tools.readInt();
        System.out.println("New name:");
        String newName = tools.readText();

        CourseMethods.update(id, newName);
    }

    void showAllCourses() {
        CourseMethods.showAll();
    }

    void addEducation() {
        System.out.println("Add education:");
        String name = tools.readText();

        EducationMethods.add(name);
    }

    void removeEducation() {
        System.out.println("Education id:");
        int id = tools.readInt();

        EducationMethods.remove(id);
    }

    void addExistingCourseToExistingTeacher() {
        System.out.println("Teacher id:");
        int teacherId = tools.readInt();
        System.out.println("Course:");
        String course = tools.readText();

        SharedCourseTeacherMethods.addExistingCourseToExistingTeacher(teacherId, course);
    }

    void addNewCourseToExistingTeacher() {
        System.out.println("Teacher id:");
        int teacherId = tools.readInt();

        System.out.println("Name course:");
        String nameCourse = tools.readText();

        SharedCourseTeacherMethods.addNewCourseToExistingTeacher(teacherId, nameCourse);
    }

    void addNewTeacherAndNewCourse() {
        System.out.println("Teacher name:");
        String teacherName = tools.readText();
        System.out.println("Course name:");
        String courseName = tools.readText();

        SharedCourseTeacherMethods.addNewTeacherAndNewCourse(teacherName, courseName);
    }

    void removeACourseFromTeacher() {
        System.out.print("Course id:");
        int courseId = tools.readInt();

        System.out.print("Teacher name:");
        String name = tools.readText();

        SharedCourseTeacherMethods.removeACourseFromTeacher(courseId, name);
    }

    void showAllCoursesOfATeacher() {
        System.out.println("Teacher id:");
        int id = tools.readInt();

        SharedCourseTeacherMethods.showAllCoursesOfATeacher(id);
    }

    void RemoveATeacherFromACourse() {
        System.out.print("Teacher name:");
        String teacherName = tools.readText();

        System.out.print("Course id:");
        int courseId = tools.readInt();

        SharedCourseTeacherMethods.RemoveATeacherFromACourse(teacherName, courseId);
    }

    void addExistingEducationWithExistingStudent() {

        System.out.println("Education id:");
        int educationId = tools.readInt();

        System.out.println("Student name:");
        String name = tools.readText();

        SharedEducationStudentMethods.addExistingEducationWithExistingStudent(educationId, name);
    }

    void addExistingEducationWithExistingTeacher() {

        System.out.println("Education id:");
        int educationId = tools.readInt();

        System.out.println("Teacher id:");
        int id = tools.readInt();

        SharedEducationTeacherMethods.addExistingEducationWithExistingTeacher(educationId, id);
    }
}
