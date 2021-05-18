package dao;

public class TeacherToCourseMethods {

    static TeacherToCourseDao teacherToCourseDao = new TeacherToCourseDao();

    public static void addExistingTeacherToExistingCourse(int teacherId, String courseName) {
        teacherToCourseDao.addExistingCourseToExistingTeacher(teacherId, courseName);
    }

    public static void addNewCourseToExistingTeacher(int teacherId, String nameCourse) {
        teacherToCourseDao.addNewCourseToExistingTeacher(teacherId, nameCourse);
    }

    public static void addExistingCourseToNewTeacher(String nameCourse, String nameTeacher) {
        teacherToCourseDao.addExistingCourseToNewTeacher(nameCourse, nameTeacher);
    }

    public static void addNewTeacherAndNewCourse(String teacherName, String courseName) {
        teacherToCourseDao.addNewTeacherAndNewCourse(teacherName, courseName);
    }

    public static void removeTeacherFromCourse(int teacherId, String courseName) {
        teacherToCourseDao.removeTeacherFromCourse(teacherId, courseName);
    }

    public static void showAllCoursesOfATeacher(int id) {
        teacherToCourseDao.showAllCoursesOfATeacher(id);
    }

    public static void showTheTeacherOfTheCourse(int id) {
        teacherToCourseDao.showTheTeacherOfTheCourse(id);
    }
}
