package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.EmployeeDao;
import com.sample.model.Employee;
import com.sample.Exception.DataIsNull;

@Service
public class EmployeeServiceImpl implements EmployeeService{
     
    @Autowired
    EmployeeDao employeedao;

    @Override
    public Employee savemployee(Employee employee) throws DataIsNull {
        if(employee== null){
            throw new DataIsNull("data is null");
        }
           return employeedao.savemployee(employee);
    }

    @Override
    public List<Employee> getallEmployees(){
        return employeedao.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int id){
       
        return employeedao.getEmployee(id);
    }

    @Override
    public Employee updatEmployee(Employee employee){
        //employee.setId(id);
        return employeedao.updatEmployee(employee);
    }
     
    @Override
    public void deleteEmployee(int id){
         employeedao.deleteEmployee(id);
    }
    
}
