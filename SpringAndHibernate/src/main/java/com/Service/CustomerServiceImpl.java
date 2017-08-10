package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.IDao.CustomerDAO;
import com.IService.CustomerService;
import com.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	// Inject DAO
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// Delegating calls to CustomerDAO
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer cust) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(cust);
		return ;
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(id);
		return;
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String search) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomersByName(search);
	}

}
