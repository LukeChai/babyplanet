package com.bp.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bp.app.dao.AbstractDao;
import com.bp.app.dao.CustomerDao;
import com.bp.app.mapper.CustomerMapper;
import com.bp.app.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Customer findById(int id) {
		return getByKey(id);
	}

	@Override
	public Customer findCustomerByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (Customer) criteria.uniqueResult();
	}

	@Override
	public List<Customer> findAllCustomers() {
//		Criteria criteria = createEntityCriteria();
//		return (List<Customer>) criteria.list();
		return customerMapper.getCustomerList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		persist(customer);
	}

	@Override
	public void deleteCustomerByName(String name) {
		Query query = getSession().createSQLQuery("delete from Customer where name = :name");
		query.setString("name", name);
		query.executeUpdate();
	}

}
