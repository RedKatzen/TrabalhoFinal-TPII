package br.com.ienh.trabalhofinal.dto;

import br.com.ienh.trabalhofinal.entities.Grupo;
import br.com.ienh.trabalhofinal.entities.Marca;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
        Integer id,

        @NotNull(message = "Informação obrigatória.")
        String descricao,

        @NotNull(message = "Informação obrigatória.")
        Double preco,

        Integer quantidade,

        Integer codBarras,

        Grupo grupo,

        @NotNull(message = "Informação obrigatória.")
        Marca marca
) {
}
