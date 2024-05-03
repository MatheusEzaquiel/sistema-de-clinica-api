package com.clinica.domain.servicoMedico.dto;

import com.clinica.domain.servicoMedico.ServicoMedico;

import java.time.LocalDateTime;
import java.util.UUID;

public record ListServicoMedicoDTO(
        UUID id,
        String nome,
        String descricao,
        Float preco
) {

    public ListServicoMedicoDTO(ServicoMedico sm) {
        this(sm.getId(), sm.getNome(), sm.getDescricao(), sm.getPreco());
    }

}
