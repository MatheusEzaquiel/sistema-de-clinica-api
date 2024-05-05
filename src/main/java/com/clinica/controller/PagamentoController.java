package com.clinica.controller;

import com.clinica.domain.pagamento.dto.CreatePagamentoDTO;
import com.clinica.domain.pagamento.dto.DetailPagamentoDTO;
import com.clinica.domain.pagamento.dto.ListPagamentoDTO;
import com.clinica.domain.pagamento.dto.UpdatePagamentoDTO;
import com.clinica.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<ListPagamentoDTO>> index() {
        List<ListPagamentoDTO> paymentsDTO = pagamentoService.list();
        return ResponseEntity.status(HttpStatus.OK).body(paymentsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailPagamentoDTO> get(@PathVariable UUID id) {
        DetailPagamentoDTO paymentDTO = pagamentoService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(paymentDTO);
    }

    @PostMapping
    public ResponseEntity<DetailPagamentoDTO> save(@RequestBody CreatePagamentoDTO data) {
        DetailPagamentoDTO paymentDTO = pagamentoService.save(data);
        return ResponseEntity.status(HttpStatus.OK).body(paymentDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailPagamentoDTO> update(@PathVariable UUID id, @RequestBody UpdatePagamentoDTO data) {
        DetailPagamentoDTO paymentDTO = pagamentoService.update(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(paymentDTO);
    }

}
