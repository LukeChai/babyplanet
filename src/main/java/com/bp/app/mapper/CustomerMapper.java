package com.bp.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;

import com.bp.app.model.Customer;

public interface CustomerMapper {

	@Options(flushCache = true)
	public List<Customer> getCustomerList();
}
