package com.testeescola.model.dto;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.testeescola.model.Aluno;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private boolean ativo;

	public static AlunoDTO create(Aluno aluno) {
		ModelMapper mm = new ModelMapper();
		return mm.map(aluno, AlunoDTO.class);
	}
	
	public static Aluno decode(AlunoDTO alunoDTO) {
		ModelMapper mm = new ModelMapper();
		return mm.map(alunoDTO, Aluno.class);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
