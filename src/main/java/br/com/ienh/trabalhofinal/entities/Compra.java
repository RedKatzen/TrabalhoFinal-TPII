package br.com.ienh.trabalhofinal.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="cod_nota")
    private String codNota;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="produto_has_compra",
        joinColumns = @JoinColumn(name="compra_id"),
        inverseJoinColumns = @JoinColumn(name="produto_id"))
    private List<Produto> produtos;

    public Compra(String codNota) {
        this.codNota = codNota;
    }

    public Compra() {}

    public int getId() {
        return id;
    }

    public String getCodNota() {
        return codNota;
    }

    public void setCodNota(String codNota) {
        this.codNota = codNota;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    @Override
    public String toString() {
        return "Compra{" +
            "id=" + id +
            ", codNota='" + codNota + '\'' +
            '}';
    }
}
