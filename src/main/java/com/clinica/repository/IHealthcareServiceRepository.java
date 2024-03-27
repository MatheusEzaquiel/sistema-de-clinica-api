package com.clinica.repository;

import com.clinica.domain.healthcareservice.HealthcareService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IHealthcareServiceRepository extends JpaRepository<HealthcareService, UUID> {

}