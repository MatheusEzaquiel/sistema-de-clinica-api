package com.clinica.domain.pagamento.dto;

import com.clinica.domain.paciente.Paciente;
import com.clinica.domain.paciente.dto.IdNomeCpfPacienteDTO;
import com.clinica.domain.pagamento.Pagamento;
import com.clinica.domain.servicoMedico.ServicoMedico;
import com.clinica.domain.servicoMedico.dto.IdNomePrecoServicoMedicoDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record ListPagamentoDTO(
        UUID id,
        Float valorTotal,
        String formaDePagamento,
        Boolean situacao,
        IdNomePrecoServicoMedicoDTO servicoMedico,
        IdNomeCpfPacienteDTO paciente
) {

    public ListPagamentoDTO(Pagamento payment) {
        this(
                payment.getId(),
                payment.getValorTotal(),
                payment.getFormaDePagamento(),
                payment.getSituacao(),
                new IdNomePrecoServicoMedicoDTO(payment.getHealthService()),
                new IdNomeCpfPacienteDTO(payment.getPatient()));
    }


}
