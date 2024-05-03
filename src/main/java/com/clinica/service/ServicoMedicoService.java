package com.clinica.service;

import com.clinica.domain.dentista.Dentista;
import com.clinica.domain.dentista.dto.DetailDentistaDTO;
import com.clinica.domain.servicoMedico.ServicoMedico;
import com.clinica.domain.servicoMedico.dto.CreateServicoMedicoDTO;
import com.clinica.domain.servicoMedico.dto.DetailServicoMedicoDTO;
import com.clinica.domain.servicoMedico.dto.ListServicoMedicoDTO;
import com.clinica.domain.servicoMedico.dto.UpdateServicoMedicoDTO;
import com.clinica.repository.IDentistaRepository;
import com.clinica.repository.IServicoMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServicoMedicoService {

    @Autowired
    IServicoMedicoRepository healthServiceRepos;

    @Autowired
    IDentistaRepository dentistRepos;

    public List<ListServicoMedicoDTO> list() {
        return healthServiceRepos.findAll()
                .stream()
                .map(ListServicoMedicoDTO::new)
                .toList();
    }

    public DetailServicoMedicoDTO getById(UUID id) {

        Optional<ServicoMedico> healthServiceOpt = healthServiceRepos.findById(id);

        if(healthServiceOpt.isPresent()) {
            return new DetailServicoMedicoDTO(healthServiceOpt.get());
        }

        throw new RuntimeException("Dentist not found");

    }

    public DetailServicoMedicoDTO create(CreateServicoMedicoDTO data) {

        Optional<ServicoMedico> healthcareServiceOpt = healthServiceRepos.findByNome(data.nome());
        Optional<Dentista> dentistOpt = dentistRepos.findById(data.dentistaId());

        if (healthcareServiceOpt.isEmpty()) {

            if(dentistOpt.isPresent()) {
                ServicoMedico healthServiceToSave = new ServicoMedico(UUID.randomUUID(), data.nome(), data.descricao(), data.preco(), true, LocalDateTime.now(), null, dentistOpt.get());

                ServicoMedico healthServiceSaved = healthServiceRepos.save(healthServiceToSave);

                return new DetailServicoMedicoDTO(healthServiceSaved);
            }
            throw new RuntimeException("Dentist not found");

        }

        throw new RuntimeException("Health Service not found");

    }

    public ServicoMedico update(UUID id, UpdateServicoMedicoDTO data) {

        Optional<ServicoMedico> HealthcareServiceOpt = healthServiceRepos.findById(id);

        if (HealthcareServiceOpt.isPresent()) {

            ServicoMedico servicoMedicoToCreate = HealthcareServiceOpt.get();

            if(data.nome() != null) servicoMedicoToCreate.setNome(data.nome());
            if(data.descricao() != null) servicoMedicoToCreate.setDescricao(data.descricao());
            if(data.preco() != null) servicoMedicoToCreate.setPreco(data.preco());
            if(data.ativo() != null) servicoMedicoToCreate.setAtivo(data.ativo());
            servicoMedicoToCreate.setAtualizadoEm(LocalDateTime.now());

            return healthServiceRepos.save(servicoMedicoToCreate);

        }

        throw new RuntimeException("Health Service not found");

    }

    public ServicoMedico delete(UUID id) {

        Optional<ServicoMedico> healthcareServiceOpt = healthServiceRepos.findById(id);

        if (healthcareServiceOpt.isPresent()) {
            ServicoMedico servicoMedicoToDelete = healthcareServiceOpt.get();
            servicoMedicoToDelete.setAtivo(false);
            return healthServiceRepos.save(servicoMedicoToDelete);
        }

        throw new RuntimeException("Health Service not found");

    }

}
