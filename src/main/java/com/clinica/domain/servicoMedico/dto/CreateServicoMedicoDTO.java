package com.clinica.domain.servicoMedico.dto;

import java.util.UUID;

public record CreateServicoMedicoDTO(String nome, String descricao, Float preco, UUID dentistaId) {
}
