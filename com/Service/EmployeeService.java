package com.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Employee;
import com.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository emprepo;
	
	public List<Employee> getallemployee(Integer pageno,Integer pagesize){
	  
	  Pageable paging = PageRequest.of(pageno,pagesize);
	  
	  Page<Employee> pageResult = emprepo.findAll(paging);
		if (pageResult.hasContent()) {
			return pageResult.getContent();
		} else {
			return new ArrayList<>();
		}
	 
		
	}

}
