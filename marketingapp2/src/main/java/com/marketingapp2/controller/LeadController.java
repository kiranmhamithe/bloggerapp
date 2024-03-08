package com.marketingapp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.marketingapp2.entity.Lead;
import com.marketingapp2.service.LeadService;

@Controller
public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping("/leadForm")
    public String showLeadForm(Model model) {
        model.addAttribute("lead", new Lead());
        return "leadForm";
    }

    @PostMapping("/saveLead")
    public String saveLead(@ModelAttribute Lead lead) {
        leadService.saveLead(lead);
        return "redirect:/leadForm"; // Redirect to the lead form after saving
    }

    @GetMapping("/viewLead/{id}")
    public String viewLead(@PathVariable Long id, Model model) {
        Lead lead = leadService.getLeadById(id);
        model.addAttribute("lead", lead);
        return "viewLead";
    }

    // Add more methods for editing, deleting, listing leads, etc. as needed

}
