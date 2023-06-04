package com.spring.employeee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.employeee.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query(value="select *from Employee", nativeQuery=true)
	public List<Employee> getEmployees();
	
	@Query(value="select firstname from Employee", nativeQuery=true)
	public List<String> getEmployeeFirstName();
	
}
