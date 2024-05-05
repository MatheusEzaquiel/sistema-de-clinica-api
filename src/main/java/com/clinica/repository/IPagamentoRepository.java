package com.clinica.repository;

import com.clinica.domain.pagamento.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPagamentoRepository extends JpaRepository<Pagamento, UUID> {
}
