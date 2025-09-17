package jpa_casestudy.Repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa_casestudy.models.Employee;

public class EmployeeRepository {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EmployeeRepository() {
        this.emf = Persistence.createEntityManagerFactory("JPA_CaseStudyPU");
        this.em = emf.createEntityManager();
    }

    public void addEmployee(Employee e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public void updateEmployee(Employee e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public Employee findEmployeeById(int id) {
        em.getTransaction().begin();
        Employee e = em.find(Employee.class, id);
        em.getTransaction().commit();

        return e;
    }

    public void deleteEmployee(int id) {
        em.getTransaction().begin();
        Employee e = em.find(Employee.class, id);
        if (e != null) {
            em.remove(e);
        }
        em.getTransaction().commit();
    }

    public List<Employee> getAllEmployees() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }
}
