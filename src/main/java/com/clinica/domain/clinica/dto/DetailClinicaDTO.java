package com.clinica.domain.clinica.dto;

import com.clinica.domain.clinica.Clinica;

import java.time.LocalDateTime;
import java.util.UUID;

public record DetailClinicaDTO(
        UUID id,
        String nome,
         String cnpj,
         String endereco,
         String telefone,
         Integer anoFundacao,
         Boolean ativo,
         LocalDateTime criadoEm,
         LocalDateTime atualizadoEm) {

    public DetailClinicaDTO(Clinica clinica) {
        this(
                clinica.getId(),
                clinica.getNome(),
                clinica.getCnpj(),
                clinica.getEndereco(),
                clinica.getTelefone(),
                clinica.getAnoFundacao(),
                clinica.getAtivo(),
                clinica.getCriadoEm(),
                clinica.getAtualizadoEm()
        );
    }

}
