package com.marketing.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadDto;
import com.marketing.entity.Lead;
import com.marketing.service.LeadService;
import com.marketing.util.EmailService;

//Spring MVC ,spring web
@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	@Autowired
	private EmailService emailService;
	
	
//handler method
	//http://localhost:8080/view
	@RequestMapping("/view")
	public String viewCreateLeadForm() {
		return "create_lead";
		//RequestDispatcher
	}
//	@RequestMapping("/saveLead")
//	public String saveLead(Lead lead, Model model) {
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "Lead is saved..!");
//		return "create_lead";	
//	}
//	@RequestMapping("/saveLead")
//	public String saveLead(
//	    @RequestParam("first") String firstName,
//	    @RequestParam("last") String lastName,
//	    @RequestParam("email") String email,
//	    @RequestParam("mobile") Long mobile
//	    ,  Model model) {
//		Lead lead = new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "Lead is saved..!");
//		return "create_lead";
//}
	@RequestMapping("/saveLead")
	public String saveLead(
	   LeadDto leadDto
	    ,  Model model) {
		Lead lead = new Lead();
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setEmail(leadDto.getEmail());
        lead.setMobile(leadDto.getMobile());
		leadService.saveLead(lead);
		emailService.sendEmail(leadDto.getEmail(), "Test", "Test Email Sending");
		model.addAttribute("msg", "Lead is saved..!");
		return "create_lead";
}
	   @RequestMapping("/listall")
	   public String getAllLeads(Model  model) {
		 List<Lead> leads = leadService.getAllLeads();
		 model.addAttribute("leads", leads);
		 return "list_leads";
		 
		 
	   }
	   
	   @RequestMapping("/delete")
	   public String deleteLead(@RequestParam("id") long id, ModelMap model) {
		   leadService.deleteLead(id);
		   List<Lead> leads = leadService.getAllLeads();
			 model.addAttribute("leads", leads);
			 return "list_leads";   
	   }
	   @RequestMapping("/update")
	   public String updateLead(@RequestParam("id") long id, ModelMap model) {
		  Lead lead = leadService.findLead(id);
		  model.addAttribute("lead", lead);
			 return "update_lead";   
	   }
	   
	   @RequestMapping("/updateLead")
	   public String updateLeadInformation(LeadDto leadDto, Model model) {
		 leadService.updateLead(leadDto);
		 List<Lead> leads = leadService.getAllLeads();
		 model.addAttribute("leads", leads);
		 return "list_leads";    
	   }
	   
	   
}