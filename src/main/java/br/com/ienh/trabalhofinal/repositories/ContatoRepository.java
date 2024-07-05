package br.com.ienh.trabalhofinal.repositories;

import br.com.ienh.trabalhofinal.entities.Contato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Integer> {

    public Contato findByTipo(String tipo);

    public List<Contato> findByCliente_Id(int idCliente);

}
