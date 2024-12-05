package com.example.employee_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employee_service.model.EmployeeEntity;
import com.example.employee_service.repo.EmployeeRepo;



@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo emprepo;

	public EmployeeEntity saveEmployee(EmployeeEntity empentity) {
		// TODO Auto-generated method stub
		return emprepo.save(empentity);
	}

	public Optional<EmployeeEntity> findById(int id) {
		// TODO Auto-generated method stub
		return emprepo.findById(id);
	}

	public List<EmployeeEntity> getAllEmp() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}
	public String deleteById(int id) {
		emprepo.deleteById(id);
		return "Deleted Successfully";
	}

	public ResponseEntity<List<EmployeeEntity>> getEmpByPosition(String position) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(emprepo.getByPosition(position),HttpStatus.OK);
	}

	public ResponseEntity<List<Integer>> createFeedback(String position, int num) {
		// TODO Auto-generated method stub
		List<Integer> feed=emprepo.getFeedbackByPosition(position, num);
		return new ResponseEntity<>(feed,HttpStatus.CREATED);
	}

	public ResponseEntity<List<EmployeeEntity>> getEmpFeedback(List<Integer> empid) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(emprepo.findAllById(empid),HttpStatus.OK);
	}

}
