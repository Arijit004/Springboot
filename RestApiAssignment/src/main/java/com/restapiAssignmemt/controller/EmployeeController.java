package com.restapiAssignmemt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapiAssignmemt.model.Employee;
import com.restapiAssignmemt.service.EmployeeService;

//declaring it as rest controller...
@RestController
public class EmployeeController {
	
	//EmployeeService object to perform crud...
	@Autowired
	EmployeeService eserv;


	//controller to add employee details...
	@PostMapping("/emp")
	public ResponseEntity<?> saveEmp(@RequestBody Employee e){
		Employee e1=eserv.insert(e);
		
		//sending back saved object with "created" response...
		return new ResponseEntity<>(e1, HttpStatus.CREATED);
	}
	
	
	//controller to read all employees...
	@GetMapping("/emp")
	public ResponseEntity<?> readEmp(){
		//using collection to store all employee records...
		List<Employee> empList=eserv.readAll();
		
		//sending back fetched collection with "ok" response...
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}
	
	
	//controller to read employee by id...
	@GetMapping("/emp/{id}")
	public ResponseEntity<?> redEmpById(@PathVariable int id){
		Employee e=eserv.readById(id);
		
		//sending back fetched object with "ok" response...
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	
	//controller to update employee...
	@PutMapping("/emp/{id}")
	public ResponseEntity<?> updateEmp(@PathVariable int id, @RequestBody Employee e){
		Employee e1=eserv.update(id, e);
		
		//sending back updated object with "ok" response...
		return new ResponseEntity<>(e1, HttpStatus.OK);
	}
	
	
	//controller to delete employee...
	@DeleteMapping("/emp/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable int id){
		eserv.delete(id);
		
		//sending back "ok" response with "deleted" message...
		return new ResponseEntity<>("Deleted...", HttpStatus.OK);
	}
}
