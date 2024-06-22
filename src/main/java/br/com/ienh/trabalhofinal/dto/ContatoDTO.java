package br.com.ienh.trabalhofinal.dto;

import jakarta.validation.constraints.NotNull;

public record ContatoDTO(
        @NotNull
        String descricao,

        @NotNull
        String tipo,

        @NotNull
        Integer idAluno) {}
