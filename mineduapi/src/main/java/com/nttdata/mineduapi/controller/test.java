package com.nttdata.mineduapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class test {

    @GetMapping(value = "/hello")
    public List<String> hello() {
        List<String> helloes = new ArrayList<>();
        helloes.add("Hello ");
        helloes.add("there!");
        return helloes;
    }
}
