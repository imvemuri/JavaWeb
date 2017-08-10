package com.IDao;

import java.util.List;

import com.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public List<Customer> getCustomersByName(String name);

	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public void deleteCustomer(int id);

}
