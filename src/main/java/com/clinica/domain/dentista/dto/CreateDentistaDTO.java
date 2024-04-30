package com.clinica.domain.dentista.dto;

import java.time.LocalDate;
import java.util.UUID;

public record CreateDentistaDTO(
        String cpf,
        String cro,
        String nome,
        LocalDate dataNascimento,
        String area,
        UUID clinicaId
) {}