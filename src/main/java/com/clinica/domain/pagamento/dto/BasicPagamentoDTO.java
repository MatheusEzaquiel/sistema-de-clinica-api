package com.clinica.domain.pagamento.dto;

import com.clinica.domain.pagamento.Pagamento;

import java.util.UUID;

public record BasicPagamentoDTO(UUID id, Float valorTotal, String formaDePagamento, Boolean situacao) {

    public BasicPagamentoDTO(Pagamento payment) {
        this(payment.getId(), payment.getValorTotal(), payment.getFormaDePagamento(), payment.getSituacao());
    }

}
