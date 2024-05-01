package com.clinica.domain.paciente.dto;

import java.time.LocalDate;
import java.util.UUID;

public record CreatePacienteDTO(
        String cpf,
        String nome,
        LocalDate dataNascimento,
        Boolean planoDeSaude,
        UUID clinicaId
) {
}
