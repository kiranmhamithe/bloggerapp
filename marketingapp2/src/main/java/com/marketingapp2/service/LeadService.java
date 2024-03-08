package com.marketingapp2.service;

import com.marketingapp2.entity.Lead;

public interface LeadService {
    void saveLead(Lead lead);

	Lead getLeadById(Long id);
}

