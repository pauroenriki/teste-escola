package com.testeescola.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeescola.model.Aluno;
import com.testeescola.model.Turma;
import com.testeescola.model.dto.TurmaDTO;
import com.testeescola.repository.AlunoRepository;
import com.testeescola.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository rep;
	
	@Autowired
	private AlunoRepository alunoRep;

	public List<TurmaDTO> buscarTodos() {
		return rep.findAll().stream().map(TurmaDTO::create).collect(Collectors.toList());
	}
	
	public List<TurmaDTO> buscarAtivos() {
		return rep.findByAtivoTrue().stream().map(TurmaDTO::create).collect(Collectors.toList());
	}
	
	public List<TurmaDTO> buscarTurmasPorAluno(Long id){
		return rep.findByAluno(id).stream().map(TurmaDTO::create).collect(Collectors.toList());
	}

	public Optional<TurmaDTO> buscarPorId(Long id) {
		return rep.findById(id).map(TurmaDTO::create);
	}

	public TurmaDTO insere(Turma turma) {
		return TurmaDTO.create(rep.save(turma));
	}

	public TurmaDTO altera(Turma turma) {
		rep.save(turma);
		return buscarPorId(turma.getId()).get();
	}
	
	public TurmaDTO incluirAluno(Aluno aluno, Long idTurma) {
		Optional<Turma> turmaOpt = rep.findById(idTurma);
		if(turmaOpt.isPresent()) {
			Turma turma =  turmaOpt.get();
			turma.adicionaAluno(aluno);
			return altera(turma);
		}
		return null;
	}
	
	public TurmaDTO removerAluno(Aluno aluno, Long idTurma) {
		Optional<Turma> turmaOpt = rep.findById(idTurma);
		if(turmaOpt.isPresent()) {
			Turma turma =  turmaOpt.get();
			turma.removeAluno(aluno);
			return altera(turma);
		}
		return null;
	}

	
	public void delete(Long id) {
		Turma bd = TurmaDTO.decode(buscarPorId(id).get());
		bd.setAtivo(false);
		altera(bd);
	}
}
