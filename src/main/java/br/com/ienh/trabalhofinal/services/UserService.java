package br.com.ienh.trabalhofinal.services;

import br.com.ienh.trabalhofinal.dto.UsuarioDTO;
import br.com.ienh.trabalhofinal.entities.User;
import br.com.ienh.trabalhofinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UsuarioDTO> listar(){
        List<UsuarioDTO> usuarios = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            UsuarioDTO usuarioDTO = new UsuarioDTO(user.getId(), user.getUsername(), user.getPassword());
            usuarios.add(usuarioDTO);
        });
        return usuarios;
    }

    public void salvar(UsuarioDTO usuario){
        User novoUser = new User();
        novoUser.setUsername(usuario.username());
        novoUser.setPassword(usuario.password());
        userRepository.save(novoUser);
    }

    public void atualizarUsuario(UsuarioDTO usuario){
        User novoUser = new User();
        novoUser.setId(usuario.id());
        novoUser.setUsername(usuario.username());
        novoUser.setPassword(usuario.password());
        userRepository.save(novoUser);
    }

    public void excluirUsuario(int id){
        userRepository.deleteById(id);
    }

    public UsuarioDTO obterUsuarioPorId(int id){
        UsuarioDTO usuarioDTO = null;
        User user = userRepository.findById(id).get();
        usuarioDTO = new UsuarioDTO(user.getId(), user.getUsername(), user.getPassword());
        return usuarioDTO;
    }

}
