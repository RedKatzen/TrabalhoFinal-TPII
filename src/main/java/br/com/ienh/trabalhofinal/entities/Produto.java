package br.com.ienh.trabalhofinal.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="descricao")
    private String descricao;

    @Column(name="preco")
    private double preco;

    @Column(name="quantidade")
    private int quantidade;

    @Column(name="cod_barras")
    private int codBarras;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="produto_has_compra",
                joinColumns = @JoinColumn(name = "produto_id"),
                inverseJoinColumns = @JoinColumn(name = "compra_id"))
    private List<Compra> compras;

    public Produto(String descricao, double preco, int quantidade, int codBarras) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.codBarras = codBarras;
    }

    public Produto() {}

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(int codBarras) {
        this.codBarras = codBarras;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
      this.grupo = grupo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
      this.marca = marca;
    }

    public List<Compra> getCompras(){
        return compras;
    }

    public void setCompra(Compra compra) {
        this.compras.add(compra);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", preco='" + preco + '\'' +
                ", quantidade='" + quantidade + '\'' +
                ", codBarras='" + codBarras + '\'' +
                '}';
    }
}
