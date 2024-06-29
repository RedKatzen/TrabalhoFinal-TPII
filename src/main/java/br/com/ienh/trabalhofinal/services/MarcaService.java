package br.com.ienh.trabalhofinal.services;

import br.com.ienh.trabalhofinal.dto.MarcaDTO;
import br.com.ienh.trabalhofinal.entities.Marca;
import br.com.ienh.trabalhofinal.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    public List<MarcaDTO> listar(){
        List<MarcaDTO> marcas = new ArrayList<>();
        marcaRepository.findAll().forEach(marca -> {
            MarcaDTO marcaDTO = new MarcaDTO(marca.getId(), marca.getNome());
            marcas.add(marcaDTO);
        });
        return marcas;
    }

    public void salvar(MarcaDTO marca){
        Marca novaMarca = new Marca();
        novaMarca.setNome(marca.nome());
        marcaRepository.save(novaMarca);
    }

    public void atualizarMarca(MarcaDTO marca){
        Marca novaMarca = new Marca();
        novaMarca.setId(marca.id());
        novaMarca.setNome(marca.nome());
        marcaRepository.save(novaMarca);
    }

    public void excluirMarca(int id){
        marcaRepository.deleteById(id);
    }

    public MarcaDTO obterMarcaPorId(int id){
        MarcaDTO marcaDTO = null;
        Marca marca = marcaRepository.findById(id).get();
        marcaDTO = new MarcaDTO(marca.getId(), marca.getNome());
        return marcaDTO;
    }

    public MarcaDTO obterMarcaPorNome(String nome){
        MarcaDTO marcaDTO = null;
        Marca marca = marcaRepository.findByNome(nome);
        marcaDTO = new MarcaDTO(marca.getId(), marca.getNome());
        return marcaDTO;
    }

}
