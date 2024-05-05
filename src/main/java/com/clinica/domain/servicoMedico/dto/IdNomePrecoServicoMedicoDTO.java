package com.clinica.domain.servicoMedico.dto;

import com.clinica.domain.servicoMedico.ServicoMedico;

import java.util.UUID;

public record IdNomePrecoServicoMedicoDTO(UUID id, String nome, Float preco) {

    public IdNomePrecoServicoMedicoDTO(ServicoMedico sm) {
        this(sm.getId(), sm.getNome(), sm.getPreco());
    }

}
