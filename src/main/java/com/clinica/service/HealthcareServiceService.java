package com.clinica.service;

import com.clinica.domain.healthcareservice.HealthcareService;
import com.clinica.domain.healthcareservice.dto.CreateHealthcareServiceDTO;
import com.clinica.domain.healthcareservice.dto.UpdateHealthcareServiceDTO;
import com.clinica.repository.IHealthcareServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HealthcareServiceService {

    @Autowired
    IHealthcareServiceRepository healthcareServiceRepos;

    public List<HealthcareService> list() {
        return healthcareServiceRepos.findAll();
    }

    public HealthcareService create(CreateHealthcareServiceDTO data) {

        Optional<HealthcareService> healthcareServiceOpt = healthcareServiceRepos.findByName(data.name());

        if (healthcareServiceOpt.isEmpty()) {
            HealthcareService healthcareServiceToCreate = new HealthcareService(UUID.randomUUID(), data.name(), data.description(), data.price(), true, LocalDateTime.now(), null);
            return healthcareServiceRepos.save(healthcareServiceToCreate);
        }

        throw new RuntimeException("Healthcare service not found");

    }

    public HealthcareService update(UUID id, UpdateHealthcareServiceDTO data) {

        Optional<HealthcareService> HealthcareServiceOpt = healthcareServiceRepos.findById(id);

        if (HealthcareServiceOpt.isPresent()) {

            HealthcareService healthcareServiceToCreate = HealthcareServiceOpt.get();

            if(data.name() != null) healthcareServiceToCreate.setName(data.name());
            if(data.description() != null) healthcareServiceToCreate.setDescription(data.description());
            if(data.price() != null) healthcareServiceToCreate.setPrice(data.price());
            if(data.enabled() != null) healthcareServiceToCreate.setEnabled(data.enabled());
            if(data.createdAt() != null) healthcareServiceToCreate.setCreatedAt(data.createdAt());
            healthcareServiceToCreate.setUpdatedAt(LocalDateTime.now());

            return healthcareServiceRepos.save(healthcareServiceToCreate);

        }

        throw new RuntimeException("Healthcare service not found");

    }

    public HealthcareService delete(UUID id) {

        Optional<HealthcareService> healthcareServiceOpt = healthcareServiceRepos.findById(id);

        if (healthcareServiceOpt.isPresent()) {
            HealthcareService healthcareServiceToDelete = healthcareServiceOpt.get();
            healthcareServiceToDelete.setEnabled(false);
            return healthcareServiceRepos.save(healthcareServiceToDelete);
        }

        throw new RuntimeException("Healthcare service not found");

    }

}
