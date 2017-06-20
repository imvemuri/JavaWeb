package com.springapp.target;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springapp.exceptions.AlphaNumericException;

@Controller
public class TargetsController {
	
	final static Logger LOGGER = Logger.getLogger(TargetsController.class);

	
	@Autowired
	TargetService service ;
	
	//Helps us to bind the initial values of the parameter. Binding the date class to the yyyy-MM-dd format 
	@InitBinder
	protected void initBinder(WebDataBinder wbinder){
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		wbinder.registerCustomEditor(Date.class, new CustomDateEditor(sd,false));
	}
	
	// Only available for get requests of URL pattern /usertargets.
	@RequestMapping(value={"/","usertargets"}, method = RequestMethod.GET)
	public String showTargets(ModelMap model) throws Exception{
		LOGGER.info("showTargets()");
		model.addAttribute("usertargets", service.retrieveTargets(getUserName()));
		model.addAttribute("user",getUserName());
		return "usertargets";
	}
	// Only available for get requests of URL pattern /usertargets.
	@RequestMapping(value="/addTarget", method = RequestMethod.GET)
	public String showAddTarget(ModelMap model) throws Exception{
		LOGGER.info("showAddTarget()");
		model.addAttribute("target", new Target(-999, getUserName(), new Date(), false, ""));
		return "addUpdTarget";
	}
	
	// This page redirects to user target list page.
	// Re populate the usertargets page
	@RequestMapping(value="/addTarget", method = RequestMethod.POST)
	public String addTarget(@Valid Target target,BindingResult errors){
		LOGGER.info("addTarget()");
		if(errors.hasErrors())
			return "target";
		// A 404 error with a message.
		if(target.getDesc().matches(".*\\d.*"))
			throw new AlphaNumericException(target.getDesc());
		
		if(target.getDate() == null)
			service.addTarget(getUserName(), new Date(), false, target.getDesc());
		else
			service.addTarget(getUserName(), target.getDate(), false, target.getDesc());
		return "redirect:usertargets";
	}
	
	// After updation redirect the page to list of user targets jsp page.
	@RequestMapping(value="/updateTarget", method = RequestMethod.POST)
	public String updatedTarget(@Valid Target target,BindingResult errors){
		LOGGER.info("updatedTarget()");
		if(errors.hasErrors())
			return "target";
		service.updateTarget(target);
		return "redirect:usertargets";
	}
	
	@RequestMapping(value="/deleteTarget", method = RequestMethod.GET)
	public String deleteTarget(@RequestParam int id){
		LOGGER.info("deleteTarget()");
		service.deleteTarget(id);
		return "redirect:usertargets";
	}
	
	
	// Retrieve the target based on id.
	// Send the target to add target page.
	// Since the target is filled with values, the form will be populated with it.
	@RequestMapping(value="/updateTarget", method = RequestMethod.GET)
	public String updateTarget(ModelMap model,@RequestParam int id){
		LOGGER.info("updateTarget()");
		Target target = service.retrieveTarget(id);
		model.addAttribute("target", target);
		return "addUpdTarget";
	}
	
	// Fetch the user name.
	public String getUserName(){
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
}
