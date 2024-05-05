package com.clinica.domain.paciente;

import com.clinica.domain.atendimento.Atendimento;
import com.clinica.domain.clinica.Clinica;
import com.clinica.domain.pagamento.Pagamento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Boolean planoDeSaude;
    private Boolean ativo;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    @ManyToOne
    @JoinColumn(name = "id_clinica")
    private Clinica clinica;

    @OneToMany(mappedBy = "patient")
    private List<Pagamento> payments;

    @OneToMany(mappedBy = "patient")
    private List<Atendimento> appointments;


    public Paciente() {}

    public Paciente(UUID id, String cpf, String nome, LocalDate dataNascimento, Boolean planoDeSaude, Boolean ativo, LocalDateTime criadoEm, LocalDateTime atualizadoEm, Clinica clinica) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.planoDeSaude = planoDeSaude;
        this.ativo = ativo;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.clinica = clinica;
    }

    public Paciente(UUID id, String cpf, String nome, LocalDate dataNascimento, Boolean planoDeSaude, Boolean ativo, LocalDateTime criadoEm, LocalDateTime atualizadoEm, Clinica clinica, List<Pagamento> payments) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.planoDeSaude = planoDeSaude;
        this.ativo = ativo;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.clinica = clinica;
        this.payments = payments;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(Boolean planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public List<Pagamento> getPayments() {
        return payments;
    }

    public void setPayments(List<Pagamento> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", planoDeSaude=" + planoDeSaude +
                ", ativo=" + ativo +
                ", criadoEm=" + criadoEm +
                ", atualizadoEm=" + atualizadoEm +
                ", clinica=" + clinica +
                '}';
    }

}