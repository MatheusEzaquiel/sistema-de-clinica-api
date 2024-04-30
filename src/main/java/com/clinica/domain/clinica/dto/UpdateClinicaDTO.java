package com.clinica.domain.clinica.dto;

public record UpdateClinicaDTO(String nome, String cnpj, String endereco, String telefone, Integer anoFundacao, Boolean ativo) {
}
