package jpa_casestudy.Repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa_casestudy.models.Department;

public class DepartmentRepository {

    private EntityManagerFactory emf;
    private EntityManager em;

    public DepartmentRepository() {
        this.emf = Persistence.createEntityManagerFactory("JPA_CaseStudyPU");
        this.em = emf.createEntityManager();

    }

    public void addDepartment(Department department) {
        em.getTransaction().begin();
        em.persist(department);
        em.getTransaction().commit();
        System.out.println("dept added successfully");
    }

    public void updateDepartment(Department department) {
        em.getTransaction().begin();
        em.persist(department);
        em.getTransaction().commit();
        System.out.println("dept updated successfully");

    }

    public void deleteDepartment(int id) {
        em.getTransaction().begin();
        Department d = em.find(Department.class, id);
        if (d != null) {
            em.remove(d);
        }
        em.getTransaction().commit();
        System.out.println("dept deleted successfully");

    }

    public List<Department> getAllDepartments() {
        return em.createQuery("SELECT d FROM Department d", Department.class)
                .getResultList();
    }

    public Department getDepartmentById(int id) {
        Department d = em.find(Department.class, id);
        return d;
    }

}
