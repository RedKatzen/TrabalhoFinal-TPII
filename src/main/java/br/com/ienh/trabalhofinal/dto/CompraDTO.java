package br.com.ienh.trabalhofinal.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CompraDTO(

        Integer id,

        @NotNull
        LocalDate realizada,

        @NotNull
        Double valor

        ) { }
