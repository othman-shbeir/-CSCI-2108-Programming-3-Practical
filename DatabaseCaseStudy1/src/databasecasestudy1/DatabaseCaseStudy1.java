package databasecasestudy1;

import databasecasestudy1.models.Employee;
import databasecasestudy1.repositories.EmployeeRepository;
import java.util.List;

public class DatabaseCaseStudy1 {

    public static void main(String[] args) {
//        Employee e = new Employee(2,"Mohammed","HR");
        
        EmployeeRepository er = new EmployeeRepository();
//        er.addEmployee(e);
//        
//        System.out.println("**********get all employess ********");
//        List<Employee> employees = er.getAllEmployees();
//        
//        for(Employee e1 : employees){
//            System.out.println(e1);
//        }
//        

//           er.updateEmployeeDepartment(1, "Management");

            er.deleteEmployee(2);
    }

}
