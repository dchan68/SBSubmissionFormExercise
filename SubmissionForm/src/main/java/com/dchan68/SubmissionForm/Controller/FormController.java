package com.dchan68.SubmissionForm.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dchan68.SubmissionForm.Entity.Customer;
import com.dchan68.SubmissionForm.Repository.CustomerRepo;

@Controller
public class FormController {
	@Autowired
	CustomerRepo repo;
	
	@RequestMapping("/")
	public String dchan68() {
		return "customer";
	}
	
	@RequestMapping("/details")
	public String details(Customer customer) {
		repo.save(customer);
		return "customer";
	}
	
	@RequestMapping("/getdetails")
	public String getDetails() {
		return "ViewCustomers";
	}
	
	@PostMapping("/getdetails")
	public ModelAndView viewDetails(@RequestParam int cid) {
		ModelAndView mv = new ModelAndView("Retrieve");
		Customer customer = repo.findById(cid).orElse(null);
		mv.addObject(customer);
		return mv;
	}
	
	@RequestMapping("/customers")
	@ResponseBody
	public List<Customer> getCustomers() {
		return repo.findAll();
	}
	
	@RequestMapping("/customers/{cid}")
	@ResponseBody
	public Optional<Customer> getCustomers(@PathVariable("cid") int cid) {
		return repo.findById(cid);
	}
	
	//used for Postman demonstration purposes
	@PostMapping("/customers")
	public Customer getCustomers3(@RequestBody Customer customer) {
		repo.save(customer);
		return customer;
	}
	
	//used for Postman demonstration purposes
	@DeleteMapping("/customers/{cid}")
	public Customer getCustomers4(@PathVariable("cid") int cid) {
		Customer cust = repo.getOne(cid);
		repo.delete(cust);
		return cust;
	}
	
	//used for Postman demonstration purposes
	@PutMapping(path = "/customers", consumes= {"application/json"})
	public Customer getCustomers4(@RequestBody Customer customer) {
		repo.save(customer);
		return customer;
	}
}
