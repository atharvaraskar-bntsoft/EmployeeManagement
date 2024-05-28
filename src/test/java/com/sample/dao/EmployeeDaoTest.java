package com.sample.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;

import com.sample.model.Employee;


import java.util.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeDaoTest {

    @InjectMocks
    EmployeeDao employeeDao;

    @Test
    void saveemployee(){
        Employee expected=new Employee(1,"atharva",20000);
        
        when(employeeDao.savemployee(expected)).thenReturn(expected);

        Employee actual=employeeDao.savemployee(expected);
        assertEquals(expected, actual);

    }

    @Test
    void getAllEmployees(){
        List<Employee> expected =new ArrayList<>();
        expected.add(new Employee(1,"atharav",20000));
        expected.add(new Employee(2,"Mahi",70000));

        when(employeeDao.getAllEmployees()).thenReturn(expected);
    
        List<Employee> actual=employeeDao.getAllEmployees();
        assertEquals(expected, actual);
    }
    
    @Test
        void getEmployeetest(){
               
            Employee expected= new Employee(1,"atharav",20000);

            when(employeeDao.getEmployee(1)).thenReturn(expected);

            Employee actual=employeeDao.getEmployee(1);
            assertEquals(expected, actual);

        }

        @Test
        void updatEmployee(){

            Employee expected =new Employee(1,"atharav",20000);

            when(employeeDao.updatEmployee(expected)).thenReturn(expected);

            Employee actual = employeeDao.updatEmployee(expected);
            assertEquals(expected, actual);
        }   
        
         @Test
        void deleteEmployeetest(){
            int id=1;
            employeeDao.deleteEmployee(id);
            verify(employeeDao, times(1)).deleteEmployee(id);
        }
}
