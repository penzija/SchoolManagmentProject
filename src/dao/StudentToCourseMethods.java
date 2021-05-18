package dao;

public class StudentToCourseMethods {

    static StudentToCourseDao studentToCourseDao = new StudentToCourseDao();

    public static void addExistingStudentToExistingCourse(int studentId, String courseName) {
        studentToCourseDao.addExistingStudentToExistingCourse(studentId, courseName);
    }

    public static void addNewStudentToExistingCourse(String newName, String courseName) {
        studentToCourseDao.addNewStudentToExistingCourse(newName, courseName);
    }

    public static void addExistingStudentToNewCourse(int studentId, String newCourseName) {
        studentToCourseDao.addExistingStudentToNewCourse(studentId, newCourseName);
    }

    public static void addNewStudentToNewCourse(String newName, String newCourseName) {
        studentToCourseDao.addNewStudentToNewCourse(newName, newCourseName);
    }

    public static void removeStudentFromCourse(int studentId, String courseName) {
        studentToCourseDao.removeStudentFromCourse(studentId, courseName);
    }

    public static void showAllCoursesOfStudent(int studentId) {
        studentToCourseDao.showAllCoursesOfStudent(studentId);
    }

    public static void showAllStudentsOfCourse(String courseName) {
        studentToCourseDao.showAllStudentsOfCourse(courseName);
    }
}
