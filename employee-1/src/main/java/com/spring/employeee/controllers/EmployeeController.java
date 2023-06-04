package com.spring.employeee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employeee.entities.Employee;
import com.spring.employeee.services.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;
	@GetMapping("/welcome")
	public @ResponseBody String HelloWorld(){
		return "Hello world";
	}
	@GetMapping("getall")
	public List<Employee> getAllEmployees() {
		return employeeservice.getAllEmployees();
	}
	//native query controller
	@GetMapping("getallnative")
	public List<Employee> getEmployees() {
		return employeeservice.getEmployees();
	}
	@GetMapping("getfirstnames")
	public List<String> getEmployeeFirstName() {
		return employeeservice.getEmployeeFirstName();
	}
	@GetMapping("/get/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") long id) {
			return employeeservice.getEmployeeByID(id);
	
	}
	@PostMapping("/add")
	@Operation(
    		tags= {"AddItems","employee-controller"},
    		operationId="Add Employee",
    		summary="Adding Employee",
    		description="This is used to add Employee"
    		)
	public @ResponseBody String addEmployee(@RequestBody Employee Employee){
		employeeservice.AddEmployee(Employee);
		return "Employee Added";
	}
	@PutMapping("/update/{id}")
	public @ResponseBody Employee UpdateEmployee(@PathVariable(value="id") long id,@RequestBody Employee Employee)
	{
		return employeeservice.UpdateEmployee(Employee);
	}
	@DeleteMapping("/delete/{id}")
	public @ResponseBody String deleteEmployee(@PathVariable(value="id") long id){
		return employeeservice.deleteemployee(id);
	}
}
