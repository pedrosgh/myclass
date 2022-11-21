package com.nttdata.myclass.service;

import com.nttdata.myclass.model.Aluno;

import java.util.List;
import java.util.Optional;

public interface IAlunoService {
    List<Aluno> findAll();

    Optional<Aluno> findById(String matricula);

    Aluno create(Aluno aluno);

    Aluno update(Aluno aluno);

    void delete(Aluno Aluno);

    void delete(String matricula);
}
