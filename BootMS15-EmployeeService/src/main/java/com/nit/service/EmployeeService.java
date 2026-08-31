package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.client.DepartmentClient;
import com.nit.dto.DepartmentDto;
import com.nit.dto.EmployeResponse;
import com.nit.entity.Employee;
import com.nit.repository.EmployeeRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private DepartmentClient departmentClient;
	
	
	public Employee save(Employee employee)
	{
		return repo.save(employee);
	}
	
	public List<Employee> getAll(){
		return repo.findAll();
	}
	
	@CircuitBreaker(name="service",fallbackMethod="departmentFallback")
	
	public EmployeResponse getemployeedepartment(Long id) {
		Employee employee =repo.findById(id).
				orElseThrow(()->new RuntimeException("Employee not found with id: "+id));
		DepartmentDto department=departmentClient.getdepartment(employee.getDepartmentId());
		
		return new EmployeResponse(employee,department,"Employee and Department retrieved successfully");
	}
	
	public EmployeResponse departmentFallback(Long id,Throwable throwable) {
		Employee employee=repo.findById(id)
				.orElseThrow(()-> new RuntimeException("Employee not found with id : "+id));
		return new EmployeResponse(employee,null,"Department service is currently unavailable");
	}
	
	 public Employee update(
	            Long id,
	            Employee employee) {

	        Employee existing = repo.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Employee not found with id: " + id
	                        ));

	        existing.setName(employee.getName());
	        existing.setEmail(employee.getEmail());
	        existing.setSalary(employee.getSalary());
	        existing.setDepartmentId(employee.getDepartmentId());

	        return repo.save(existing);
	    }

	    public void delete(Long id) {

	        Employee employee = repo.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Employee not found with id: " + id
	                        ));

	        repo.delete(employee);
	    }
	
	

}
