package br.com.ienh.trabalhofinal.dto;

import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
        Integer id,

        @NotNull(message = "Informação obrigatória.")
        String descricao,

        @NotNull(message = "Informação obrigatória.")
        Double preco,

        Integer quantidade,

        Integer codBarras,

        Integer idGrupo,

        Integer idMarca
) {
}
