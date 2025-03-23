package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.CustomerDao;
import com.test.entity.Customer;
import com.test.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public boolean createCustomer(Customer cst) {

		return customerDao.createCustomer(cst);
	}

	@Override
	public List<Customer> readAllCustomers() {

		List<Customer> list=customerDao.readAllCustomers();
		
		return list;
	}

	@Override
	public boolean updateCustomer(Customer cst) {

		return customerDao.updateCustomer(cst);
		
	}

	@Override
	public boolean deleteCustomer(Customer cst) {
		
		return customerDao.deleteCustomer(cst);
		
	}

	@Override
	public List<Customer> getCustByID(Customer cust) {
		
		return customerDao.getCustById(cust);
		
	}
	
}
