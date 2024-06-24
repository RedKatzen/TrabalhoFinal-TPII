package br.com.ienh.trabalhofinal.dto;

import jakarta.validation.constraints.NotNull;

public record CompraDTO(

        Integer id,

        String codNota

) {
}
