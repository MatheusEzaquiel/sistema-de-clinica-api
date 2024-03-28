package com.clinica.domain.healthcareservice.dto;

import java.time.LocalDateTime;

public record UpdateHealthcareServiceDTO(String name, String description, Float price, Boolean enabled, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
