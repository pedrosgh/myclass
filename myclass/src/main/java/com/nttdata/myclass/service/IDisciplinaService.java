package com.nttdata.myclass.service;

import com.nttdata.myclass.model.Disciplina;
import java.util.List;
import java.util.Optional;

public interface IDisciplinaService {
    List<Disciplina> findAll();

    Optional<Disciplina> findById(int id);

    Disciplina create(Disciplina disciplina);

    Disciplina update(Disciplina disciplina);

    void delete(Disciplina disciplina);

    void delete(int id);
}
