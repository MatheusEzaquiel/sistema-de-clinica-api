package com.clinica.controller;

import com.clinica.domain.healthcareservice.HealthcareService;
import com.clinica.repository.IHealthcareServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/healthcare-services")
public class HealthcareServiceController {

    @Autowired
    private IHealthcareServiceRepository healthcareServiceRepos;

    @GetMapping
    public ResponseEntity list() {

        List<HealthcareService> services = healthcareServiceRepos.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(services);

    }

}
