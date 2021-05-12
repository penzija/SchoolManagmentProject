package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagmentproject.domain.Education;
import schoolmanagmentproject.domain.Student;

public class SharedEducationStudentDao {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void addExistingEducationWithExistingStudent(int educationId, String name) {
        EntityManager em = emf.createEntityManager();

        Education e = em.find(Education.class, educationId);

        TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s WHERE s.name =:nameStudent", Student.class);
        q.setParameter("nameStudent", name);
        
        Student s = q.getSingleResult();

        em.getTransaction().begin();
        // EducationDao.add(s);
        em.getTransaction().commit();

        em.close();
    }
    
    

}
