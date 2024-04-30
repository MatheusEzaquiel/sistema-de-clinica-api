package com.clinica.controller;

import com.clinica.domain.dentista.dto.CreateDentistaDTO;
import com.clinica.domain.dentista.dto.DetailDentistaDTO;
import com.clinica.domain.dentista.dto.ListDentistaDTO;
import com.clinica.domain.dentista.dto.UpdateDentistaDTO;
import com.clinica.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    DentistaService dentistaService;

    @GetMapping
    public ResponseEntity<List<ListDentistaDTO>> index() {
        List<ListDentistaDTO> dentistsDTO = dentistaService.list();
        return ResponseEntity.status(HttpStatus.OK).body(dentistsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailDentistaDTO> get(@PathVariable UUID id) {
        DetailDentistaDTO dentistDTO = dentistaService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dentistDTO);
    }

    @PostMapping
    public ResponseEntity<DetailDentistaDTO> save(@RequestBody CreateDentistaDTO data) {
        DetailDentistaDTO dentistDTO = dentistaService.save(data);
        return ResponseEntity.status(HttpStatus.OK).body(dentistDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailDentistaDTO> update(@PathVariable UUID id, @RequestBody UpdateDentistaDTO data) {
        DetailDentistaDTO dentistDTO = dentistaService.update(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(dentistDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetailDentistaDTO> delete(@PathVariable UUID id) {
        DetailDentistaDTO dentistDTO = dentistaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(dentistDTO);
    }

}
