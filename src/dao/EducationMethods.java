package dao;

public class EducationMethods {

    static EducationDao educationDao = new EducationDao();

    public static void add(String name) {
        educationDao.add(name);
    }

    public static void remove(int id) {
        educationDao.remove(id);
    }

    public static void update(int id, String newName) {
        educationDao.update(id, newName);
    }

    public static void showAll() {
        educationDao.showAll();
    }
}
