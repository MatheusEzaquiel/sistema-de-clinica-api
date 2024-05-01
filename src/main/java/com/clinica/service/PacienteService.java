package com.clinica.service;

import com.clinica.domain.clinica.Clinica;
import com.clinica.domain.paciente.Paciente;
import com.clinica.domain.paciente.dto.CreatePacienteDTO;
import com.clinica.domain.paciente.dto.DetailPacienteDTO;
import com.clinica.domain.paciente.dto.ListPacienteDTO;
import com.clinica.repository.IClinicaRepository;
import com.clinica.repository.IPacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository patientRepos;

    @Autowired
    IClinicaRepository clinicaRepos;

    public List<ListPacienteDTO> list() {
        return patientRepos.findAll()
                .stream()
                .map(ListPacienteDTO::new)
                .toList();
    }

    public DetailPacienteDTO getById(UUID id) {

        Optional<Paciente> patientOpt = patientRepos.findById(id);

        if(patientOpt.isPresent()) return new DetailPacienteDTO(patientOpt.get());

        throw new RuntimeException("Patient not found");

    }

    public DetailPacienteDTO save(CreatePacienteDTO data) {

        if(data.cpf() == null) throw new RuntimeException("the field cpf is blank");
        if(data.nome() == null) throw new RuntimeException("the field nome is blank");
        if(data.clinicaId() == null) throw new RuntimeException("the field clinicaId is blank");
        if(data.dataNascimento() == null) throw new RuntimeException("the field dataNascimento is blank");
        if(data.planoDeSaude() == null) throw new RuntimeException("the field planoDeSaude is blank");


        Optional<Clinica> clinicaOpt = clinicaRepos.findById(data.clinicaId());

        if(clinicaOpt.isPresent()) {

            Clinica clinica = clinicaOpt.get();
            var patientToSave = new Paciente(UUID.randomUUID(), data.cpf(), data.nome(), data.dataNascimento(), data.planoDeSaude(), true, LocalDateTime.now(), null, clinica);

            return new DetailPacienteDTO(patientRepos.save(patientToSave));

        } else {
            throw new RuntimeException("The clinic of this admin was not found");
        }

    }

    @Transactional
    public DetailPacienteDTO update(UUID id, Paciente data) {

        Optional<Paciente> patientOpt = patientRepos.findById(id);

        if(patientOpt.isPresent()) {
            Paciente patientToUpdate = patientOpt.get();
            if (data.getCpf() != null) patientToUpdate.setCpf(data.getCpf());
            if (data.getNome() != null) patientToUpdate.setNome(data.getNome());
            if (data.getDataNascimento() != null) patientToUpdate.setDataNascimento(data.getDataNascimento());
            if (data.getPlanoDeSaude() != null) patientToUpdate.setPlanoDeSaude(data.getPlanoDeSaude());
            if (data.getAtivo() != null) patientToUpdate.setAtivo(data.getAtivo());
            /*if (data.idClinica() != null) {
                Optional<Clinica> clinicaOpt = clinicaRepos.findById(data.idClinica());
                clinicaOpt.ifPresent(patientToUpdate::setClinica);
            }*/

            return new DetailPacienteDTO(patientRepos.save(patientToUpdate));

        }

        throw new RuntimeException("Patient not found");

    }

    @Transactional
    public DetailPacienteDTO delete(UUID id) {

        Optional<Paciente> patientOpt = patientRepos.findById(id);

        if(patientOpt.isPresent()) {

            Paciente adminToDelete = patientOpt.get();

            if (adminToDelete.getAtivo()) {
                adminToDelete.setAtivo(false);
                return new DetailPacienteDTO(patientRepos.save(adminToDelete));
            }

            throw new RuntimeException("Patient alredy is abled");

        }

        throw new RuntimeException("Patient not found");

    }

}