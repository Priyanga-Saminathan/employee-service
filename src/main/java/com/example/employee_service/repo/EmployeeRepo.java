package com.example.employee_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.employee_service.model.EmployeeEntity;
@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer>{

	public List<EmployeeEntity> getByPosition(String position);
	@Query(value="Select e.id from emp_table e where e.position=:position order By rand() limit :num",nativeQuery=true )
	public List<Integer> getFeedbackByPosition(String position, int num);

//	public EmployeeEntity findById(String id);
//
//	public void deleteById(String id);

	
}
