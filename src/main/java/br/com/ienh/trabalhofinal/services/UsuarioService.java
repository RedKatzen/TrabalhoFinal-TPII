package br.com.ienh.trabalhofinal.services;

import br.com.ienh.trabalhofinal.dto.UsuarioDTO;
import br.com.ienh.trabalhofinal.entities.Usuario;
import br.com.ienh.trabalhofinal.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listar(){
        List<UsuarioDTO> usuarios = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuario -> {
            UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getRole());
            usuarios.add(usuarioDTO);
        });
        return usuarios;
    }

    public void salvar(UsuarioDTO usuario){
        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsername(usuario.nome());
        novoUsuario.setPassword(usuario.senha());
        novoUsuario.setRole(usuario.tipo());
        usuarioRepository.save(novoUsuario);
    }

    public void atualizarUsuario(UsuarioDTO usuario){
        Usuario novoUsuario = new Usuario();
        novoUsuario.setId(usuario.id());
        novoUsuario.setUsername(usuario.nome());
        novoUsuario.setPassword(usuario.senha());
        novoUsuario.setRole(usuario.tipo());
        usuarioRepository.save(novoUsuario);
    }

    public void excluirUsuario(int id){
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO obterUsuarioPorId(int id){
        UsuarioDTO usuarioDTO = null;
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getRole());
        return usuarioDTO;
    }

    public UsuarioDTO obterUsuarioPorNome(String nome){
        UsuarioDTO usuarioDTO = null;
        Usuario usuario = usuarioRepository.findByUsername(nome);
        usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getRole());
        return usuarioDTO;
    }

    public UsuarioDTO obterUsuarioPorTipo(String tipo){
        UsuarioDTO usuarioDTO = null;
        Usuario usuario = usuarioRepository.findByRole(tipo);
        usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getRole());
        return usuarioDTO;
    }
}
