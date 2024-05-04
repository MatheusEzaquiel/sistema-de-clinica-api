package com.clinica.controller;

import com.clinica.domain.atendimento.dto.CreateAtendimentoDTO;
import com.clinica.domain.atendimento.dto.DetailAtendimentoDTO;
import com.clinica.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    AtendimentoService appointmentService;

    @GetMapping
    public ResponseEntity<List<DetailAtendimentoDTO>> index() {
        System.out.println("ok");
        List<DetailAtendimentoDTO> appointmentDTO = appointmentService.list();
        return ResponseEntity.status(HttpStatus.OK).body(appointmentDTO);
    }

    @PostMapping
    public ResponseEntity<DetailAtendimentoDTO> save(@RequestBody CreateAtendimentoDTO data) {

        System.out.println("data:" + data);

        DetailAtendimentoDTO appointmentDTO = appointmentService.save(data);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentDTO);
    }

}
