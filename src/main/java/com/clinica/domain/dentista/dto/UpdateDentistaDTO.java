package com.clinica.domain.dentista.dto;

import java.time.LocalDate;

public record UpdateDentistaDTO(
        String cpf,
        String cro,
        String nome,
        LocalDate dataNascimento,
        String area,
        Boolean ativo
) {
}
