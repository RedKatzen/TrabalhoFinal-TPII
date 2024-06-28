package br.com.ienh.trabalhofinal.services;

import br.com.ienh.trabalhofinal.dto.GrupoDTO;
import br.com.ienh.trabalhofinal.entities.Grupo;
import br.com.ienh.trabalhofinal.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GrupoService {

    @Autowired
    GrupoRepository grupoRepository;

    public List<GrupoDTO> listar(){
        List<GrupoDTO> grupos = new ArrayList<>();
        grupoRepository.findAll().forEach(grupo -> {
            GrupoDTO grupoDTO = new GrupoDTO(grupo.getId(), grupo.getNome());
            grupos.add(grupoDTO);
        });
        return grupos;
    }

    public void salvar(GrupoDTO grupo){
        Grupo novoGrupo = new Grupo();
        novoGrupo.setNome(grupo.nome());
        grupoRepository.save(novoGrupo);
    }

    public void atualizarGrupo(GrupoDTO grupo){
        Grupo novoGrupo = new Grupo();
        novoGrupo.setId(grupo.id());
        novoGrupo.setNome(grupo.nome());
        grupoRepository.save(novoGrupo);
    }

    public void excluirGrupo(int id){
        grupoRepository.deleteById(id);
    }

    public GrupoDTO obterGrupoPorId(int id){
        GrupoDTO grupoDTO = null;
        Grupo grupo = grupoRepository.findById(id).get();
        grupoDTO = new GrupoDTO(grupo.getId(), grupo.getNome());
        return grupoDTO;
    }

    public GrupoDTO obterGrupoPorNome(String nome){
        GrupoDTO grupoDTO = null;
        Grupo grupo = grupoRepository.findByNome(nome);
        grupoDTO = new GrupoDTO(grupo.getId(), grupo.getNome());
        return grupoDTO;
    }

}
