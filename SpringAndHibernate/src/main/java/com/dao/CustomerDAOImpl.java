package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.IDao.CustomerDAO;
import com.entity.Customer;

//For component scanning and converting persistence based exceptions
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// Injecting session factory
	@Autowired
	SessionFactory sessionFactory ;

	@Override
	public List<Customer> getCustomers() {
		// Get the current session from session factory.
		Session CurSession = sessionFactory.getCurrentSession();
		//Create Query
		Query<Customer> query = CurSession.createQuery("from Customer", Customer.class);
		// Execute Query
		List<Customer> customers = query.getResultList();
		// Result
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// Get the current session from session factory.
		Session CurSession = sessionFactory.getCurrentSession();
		//Create Query
		CurSession.saveOrUpdate(customer);
		return;
	}

	@Override
	public Customer getCustomer(int id) {
		// Get the current session from session factory.
		Session CurSession = sessionFactory.getCurrentSession();
		//Create Query
		Customer customer = CurSession.get(Customer.class,id);
		// Result
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		// Get the current session from session factory.
		Session CurSession = sessionFactory.getCurrentSession();
		//Create Query
		Query query = CurSession.createQuery("delete from Customer where id=:ID");
		
		query.setParameter("ID", id);
		
		query.executeUpdate();
		
	}

	@Override
	public List<Customer> getCustomersByName(String name) {
		// Get the current session from session factory.
		Session CurSession = sessionFactory.getCurrentSession();
		//Create Query

        // search for firstName or lastName ... case insensitive
        Query<Customer> theQuery =CurSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
        theQuery.setParameter("theName", "%" + name.toLowerCase() + "%");
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
       
        return (customers.size() == 0) ? getCustomers() : customers;
	}

}
