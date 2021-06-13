package com.testeescola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testeescola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	List<Aluno> findByAtivoTrue();
}
