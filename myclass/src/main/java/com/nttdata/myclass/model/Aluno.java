package com.nttdata.myclass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ALUNO")
@Entity
public class Aluno {

    @Id
    @Column(name = "matricula", nullable=false, length = 8, columnDefinition = "CHAR")
    private String matricula;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true, columnDefinition = "CHAR")
    private String cpf;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "sexo", columnDefinition = "CHAR")
    private String sexo;

    @Column(name= "pne", columnDefinition = "CHAR")
    private char pne;

    @Column(name = "escolaridade")
    private Integer escolaridade;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public char getPne() {
        return pne;
    }

    public void setPne(char pne) {
        this.pne = pne;
    }

    public Integer getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Integer escolaridade) {
        this.escolaridade = escolaridade;
    }
}