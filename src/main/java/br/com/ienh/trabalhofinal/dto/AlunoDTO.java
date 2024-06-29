
package br.com.ienh.trabalhofinal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoDTO(
        Integer id,

        @Size(max= 40, min=4, message="O nome deve ter entre 5 e 40 caracteres.")
        String nome,

        @NotNull
        //@Size(max=11, min=11, message="O CPF deve cumprir o critério.")
        String cpf,

        @NotNull
        //@Size(max= 10, min=10, message="O número de matrícula deve ter 10 caracteres.")
        String numeroMatricula,

        @Size(max= 45, min=5, message="O endereço deve ter entre 5 e 45 caracteres.")
        String endereco,

        @NotNull(message = "Informação obrigatória.")
        @Past(message = "A data de nascimento deve ser no passado.")
        LocalDate nascimento
) {}