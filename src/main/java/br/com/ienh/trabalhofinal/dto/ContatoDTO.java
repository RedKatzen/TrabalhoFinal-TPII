package br.com.ienh.trabalhofinal.dto;

import br.com.ienh.trabalhofinal.entities.Cliente;
import jakarta.validation.constraints.NotNull;

public record ContatoDTO(

        Integer id,

        @NotNull
        String descricao,

        @NotNull
        String tipo,

        @NotNull
        Integer idCliente
) {}
