package com.spring.employeee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.employeee.controllers.EmployeeController;
import com.spring.employeee.entities.Employee;
import com.spring.employeee.services.EmployeeService;

@SpringBootTest(classes= {ControllerMockitoTests.class})
public class ControllerMockitoTests {
	
	@Mock
	EmployeeService employeeservice;
	
	@InjectMocks
	EmployeeController employeecon;
	
	public List<Employee> myemployees;
	Employee employee;
	
	@Test
	@Order(1)
	public void test_getAllEmployees() {
		myemployees= new ArrayList<Employee>();
		myemployees.add(new Employee(1,"Rithik","R",28000));
		myemployees.add(new Employee(2,"Darshan","Balaji",28000));
		myemployees.add(new Employee(3,"Faizaan","Chowdhary",55000));
		
		when(employeeservice.getAllEmployees()).thenReturn(myemployees);//Mocking statement that replaces findall with created list
		assertEquals(3,employeeservice.getAllEmployees().size());
	}
	@Test
	@Order(2)
	public void test_getEmployeeByID() {
		Employee employee=new Employee(4,"fferg","jfhg",23458);
		long employeeId=4;
		
		when(employeeservice.getEmployeeByID(employeeId)).thenReturn(employee);
		assertEquals(employee,employeecon.getEmployeeById(employeeId));
	}
	@Test
	@Order(4)
	public void test_AddEmployee() {
		Employee employee=new Employee(4,"fferg","jfhg",23458);
		when(employeeservice.AddEmployee(employee)).thenReturn(employee);
		assertEquals("Employee Added",employeecon.addEmployee(employee));
	}
	@Test
	@Order(4)
	public void test_UpdateEmployee() {
		Employee employee=new Employee(4,"fferg","jfhg",23458);
		long employeeId=4;
		when(employeeservice.UpdateEmployee(employee)).thenReturn(employee);
		assertEquals(employee,employeecon.UpdateEmployee(employeeId,employee));
		
	}
	@Test
	@Order(5)
	public void test_DeleteEmployee() {
		long employeeid=4;
		when(employeeservice.deleteemployee(employeeid)).thenReturn("Employee Removed");
		assertEquals("Employee Removed",employeecon.deleteEmployee(employeeid));
	}
}
