package br.com.ienh.trabalhofinal.repositories;

import br.com.ienh.trabalhofinal.entities.Grupo;
import org.springframework.data.repository.CrudRepository;

public interface GrupoRepository extends CrudRepository<Grupo, Integer>{
    public Grupo findByNome(String nome);
}
