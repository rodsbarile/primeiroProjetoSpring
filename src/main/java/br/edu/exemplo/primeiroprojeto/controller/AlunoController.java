package br.edu.exemplo.primeiroprojeto.controller;

import br.edu.exemplo.primeiroprojeto.model.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final List<Aluno> alunos = new ArrayList<>();

    public AlunoController() {
        alunos.add(new Aluno(1L, "Ana", "ADS"));
        alunos.add(new Aluno(2L, "Bruno", "Banco de Dados"));
        alunos.add(new Aluno(3L, "Carla", "ADS"));
    }

    @GetMapping
    public List<Aluno> listar() {
        return alunos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable("id") Long id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                return ResponseEntity.ok(aluno);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public List<Aluno> buscarPorCurso(@RequestParam("curso") String curso) {
        List<Aluno> encontrados = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.getCurso().equalsIgnoreCase(curso)) {
                encontrados.add(aluno);
            }
        }
        return encontrados;
    }
}