package com.testeescola.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testeescola.model.Aluno;
import com.testeescola.model.dto.AlunoDTO;
import com.testeescola.service.AlunoService;

@RestController
@RequestMapping("/teste-escola/api/v1/aluno")
public class AlunoController {
	@Autowired
	private AlunoService service;

	/**
	 * Método que retorna todos os Alunos.
	 * @return lista de alunos.
	 */
	@GetMapping
	public ResponseEntity<List<AlunoDTO>> buscarTodos() {
		return ResponseEntity.ok(service.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
		return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/ativos")
	public ResponseEntity<List<AlunoDTO>> buscarAtivos() {
		return ResponseEntity.ok(service.buscarAtivos());
	}

	@PostMapping
	public ResponseEntity insereAluno(@RequestBody Aluno aluno) {
		try {
			return ResponseEntity.ok(service.insert(aluno));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping
	public ResponseEntity alteraAluno(@RequestBody Aluno aluno) {
		try {
			return ResponseEntity.ok(service.altera(aluno));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
