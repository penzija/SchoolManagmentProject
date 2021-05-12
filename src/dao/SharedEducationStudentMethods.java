package dao;

public class SharedEducationStudentMethods {
    
    static SharedEducationStudentDao sharedEducationStudentDao = new SharedEducationStudentDao();

    public static void addExistingEducationWithExistingStudent(int educationId, String name) {
        
        sharedEducationStudentDao.addExistingEducationWithExistingStudent(educationId, name);
        
        
        
        
        
    }
    

}
