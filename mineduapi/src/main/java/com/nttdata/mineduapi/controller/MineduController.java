package com.nttdata.mineduapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MineduController {

    @GetMapping(value = "/disciplina/area")
    public ResponseEntity<Object> getDisciplinaAreas() {
        List<String> areas = new ArrayList<>();
        areas.add("Humanas"); areas.add("Exatas"); areas.add("Tecnologia"); areas.add("Saúde");

        return new ResponseEntity<>(areas, HttpStatus.OK);
    }

    @GetMapping(value = "/aluno/escolaridade/{idade}")
    public ResponseEntity<Object> getAlunoEscolaridadeMinima(@PathVariable int idade) {
        int escolaridade = -1;
        switch (idade) {
            case 19:  escolaridade = 2; break;
            case 20: escolaridade = 3; break;
            case 21: escolaridade = 4; break;
            default: escolaridade = 1; break;
        }
        return new ResponseEntity<>(escolaridade, HttpStatus.OK);
    }
}
