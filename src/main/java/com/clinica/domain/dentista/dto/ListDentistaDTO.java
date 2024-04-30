package com.clinica.domain.dentista.dto;

import com.clinica.domain.dentista.Dentista;

import java.time.LocalDate;
import java.util.UUID;

public record ListDentistaDTO(
        UUID id,
        String cpf,
        String cro,
        String nome,
        LocalDate dataNascimento,
        String area
) {
    public ListDentistaDTO(Dentista dentist){
        this(dentist.getId(), dentist.getCpf(), dentist.getCro(), dentist.getNome(), dentist.getDataNascimento(), dentist.getArea());
    }
}
