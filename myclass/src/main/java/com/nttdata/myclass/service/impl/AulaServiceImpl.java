package com.nttdata.myclass.service.impl;

import com.nttdata.myclass.model.Aula;
import com.nttdata.myclass.repository.IAulaRepository;
import com.nttdata.myclass.service.IAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaServiceImpl implements IAulaService {

    @Autowired
    private IAulaRepository aulaRepository;

    @Override
    public List<Aula> findAll() {
        return aulaRepository.findAll();
    }

    @Override
    public Optional<Aula> findById(int id) {
        return aulaRepository.findById(id);
    }

    @Override
    public Aula create(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public Aula update(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public void delete(Aula aula) {
        aulaRepository.delete(aula);
    }

    @Override
    public void delete(int id) {
        Optional<Aula> aula = aulaRepository.findById(id);
        if(aula.isPresent()) {this.delete(aula.get());}
    }
}
