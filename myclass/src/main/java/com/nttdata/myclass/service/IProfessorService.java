package com.nttdata.myclass.service;

import com.nttdata.myclass.model.Professor;

import java.util.List;
import java.util.Optional;

public interface IProfessorService {
    List<Professor> findAll();

    Optional<Professor> findById(String cpf);

    Professor create(Professor professor);

    Professor update(Professor professor);

    void delete(Professor professor);

    void delete(String cpf);
}
