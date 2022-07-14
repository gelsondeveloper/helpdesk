package com.gelson.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gelson.helpdesk.domain.enums.Prioridade;
import com.gelson.helpdesk.domain.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Chamado {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Chamado() {
        super();
    }

    public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chamado)) return false;

        Chamado chamado = (Chamado) o;

        if (getId() != null ? !getId().equals(chamado.getId()) : chamado.getId() != null) return false;
        if (getDataAbertura() != null ? !getDataAbertura().equals(chamado.getDataAbertura()) : chamado.getDataAbertura() != null)
            return false;
        if (getDataFechamento() != null ? !getDataFechamento().equals(chamado.getDataFechamento()) : chamado.getDataFechamento() != null)
            return false;
        if (getPrioridade() != chamado.getPrioridade()) return false;
        if (getStatus() != chamado.getStatus()) return false;
        if (getTitulo() != null ? !getTitulo().equals(chamado.getTitulo()) : chamado.getTitulo() != null) return false;
        if (getObservacoes() != null ? !getObservacoes().equals(chamado.getObservacoes()) : chamado.getObservacoes() != null)
            return false;
        if (getTecnico() != null ? !getTecnico().equals(chamado.getTecnico()) : chamado.getTecnico() != null)
            return false;
        return getCliente() != null ? getCliente().equals(chamado.getCliente()) : chamado.getCliente() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDataAbertura() != null ? getDataAbertura().hashCode() : 0);
        result = 31 * result + (getDataFechamento() != null ? getDataFechamento().hashCode() : 0);
        result = 31 * result + (getPrioridade() != null ? getPrioridade().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getTitulo() != null ? getTitulo().hashCode() : 0);
        result = 31 * result + (getObservacoes() != null ? getObservacoes().hashCode() : 0);
        result = 31 * result + (getTecnico() != null ? getTecnico().hashCode() : 0);
        result = 31 * result + (getCliente() != null ? getCliente().hashCode() : 0);
        return result;
    }
}
