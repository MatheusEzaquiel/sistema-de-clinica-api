package com.clinica.domain.servicoMedico.dto;

import com.clinica.domain.dentista.Dentista;
import com.clinica.domain.dentista.dto.ListDentistaDTO;
import com.clinica.domain.servicoMedico.ServicoMedico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record DetailServicoMedicoDTO(
        UUID id,
        String nome,
        String descricao,
        Float preco,
        Boolean ativo,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm,
        ListDentistaDTO dentistaDTO
) {


    public DetailServicoMedicoDTO(ServicoMedico sm) {
        this(
                sm.getId(),
                sm.getNome(),
                sm.getDescricao(),
                sm.getPreco(),
                sm.isAtivo(),
                sm.getCriadoEm(),
                sm.getAtualizadoEm(),
                new ListDentistaDTO(sm.getDentista())
        );
    }


}
