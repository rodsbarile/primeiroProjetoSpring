package br.edu.exemplo.primeiroprojeto.repository;

import br.edu.exemplo.primeiroprojeto.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository
        extends JpaRepository<Aluno, Long> {
    List<Aluno> findByCursoIgnoreCase(String curso);
}