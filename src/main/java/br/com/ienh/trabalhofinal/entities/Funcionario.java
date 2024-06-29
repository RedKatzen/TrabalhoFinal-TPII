package br.com.ienh.trabalhofinal.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nome")
    private String nome;

    @Column(name="cpf")
    private String cpf;

    @Column(name="identificador")
    private String identificador;

    public Funcionario(String nome, String identificador, String cpf) {
        this.nome = nome;
        this.identificador = identificador;
        this.cpf = cpf;
    }

    public Funcionario() {}


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "Funcionario{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", identificador='" + identificador + '\'' +
            ", cpf='" + cpf + '\'' +
            '}';
    }

}
