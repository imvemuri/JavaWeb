package com.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.IService.CustomerService;
import com.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("lists")
	public String listCustomers(Model model){
		// Get customers from service. Delegating call to DAO.
		List<Customer> customers = customerService.getCustomers();
		
		// put the customers into model object for view.
		model.addAttribute("customers",customers);
		
		// Return the JSP page.
		return "ListCustomers";
	}
	
	@GetMapping("SearchByName")
    public String searchCustomers(@RequestParam("SearchName") String SearchName,
                                    Model model) {
		//Get the customers and return the populate the customers with matching name
        List<Customer> theCustomers = customerService.searchCustomers(SearchName);
        model.addAttribute("customers", theCustomers);

        return "ListCustomers";        
    }
	
	@GetMapping("addCustomer")
	public String addCustomers(Model model){
		// Build a new Customer
		Customer customer = new Customer();
		
		model.addAttribute("customer",customer);

		// Return the JSP page.
		return "NewCustomer";
	}
	
	@PostMapping("SaveCustomer")
	public String SaveCustomer(@ModelAttribute("customer") Customer customer){
		// Build a new Customer
		customerService.saveCustomer(customer);
		// Return the JSP page.
		return "redirect:lists";
	}

	@GetMapping("Update")
	public String UpdateCustomer(@RequestParam("ID") Integer ID,Model model){
		// Build a new Customer
		Customer customer = customerService.getCustomer(ID);
		// Add to the model
		model.addAttribute("customer", customer);
		// Return the JSP page.
		return "NewCustomer";
	}
	
	
	@GetMapping("Delete")
	public String DeleteCustomer(@RequestParam("ID") Integer ID){
		// Return the JSP page.
		System.out.println("Delete Called");
		customerService.deleteCustomer(ID);
		return "redirect:lists";
	}
}
