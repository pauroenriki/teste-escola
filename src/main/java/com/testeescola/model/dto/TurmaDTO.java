package com.testeescola.model.dto;

import java.io.Serializable;
import java.util.Set;

import org.modelmapper.ModelMapper;

import com.testeescola.model.Aluno;
import com.testeescola.model.Turma;

public class TurmaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descricao;
	private Set<Aluno> alunos;
	private boolean ativo;
	
	public static TurmaDTO create(Turma turma) {
		ModelMapper mm = new ModelMapper();
		return mm.map(turma, TurmaDTO.class);
	}
	
	public static Turma decode(TurmaDTO turmaDTO) {
		ModelMapper mm = new ModelMapper();
		return mm.map(turmaDTO, Turma.class);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Set<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	

}
