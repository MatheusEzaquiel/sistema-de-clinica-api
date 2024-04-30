package com.clinica.repository;

import com.clinica.domain.dentista.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDentistaRepository extends JpaRepository<Dentista, UUID> {}
