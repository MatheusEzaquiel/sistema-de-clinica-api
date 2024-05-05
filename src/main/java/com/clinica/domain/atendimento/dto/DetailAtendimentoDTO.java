package com.clinica.domain.atendimento.dto;

import com.clinica.domain.admin.Admin;
import com.clinica.domain.admin.dto.BasicAdminDTO;
import com.clinica.domain.atendimento.Atendimento;
import com.clinica.domain.clinica.Clinica;
import com.clinica.domain.clinica.dto.BasicClinicaDTO;
import com.clinica.domain.dentista.Dentista;
import com.clinica.domain.dentista.dto.BasicDentistaDTO;
import com.clinica.domain.paciente.dto.IdNomeCpfPacienteDTO;
import com.clinica.domain.pagamento.Pagamento;
import com.clinica.domain.pagamento.dto.BasicPagamentoDTO;
import com.clinica.domain.servicoMedico.ServicoMedico;
import com.clinica.domain.servicoMedico.dto.IdNomePrecoServicoMedicoDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record DetailAtendimentoDTO(
        UUID id,
        LocalTime horarioInicio,
        LocalTime horarioFim,
        LocalDate data,
        Boolean ativo,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm,
        BasicDentistaDTO dentista,
        IdNomeCpfPacienteDTO paciente,
        IdNomePrecoServicoMedicoDTO  servicoMedico,
        BasicAdminDTO admin,
        BasicClinicaDTO clinica
) {

    public DetailAtendimentoDTO(Atendimento appointment) {
        this(
                appointment.getId(),
                appointment.getHorarioInicio(),
                appointment.getHorarioFim(),
                appointment.getData(),
                appointment.getAtivo(),
                appointment.getCriadoEm(),
                appointment.getAtualizadoEm(),
                new BasicDentistaDTO(appointment.getDentist()),
                new IdNomeCpfPacienteDTO(appointment.getPatient()),
                new IdNomePrecoServicoMedicoDTO(appointment.getHealthService()),
                new BasicAdminDTO(appointment.getAdmin()) ,
                new BasicClinicaDTO(appointment.getClinica())
        );
    }

}