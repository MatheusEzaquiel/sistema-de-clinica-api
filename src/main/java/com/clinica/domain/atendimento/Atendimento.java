package com.clinica.domain.atendimento;

import com.clinica.domain.admin.Admin;
import com.clinica.domain.clinica.Clinica;
import com.clinica.domain.dentista.Dentista;
import com.clinica.domain.paciente.Paciente;
import com.clinica.domain.pagamento.Pagamento;
import com.clinica.domain.servicoMedico.ServicoMedico;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity(name = "Atendimento")
@Table(name = "atendimentos")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private java.util.UUID id;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    @Column(name = "data_atendimento")
    private LocalDate data;
    private Boolean ativo;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    @ManyToOne
    @JoinColumn(name = "id_dentista")
    private Dentista dentist;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente patient;

    @ManyToOne
    @JoinColumn(name = "id_servico_medico")
    private ServicoMedico healthService;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "id_clinica")
    private Clinica clinic;

    public Atendimento() {}

    public Atendimento(UUID id, LocalTime horarioInicio, LocalTime horarioFim, LocalDate data, Boolean ativo, LocalDateTime criadoEm, LocalDateTime atualizadoEm, Dentista dentist, Paciente patient, ServicoMedico healthService, Admin admin, Clinica clinica) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.data = data;
        this.ativo = ativo;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.dentist = dentist;
        this.patient = patient;
        this.healthService = healthService;
        this.admin = admin;
        this.clinic = clinica;
    }

    public Atendimento(LocalTime horarioInicio, LocalTime horarioFim, LocalDate data, Boolean ativo, LocalDateTime criadoEm, LocalDateTime atualizadoEm, Dentista dentist, Paciente patient, ServicoMedico healthService, Admin admin, Clinica clinica) {
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.data = data;
        this.ativo = ativo;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.dentist = dentist;
        this.patient = patient;
        this.healthService = healthService;
        this.admin = admin;
        this.clinic = clinica;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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

    public Dentista getDentist() {
        return dentist;
    }

    public void setDentist(Dentista dentist) {
        this.dentist = dentist;
    }

    public Paciente getPatient() {
        return patient;
    }

    public void setPatient(Paciente patient) {
        this.patient = patient;
    }

    public ServicoMedico getHealthService() {
        return healthService;
    }

    public void setHealthService(ServicoMedico healthService) {
        this.healthService = healthService;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Clinica getClinica() {
        return clinic;
    }

    public void setClinica(Clinica clinica) {
        this.clinic = clinica;
    }
}