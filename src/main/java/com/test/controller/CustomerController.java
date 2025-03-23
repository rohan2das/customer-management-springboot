package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Customer;
import com.test.service.CustomerService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	public void setService(CustomerService service) {
		this.service = service;
	}
	
	@PostMapping("save-customer")
	public boolean saveStudent(@RequestBody Customer cust) {
		 return service.createCustomer(cust);
		
	}
	
	@GetMapping("customer-list")
	public List<Customer> allstudents() {
		 return service.readAllCustomers();
	}
	
	@PutMapping("update-customer/{cust_id}")
	public boolean updateStudent(@RequestBody Customer cust,@PathVariable("cust_id") int cust_id) {
		cust.setCustomer_id(cust_id);
		return service.updateCustomer(cust);
	}
	
	@DeleteMapping("delete-customer/{cust_id}")
	public boolean deleteStudent(@PathVariable("cust_id") int cust_id,Customer cust) {
		cust.setCustomer_id(cust_id);
		return service.deleteCustomer(cust);
	}
	
	@GetMapping("customer/{cust_id}")
	public List<Customer> allCustomerByID(@PathVariable("cust_id") int cust_id,Customer cust) {
		cust.setCustomer_id(cust_id);
		 return service.getCustByID(cust);
		
	}
	
}
