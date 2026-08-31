package com.nit.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nit.dto.DepartmentDto;

@FeignClient(name="BootMS15-DepartmentService",path="/department")
public interface DepartmentClient {
	@GetMapping("/{id}")
	DepartmentDto getdepartment(@PathVariable("id") Long id);

}
