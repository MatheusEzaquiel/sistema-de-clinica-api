package com.clinica.domain.clinica.dto;

import com.clinica.domain.clinica.Clinica;

import java.util.UUID;

public record BasicClinicaDTO(UUID id, String cnpj, String nome) {

    public BasicClinicaDTO(Clinica clinic) {
        this(clinic.getId(), clinic.getCnpj(), clinic.getNome());
    }

}
