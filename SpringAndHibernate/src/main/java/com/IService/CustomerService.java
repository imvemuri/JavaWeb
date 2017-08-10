package com.IService;

import java.util.List;

import com.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public List<Customer> searchCustomers(String search);
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public void deleteCustomer(int id);


}
