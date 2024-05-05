package com.clinica.domain.clinica;

import com.clinica.domain.admin.Admin;
import com.clinica.domain.atendimento.Atendimento;
import com.clinica.domain.paciente.Paciente;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "Clinica")
@Table(name = "clinicas")
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cnpj;
    private String nome;
    private String endereco;
    private String telefone;
    private Integer anoFundacao;
    private Boolean ativo;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    @OneToMany(mappedBy = "clinica")
    private List<Admin> admins;

    @OneToMany(mappedBy = "clinica")
    private List<Paciente> patients;

    @OneToMany(mappedBy = "clinic")
    private List<Atendimento> appointments;

    public Clinica() {}

    public Clinica(UUID id, String cnpj, String nome, String endereco, String telefone, Integer anoFundacao, Boolean ativo, LocalDateTime criadoEm, LocalDateTime atualizadoEm, List<Admin> admins, List<Paciente> patients) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.anoFundacao = anoFundacao;
        this.ativo = ativo;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.admins = admins;
        this.patients = patients;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(Integer anoFundacao) {
        this.anoFundacao = anoFundacao;
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

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Paciente> getPatients() {
        return patients;
    }

    public void setPatients(List<Paciente> patients) {
        this.patients = patients;
    }

}