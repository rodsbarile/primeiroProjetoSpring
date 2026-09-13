package br.edu.exemplo.primeiroprojeto.controller;

import br.edu.exemplo.primeiroprojeto.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final List<Livro> livros = new ArrayList<>();
    private Long proximoId = 1L;

    public LivroController() {
        livros.add(new Livro(proximoId++, "Dom Casmurro", "Machado de Assis"));
        livros.add(new Livro(proximoId++, "O Pequeno Principe", "Antoine de Saint-Exupery"));
    }

    @GetMapping
    public List<Livro> listar() {
        return livros;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                return ResponseEntity.ok(livro);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        livro.setId(proximoId++);
        livros.add(livro);
        return ResponseEntity.status(201).body(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id,
                                           @RequestBody Livro dadosAtualizados) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                livro.setTitulo(dadosAtualizados.getTitulo());
                livro.setAutor(dadosAtualizados.getAutor());
                return ResponseEntity.ok(livro);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                livros.remove(livro);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}