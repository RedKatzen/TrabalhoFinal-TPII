package br.com.ienh.aulaspringjava.repositories;

import br.com.ienh.aulaspringjava.entities.Turma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Integer>{

}
