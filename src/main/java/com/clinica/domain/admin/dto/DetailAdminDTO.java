package com.clinica.domain.admin.dto;

import com.clinica.domain.admin.Admin;
import com.clinica.domain.clinica.dto.IdNomeClinicaDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record DetailAdminDTO(

        UUID id,
        String cpf,
        String role,
        String nome,
        LocalDate dataNascimento,
        Boolean ativo,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm,
        IdNomeClinicaDTO clinica

        ) {

    public DetailAdminDTO(Admin admin) {
        this(
                admin.getId(),
                admin.getCpf(),
                admin.getRole(),
                admin.getNome(),
                admin.getDataNascimento(),
                admin.getAtivo(),
                admin.getCriadoEm(),
                admin.getAtualizadoEm(),
                new IdNomeClinicaDTO(admin.getClinica().getId(), admin.getClinica().getNome())
        );
    }
    public DetailAdminDTO(Admin admin, IdNomeClinicaDTO clinica) {
        this(
                admin.getId(),
                admin.getCpf(),
                admin.getRole(),
                admin.getNome(),
                admin.getDataNascimento(),
                admin.getAtivo(),
                admin.getCriadoEm(),
                admin.getAtualizadoEm(),
                clinica
        );
    }
}
