package com.example.BulkEmail.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.BulkEmail.model.Employees;

public interface EmployeeRepo extends CrudRepository<Employees,Integer>{
	
	@Query("select employeeEmail from Employees")
	List<String> findByAllEmail();

}
