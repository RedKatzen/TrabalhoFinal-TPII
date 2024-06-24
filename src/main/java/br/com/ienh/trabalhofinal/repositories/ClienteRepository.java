package br.com.ienh.trabalhofinal.repositories;

import br.com.ienh.trabalhofinal.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository  extends CrudRepository<Cliente, Integer> {

    public Cliente findByCpf(String cpf);

    public Cliente findByNome(String nome);

}
