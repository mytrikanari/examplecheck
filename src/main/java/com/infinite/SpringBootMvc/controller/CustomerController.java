package com.infinite.SpringBootMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infinite.SpringBootMvc.model.Customer;
import com.infinite.SpringBootMvc.service.CustomerServiceImpl;

@Controller
public class CustomerController {
	@Autowired
	CustomerServiceImpl cservice;

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllCustomers";
	}
	@RequestMapping(value="/getAllCustomers",method =RequestMethod.GET)
	public String getAllCustomers(Model model){
		model.addAttribute("Customer",new Customer());
      model.addAttribute("listOfCustomers",cservice.getAllCustomers());
	return "customerDetails";
	}
}
