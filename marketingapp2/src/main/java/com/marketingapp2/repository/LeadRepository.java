package com.marketingapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketingapp2.entity.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    
}

