package com.testeescola.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@Column(columnDefinition = "tinyint default true")
	private boolean ativo;

	@ManyToMany(targetEntity = Aluno.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "turma_aluno", joinColumns = { @JoinColumn(name = "turma_id") }, inverseJoinColumns = {
			@JoinColumn(name = "aluno_id") })
	private Set<Aluno> alunos;

	public Turma() {
		// Construtor Padrão.
	}

	public Turma(Long id, String descricao, Set<Aluno> alunos, boolean ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.alunos = alunos;
		this.ativo = ativo;
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

	public void adicionaAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public void removeAluno(Aluno aluno) {
		this.alunos.remove(aluno);
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
