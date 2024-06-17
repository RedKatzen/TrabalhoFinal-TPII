package br.com.ienh.aulaspringjava.dto;

import br.com.ienh.aulaspringjava.entities.Aluno;

public record ContatoDTO(String descricao, String tipo, Aluno aluno) { }
