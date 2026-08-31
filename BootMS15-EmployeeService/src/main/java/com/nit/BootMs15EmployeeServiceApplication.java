package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BootMs15EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMs15EmployeeServiceApplication.class, args);
	}

}
