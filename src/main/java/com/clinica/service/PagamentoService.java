package com.clinica.service;

import com.clinica.domain.paciente.Paciente;
import com.clinica.domain.pagamento.Pagamento;
import com.clinica.domain.pagamento.dto.CreatePagamentoDTO;
import com.clinica.domain.pagamento.dto.DetailPagamentoDTO;
import com.clinica.domain.pagamento.dto.ListPagamentoDTO;
import com.clinica.domain.pagamento.dto.UpdatePagamentoDTO;
import com.clinica.domain.servicoMedico.ServicoMedico;
import com.clinica.repository.IDentistaRepository;
import com.clinica.repository.IPacienteRepository;
import com.clinica.repository.IPagamentoRepository;
import com.clinica.repository.IServicoMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PagamentoService {

    @Autowired
    IPagamentoRepository paymentRepos;
    @Autowired
    IServicoMedicoRepository healthServiceRepos;
    @Autowired
    IPacienteRepository patientRepos;

    @Autowired
    IDentistaRepository dentistRepos;

    public List<ListPagamentoDTO> list() {
        return paymentRepos.findAll()
                .stream()
                .map(ListPagamentoDTO::new)
                .toList();
    }

    public DetailPagamentoDTO getById(UUID id) {

        Optional<Pagamento> paymentoOpt = paymentRepos.findById(id);

        if(paymentoOpt.isPresent()) {
            return new DetailPagamentoDTO(paymentoOpt.get());
        }

        throw new RuntimeException("Dentist not found");

    }

    public DetailPagamentoDTO save(CreatePagamentoDTO data) {

        Optional<ServicoMedico> healthServiceOpt = healthServiceRepos.findById(data.servicoMedicoId());
        Optional<Paciente> patientOpt = patientRepos.findById(data.pacienteId());

        if (patientOpt.isPresent() && healthServiceOpt.isPresent()) {
            Pagamento payment = new Pagamento(UUID.randomUUID(), data.valorTotal(), data.formaDePagamento(), data.situacao(), LocalDateTime.now(), null, healthServiceOpt.get(), patientOpt.get());
            return new DetailPagamentoDTO(paymentRepos.save(payment));
        }

        throw new RuntimeException("Health Service or patient not found");

    }

    public DetailPagamentoDTO update(UUID id, UpdatePagamentoDTO data) {

        Optional<Pagamento> paymentOpt = paymentRepos.findById(id);

        if (paymentOpt.isPresent()) {

            Pagamento paymentToUpdate = paymentOpt.get();

            if (data.formaDePagamento() != null) paymentToUpdate.setFormaDePagamento(data.formaDePagamento());
            if (data.valorTotal() != null) paymentToUpdate.setValorTotal(data.valorTotal());
            if (data.situacao() != null) paymentToUpdate.setSituacao(data.situacao());
            paymentToUpdate.setAtualizadoEm(LocalDateTime.now());
            if (data.pacienteId() != null) {

                Optional<Paciente> patientOpt = patientRepos.findById(data.pacienteId());

                if(patientOpt.isPresent()) {
                    paymentToUpdate.setPatient(patientOpt.get());
                } else {
                    throw new RuntimeException("Payment not found");
                }

            };
            if(data.servicoMedicoId() != null) {

                Optional<ServicoMedico> healthServiceOpt = healthServiceRepos.findById(data.servicoMedicoId());

                if(healthServiceOpt.isPresent()) {
                    paymentToUpdate.setHealthService(healthServiceOpt.get());
                } else {
                    throw new RuntimeException("Health Service not found");
                }

            }

            return new DetailPagamentoDTO(paymentRepos.save(paymentToUpdate)) ;

        }

        throw new RuntimeException("Payment not found");

    }

}
