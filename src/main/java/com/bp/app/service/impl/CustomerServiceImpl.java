package com.bp.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bp.app.dao.CustomerDao;
import com.bp.app.model.Customer;
import com.bp.app.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer findById(int id) {
		return customerDao.findById(id);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.findAllCustomers();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

}
