package com.clinica.domain.pagamento.dto;

import com.clinica.domain.paciente.Paciente;
import com.clinica.domain.paciente.dto.IdNomeCpfPacienteDTO;
import com.clinica.domain.pagamento.Pagamento;
import com.clinica.domain.servicoMedico.ServicoMedico;
import com.clinica.domain.servicoMedico.dto.IdNomePrecoServicoMedicoDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record DetailPagamentoDTO(
        UUID id,
        Float valorTotal,
        String formaDePagamento,
        Boolean situacao,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm,
        IdNomePrecoServicoMedicoDTO servicoMedico,
        IdNomeCpfPacienteDTO paciente
) {

    public DetailPagamentoDTO(Pagamento payment) {
        this(
                payment.getId(),
                payment.getValorTotal(),
                payment.getFormaDePagamento(),
                payment.getSituacao(),
                payment.getCriadoEm(),
                payment.getAtualizadoEm(),
                new IdNomePrecoServicoMedicoDTO(payment.getHealthService()),
                new IdNomeCpfPacienteDTO(payment.getPatient())
        );
    }

}
