package br.com.ienh.aulaspringjava.dto;

import java.time.LocalDate;

public record AlunoDTO(String nome, String endereco, String numeroMatricula, String cpf, LocalDate nascimento){ }
