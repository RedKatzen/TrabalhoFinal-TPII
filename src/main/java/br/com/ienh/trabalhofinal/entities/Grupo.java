package br.com.ienh.trabalhofinal.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "nome")
    private String nome;

    @OneToMany(cascade = CascadeType.ALL,
                mappedBy = "grupo")
    private List<Produto> produtos;

    public Grupo(String nome) {
        this.nome = nome;
    }

    public Grupo() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
