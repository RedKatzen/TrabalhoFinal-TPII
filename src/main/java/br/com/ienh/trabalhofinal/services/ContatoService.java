package br.com.ienh.trabalhofinal.services;

import br.com.ienh.trabalhofinal.dto.ContatoDTO;
import br.com.ienh.trabalhofinal.entities.Contato;
import br.com.ienh.trabalhofinal.repositories.ClienteRepository;
import br.com.ienh.trabalhofinal.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public List<ContatoDTO> listar(){
        List<ContatoDTO> contatos = new ArrayList<>();
        contatoRepository.findAll().forEach(contato -> {
            ContatoDTO contatoDTO = new ContatoDTO(contato.getId(), contato.getDescricao(), contato.getTipo(), contato.getCliente().getId());
            contatos.add(contatoDTO);
        });
        return contatos;
    }

    public void salvar(ContatoDTO contato){
        Contato novoContato = new Contato();
        novoContato.setDescricao(contato.descricao());
        novoContato.setTipo(contato.tipo());
        clienteRepository.findById(contato.idCliente()).ifPresent(novoContato::setCliente);
        contatoRepository.save(novoContato);
    }

    public void atualizarContato(ContatoDTO contato) {
        if (contato.id() == null) {
            throw new IllegalArgumentException("ID do contato não pode ser nulo ao atualizar contato");
        }
        // Buscar o contato existente no banco de dados
        Contato contatoExistente = contatoRepository.findById(contato.id())
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado"));
        // Atualizar os campos necessários
        contatoExistente.setDescricao(contato.descricao());
        contatoExistente.setTipo(contato.tipo());
        clienteRepository.findById(contato.idCliente()).ifPresent(contatoExistente::setCliente);
        // Salvar o contato atualizado
        contatoRepository.save(contatoExistente);
    }
//    public void atualizarContato(ContatoDTO contato){
//        if(contato.id() == null){
//            throw new IllegalArgumentException("Contato não encontrado");
//        }
//        Contato novoContato = new Contato();
//        novoContato.setId(contato.id());
//        novoContato.setDescricao(contato.descricao());
//        novoContato.setTipo(contato.tipo());
//        clienteRepository.findById(contato.idCliente()).ifPresent(novoContato::setCliente);
//        contatoRepository.save(novoContato);
//    }

    public void excluirContato(int id){
        contatoRepository.deleteById(id);
    }

    public ContatoDTO obterContatoPorId(int id){
        ContatoDTO contatoDTO = null;
        Contato contato = contatoRepository.findById(id).get();
        contatoDTO = new ContatoDTO(contato.getId(), contato.getDescricao(), contato.getTipo(), contato.getCliente().getId());
        return contatoDTO;
    }

    public ContatoDTO obterContatoPorTipo(String tipo){
        ContatoDTO contatoDTO = null;
        Contato contato = contatoRepository.findByTipo(tipo);
        contatoDTO = new ContatoDTO(contato.getId(), contato.getDescricao(), contato.getTipo(), contato.getCliente().getId());
        return contatoDTO;
    }
}
