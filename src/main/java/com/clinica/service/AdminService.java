package com.clinica.service;

import com.clinica.domain.admin.Admin;
import com.clinica.domain.admin.dto.CreateAdminDTO;
import com.clinica.domain.admin.dto.DetailAdminDTO;
import com.clinica.domain.admin.dto.UpdateAdminDTO;
import com.clinica.domain.clinica.Clinica;
import com.clinica.domain.clinica.dto.IdNomeClinicaDTO;
import com.clinica.repository.IAdminRepository;
import com.clinica.repository.IClinicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminService {

    @Autowired
    IAdminRepository adminRepos;

    @Autowired
    IClinicaRepository clinicaRepos;

    public List<DetailAdminDTO> list() {
        return adminRepos.findAll()
                .stream()
                .map(DetailAdminDTO::new)
                .toList() ;
    }

    public DetailAdminDTO getById(UUID id) {

        Optional<Admin> adminOpt = adminRepos.findById(id);

        if(adminOpt.isPresent()) {

            Optional<Clinica> clinicaOpt = clinicaRepos.findById(adminOpt.get().getClinica().getId());

            if(clinicaOpt.isPresent()) {

                Clinica clinica = clinicaOpt.get();
                IdNomeClinicaDTO clinicaDTO = new IdNomeClinicaDTO(clinica.getId(), clinica.getNome());

                return new DetailAdminDTO(adminOpt.get(), clinicaDTO);

            } else {
                throw new RuntimeException("the clinic of this admin was not found");
            }

        }

        throw new RuntimeException("Admin not founded");

    }

    public DetailAdminDTO save(CreateAdminDTO data) {

        if(data.cpf() == null) throw new RuntimeException("the field cpf is blank");
        if(data.nome() == null) throw new RuntimeException("the field nome is blank");
        if(data.role() == null) throw new RuntimeException("the field role is blank");
        if(data.idClinica() == null) throw new RuntimeException("the field id clinica is blank");
        if(data.dataNascimento() == null)throw new RuntimeException("the field data nascimento is blank");


        Optional<Clinica> clinicaOpt = clinicaRepos.findById(data.idClinica());

        if(clinicaOpt.isPresent()) {

            Clinica clinica = clinicaOpt.get();
            IdNomeClinicaDTO clinicaDTO = new IdNomeClinicaDTO(clinica.getId(), clinica.getNome());

            Admin adminToSave = new Admin(UUID.randomUUID(), data.cpf(), data.role(), data.nome(), data.dataNascimento(), true, LocalDateTime.now(), null, clinica);

            return new DetailAdminDTO(adminRepos.save(adminToSave),clinicaDTO);

        } else {
            throw new RuntimeException("the clinic of this admin was not found");
        }

    }

    @Transactional
    public DetailAdminDTO update(UUID id, UpdateAdminDTO data) {

        Optional<Admin> adminOpt = adminRepos.findById(id);

        if(adminOpt.isPresent()) {
            Admin adminToUpdate = adminOpt.get();
            if (data.cpf() != null) adminToUpdate.setCpf(data.cpf());
            if (data.nome() != null) adminToUpdate.setNome(data.nome());
            if (data.dataNascimento() != null) adminToUpdate.setDataNascimento(data.dataNascimento());
            if (data.ativo() != null) adminToUpdate.setAtivo(data.ativo());
            if (data.role() != null) adminToUpdate.setCpf(data.cpf());
            if (data.idClinica() != null) {
                Optional<Clinica> clinicaOpt = clinicaRepos.findById(data.idClinica());
                clinicaOpt.ifPresent(adminToUpdate::setClinica);
            }

            Admin adminUpdated = adminRepos.save(adminToUpdate);

            return new DetailAdminDTO(adminUpdated);

        }

        throw new RuntimeException("Admin not found");

    }

    @Transactional
    public DetailAdminDTO delete(UUID id) {

        Optional<Admin> adminOpt = adminRepos.findById(id);

        if(adminOpt.isPresent()) {

            Admin adminToDelete = adminOpt.get();

            if (adminToDelete.getAtivo()) {
                adminToDelete.setAtivo(false);
                return new DetailAdminDTO(adminRepos.save(adminToDelete));
            }

            throw new RuntimeException("Admin já está desativado");

        }

        throw new RuntimeException("Admin não encontrado");

    }

}
