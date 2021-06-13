package com.testeescola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.testeescola.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	List<Turma> findByAtivoTrue();
	@Query("SELECT t FROM Turma t INNER JOIN t.alunos a WHERE a.id = :id")
	List<Turma> findByAluno(Long id);
}
