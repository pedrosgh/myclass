package com.nttdata.myclass.controller;

import com.nttdata.myclass.model.Disciplina;
import com.nttdata.myclass.service.IDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private IDisciplinaService disciplinaService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Disciplina> listDisciplinas = disciplinaService.findAll();
        model.addAttribute("listDisciplinas", listDisciplinas);

        return "index";
    }

}
