package dao;

public class SharedCourseTeacherMethods {

    static SharedCourseTeacherDao sharedCourseTeacherDao = new SharedCourseTeacherDao();

    public static void addExistingCourseToExistingTeacher(int teacherId, String course) {
        sharedCourseTeacherDao.addExistingCourseToExistingTeacher(teacherId, course);
    }

    public static void addNewCourseToExistingTeacher(int teacherId, String nameCourse) {
        sharedCourseTeacherDao.addNewCourseToExistingTeacher(teacherId, nameCourse);
    }

    public static void addNewTeacherAndNewCourse(String teacherName, String courseName) {
        sharedCourseTeacherDao.addNewTeacherAndNewCourse(teacherName, courseName);
    }

    public static void removeACourseFromTeacher(int courseId, String name) {
        sharedCourseTeacherDao.removeACourseFromTeacher(courseId, name);
    }

    public static void showAllCoursesOfATeacher(int id) {
        sharedCourseTeacherDao.showAllCoursesOfATeacher(id);
    }

    public static void RemoveATeacherFromACourse(String teacherName, int courseId) {
        sharedCourseTeacherDao.RemoveATeacherFromACourse(teacherName, courseId);
    }

}
