package br.edu.exemplo.primeiroprojeto.repository;

import br.edu.exemplo.primeiroprojeto.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository
        extends JpaRepository<Livro, Long> {
}