package com.clinica.repository;

import com.clinica.domain.servicoMedico.ServicoMedico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IServicoMedicoRepository extends JpaRepository<ServicoMedico, UUID> {
    Optional<ServicoMedico> findByNome(String name);
}