package br.com.ienh.trabalhofinal.dto;

import jakarta.validation.constraints.NotNull;

public record FuncionarioDTO(

        Integer id,

        @NotNull(message = "Informação obrigatória.")
        String nome,

        @NotNull(message = "Informação obrigatória.")
        String cpf,

        @NotNull(message = "Informação obrigatória.")
        String identificador

) {
}
