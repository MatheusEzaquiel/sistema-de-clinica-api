package com.clinica.domain.admin.dto;

import com.clinica.domain.admin.Admin;

import java.util.UUID;

public record BasicAdminDTO(UUID id, String nome, String cpf) {

    public BasicAdminDTO(Admin admin) {
        this(admin.getId(), admin.getNome(), admin.getCpf());
    }

}
