package jpa_casestudy;

import java.util.List;
import jpa_casestudy.Repositories.DepartmentRepository;
import jpa_casestudy.Repositories.EmployeeRepository;
import jpa_casestudy.models.Department;
import jpa_casestudy.models.Employee;

public class JPA_CaseStudy {

    public static void main(String[] args) {
        DepartmentRepository dr = new DepartmentRepository();

        Department ITDept = new Department("IT", "3rd Floor");
        Department HRDept = new Department("HR", "6rd Floor");
        Department ManagementDept = new Department("Management", "5th Floor");

//        dr.addDepartment(ITDept);
//        dr.addDepartment(HRDept);
//        dr.addDepartment(ManagementDept);
//        Department d = dr.getDepartmentById(1);
//        d.setName("Information Technology");
//        
//        dr.updateDepartment(d);
//        dr.deleteDepartment(2);
//        List<Department> allDepts = dr.getAllDepartments();
//        
//        for (Department dept : allDepts) {
//            System.out.println(dept);
//        }
        EmployeeRepository er = new EmployeeRepository();
        ITDept = dr.getDepartmentById(1);
        ManagementDept = dr.getDepartmentById(3);

//        Employee e = new Employee("Ali", 500, ITDept);
//        Employee e1 = new Employee("Mohammed", 1000, ManagementDept);
//        Employee e2 = new Employee("Fatima", 250, ITDept);
//        er.addEmployee(e);
//        er.addEmployee(e1);
//        er.addEmployee(e2);
//        Employee e2 = er.findEmployeeById(3);
//        e2.setDepartment(ManagementDept);
//        er.updateEmployee(e2);
//        er.deleteEmployee(3);
        List<Employee>es = er.getAllEmployees();
        
        for(Employee e : es){
            System.out.println(e);
        }

    }

}
