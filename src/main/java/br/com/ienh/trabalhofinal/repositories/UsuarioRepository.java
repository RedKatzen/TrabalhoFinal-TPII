package br.com.ienh.trabalhofinal.repositories;

import br.com.ienh.trabalhofinal.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

    public Usuario findByUsername(String username);

    public Usuario findByRole(String role);

}
