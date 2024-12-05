package com.example.employee_service.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_service.model.EmployeeEntity;
import com.example.employee_service.service.EmployeeService;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empservice;
	@Autowired
	Environment environment;
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Optional<EmployeeEntity>> getemployee(@PathVariable("id") int id) {
		Optional<EmployeeEntity> getName=empservice.findById(id);
		return ResponseEntity.ok(getName);
	} 
	@PostMapping("/addEmployee")
	public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity empentity){
		EmployeeEntity saveEmp=empservice.saveEmployee(empentity);
		return new ResponseEntity<>(saveEmp,HttpStatus.CREATED);
	}
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployee(){
		return new ResponseEntity<>(empservice.getAllEmp(),HttpStatus.OK);
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		String res= empservice.deleteById(id);
		return res;
	}
	@GetMapping("/getEmpByPosition/{position}")
	public ResponseEntity<List<EmployeeEntity>> getEmpByPosition(@PathVariable("position") String position){
		return empservice.getEmpByPosition(position);
	}
	@GetMapping("/createFeedback")
	public ResponseEntity<List<Integer>> createFeedback(@RequestParam String position,@RequestParam int num){
		return empservice.createFeedback(position,num);
	}
	@PostMapping("/getEmpFeedback")
	public ResponseEntity<List<EmployeeEntity>> getEmpFeedback(@RequestBody List<Integer> empid){
		System.out.println(environment.getProperty("local.server.port"));
		return empservice.getEmpFeedback(empid);
	}
}
