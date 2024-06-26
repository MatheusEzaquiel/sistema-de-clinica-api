package com.clinica.domain.admin.dto;

import java.time.LocalDate;
import java.util.UUID;

public record CreateAdminDTO(

        String cpf,
        Integer role,
        String nome,
        LocalDate dataNascimento,
        UUID idClinica

) {

}
