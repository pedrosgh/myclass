package com.nttdata.myclass.service.impl;

import com.nttdata.myclass.repository.IProfessorRepository;
import com.nttdata.myclass.service.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements IProfessorService {

    @Autowired
    private IProfessorRepository professorRepository;

}
