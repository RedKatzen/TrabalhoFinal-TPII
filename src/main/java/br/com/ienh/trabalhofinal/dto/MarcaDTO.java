package br.com.ienh.trabalhofinal.dto;

import jakarta.validation.constraints.NotNull;

public record MarcaDTO(

        Integer id,

        @NotNull(message = "O nome do grupo é obrigatório.")
        String nome

) {
}
