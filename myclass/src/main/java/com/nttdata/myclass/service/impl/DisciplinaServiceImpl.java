package com.nttdata.myclass.service.impl;

import com.nttdata.myclass.model.Disciplina;
import com.nttdata.myclass.repository.IDisciplinaRepository;
import com.nttdata.myclass.service.ICallMineduAPI;
import com.nttdata.myclass.service.IDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaServiceImpl implements IDisciplinaService {

    @Autowired
    private IDisciplinaRepository disciplinaRepository;

    @Autowired
    private ICallMineduAPI callMineduAPI;

    @Override
    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    @Override
    public Optional<Disciplina> findById(int id) {
        return disciplinaRepository.findById(id);
    }

    @Override
    public Disciplina create(Disciplina disciplina) {
        if(callMineduAPI.validateDisciplinaArea(disciplina)) {
            return disciplinaRepository.save(disciplina);
        } else {
            return null;
        }
    }

    @Override
    public Disciplina update(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public void delete(Disciplina disciplina) {
        disciplinaRepository.delete(disciplina);
    }

    @Override
    public void delete(int id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if(disciplina.isPresent()) {this.delete(disciplina.get());}
    }
}
