package com.clinica.domain.pagamento;

import com.clinica.domain.clinica.Clinica;
import com.clinica.domain.paciente.Paciente;
import com.clinica.domain.servicoMedico.ServicoMedico;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Pagamento")
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Float valorTotal;
    private String formaDePagamento;
    private Boolean situacao;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    @ManyToOne
    @JoinColumn(name = "id_servico_medico")
    private ServicoMedico healthService;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente patient;

    public Pagamento(){}
    public Pagamento(UUID id, Float valorTotal, String formaDePagamento, Boolean situacao, LocalDateTime criadoEm, LocalDateTime atualizadoEm, ServicoMedico healthService, Paciente patient) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.formaDePagamento = formaDePagamento;
        this.situacao = situacao;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.healthService = healthService;
        this.patient = patient;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public ServicoMedico getHealthService() {
        return healthService;
    }

    public void setHealthService(ServicoMedico healthService) {
        this.healthService = healthService;
    }

    public Paciente getPatient() {
        return patient;
    }

    public void setPatient(Paciente patient) {
        this.patient = patient;
    }
}

