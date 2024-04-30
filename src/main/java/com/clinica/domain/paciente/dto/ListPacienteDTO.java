package com.clinica.domain.paciente.dto;

import com.clinica.domain.paciente.Paciente;

import java.time.LocalDate;
import java.util.UUID;

public record ListPacienteDTO(
        UUID id,
        String cpf,
        String nome,
        LocalDate dataNascimento,
        Boolean planoDeSaude,
        Boolean ativo) {

    public ListPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getCpf(), paciente.getNome(), paciente.getDataNascimento(), paciente.getPlanoDeSaude(), paciente.getAtivo());
    }

}
