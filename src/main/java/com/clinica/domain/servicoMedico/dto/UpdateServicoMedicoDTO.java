package com.clinica.domain.servicoMedico.dto;

import java.time.LocalDateTime;

public record UpdateServicoMedicoDTO(
        String nome,
        String descricao,
        Float preco,
        Boolean ativo,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm) {
}
