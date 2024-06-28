package br.com.ienh.trabalhofinal.repositories;

import br.com.ienh.trabalhofinal.entities.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{

    public Funcionario findByNome(String nome);

}
