package br.edu.exemplo.primeiroprojeto.controller;

import br.edu.exemplo.primeiroprojeto.model.Aluno;
import br.edu.exemplo.primeiroprojeto.repository.AlunoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }

    @GetMapping
    public List<Aluno> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public List<Aluno> buscarPorCurso(@RequestParam("curso") String curso) {
        return repository.findByCursoIgnoreCase(curso);
    }
}