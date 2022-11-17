package com.nttdata.myclass.service.impl;

import com.nttdata.myclass.repository.IAulaRepository;
import com.nttdata.myclass.service.IAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaServiceImpl implements IAulaService {

    @Autowired
    private IAulaRepository aulaRepository;

}
