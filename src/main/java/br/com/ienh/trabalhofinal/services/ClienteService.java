package br.com.ienh.trabalhofinal.services;

import br.com.ienh.trabalhofinal.dto.ClienteDTO;
import br.com.ienh.trabalhofinal.entities.Cliente;
import br.com.ienh.trabalhofinal.entities.Contato;
import br.com.ienh.trabalhofinal.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteDTO> listar(){
        List<ClienteDTO> clientes = new ArrayList<>();
        clienteRepository.findAll().forEach(cliente -> {
            ClienteDTO clienteDTO = new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getContatos().get(0).getDescricao());
            clientes.add(clienteDTO);
        });
        return clientes;
    }

    public void salvar(ClienteDTO cliente){
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(cliente.nome());
        novoCliente.setCpf(cliente.cpf());
        clienteRepository.save(novoCliente);
    }

    public void atualizarCliente(ClienteDTO cliente){
        Cliente novoCliente = new Cliente();
        novoCliente.setId(cliente.id());
        novoCliente.setNome(cliente.nome());
        novoCliente.setCpf(cliente.cpf());
        clienteRepository.save(novoCliente);
    }

    public ClienteDTO obterClientePorId(int id){
        ClienteDTO clienteDTO = null;
        Cliente cliente = clienteRepository.findById(id).get();
        clienteDTO = new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getContatos().get(0).getDescricao());
        return clienteDTO;
    }

    public ClienteDTO obterClientePorCpf(String cpf){
        ClienteDTO clienteDTO = null;
        Cliente cliente = clienteRepository.findByCpf(cpf);
        clienteDTO = new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getContatos().get(0).getDescricao());
        return clienteDTO;
    }

    public ClienteDTO obterClientePorNome(String nome){
        ClienteDTO clienteDTO = null;
        Cliente cliente = clienteRepository.findByNome(nome);
        clienteDTO = new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getContatos().get(0).getDescricao());
        return clienteDTO;
    }

    public void excluirCliente(int id){
        clienteRepository.deleteById(id);
    }

}
