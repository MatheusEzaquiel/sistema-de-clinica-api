package com.clinica.service;

import com.clinica.domain.admin.Admin;
import com.clinica.domain.atendimento.Atendimento;
import com.clinica.domain.atendimento.dto.CreateAtendimentoDTO;
import com.clinica.domain.atendimento.dto.DetailAtendimentoDTO;
import com.clinica.domain.clinica.Clinica;
import com.clinica.domain.dentista.Dentista;
import com.clinica.domain.paciente.Paciente;
import com.clinica.domain.pagamento.Pagamento;
import com.clinica.domain.servicoMedico.ServicoMedico;
import com.clinica.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AtendimentoService {

    @Autowired
    IAtendimentoRepository appointmentRepos;

    @Autowired
    IDentistaRepository dentistRepos;

    @Autowired
    IPacienteRepository patientRepos;

    @Autowired
    IServicoMedicoRepository healthServiceRepos;

    @Autowired
    IPagamentoRepository paymentRepos;

    @Autowired
    IAdminRepository adminRepos;

    @Autowired
    IClinicaRepository clinicRepos;


    public List<DetailAtendimentoDTO> list() {
        return appointmentRepos.findAll()
                .stream()
                .map(DetailAtendimentoDTO::new)
                .toList();
    }

    @Transactional
    public DetailAtendimentoDTO save(CreateAtendimentoDTO data) {
        /*
        Optional<Dentista> dentistOpt = dentistRepos.findById(data.dentistaId());
        Optional<Paciente> patientOpt = patientRepos.findById(data.pacienteId());
        Optional<ServicoMedico> healthServiceOpt = healthServiceRepos.findById(data.servicoMedicoId());
        Optional<Pagamento> paymentOpt = paymentRepos.findById(data.pagamentoId());
        Optional<Admin> adminOpt = adminRepos.findById(data.adminId());
        Optional<Clinica> clinicOpt = clinicRepos.findById(data.clinicaId());

        Atendimento appointmentToSave = new Atendimento(
                UUID.randomUUID(), data.horarioInicio(), data.horarioFim(), data.data(), true, LocalDateTime.now(), null,
                dentistOpt.get(), patientOpt.get(), healthServiceOpt.get(), paymentOpt.get(), adminOpt.get(), clinicOpt.get());*/

        Dentista dentist = dentistRepos.findById(data.dentistaId())
                .orElseThrow(() -> new RuntimeException("Dentista não encontrado com ID: " + data.dentistaId()));

        Paciente patient = patientRepos.findById(data.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + data.pacienteId()));

        ServicoMedico healthService = healthServiceRepos.findById(data.servicoMedicoId())
                .orElseThrow(() -> new RuntimeException("Serviço médico não encontrado com ID: " + data.servicoMedicoId()));

        Pagamento payment = paymentRepos.findById(data.pagamentoId())
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com ID: " + data.pagamentoId()));

        Admin admin = adminRepos.findById(data.adminId())
                .orElseThrow(() -> new RuntimeException("Admin não encontrado com ID: " + data.adminId()));

        Clinica clinic = clinicRepos.findById(data.clinicaId())
                .orElseThrow(() -> new RuntimeException("Clínica não encontrada com ID: " + data.clinicaId()));

        Atendimento appointmentToSave = new Atendimento(
                UUID.randomUUID(), data.horarioInicio(), data.horarioFim(), data.data(), true, LocalDateTime.now(), null,
                dentist, patient, healthService, payment, admin, clinic);

        return new DetailAtendimentoDTO(appointmentRepos.save(appointmentToSave));

    }

}
