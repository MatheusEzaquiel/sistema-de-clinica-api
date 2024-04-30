package com.clinica.repository;

import com.clinica.domain.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPacienteRepository extends JpaRepository<Paciente, UUID> {
}
