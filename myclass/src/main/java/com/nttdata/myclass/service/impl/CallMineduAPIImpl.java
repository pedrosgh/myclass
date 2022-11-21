package com.nttdata.myclass.service.impl;

import com.nttdata.myclass.model.Aluno;
import com.nttdata.myclass.model.Disciplina;
import com.nttdata.myclass.service.ICallMineduAPI;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.util.Collections;
import java.util.List;

@Service
public class CallMineduAPIImpl implements ICallMineduAPI {

    private String MINEDU_ENDPOINT = "http://localhost:8081";
    private String DISCIPLINA_AREA = "/disciplina/area/";
    private String ALUNO_ESCOLARIDADE = "/aluno/escolaridade/";

    @Override
    public boolean validateDisciplinaArea(Disciplina disciplina) {
        WebClient webClient = WebClient.builder()
                .baseUrl(MINEDU_ENDPOINT)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create(ConnectionProvider.newConnection())))
                .build();
        Mono<List<String>> response;
        List<String> areas;
        try {
            response = webClient.get().uri(DISCIPLINA_AREA).retrieve()
                    .onStatus(HttpStatus::is4xxClientError, error -> {
                        return Mono.empty();
                    })
                    .bodyToMono(new ParameterizedTypeReference<>() {
                    });
            areas = response.block();
        } catch (Exception e) {
            areas = Collections.emptyList();
        }

        if (areas != null && areas.contains(disciplina.getArea())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer getAlunoEscolaridade(Aluno aluno) {
        WebClient webClient = WebClient.builder()
                .baseUrl(MINEDU_ENDPOINT)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create(ConnectionProvider.newConnection())))
                .build();
        Mono<Integer> response;
        Integer escolaridade;
        try {
            response = webClient.get().uri(ALUNO_ESCOLARIDADE + aluno.getIdade()).retrieve()
                    .onStatus(HttpStatus::is4xxClientError, error -> {
                        return Mono.empty();
                    })
                    .bodyToMono(new ParameterizedTypeReference<>() {
                    });
            escolaridade = response.block();
        } catch (Exception e) {
            escolaridade = null;
        }

        return escolaridade;
    }
}
