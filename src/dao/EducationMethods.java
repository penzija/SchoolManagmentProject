package dao;

public class EducationMethods {

    static EducationDao educationDao = new EducationDao();

    public static void add(String name) {
        educationDao.add(name);
    }

    public static void remove(int id) {
        educationDao.remove(id);
    }
}
