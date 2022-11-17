package com.nttdata.myclass.service.impl;

import com.nttdata.myclass.model.Disciplina;
import com.nttdata.myclass.repository.IDisciplinaRepository;
import com.nttdata.myclass.service.IDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaServiceImpl implements IDisciplinaService {

    @Autowired
    private IDisciplinaRepository disciplinaRepository;

    @Override
    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }
}
