package com.restapiAssignmemt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapiAssignmemt.Dao.EmployeeRepository;
import com.restapiAssignmemt.model.Employee;

//service layer which we will call from Controller layer to perform certain task...
@Service
public class EmployeeService {
	
	//EmployeeRepository object to use methods from JpaRepository...  
	@Autowired
	private EmployeeRepository erep;
	
	//insert method...
	public Employee insert(Employee e) {
		return erep.save(e);
	}
	
	//readAll method...
	public List<Employee> readAll(){
		return erep.findAll();
	}
	
	//readById method...
	public Employee readById(int id) {
		//converting Optional to Employee using get method...
		return erep.findById(id).get();
	}
	
	//update method...
	public Employee update(int id, Employee e) {
		//fetching Employee object before updating...
		Employee e1=erep.findById(id).get();
		
		//updating details...
		e1.setName(e.getName());
		e1.setAddress(e.getAddress());
		
		return erep.save(e1);
	}
	
	//delete method...
	public void delete(int id) {
		erep.deleteById(id);
	}
}
