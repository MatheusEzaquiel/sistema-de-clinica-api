package com.clinica.service;

import com.clinica.domain.clinica.Clinica;
import com.clinica.domain.clinica.dto.CreateClinicaDTO;
import com.clinica.domain.clinica.dto.DetailClinicaDTO;
import com.clinica.domain.clinica.dto.UpdateClinicaDTO;
import com.clinica.repository.IClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClinicaService {

    @Autowired
    IClinicaRepository clinicaRepos;

    public List<Clinica> list() {
        return clinicaRepos.findAll();
    }

    public DetailClinicaDTO create(CreateClinicaDTO data) {

        Optional<Clinica> clinicOpt = clinicaRepos.findByNome(data.nome());

        if (clinicOpt.isEmpty()) {
            Clinica clinicToCreate = new Clinica(UUID.randomUUID(), data.cnpj(), data.nome(), data.endereco(), data.telefone(), data.anoFundacao(), true, LocalDateTime.now(), null, null, null);
            return new DetailClinicaDTO(clinicaRepos.save(clinicToCreate));
        }

        throw new RuntimeException("Clinic not found");

    }

    public DetailClinicaDTO update(UUID id, UpdateClinicaDTO data) {

        Optional<Clinica> ClinicOpt = clinicaRepos.findById(id);

        if (ClinicOpt.isPresent()) {

            Clinica clinicToCreate = ClinicOpt.get();

            if(data.nome() != null) clinicToCreate.setNome(data.nome());
            if(data.cnpj() != null) clinicToCreate.setCnpj(data.cnpj());
            if(data.endereco() != null) clinicToCreate.setEndereco(data.endereco());
            if(data.telefone() != null) clinicToCreate.setTelefone(data.telefone());
            if(data.anoFundacao() != null) clinicToCreate.setAnoFundacao(data.anoFundacao());
            if(data.ativo() != null) clinicToCreate.setAtivo(data.ativo());
            clinicToCreate.setAtualizadoEm(LocalDateTime.now());

            return new DetailClinicaDTO(clinicaRepos.save(clinicToCreate));

        }

        throw new RuntimeException("Clinic not found");

    }

    public DetailClinicaDTO delete(UUID id) {

        Optional<Clinica> clinicOpt = clinicaRepos.findById(id);

        if (clinicOpt.isPresent()) {
            Clinica clinicToDelete = clinicOpt.get();
            clinicToDelete.setAtivo(false);
            return new DetailClinicaDTO(clinicaRepos.save(clinicToDelete));
        }

        throw new RuntimeException("Clinic not found");

    }

}