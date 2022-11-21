package com.nttdata.myclass.repository;

import com.nttdata.myclass.model.Aula;
import com.nttdata.myclass.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAulaRepository extends JpaRepository<Aula, Integer> {

}
