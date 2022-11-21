package com.nttdata.myclass.service;

import com.nttdata.myclass.model.Aula;

import java.util.List;
import java.util.Optional;

public interface IAulaService {
    List<Aula> findAll();

    Optional<Aula> findById(int id);

    Aula create(Aula aula);

    Aula update(Aula aula);

    void delete(Aula aula);

    void delete(int id);
}
