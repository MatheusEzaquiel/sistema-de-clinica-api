package com.clinica.domain.dentista.dto;

import com.clinica.domain.dentista.Dentista;

import java.util.UUID;

public record BasicDentistaDTO(UUID id, String cro, String nome) {

    public BasicDentistaDTO(Dentista dentist) {
        this(dentist.getId(), dentist.getCro(), dentist.getNome());
    }

}
