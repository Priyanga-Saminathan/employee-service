package com.example.employee_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="emp_table")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String position;
	private String age;
	private String feedback;
	public EmployeeEntity() {
		
	}
	public EmployeeEntity(String name, String position, String age, String feedback) {
		this.name=name;
		this.position=position;
		this.age=age;
		this.feedback=feedback;
	}
//	public String getId() {
//		return this.id;
//	}
//	public void setId(String id) {
//		this.id=id;
//	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getPosition() {
		return this.position;
	}
	public void setPosition(String position) {
		this.position=position;
	}
	public String getAge() {
		return this.age;
	}
	public void setFeedback(String feedback) {
		this.feedback=feedback;
	}
	public String getFeedback() {
		return this.feedback;
	}
	public void setAge(String age) {
		this.age=age;
	}
}
