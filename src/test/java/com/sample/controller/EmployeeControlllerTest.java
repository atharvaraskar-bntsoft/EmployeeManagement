package com.sample.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import com.sample.dao.EmployeeDao;
import com.sample.model.Employee;
import com.sample.service.EmployeeServiceImpl;

import java.util.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeControlllerTest {


    @Mock
    EmployeeDao employeedao;
     
    @Mock
    EmployeeServiceImpl employeeServiceImpl ;

    @InjectMocks
    EmployeeController employeeControlller;

    @Test
    void checkhello(){
       
        String expectedresult="hello world";
        String acutalresult=employeeControlller.hello();
        assertEquals(expectedresult, acutalresult);
    }

    @Test
    void saveEmployeetest() throws Exception{

        Employee expected=new Employee(1,"atharva",20000);
       when(employeeServiceImpl.savemployee(expected)).thenReturn(expected);

       Employee actual=employeeControlller.saveemployee(expected);
       assertEquals(expected, actual);


    }

     @Test
    void getAllEmployees(){
       
         List<Employee> expectedlist = new ArrayList<>();
         expectedlist.add(new Employee(1, "atharva", 20000));
         expectedlist.add(new Employee(2, "ram", 40000));
     
         // Mocking the behavior of the service method
         when(employeeServiceImpl.getallEmployees()).thenReturn(expectedlist);
     
         // Calling the controller method under test
         List<Employee> actualList = employeeControlller.getAllEmployees();
     
         // Asserting that the expected and actual lists are equal
         assertEquals(expectedlist, actualList);

    }

    @Test
    void getEmployeeById(){
        
        Employee expected=new Employee(1,"atharva",200000);
        
        when(employeeServiceImpl.getEmployee(1)).thenReturn(expected);
        Employee actual=employeeControlller.getEmployeeById(1);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void updatEmployee(){

        Employee expected=new Employee(1,"atharva",200000);

        when(employeeServiceImpl.updatEmployee(expected)).thenReturn(expected);
        Employee actual=employeeControlller.updatEmployee(expected);

        assertEquals(expected, actual);
    }

    @Test
    void deleteEmployee(){
           
        int id=2;
        employeeControlller.deleteEmployee(id);
        verify(employeeServiceImpl, times(1)).deleteEmployee(id);      
    }



}
