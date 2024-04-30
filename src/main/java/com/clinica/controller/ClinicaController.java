package com.clinica.controller;

import com.clinica.domain.clinica.Clinica;
import com.clinica.domain.clinica.dto.CreateClinicaDTO;
import com.clinica.domain.clinica.dto.DetailClinicaDTO;
import com.clinica.domain.clinica.dto.UpdateClinicaDTO;
import com.clinica.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clinicas")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    @GetMapping
    public ResponseEntity<List<Clinica>> list() {
        List<Clinica> clinics = clinicaService.list();
        return ResponseEntity.status(HttpStatus.OK).body(clinics);
    }

    @PostMapping
    public ResponseEntity<DetailClinicaDTO> save(@RequestBody CreateClinicaDTO data) {
        DetailClinicaDTO clinicCreated = clinicaService.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(clinicCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailClinicaDTO> update(@PathVariable UUID id, @RequestBody UpdateClinicaDTO data) {
        DetailClinicaDTO clinicUpdated = clinicaService.update(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(clinicUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetailClinicaDTO> delete(@PathVariable UUID id) {
        DetailClinicaDTO clinicDeleted = clinicaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(clinicDeleted);
    }

}