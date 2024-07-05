package br.com.ienh.trabalhofinal.repositories;

import br.com.ienh.trabalhofinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
