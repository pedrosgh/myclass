package com.nttdata.myclass.repository;

import com.nttdata.myclass.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor, Long> {

}
