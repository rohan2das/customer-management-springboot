package com.test.dao.impl;

import java.lang.foreign.Linker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.CustomerDao;
import com.test.entity.Customer;
import com.test.repository.CustomerRepository;


@Repository
public class CustomerDAOImpl implements CustomerDao {

	@Autowired
	private CustomerRepository repository;
	
	
	@Override
	public boolean createCustomer(Customer cst) {
		boolean status = false;
		try {
			repository.save(cst);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Customer> readAllCustomers() {
		return repository.findAll();
	}

	@Override
	public boolean updateCustomer(Customer cst) {
		boolean status = false;
		try {
			repository.save(cst);
			status = true;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}


	@Override
	public boolean deleteCustomer(Customer cust) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			repository.deleteById(cust.getCustomer_id());
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Customer> getCustById(Customer cust) {
		// TODO Auto-generated method stub
		Optional<Customer> cst = repository.findById(cust.getCustomer_id());
		
		List<Customer> custList = new ArrayList<>();
		custList.add(cst.get());
		return custList;
	}

}
