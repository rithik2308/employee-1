package com.spring.employeee.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employeee.entities.Employee;
import com.spring.employeee.repositories.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	// to access methods of jparepo we need to create object.
	@Autowired
	private EmployeeRepository employeerep;
	public List<Employee> getAllEmployees() {
		return employeerep.findAll(); // to find all data in database
	}
	//Native query service
	public List<Employee> getEmployees(){
		return employeerep.getEmployees();
	}
	
	public List<String> getEmployeeFirstName(){
		return employeerep.getEmployeeFirstName();
	}
	
	public Employee getEmployeeByID(long id ) {
		List<Employee> employees=employeerep.findAll();
		Employee employee=null;
		
		for(Employee emp:employees) {
			if(emp.getId()==id) {
				employee=emp;
			}
		}
		return employee;
	}
	public Employee AddEmployee(Employee employee) {
		log.info("creating new Employee");
		employeerep.save(employee);
		return employee;
	}
	public Employee UpdateEmployee(Employee employee) {
        employeerep.save(employee);
        return employee;
    }
	public String deleteemployee(long id) {
		employeerep.deleteById(id);
		return "Employee Removed";
	}
}