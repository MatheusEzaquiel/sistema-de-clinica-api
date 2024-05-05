package com.clinica.repository;

import com.clinica.domain.atendimento.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAtendimentoRepository extends JpaRepository<Atendimento, UUID> {
}
