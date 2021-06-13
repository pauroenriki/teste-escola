package com.testeescola.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeescola.model.Aluno;
import com.testeescola.model.dto.AlunoDTO;
import com.testeescola.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository rep;
	
	public List<AlunoDTO> buscarTodos(){
		return rep.findAll().stream().map(AlunoDTO::create).collect(Collectors.toList());
	}
	
	public List<AlunoDTO> buscarAtivos(){
		return rep.findByAtivoTrue().stream().map(AlunoDTO::create).collect(Collectors.toList());
	}
	
	public Optional<AlunoDTO> buscarPorId(Long id) {
		return rep.findById(id).map(AlunoDTO::create);
	}
	
	public AlunoDTO insert(Aluno aluno) {
		return AlunoDTO.create(rep.save(aluno));
	}
	
	public AlunoDTO altera(Aluno aluno) {
		rep.save(aluno);
		return buscarPorId(aluno.getId()).get();
	}
	
	public void delete(Long id) {
		Aluno bd = AlunoDTO.decode(buscarPorId(id).get());
		bd.setAtivo(false);
		altera(bd);
	}
}
