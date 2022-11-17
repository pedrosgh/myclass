package com.nttdata.myclass.repository;

import com.nttdata.myclass.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDisciplinaRepository extends JpaRepository<Disciplina, Long> {

}
