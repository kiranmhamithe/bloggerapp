package com.marketing.service;


import java.util.List;

import com.marketing.dto.LeadDto;
import com.marketing.entity.Lead;

public interface LeadService {
	public void saveLead(Lead lead);

	public List<Lead> getAllLeads();

	public void deleteLead(long id);

	public Lead findLead(long id);

	void updateLead(LeadDto leadDto);

	

	

}
