package com.nttdata.myclass.service.impl;

import com.nttdata.myclass.repository.IAlunoRepository;
import com.nttdata.myclass.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private IAlunoRepository alunoRepository;

}
