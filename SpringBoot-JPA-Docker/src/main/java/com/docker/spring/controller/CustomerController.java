package com.docker.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.docker.spring.entities.Customer;
import com.docker.spring.repository.CustomerRepository;


@Controller
//@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository CR;
	
	@GetMapping("/all")
	public String listCustomers(Model model){
		// Get customers from service. Delegating call to DAO.
		List<Customer> customers = CR.findAll();
		// put the customers into model object for view.
		model.addAttribute("customers",customers);
		// Return the JSP page.
		return "listCustomers";
	}
	
	@GetMapping("/")
	public String ShowWelcomePage(){
		return "Welcome";
	}
	
	@GetMapping("/searchPage")
	public String ShowSearchPage(){
		return "Search";
	}
	
	@GetMapping("/search")
    public String searchCustomers(@RequestParam("SearchName") String SearchName,
                                    Model model) {
		//Get the customers and return the populate the customers with matching name
        List<Customer> theCustomers = getListCustomers(SearchName);
        model.addAttribute("customers", theCustomers);
        return "listCustomers";        
    }
	
	public List<Customer> getListCustomers(String name){
		 List<Customer> theCustomers = CR.findByFirstNameContaining(name);
	     System.out.println(theCustomers);
		 for(Customer cust : CR.findByLastNameContaining(name))
			 theCustomers.add(cust);
	     System.out.println(theCustomers);
		 return theCustomers;
	}
	
	@GetMapping("/add")
	public String addCustomers(Model model){
		// Build a new Customer
		Customer customer = new Customer();
		model.addAttribute("customer",customer);

		// Return the JSP page.
		return "NewCustomer";
	}
	
	@PostMapping("/save")
	public String SaveCustomer(@ModelAttribute("customer") Customer customer){
		// Build a new Customer
		CR.save(customer);
		// Return the JSP page.
		return "redirect:all";
	}

	@GetMapping("/update")
	public String UpdateCustomer(@RequestParam("ID") Integer ID,Model model){
		// Build a new Customer
		Customer customer = CR.findOne(ID);
		// Add to the model
		model.addAttribute("customer", customer);
		// Return the JSP page.
		return "NewCustomer";
	}
	
	
	@GetMapping("/delete")
	public String DeleteCustomer(@RequestParam("ID") Integer ID){
		// Return the JSP page.
		CR.delete(ID);
		return "redirect:all";
	}


}
