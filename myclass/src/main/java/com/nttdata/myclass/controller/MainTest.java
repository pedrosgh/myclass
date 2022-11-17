package com.nttdata.myclass.controller;

import com.nttdata.myclass.model.Disciplina;
import com.nttdata.myclass.service.IDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class MainTest {
    @Autowired
    IDisciplinaService disciplinaService;

    @PostConstruct
    public void run() {
        //Tests
        List<Disciplina> disciplinas = disciplinaService.findAll();

        for (Disciplina d: disciplinas
        ) {
            System.out.println(d.getTitulo());
        }
    }
}
