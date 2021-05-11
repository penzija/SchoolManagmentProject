package dao;

import dao.StudentDao;
import schoolmanagmentproject.domain.Student;

public class StudentMethods {

    static StudentDao studentDao = new StudentDao();

    public static void add(String name) {
        studentDao.create(name);
    }

    public static void delete(int id) {
        studentDao.delete(id);
    }

    public static void Update(int id, String newName) {
        studentDao.update(id, newName);
    }

    public static void showAll() {
        studentDao.showAll();
    }

}
