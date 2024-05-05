package com.clinica.domain.paciente.dto;

import com.clinica.domain.paciente.Paciente;

import java.util.UUID;

public record IdNomeCpfPacienteDTO(UUID id, String nome, String cpf) {

    public IdNomeCpfPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf());
    }
}
