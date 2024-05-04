package com.clinica.domain.pagamento.dto;

import java.util.UUID;

public record CreatePagamentoDTO(
        Float valorTotal,
        String formaDePagamento,
        Boolean situacao,
        UUID servicoMedicoId,
        UUID pacienteId
) {
}
