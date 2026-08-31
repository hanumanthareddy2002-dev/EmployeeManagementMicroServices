package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Department;
import com.nit.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository repo;
	
	
	public Department save(Department department) {
		return repo.save(department);
	}
	
	public List<Department> getAll()
	{
		return repo.findAll();
	}
	
	public Department getbyId(Long id) {
		return repo.findById(id).
				orElseThrow(()->new RuntimeException("Department not found with id : "+id));
	}
	
	public Department update(Long id,Department department)
	{
		Department dep=getbyId(id);
	    dep.setName(department.getName());
	    dep.setLocation(department.getLocation());
	    
	    return repo.save(dep);
		
	}
	public void delete(Long id)
	{
		Department department=getbyId(id);
		
		repo.delete(department);
	}
	
	
	
	
	

}
