package br.com.ienh.trabalhofinal.dto;

import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(
        Integer id,

        @NotNull(message = "Informação obrigatória.")
        String nome,

        @NotNull(message = "Informação obrigatória.")
        String senha,

        @NotNull(message = "Informação obrigatória.")
        String tipo
) {
}
