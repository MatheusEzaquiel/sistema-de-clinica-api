package com.clinica.service;

import com.clinica.domain.clinica.Clinica;
import com.clinica.domain.dentista.Dentista;
import com.clinica.domain.dentista.dto.CreateDentistaDTO;
import com.clinica.domain.dentista.dto.DetailDentistaDTO;
import com.clinica.domain.dentista.dto.ListDentistaDTO;
import com.clinica.domain.dentista.dto.UpdateDentistaDTO;
import com.clinica.repository.IClinicaRepository;
import com.clinica.repository.IDentistaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DentistaService {

    @Autowired
    IDentistaRepository dentistaRepos;

    @Autowired
    IClinicaRepository clinicaRepos;

    public List<ListDentistaDTO> list() {
        return dentistaRepos.findAll()
                .stream()
                .map(ListDentistaDTO::new)
                .toList();
    }

    public DetailDentistaDTO getById(UUID id) {

        Optional<Dentista> dentistOpt = dentistaRepos.findById(id);

        if(dentistOpt.isPresent()) return new DetailDentistaDTO(dentistOpt.get());

        throw new RuntimeException("Dentist not found");

    }

    public DetailDentistaDTO save(CreateDentistaDTO data) {

        if(data.cpf() == null) throw new RuntimeException("the field cpf is blank");
        if(data.cro() == null) throw new RuntimeException("the field cro is blank");
        if(data.nome() == null) throw new RuntimeException("the field nome is blank");
        if(data.dataNascimento() == null) throw new RuntimeException("the field dataNascimento is blank");
        if(data.area() == null) throw new RuntimeException("the field area is blank");
        if(data.clinicaId() == null) throw new RuntimeException("the field clinicaId is blank");


        Optional<Clinica> clinicaOpt = clinicaRepos.findById(data.clinicaId());

        if(clinicaOpt.isPresent()) {

            Clinica clinica = clinicaOpt.get();
            Dentista d = new Dentista(UUID.randomUUID(), data.cpf(), data.cro(), data.nome(), data.dataNascimento(), data.area(),
                    true, LocalDateTime.now(), null, clinica);

            return new DetailDentistaDTO(dentistaRepos.save(d));

        } else {
            throw new RuntimeException("The clinic of this dentist was not found");
        }

    }

    @Transactional
    public DetailDentistaDTO update(UUID id, UpdateDentistaDTO data) {

        Optional<Dentista> dentistOpt = dentistaRepos.findById(id);

        if(dentistOpt.isPresent()) {
            Dentista dentistToUpdate = dentistOpt.get();
            if (data.cpf() != null) dentistToUpdate.setCpf(data.cpf());
            if (data.cro() != null) dentistToUpdate.setCro(data.cro());
            if (data.nome() != null) dentistToUpdate.setNome(data.nome());
            if (data.dataNascimento() != null) dentistToUpdate.setDataNascimento(data.dataNascimento());
            if (data.area() != null) dentistToUpdate.setArea(data.area());
            if (data.ativo() != null) dentistToUpdate.setAtivo(data.ativo());
            /*if (data.idClinica() != null) {
                Optional<Clinica> clinicaOpt = clinicaRepos.findById(data.idClinica());
                clinicaOpt.ifPresent(patientToUpdate::setClinica);
            }*/

            return new DetailDentistaDTO(dentistaRepos.save(dentistToUpdate));

        }

        throw new RuntimeException("Dentist not found");

    }

    @Transactional
    public DetailDentistaDTO delete(UUID id) {

        Optional<Dentista> dentistOpt = dentistaRepos.findById(id);

        if(dentistOpt.isPresent()) {

            Dentista dentistToDelete = dentistOpt.get();

            if (dentistToDelete.getAtivo()) { // se ele for ativo
                dentistToDelete.setAtivo(false);
                return new DetailDentistaDTO(dentistaRepos.save(dentistToDelete));
            }


            throw new RuntimeException("Dentist alredy is abled");

        }

        throw new RuntimeException("Dentist not found");

    }

}
