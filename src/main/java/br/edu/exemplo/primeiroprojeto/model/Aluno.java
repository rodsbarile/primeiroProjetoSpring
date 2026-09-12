package br.edu.exemplo.primeiroprojeto.model;

public class Aluno {
    private final Long id;
    private final String nome;
    private final String curso;

    public Aluno(Long id, String nome, String curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }
}