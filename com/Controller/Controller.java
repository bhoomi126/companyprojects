package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Employee;
import com.Repository.EmployeeRepository;
import com.Service.EmployeeService;

@RestController
public class Controller {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	EmployeeRepository empRepository;
	
	@PostMapping("/employee")
	public Employee add(@RequestBody Employee employee) {
		return empRepository.save(employee);
		
	}
	
	@GetMapping("/employee/{pageno}/{pagesize}")
	public List<Employee> getallemployee(@PathVariable Integer pageno, @PathVariable Integer pagesize) {

		return empService.getallemployee(pageno, pagesize);

	}
	 

}
