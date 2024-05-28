package com.sample.service;

import java.util.List;

import com.sample.Exception.DataIsNull;
import com.sample.model.Employee;

public interface EmployeeService {
    
     public Employee savemployee(Employee employee) throws DataIsNull;

     public Employee getEmployee(int id);

     public List<Employee> getallEmployees();
  
     public Employee updatEmployee(Employee employee);

     public void deleteEmployee(int id);

  } 
