package com.clinica.domain.pagamento.dto;

import java.util.UUID;

public record UpdatePagamentoDTO(
        Float valorTotal,
        String formaDePagamento,
        Boolean situacao,
        UUID servicoMedicoId,
        UUID pacienteId
) {
}
