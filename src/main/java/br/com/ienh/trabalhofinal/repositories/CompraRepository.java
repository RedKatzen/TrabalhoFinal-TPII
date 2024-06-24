package br.com.ienh.trabalhofinal.repositories;

import br.com.ienh.trabalhofinal.entities.Compra;
import org.springframework.data.repository.CrudRepository;

public interface CompraRepository extends CrudRepository<Compra, Integer>{

    public Compra findByClienteId(int id);

}
