package com.spring.employeee;

import java.util.List;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.employeee.entities.Employee;
import com.spring.employeee.repositories.EmployeeRepository;
import com.spring.employeee.services.EmployeeService;

@SpringBootTest(classes=ServiceMockitoTests.class)
public class ServiceMockitoTests {
	
	//mocking the repository
	@Mock	//mocking the repository
	EmployeeRepository employeerep;
	
	//To invoke all service methods
	@InjectMocks
	EmployeeService employeeservice;
	
	public List<Employee> myemployees;
	
	//To run tests
	@Test
	@Order(1)
	public void test_getAllEmployees() {
		List<Employee> myemployees= new ArrayList<Employee>();
		myemployees.add(new Employee(1,"Rithik","R",28000));
		myemployees.add(new Employee(2,"Darshan","Balaji",28000));
		myemployees.add(new Employee(3,"Faizaan","Chowdhary",55000));
		
		when(employeerep.findAll()).thenReturn(myemployees);//Mocking statement that replaces findall with created list
		assertEquals(3,employeeservice.getAllEmployees().size());
	}
	@Test
	@Order(2)
	public void test_getEmployeeByID() {
		List<Employee> myemployees= new ArrayList<Employee>();
		myemployees.add(new Employee(1,"Rithik","R",28000));
		myemployees.add(new Employee(2,"Darshan","Balaji",28000));
		myemployees.add(new Employee(3,"Faizaan","Chowdhary",55000));
		
		long employeeId=1;
		
		when(employeerep.findAll()).thenReturn(myemployees);//Mocking statement that replaces findall with created list
		assertEquals(employeeId,employeeservice.getEmployeeByID(employeeId).getId());
	}
	@Test
	@Order(3)
	public void test_AddEmployee() {
		Employee employee=new Employee(4,"fferg","jfhg",23458);
		
		when(employeerep.save(employee)).thenReturn(employee);
		assertEquals(employee,employeeservice.AddEmployee(employee));
	}
	@Test
	@Order(4)
	public void test_UpdateEmployee() {
		Employee employee=new Employee(4,"fferg","jfhg",23458);
		
		when(employeerep.save(employee)).thenReturn(employee);
		assertEquals(employee,employeeservice.UpdateEmployee(employee));
	}
	@Test
	@Order(5)
	public void test_DeleteEmployee() {
		int employeeid=4;
		assertEquals("Employee Removed",employeeservice.deleteemployee(employeeid));
	}
	
}
