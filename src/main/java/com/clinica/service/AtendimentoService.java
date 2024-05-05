package com.clinica.service;

import com.clinica.domain.admin.Admin;
import com.clinica.domain.atendimento.Atendimento;
import com.clinica.domain.atendimento.dto.CreateAtendimentoDTO;
import com.clinica.domain.atendimento.dto.DetailAtendimentoDTO;
import com.clinica.domain.clinica.Clinica;
import com.clinica.domain.dentista.Dentista;
import com.clinica.domain.paciente.Paciente;
import com.clinica.domain.pagamento.Pagamento;
import com.clinica.domain.pagamento.dto.CreatePagamentoDTO;
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
    PagamentoService paymentService;


    public List<DetailAtendimentoDTO> list() {
        return appointmentRepos.findAll()
                .stream()
                .map(DetailAtendimentoDTO::new)
                .toList();
    }

    @Transactional
    public DetailAtendimentoDTO save(CreateAtendimentoDTO data) {

        Paciente patient = patientRepos.findById(data.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + data.pacienteId()));

        // Patient's clinic
        Clinica clinic = patient.getClinica();


        // Verification Dentist exists
        Dentista dentist = dentistRepos.findById(data.dentistaId())
                .orElseThrow(() -> new RuntimeException("Dentista não encontrado com ID: " + data.dentistaId()));

            // Verification Dentist doesn't belong the same Clinic of patient
            if(dentist.getClinica().getId() != clinic.getId()) {
                throw new RuntimeException("This Dentist doesn't belong the same clinic of the patient");
            }

        // Verification HealthService exists
        ServicoMedico healthService = healthServiceRepos.findById(data.servicoMedicoId())
                .orElseThrow(() -> new RuntimeException("Health Service not found: " + data.servicoMedicoId()));

            //Verification Dentist realizes this healthService
            if(healthService.getDentista().getId() != dentist.getId()) throw new RuntimeException("Dentist doesn't realize this health service");

        // Verification Admin exists
        Admin admin = adminRepos.findById(data.adminId())
                .orElseThrow(() -> new RuntimeException("Admin não encontrado com ID: " + data.adminId()));

            // Verification Admins belong the same clinic of patient
            if(admin.getClinica().getId() != clinic.getId()) throw new RuntimeException("Admin doesn't belong of this clinic");


        Atendimento appointmentToSave = new Atendimento(
                UUID.randomUUID(), data.horarioInicio(), data.horarioFim(), data.data(), true, LocalDateTime.now(), null,
                dentist, patient, healthService, admin, clinic);

        return new DetailAtendimentoDTO(appointmentRepos.save(appointmentToSave));

    }

}