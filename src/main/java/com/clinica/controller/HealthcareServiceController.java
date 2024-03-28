package com.clinica.controller;

import com.clinica.domain.healthcareservice.HealthcareService;
import com.clinica.domain.healthcareservice.dto.CreateHealthcareServiceDTO;
import com.clinica.domain.healthcareservice.dto.UpdateHealthcareServiceDTO;
import com.clinica.service.HealthcareServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/healthcare-service")
public class HealthcareServiceController {

    @Autowired
    private HealthcareServiceService healthcareServiceService;

    @GetMapping
    public ResponseEntity<List<HealthcareService>> list() {
        List<HealthcareService> services = healthcareServiceService.list();
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }

    @PostMapping
    public ResponseEntity<HealthcareService> create(@RequestBody CreateHealthcareServiceDTO data) {
        HealthcareService serviceCreated = healthcareServiceService.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthcareService> update(@PathVariable UUID id, @RequestBody UpdateHealthcareServiceDTO data) {
        HealthcareService servicesUpdated = healthcareServiceService.update(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(servicesUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HealthcareService> delete(@PathVariable UUID id) {
        HealthcareService serviceDeleted = healthcareServiceService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(serviceDeleted);
    }

}
