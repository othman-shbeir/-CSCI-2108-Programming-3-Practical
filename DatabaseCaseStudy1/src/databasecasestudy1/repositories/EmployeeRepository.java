package databasecasestudy1.repositories;

import databasecasestudy1.Config.DBConnection;
import databasecasestudy1.models.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeRepository {

    private final Connection con;

    public EmployeeRepository() {
        this.con = DBConnection.getDBConnection().getConnection();
    }

    // insert new employee
    public void addEmployee(Employee e) {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setString(3, e.getDepartment());

            ps.executeUpdate();
            System.out.println("Employee has been added successfully:\n"
                    + e.toString());

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employees";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("department")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }

    public void updateEmployeeDepartment(int id, String newDept) {
        String sql = "UPDATE employees SET department=? WHERE id=?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, newDept);
            ps.setInt(2, id);
            
            ps.executeUpdate();
            System.out.println("Employee updated successfully");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void deleteEmployee(int id){
        String sql = "DELETE FROM employees WHERE id=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Employee with id:"+id+" is deleted successfully");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
