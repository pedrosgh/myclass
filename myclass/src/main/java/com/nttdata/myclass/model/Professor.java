package com.nttdata.myclass.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PROFESSOR")
public class Professor {

    @Id
    @Column(name = "cpf", nullable = false, unique = true, columnDefinition = "CHAR")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "sexo")
    private char sexo;

    @Column(name = "tempo_ensino")
    private int tempoEnsino;

    @Column(name = "salario")
    private BigDecimal salario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getTempoEnsino() {
        return tempoEnsino;
    }

    public void setTempoEnsino(int tempoEnsino) {
        this.tempoEnsino = tempoEnsino;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
