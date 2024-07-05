package br.com.ienh.trabalhofinal.services;

import br.com.ienh.trabalhofinal.dto.ProdutoDTO;
import br.com.ienh.trabalhofinal.entities.Produto;
import br.com.ienh.trabalhofinal.repositories.GrupoRepository;
import br.com.ienh.trabalhofinal.repositories.MarcaRepository;
import br.com.ienh.trabalhofinal.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    GrupoRepository grupoRepository;

    @Autowired
    MarcaRepository marcaRepository;

    public List<ProdutoDTO> listar(){
        List<ProdutoDTO> produtos = new ArrayList<>();
        produtoRepository.findAll().forEach(produto -> {
            ProdutoDTO produtoDTO = new ProdutoDTO(produto.getId(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade(), produto.getCodBarras(), produto.getGrupo().getId(), produto.getGrupo().getNome(), produto.getMarca().getId(), produto.getMarca().getNome());
            produtos.add(produtoDTO);
        });
        return produtos;
    }

    public void salvar(ProdutoDTO produto){
        Produto novoProduto = new Produto();
        novoProduto.setDescricao(produto.descricao());
        novoProduto.setPreco(produto.preco());
        novoProduto.setQuantidade(produto.quantidade());
        novoProduto.setCodBarras(produto.codBarras());
        grupoRepository.findById(produto.idGrupo()).ifPresent(novoProduto::setGrupo);
        marcaRepository.findById(produto.idMarca()).ifPresent(novoProduto::setMarca);
        produtoRepository.save(novoProduto);
    }

    public void atualizarProduto(ProdutoDTO produto){
        Produto novoProduto = new Produto();
        novoProduto.setId(produto.id());
        novoProduto.setDescricao(produto.descricao());
        novoProduto.setPreco(produto.preco());
        novoProduto.setQuantidade(produto.quantidade());
        novoProduto.setCodBarras(produto.codBarras());
        grupoRepository.findById(produto.idGrupo()).ifPresent(novoProduto::setGrupo);
        marcaRepository.findById(produto.idMarca()).ifPresent(novoProduto::setMarca);
        produtoRepository.save(novoProduto);
    }

    public void excluirProduto(int id){
        produtoRepository.deleteById(id);
    }

    public ProdutoDTO obterProdutoPorId(int id){
        ProdutoDTO produtoDTO = null;
        Produto produto = produtoRepository.findById(id).get();
        produtoDTO = new ProdutoDTO(produto.getId(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade(), produto.getCodBarras(), produto.getGrupo().getId(), produto.getGrupo().getNome(), produto.getMarca().getId(), produto.getMarca().getNome());
        return produtoDTO;
    }

    public ProdutoDTO obterProdutoPorCodBarras(double preco){
        ProdutoDTO produtoDTO = null;
        Produto produto = produtoRepository.findByPreco(preco);
        produtoDTO = new ProdutoDTO(produto.getId(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade(), produto.getCodBarras(), produto.getGrupo().getId(), produto.getGrupo().getNome(), produto.getMarca().getId(), produto.getMarca().getNome());
        return produtoDTO;
    }

}
