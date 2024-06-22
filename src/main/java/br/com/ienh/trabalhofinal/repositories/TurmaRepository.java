package br.com.ienh.trabalhofinal.repositories;

import br.com.ienh.trabalhofinal.entities.Turma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Integer>{

}
