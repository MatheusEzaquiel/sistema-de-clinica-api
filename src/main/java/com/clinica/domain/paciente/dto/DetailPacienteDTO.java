package com.clinica.domain.paciente.dto;

import com.clinica.domain.clinica.dto.IdNomeClinicaDTO;
import com.clinica.domain.paciente.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record DetailPacienteDTO(
        UUID id,
        String cpf,
        String nome,
        LocalDate dataNascimento,
        Boolean planoDeSaude,
        Boolean ativo,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm,
        IdNomeClinicaDTO clinica
    ) {

    public DetailPacienteDTO(Paciente paciente){
        this(
                paciente.getId(),
                paciente.getCpf(),
                paciente.getNome(),
                paciente.getDataNascimento(),
                paciente.getPlanoDeSaude(),
                paciente.getAtivo(),
                paciente.getCriadoEm(),
                paciente.getAtualizadoEm(),
                new IdNomeClinicaDTO(paciente.getClinica().getId(), paciente.getClinica().getNome())
        );
    }
}
