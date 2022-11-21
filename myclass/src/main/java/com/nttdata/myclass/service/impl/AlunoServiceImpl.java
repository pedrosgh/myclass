package com.nttdata.myclass.service.impl;

import com.nttdata.myclass.model.Aluno;
import com.nttdata.myclass.repository.IAlunoRepository;
import com.nttdata.myclass.service.IAlunoService;
import com.nttdata.myclass.service.ICallMineduAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private IAlunoRepository alunoRepository;

    @Autowired
    private ICallMineduAPI callMineduAPI;

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Optional<Aluno> findById(String matricula) {
        return alunoRepository.findById(matricula);
    }

    @Override
    public Aluno create(Aluno aluno) {
        if(aluno.getEscolaridade() == null && aluno.getIdade() != null) {
            aluno.setEscolaridade(callMineduAPI.getAlunoEscolaridade(aluno));
        }
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno update(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(Aluno aluno) {
        alunoRepository.delete(aluno);
    }

    @Override
    public void delete(String matricula) {
        Optional<Aluno> aluno = alunoRepository.findById(matricula);
        if(aluno.isPresent()) {this.delete(aluno.get());}
    }
}
