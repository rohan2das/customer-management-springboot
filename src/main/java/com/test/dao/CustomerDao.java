package com.test.dao;

import java.util.List;

import com.test.entity.Customer;

public interface CustomerDao {

	public boolean createCustomer(Customer cst);
	
	public List<Customer> readAllCustomers();
	
	public boolean updateCustomer(Customer cst);
	
	public boolean deleteCustomer(Customer cust);
	
	public List<Customer> getCustById(Customer cust);
}
