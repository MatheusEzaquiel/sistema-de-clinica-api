package com.clinica.controller;

import com.clinica.domain.paciente.Paciente;
import com.clinica.domain.paciente.dto.CreatePacienteDTO;
import com.clinica.domain.paciente.dto.DetailPacienteDTO;
import com.clinica.domain.paciente.dto.ListPacienteDTO;
import com.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<ListPacienteDTO>> index() {
        List<ListPacienteDTO> patientsDTO = pacienteService.list();
        return ResponseEntity.status(HttpStatus.OK).body(patientsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailPacienteDTO> get(@PathVariable UUID id) {
        DetailPacienteDTO patientDTO = pacienteService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patientDTO);
    }

    @PostMapping
    public ResponseEntity<DetailPacienteDTO> save(@RequestBody CreatePacienteDTO data) {
        DetailPacienteDTO patientDTO = pacienteService.save(data);
        return ResponseEntity.status(HttpStatus.OK).body(patientDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailPacienteDTO> update(@PathVariable UUID id, @RequestBody Paciente data) {
        DetailPacienteDTO patientDTO = pacienteService.update(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(patientDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetailPacienteDTO> delete(@PathVariable UUID id) {
        DetailPacienteDTO patientsDTO = pacienteService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(patientsDTO);
    }

}
