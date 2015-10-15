package com.bp.app.dao;

import java.util.List;

import com.bp.app.model.Customer;

public interface CustomerDao {
	public Customer findById(int id);

	public Customer findCustomerByName(String name);

	public List<Customer> findAllCustomers();

	public void saveCustomer(Customer customer);

	public void deleteCustomerByName(String name);
}
