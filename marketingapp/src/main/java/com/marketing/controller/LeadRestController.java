package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;

@RestController
@RequestMapping("/api")
public class LeadRestController {
	@Autowired
	private LeadRepository leadRepo;
	//http://localhost:8080/api
	@GetMapping
	public List<Lead> getLeads(){
		List<Lead> leads = leadRepo.findAll();
	    return leads;
	}
	
	@PostMapping
	public void saveLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	@PutMapping
	public void updateLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	//http://localhost:8080/api/16
	@DeleteMapping("/{id}")
	public void deleteLead(@PathVariable("id") long id) {
		leadRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
 
}
