package br.com.ienh.aulaspringjava.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="descricao")
    private String descricao;

    @Column(name="tipo")
    private String tipo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Contato(String descricao, String tipo, Aluno aluno) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.aluno = aluno;
    }

    public Contato() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    //public void setAluno(Aluno aluno) {this.aluno = aluno;}

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}
