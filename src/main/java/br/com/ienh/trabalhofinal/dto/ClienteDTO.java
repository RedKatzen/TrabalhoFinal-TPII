package br.com.ienh.trabalhofinal.dto;

import jakarta.validation.constraints.NotNull;

public record ClienteDTO (

        Integer id,

        @NotNull(message = "Informação obrigatória.")
        String nome,

        @NotNull(message = "Informação obrigatória.")
        String cpf,

        String descricaoContato
){}
