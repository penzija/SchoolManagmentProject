package dao;

public class EducationToCourseMethods {

    static EducationToCourseDao educationToCourseDao = new EducationToCourseDao();

    public static void addExistingEducationToExistingCourse(String educationName, String courseName) {
        educationToCourseDao.addExistingEducationToExistingCourse(educationName, courseName);
    }

    public static void addNewEducationToExistingCourse(String newEducationName, String courseName) {
        educationToCourseDao.addNewEducationToExistingCourse(newEducationName, courseName);
    }

    public static void addExistingEducationToNewCourse(String educationName, String newCourseName) {
        educationToCourseDao.addExistingEducationToNewCourse(educationName, newCourseName);
    }

    public static void addNewEducationToNewCourse(String newEducationName, String newCourseName) {
        educationToCourseDao.addNewEducationToNewCourse(newEducationName, newCourseName);
    }

    public static void removeEducationFromCourse(String educationName, String courseName) {
        educationToCourseDao.removeEducationFromCourse(educationName, courseName);
    }
}
