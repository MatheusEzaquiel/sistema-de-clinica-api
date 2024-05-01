package com.clinica.domain.admin.dto;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateAdminDTO(
        String cpf,
        Integer role,
        String nome,
        LocalDate dataNascimento,
        Boolean ativo,
        UUID idClinica
) {
}
