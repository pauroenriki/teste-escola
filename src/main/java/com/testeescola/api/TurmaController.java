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
import com.testeescola.model.Turma;
import com.testeescola.model.dto.TurmaDTO;
import com.testeescola.service.TurmaService;

@RestController
@RequestMapping("/teste-escola/api/v1/turma")
public class TurmaController {
	@Autowired
	private TurmaService service;

	/**
	 * Método que retorna todas as turmas cadastradas.
	 * 
	 * @return lista de turmas.
	 */
	@GetMapping
	public ResponseEntity<List<TurmaDTO>> buscarTodos() {
		return ResponseEntity.ok(service.buscarTodos());
	}

	/**
	 * Método que retorna turmas ativas.
	 * 
	 * @return lista de turmas ativas.
	 */
	@GetMapping("/ativos")
	public ResponseEntity<List<TurmaDTO>> buscarAtivos() {
		return ResponseEntity.ok(service.buscarAtivos());
	}

	@GetMapping("/aluno/{id}")
	public ResponseEntity<List<TurmaDTO>> buscarPorAluno(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.buscarTurmasPorAluno(id));
	}
	
	/**
	 * Método que busca Turma por id.
	 * 
	 * @param id identificador da turma.
	 * @return turma.
	 */
	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
		return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	/**
	 * Método que insere nova Turma no banco de dados.
	 * 
	 * @param turma nova turma a ser inserida no banco de dados.
	 * @return caso sucesso, retorna a turma que foi gravada no bd.
	 */
	@PostMapping
	public ResponseEntity insereTurma(@RequestBody Turma turma) {
		try {
			return ResponseEntity.ok(service.insere(turma));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	/**
	 * Método que inclui aluno na turma.
	 * @param aluno aluno a ser incluído.
	 * @param idTurma identificador da turma a ser alterada.
	 * @return turma contendo os alunos atuais.
	 */
	@PutMapping("/incluir-aluno/{idTurma}")
	public ResponseEntity incluiAluno(@RequestBody Aluno aluno, @PathVariable("idTurma") Long idTurma) {
		try {
			return ResponseEntity.ok(service.incluirAluno(aluno, idTurma));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}
	
	/**
	 * Método que remove aluno da turma.
	 * @param aluno aluno a ser removido.
	 * @param idTurma identificador da turma a ser alterada.
	 * @return turma contendo os alunos atuais.
	 */
	@PutMapping("/remover-aluno/{idTurma}")
	public ResponseEntity remopveAluno(@RequestBody Aluno aluno, @PathVariable("idTurma") Long idTurma) {
		try {
			return ResponseEntity.ok(service.removerAluno(aluno, idTurma));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

	/**
	 * Método que altera uma turma.
	 * 
	 * @param turma dados da turma para alteração.
	 * @return turma alterada.
	 */
	@PutMapping
	public ResponseEntity alteraTurma(@RequestBody Turma turma) {
		try {
			return ResponseEntity.ok(service.altera(turma));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	/**
	 * Método que faz a deleção lógica da turma.
	 * 
	 * @param id identificador da turma que deve ser deletada.
	 * @return retorna status http.
	 */
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
