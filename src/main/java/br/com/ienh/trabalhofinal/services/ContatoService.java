package br.com.ienh.trabalhofinal.services;

import br.com.ienh.trabalhofinal.dto.ContatoDTO;
import br.com.ienh.trabalhofinal.entities.Contato;
import br.com.ienh.trabalhofinal.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    public List<ContatoDTO> listar(){
        List<ContatoDTO> contatos = new ArrayList<>();
        contatoRepository.findAll().forEach(contato -> {
            ContatoDTO contatoDTO = new ContatoDTO(contato.getId(), contato.getDescricao(), contato.getTipo(), contato.getCliente());
            contatos.add(contatoDTO);
        });
        return contatos;
    }

    public void salvar(ContatoDTO contato){
        Contato novoContato = new Contato();
        novoContato.setDescricao(contato.descricao());
        novoContato.setTipo(contato.tipo());
        novoContato.setCliente(contato.cliente());
        contatoRepository.save(novoContato);
    }

    public void atualizarContato(ContatoDTO contato){
        Contato novoContato = new Contato();
        novoContato.setId(contato.id());
        novoContato.setDescricao(contato.descricao());
        novoContato.setTipo(contato.tipo());
        novoContato.setCliente(contato.cliente());
        contatoRepository.save(novoContato);
    }

    public void excluirContato(int id){
        contatoRepository.deleteById(id);
    }

    public ContatoDTO obterContatoPorId(int id){
        ContatoDTO contatoDTO = null;
        Contato contato = contatoRepository.findById(id).get();
        contatoDTO = new ContatoDTO(contato.getId(), contato.getDescricao(), contato.getTipo(), contato.getCliente());
        return contatoDTO;
    }

    public ContatoDTO obterContatoPorTipo(String tipo){
        ContatoDTO contatoDTO = null;
        Contato contato = contatoRepository.findByTipo(tipo);
        contatoDTO = new ContatoDTO(contato.getId(), contato.getDescricao(), contato.getTipo(), contato.getCliente());
        return contatoDTO;
    }
}
