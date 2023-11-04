package com.restapiAssignmemt.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapiAssignmemt.model.Employee;

//Repository layer extending "JpaRepository" to perform all the database related operations... (CRUD operations)
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
