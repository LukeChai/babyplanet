package com.bp.app.service;

import java.util.List;

import com.bp.app.model.Customer;

public interface CustomerService {
	Customer findById(int id);

	List<Customer> findAllCustomers();

	void saveCustomer(Customer customer);

}
