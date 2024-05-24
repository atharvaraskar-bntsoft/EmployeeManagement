package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.model.Employee;



@Repository
public class EmployeeDao {
     
    @Autowired
    DataSource dataSource;
    


    public Employee savemployee(Employee employees){
         
        try{
             
            Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO empdata (id, name, salary) VALUES (?, ?, ?)");
            ps.setInt(1,employees.getId());
            ps.setString(2,employees.getName());
            ps.setInt(3,employees.getSalary());
            ps.executeUpdate();
       
        }
        catch(SQLException e){
                e.printStackTrace();   
        }
        return employees;
    }


    public List<Employee> getAllEmployees(){
        List<Employee>employees=new ArrayList<Employee>();
        
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from empdata");
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int employeeId=rs.getInt(1);
                String employeeName =rs.getString(2);
                int employeeSalary=rs.getInt(3);
                employees.add(new Employee(employeeId,employeeName,employeeSalary));
            }
 
        } catch (SQLException e) {
               e.printStackTrace();
        }
        
        return employees;
    }



    public Employee getEmployee(int id){

        Employee employee=null;

        try {
            Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM empdata WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int employeeId=rs.getInt(1);
                String employeeName =rs.getString(2);
                int employeeSalary=rs.getInt(3);
                employee = new Employee(employeeId,employeeName,employeeSalary);;
            }
 
        } catch (SQLException e) {
               e.printStackTrace();
        }
         
        return employee;
    }


    public Employee updatEmployee(Employee employee){
        try {
        
        Connection con=dataSource.getConnection();
        PreparedStatement ps= con.prepareStatement("UPDATE EMPDATA SET name =?,salary=? WHERE id=?");
        ps.setString(1, employee.getName());
        ps.setInt(2, employee.getSalary());
        ps.setInt(3,employee.getId());
        ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
          
        return employee;
    }


    public void deleteEmployee(int id){

        try {
            Connection con=dataSource.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from empdata where id=?");
            ps.setInt(1,id);
    
            ps.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    
}
