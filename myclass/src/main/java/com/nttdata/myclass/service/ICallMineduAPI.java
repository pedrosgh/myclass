package com.nttdata.myclass.service;

import com.nttdata.myclass.model.Aluno;
import com.nttdata.myclass.model.Disciplina;

public interface ICallMineduAPI {
    boolean validateDisciplinaArea(Disciplina disciplina);

    Integer getAlunoEscolaridade(Aluno aluno);
}
