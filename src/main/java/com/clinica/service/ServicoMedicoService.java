package com.clinica.service;

import com.clinica.domain.servicoMedico.ServicoMedico;
import com.clinica.domain.servicoMedico.dto.CreateServicoMedicoDTO;
import com.clinica.domain.servicoMedico.dto.UpdateServicoMedicoDTO;
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
    IServicoMedicoRepository servicoMedicoRepos;

    public List<ServicoMedico> list() {
        return servicoMedicoRepos.findAll();
    }

    public ServicoMedico create(CreateServicoMedicoDTO data) {

        Optional<ServicoMedico> healthcareServiceOpt = servicoMedicoRepos.findByNome(data.nome());

        if (healthcareServiceOpt.isEmpty()) {
            ServicoMedico servicoMedicoToCreate = new ServicoMedico(UUID.randomUUID(), data.nome(), data.descricao(), data.preco(), true, LocalDateTime.now(), null);
            return servicoMedicoRepos.save(servicoMedicoToCreate);
        }

        throw new RuntimeException("Health Service not found");

    }

    public ServicoMedico update(UUID id, UpdateServicoMedicoDTO data) {

        Optional<ServicoMedico> HealthcareServiceOpt = servicoMedicoRepos.findById(id);

        if (HealthcareServiceOpt.isPresent()) {

            ServicoMedico servicoMedicoToCreate = HealthcareServiceOpt.get();

            if(data.nome() != null) servicoMedicoToCreate.setNome(data.nome());
            if(data.descricao() != null) servicoMedicoToCreate.setDescricao(data.descricao());
            if(data.preco() != null) servicoMedicoToCreate.setPreco(data.preco());
            if(data.ativo() != null) servicoMedicoToCreate.setAtivo(data.ativo());
            if(data.criadoEm() != null) servicoMedicoToCreate.setCriadoEm(data.criadoEm());
            servicoMedicoToCreate.setAtualizadoEm(LocalDateTime.now());

            return servicoMedicoRepos.save(servicoMedicoToCreate);

        }

        throw new RuntimeException("Health Service not found");

    }

    public ServicoMedico delete(UUID id) {

        Optional<ServicoMedico> healthcareServiceOpt = servicoMedicoRepos.findById(id);

        if (healthcareServiceOpt.isPresent()) {
            ServicoMedico servicoMedicoToDelete = healthcareServiceOpt.get();
            servicoMedicoToDelete.setAtivo(false);
            return servicoMedicoRepos.save(servicoMedicoToDelete);
        }

        throw new RuntimeException("Health Service not found");

    }

}
