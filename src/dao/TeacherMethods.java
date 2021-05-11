package dao;

public class TeacherMethods {

    static TeacherDao teacherDao = new TeacherDao();

    public static void create(String name) {
        teacherDao.create(name);
    }

    public static void delete(int id) {
        teacherDao.delete(id);
    }

    public static void update(int id, String newName) {
        teacherDao.update(id, newName);
    }

    public static void showAll() {
        teacherDao.showAll();
    }

}
