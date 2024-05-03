package br.com.ienh.aulaspringjava.repositories;

import br.com.ienh.aulaspringjava.entities.Contato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Integer> {

    public List<Contato> findByTipoOrderByDescricaoDesc(String tipo);

}
