package com.sample.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.sample.dao.EmployeeDao;
import com.sample.model.Employee;
import java.util.*;



@ExtendWith(MockitoExtension.class)
 class EmployeeServiceImplTest {

    @Mock
    EmployeeDao employeeDao;

    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;


       @Test
        void saveemployeetest(){
             Employee expected= new Employee(1,"atharava",20000);

              when(employeeDao.savemployee(expected)).thenReturn(expected);

              Employee actual = employeeServiceImpl.savemployee(expected);
              assertEquals(expected, actual);

        }

        @Test
        void getallEmployeestest(){
              List<Employee> expected =new ArrayList<>();
              expected.add(new Employee(1,"atharav",20000));
              expected.add(new Employee(2,"Mahi",70000));

              when(employeeDao.getAllEmployees()).thenReturn(expected);
          
              List<Employee> actual=employeeServiceImpl.getallEmployees();
              assertEquals(expected, actual);

        }

        @Test
        void getEmployeetest(){
               
            Employee expected= new Employee(1,"atharav",20000);

            when(employeeDao.getEmployee(1)).thenReturn(expected);

            Employee actual=employeeServiceImpl.getEmployee(1);
            assertEquals(expected, actual);

        }

        @Test
        void updatEmployee(){

            Employee expected =new Employee(1,"atharav",20000);

            when(employeeDao.updatEmployee(expected)).thenReturn(expected);

            Employee actual = employeeServiceImpl.updatEmployee(expected);
            assertEquals(expected, actual);
        }

        @Test
        void deleteEmployeetest(){
            int id=1;
            employeeServiceImpl.deleteEmployee(id);
            verify(employeeDao, times(1)).deleteEmployee(id);
        }

  
    
}
