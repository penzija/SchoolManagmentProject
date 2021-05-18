package dao;

public class EducationToStudentMethods {

    static EducationToStudentDao educationToStudentDao = new EducationToStudentDao();

    public static void addExistingEducationToExistingStudent(String educationName, int studentId) {
        educationToStudentDao.addExistingEducationToExistingStudent(educationName, studentId);
    }

    public static void addExistingEducationeToNewStudent(int educationId, String studentName) {
        educationToStudentDao.addExistingEducationeToNewStudent(educationId, studentName);
    }

    public static void removeEducationFromStudent(int educationId, int studentId) {
        educationToStudentDao.removeEducationFromStudent(educationId, studentId);
    }

    public static void showEducationOfStudent(int studentId) {
        educationToStudentDao.showEducationOfStudent(studentId);
    }
}
