package com.clinica.service;

import com.clinica.domain.healthcareservice.HealthcareService;
import com.clinica.repository.IHealthcareServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthcareServiceService {

    @Autowired
    IHealthcareServiceRepository healthcareServiceRepos;

    public List<HealthcareService> list() {
        return healthcareServiceRepos.findAll();
    }

}
