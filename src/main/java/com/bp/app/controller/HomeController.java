package com.bp.app.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bp.app.model.Customer;
import com.bp.app.service.CustomerService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	CustomerService customerService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String home(Locale locale, Model model) {
		Customer c = new Customer();
		model.addAttribute("customer", c);

		return "home";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String newCustomer(Model model) {
		Customer c = new Customer();
		model.addAttribute("customer", c);
		return "add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveCustomer(@Valid Customer customer, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "add";
		}

		customerService.saveCustomer(customer);

		return "redirect:/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		List<Customer> list = customerService.findAllCustomers();
		model.addAttribute("customers", list);

		return "list2";
	}

}
