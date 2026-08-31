package com.nit.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Department;
import com.nit.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	
	@PostMapping
	public ResponseEntity<Department> create(@RequestBody Department department){
		return new ResponseEntity<>(service.save(department),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Department>> getall(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getById(@PathVariable Long id){
		return ResponseEntity.ok(service.getbyId(id));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Department> update(@PathVariable Long id,@RequestBody Department department){
		return ResponseEntity.ok(service.update(id, department));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Department> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
