package com.test.service;

import java.util.List;

import com.test.entity.Customer;

public interface CustomerService {

	public boolean createCustomer(Customer cst);
	
	public List<Customer> readAllCustomers();
	
	public boolean updateCustomer(Customer cst);
	
	public boolean deleteCustomer(Customer cst);
	
	public List<Customer> getCustByID(Customer cust);
	
}
