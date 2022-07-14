package com.gelson.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gelson.helpdesk.domain.enums.Perfil;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public abstract class Pessoa implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Integer id;
  protected String nome;

  @Column(unique = true)
  protected String cpf;

  @Column(unique = true)
  protected String email;
  protected String senha;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "PERFIS")
  protected Set<Integer> perfis = new HashSet<>();

  @JsonFormat(pattern = "dd/MM/yyyy")
  protected LocalDate dataCriacao = LocalDate.now();

  public Pessoa() {
    super();
    addPerfis(Perfil.CLIENTE);
  }

  public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
    super();
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.senha = senha;
    addPerfis(Perfil.CLIENTE);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Set<Perfil> getPerfis() {
    return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
  }

  public void addPerfis(Perfil perfil) {
    this.perfis.add(perfil.getCodigo());
  }

  public LocalDate getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pessoa)) return false;

    Pessoa pessoa = (Pessoa) o;

    if (!getId().equals(pessoa.getId())) return false;
    if (getNome() != null ? !getNome().equals(pessoa.getNome()) : pessoa.getNome() != null) return false;
    if (!getCpf().equals(pessoa.getCpf())) return false;
    if (getEmail() != null ? !getEmail().equals(pessoa.getEmail()) : pessoa.getEmail() != null) return false;
    if (getSenha() != null ? !getSenha().equals(pessoa.getSenha()) : pessoa.getSenha() != null) return false;
    if (getPerfis() != null ? !getPerfis().equals(pessoa.getPerfis()) : pessoa.getPerfis() != null) return false;
    return getDataCriacao() != null ? getDataCriacao().equals(pessoa.getDataCriacao()) : pessoa.getDataCriacao() == null;
  }

  @Override
  public int hashCode() {
    int result = getId().hashCode();
    result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
    result = 31 * result + getCpf().hashCode();
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + (getSenha() != null ? getSenha().hashCode() : 0);
    result = 31 * result + (getPerfis() != null ? getPerfis().hashCode() : 0);
    result = 31 * result + (getDataCriacao() != null ? getDataCriacao().hashCode() : 0);
    return result;
  }
}
