package br.com.ienh.trabalhofinal.repositories;

import br.com.ienh.trabalhofinal.entities.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

    public Produto findByDescricao(String descricao);

    public Produto findByDescricaoOrderByPreco(String descricao);

}
