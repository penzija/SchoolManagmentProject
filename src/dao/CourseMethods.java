package dao;

public class CourseMethods {

    static CourseDao courseDao = new CourseDao();

    public static void add(String nameCourse) {
        courseDao.add(nameCourse);
    }

    public static void remove(String courseName) {
        courseDao.remove(courseName);
    }

    public static void removeById(int courseId) {
        courseDao.removeById(courseId);
    }

    public static void update(int id, String newName) {
        courseDao.update(id, newName);
    }

    public static void showAll() {
        courseDao.showAll();
    }
}
