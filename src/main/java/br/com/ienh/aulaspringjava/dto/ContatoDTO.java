package br.com.ienh.aulaspringjava.dto;

import jakarta.validation.constraints.NotNull;

public record ContatoDTO(
        @NotNull
        String descricao,

        @NotNull
        String tipo,

        @NotNull
        Integer idAluno) {}
