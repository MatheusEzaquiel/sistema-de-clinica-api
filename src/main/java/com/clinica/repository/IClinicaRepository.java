package com.clinica.repository;

import com.clinica.domain.clinica.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IClinicaRepository extends JpaRepository<Clinica, UUID> {
    Optional<Clinica> findByNome(String nome);
}
