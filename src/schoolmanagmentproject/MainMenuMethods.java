package schoolmanagmentproject;

import dao.EducationMethods;
import dao.CourseMethods;
import dao.EducationToCourseMethods;
import dao.StudentMethods;
import dao.TeacherMethods;
import dao.TeacherToCourseMethods;
import dao.EducationToStudentMethods;
import dao.StudentToCourseMethods;

public class MainMenuMethods {

    static Tools tools = new Tools();

    void addCourse() {
        System.out.println("Name course :");
        String nameCourse = tools.readText();

        CourseMethods.add(nameCourse);
    }

    void removeCourse() {
        System.out.println("1. Delete by ID");
        System.out.println("2. Delete by name");
        int select = tools.readInt();
        switch (select) {
            case 1: {
                System.out.print("Insert the id of the course: ");
                int courseId = tools.readInt();
                CourseMethods.removeById(courseId);
                break;
            }
            case 2: {
                System.out.println("Course name:");
                String courseName = tools.readText();
                CourseMethods.remove(courseName);
                break;
            }
            default:
                System.out.println("No such choice!");
                break;
        }
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

    void addExistingCourseToExistingTeacher() {
        System.out.println("Teacher id:");
        int teacherId = tools.readInt();
        System.out.println("Insert the name of the course:");
        String courseName = tools.readText();

        TeacherToCourseMethods.addExistingTeacherToExistingCourse(teacherId, courseName);
    }

    void addNewCourseToExistingTeacher() {
        System.out.println("Teacher id:");
        int teacherId = tools.readInt();

        System.out.println("Name the new course:");
        String nameCourse = tools.readText();

        TeacherToCourseMethods.addNewCourseToExistingTeacher(teacherId, nameCourse);
    }

    void addExistingCourseToNewTeacher() {
        System.out.print("Write the name of the course: ");
        String nameCourse = tools.readText();

        System.out.print("Write the name of the teacher: ");
        String nameTeacher = tools.readText();

        TeacherToCourseMethods.addExistingCourseToNewTeacher(nameCourse, nameTeacher);
    }

    void addNewTeacherAndNewCourse() {
        System.out.println("Teacher name:");
        String teacherName = tools.readText();
        System.out.println("Course name:");
        String courseName = tools.readText();

        TeacherToCourseMethods.addNewTeacherAndNewCourse(teacherName, courseName);
    }

    void removeTeacherFromCourse() {
        System.out.print("Course name:");
        String courseName = tools.readText();

        System.out.print("Teacher id:");
        int teacherId = tools.readInt();

        TeacherToCourseMethods.removeTeacherFromCourse(teacherId, courseName);
    }

    void showAllCoursesOfATeacher() {
        System.out.println("Teacher id:");
        int id = tools.readInt();

        TeacherToCourseMethods.showAllCoursesOfATeacher(id);
    }

    void showTheTeacherOfTheCourse() {
        System.out.print("Insert the course ID: ");
        int id = tools.readInt();

        TeacherToCourseMethods.showTheTeacherOfTheCourse(id);
    }

    // Course Menu up to here
    // Education Menu starts here
    void addEducation() {
        System.out.println("Add education:");
        String name = tools.readText();

        EducationMethods.add(name);
    }

    void addExistingEducationToExistingStudent() {
        System.out.println("Education name:");
        String educationName = tools.readText();

        System.out.println("Student id:");
        int studentId = tools.readInt();

        EducationToStudentMethods.addExistingEducationToExistingStudent(educationName, studentId);
    }

    void addExistingEducationToNewStudent() {
        System.out.print("Insert the ID of the education: ");
        int educationId = tools.readInt();
        System.out.print("Write the name of the student: ");
        String studentName = tools.readText();

        EducationToStudentMethods.addExistingEducationeToNewStudent(educationId, studentName);
    }

    void addExistingEducationToExistingCourse() {
        System.out.print("Write the name of the course: ");
        String courseName = tools.readText();

        System.out.print("Insert the name of the education: ");
        String educationName = tools.readText();

        EducationToCourseMethods.addExistingEducationToExistingCourse(educationName, courseName);
    }

    void addNewEducationToExistingCourse() {
        System.out.print("Insert the name of the course: ");
        String courseName = tools.readText();
        System.out.print("Insert the name of the new education:");
        String newEducationName = tools.readText();

        EducationToCourseMethods.addNewEducationToExistingCourse(newEducationName, courseName);
    }

    void addExistingEducationToNewCourse() {
        System.out.print("Insert the name of the education:");
        String educationName = tools.readText();

        System.out.print("Insert the name of the new course: ");
        String newCourseName = tools.readText();

        EducationToCourseMethods.addExistingEducationToNewCourse(educationName, newCourseName);
    }

    void addNewEducationToNewCourse() {
        System.out.print("Insert the name of the new education: ");
        String newEducationName = tools.readText();

        System.out.println("Insert the name of the new course: ");
        String newCourseName = tools.readText();

        EducationToCourseMethods.addNewEducationToNewCourse(newEducationName, newCourseName);
    }

    void removeEducation() {
        System.out.println("Education id:");
        int id = tools.readInt();

        EducationMethods.remove(id);
    }

    void removeEducationFromCourse() {
        System.out.print("Insert the name of the education: ");
        String educationName = tools.readText();

        System.out.print("Insert the name of the course: ");
        String courseName = tools.readText();

        EducationToCourseMethods.removeEducationFromCourse(educationName, courseName);
    }

    void removeEducationFromStudent() {
        System.out.print("Insert the ID of the education: ");
        int educationId = tools.readInt();

        System.out.print("Insert the ID of the student: ");
        int studentId = tools.readInt();

        EducationToStudentMethods.removeEducationFromStudent(educationId, studentId);
    }

    void updateEducation() {
        System.out.println("Education Id:");
        int id = tools.readInt();

        System.out.print("Insert the new name of the education: ");
        String newName = tools.readText();

        EducationMethods.update(id, newName);
    }

    void showAllEducations() {
        EducationMethods.showAll();
    }

    // Education Menu up to here
    // Teacher Menu starts here
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

    void showAllTeachers() {
        TeacherMethods.showAll();
    }

    void updateTeacher() {
        System.out.print("Insert the ID of the teacher you want to modify: ");
        int id = tools.readInt();

        System.out.println("Insert the new name: ");
        String newName = tools.readText();

        TeacherMethods.update(id, newName);
    }

    // Teacher Menu up to here
    // Student Menu starts here
    void addStudent() {
        System.out.print("Insert the name of the student: ");
        String name = tools.readText();

        StudentMethods.add(name);
    }

    void addExistingStudentToExistingCourse() {
        System.out.print("Insert the ID of the student: ");
        int studentId = tools.readInt();
        System.out.print("Insert the name of the course: ");
        String courseName = tools.readText();

        StudentToCourseMethods.addExistingStudentToExistingCourse(studentId, courseName);
    }

    void addNewStudentToExistingCourse() {
        System.out.print("Insert the name of the student: ");
        String newName = tools.readText();

        System.out.print("Insert the name of the course: ");
        String courseName = tools.readText();

        StudentToCourseMethods.addNewStudentToExistingCourse(newName, courseName);
    }

    void addExistingStudentToNewCourse() {
        System.out.print("Insert the ID of the student: ");
        int studentId = tools.readInt();

        System.out.print("Insert the name of the new course: ");
        String newCourseName = tools.readText();

        StudentToCourseMethods.addExistingStudentToNewCourse(studentId, newCourseName);
    }

    void addNewStudentToNewCourse() {
        System.out.print("Insert the name of the new student: ");
        String newName = tools.readText();

        System.out.print("Insert the name of the new course: ");
        String newCourseName = tools.readText();

        StudentToCourseMethods.addNewStudentToNewCourse(newName, newCourseName);
    }

    void deleteStudent() {
        System.out.print("Insert the ID of the student you want to remove: ");
        int id = tools.readInt();

        StudentMethods.delete(id);
    }

    void removeStudentFromCourse() {
        System.out.print("Insert the ID of the student: ");
        int studentId = tools.readInt();
        System.out.print("Insert the name of the course: ");
        String courseName = tools.readText();

        StudentToCourseMethods.removeStudentFromCourse(studentId, courseName);
    }

    void showAllStudents() {
        StudentMethods.showAll();
    }

    void updateStudent() {
        System.out.print("Insert the ID of the student you want to modify: ");
        int id = tools.readInt();

        System.out.println("Insert the new name: ");
        String newName = tools.readText();

        StudentMethods.update(id, newName);
    }

    void showAllCoursesOfStudent() {
        System.out.print("Insert the ID of the student: ");
        int studentId = tools.readInt();

        StudentToCourseMethods.showAllCoursesOfStudent(studentId);
    }

    void showEducationOfStudent() {
        System.out.print("Insert the ID of the student: ");
        int studentId = tools.readInt();
        EducationToStudentMethods.showEducationOfStudent(studentId);
    }

    void showAllStudentsOfCourse() {
        System.out.print("Insert the name of the course: ");
        String courseName = tools.readText();

        StudentToCourseMethods.showAllStudentsOfCourse(courseName);
    }
}
