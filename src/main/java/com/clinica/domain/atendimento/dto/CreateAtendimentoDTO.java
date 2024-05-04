package com.clinica.domain.atendimento.dto;

import com.clinica.domain.admin.dto.BasicAdminDTO;
import com.clinica.domain.clinica.dto.BasicClinicaDTO;
import com.clinica.domain.dentista.dto.BasicDentistaDTO;
import com.clinica.domain.paciente.dto.IdNomeCpfPacienteDTO;
import com.clinica.domain.servicoMedico.dto.IdNomePrecoServicoMedicoDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record CreateAtendimentoDTO(
        LocalTime horarioInicio,
        LocalTime horarioFim,
        LocalDate data,
        UUID dentistaId,
        UUID pacienteId,
        UUID servicoMedicoId,
        UUID pagamentoId,
        UUID adminId,
        UUID clinicaId
) {
}