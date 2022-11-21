package com.nttdata.myclass.service.impl;

import com.nttdata.myclass.model.Professor;
import com.nttdata.myclass.repository.IProfessorRepository;
import com.nttdata.myclass.service.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements IProfessorService {

    @Autowired
    private IProfessorRepository professorRepository;

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Optional<Professor> findById(String cpf) {
        return professorRepository.findById(cpf);
    }

    @Override
    public Professor create(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor update(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void delete(Professor professor) {
        professorRepository.delete(professor);
    }

    @Override
    public void delete(String cpf) {
        Optional<Professor> professor = professorRepository.findById(cpf);
        if(professor.isPresent()) {this.delete(professor.get());}
    }
}
