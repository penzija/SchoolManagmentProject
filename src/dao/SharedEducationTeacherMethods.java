package dao;

public class SharedEducationTeacherMethods {

    static SharedEducationTeacherDao sharedEducationTeacherDao = new SharedEducationTeacherDao();

    public static void addExistingEducationWithExistingTeacher(int educationId, int id) {
        sharedEducationTeacherDao.addExistingEducationWithExistingTeacher(educationId, id);
    }

}
