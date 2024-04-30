package com.clinica.controller;

import com.clinica.domain.servicoMedico.ServicoMedico;
import com.clinica.domain.servicoMedico.dto.CreateServicoMedicoDTO;
import com.clinica.domain.servicoMedico.dto.UpdateServicoMedicoDTO;
import com.clinica.service.ServicoMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/servicos-medicos")
public class ServicoMedicoController {

    @Autowired
    private ServicoMedicoService servicoMedicoService;

    @GetMapping
    public ResponseEntity<List<ServicoMedico>> list() {
        List<ServicoMedico> services = servicoMedicoService.list();
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }

    @PostMapping
    public ResponseEntity<ServicoMedico> create(@RequestBody CreateServicoMedicoDTO data) {
        ServicoMedico serviceCreated = servicoMedicoService.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoMedico> update(@PathVariable UUID id, @RequestBody UpdateServicoMedicoDTO data) {
        ServicoMedico servicesUpdated = servicoMedicoService.update(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(servicesUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServicoMedico> delete(@PathVariable UUID id) {
        ServicoMedico serviceDeleted = servicoMedicoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(serviceDeleted);
    }

}
