package com.clinica.domain.dentista.dto;

import com.clinica.domain.dentista.Dentista;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record DetailDentistaDTO(
        UUID id,
        String cpf,
        String cro,
        String nome,
        LocalDate dataNascimento,
        String area,
        Boolean ativo,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) {

    public DetailDentistaDTO(Dentista dentista) {
        this(
                dentista.getId(),
                dentista.getCpf(),
                dentista.getCro(),
                dentista.getNome(),
                dentista.getDataNascimento(),
                dentista.getArea(),
                dentista.getAtivo(),
                dentista.getCriadoEm(),
                dentista.getAtualizadoEm()
        );
    }

}
