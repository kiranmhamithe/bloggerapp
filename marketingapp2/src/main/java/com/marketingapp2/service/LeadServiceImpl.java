package com.marketingapp2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp2.entity.Lead;
import com.marketingapp2.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Override
    public void saveLead(Lead lead) {
        leadRepository.save(lead);
    }

	@Override
	public Lead getLeadById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}

