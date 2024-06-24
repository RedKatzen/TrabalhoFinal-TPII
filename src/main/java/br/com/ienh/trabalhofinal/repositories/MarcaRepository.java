package br.com.ienh.trabalhofinal.repositories;

import br.com.ienh.trabalhofinal.entities.Marca;
import org.springframework.data.repository.CrudRepository;

public interface MarcaRepository extends CrudRepository<Marca, Integer>{
    public Marca findByNome(String nome);
}
