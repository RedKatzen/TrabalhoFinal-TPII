package br.com.ienh.trabalhofinal.dto;

import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(
        Integer id,

        @NotNull(message = "Informação obrigatória.")
        String username,

        @NotNull(message = "Informação obrigatória.")
        String password
) {
}
