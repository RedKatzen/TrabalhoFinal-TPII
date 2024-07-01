package br.com.ienh.trabalhofinal.controllers;


import br.com.ienh.trabalhofinal.dto.GrupoDTO;
import br.com.ienh.trabalhofinal.dto.MarcaDTO;
import br.com.ienh.trabalhofinal.dto.ProdutoDTO;
import br.com.ienh.trabalhofinal.entities.Grupo;
import br.com.ienh.trabalhofinal.entities.Marca;
import br.com.ienh.trabalhofinal.repositories.GrupoRepository;
import br.com.ienh.trabalhofinal.repositories.MarcaRepository;
import br.com.ienh.trabalhofinal.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    GrupoRepository grupoRepository;

    @Autowired
    MarcaRepository marcaRepository;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("produtos", produtoService.listar());
        return "/produto/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("produto") ProdutoDTO produto, Model model){
        Iterable<Marca> marcas = marcaRepository.findAll();
        List<MarcaDTO>  marcasDTO = new ArrayList<>();

        Iterable<Grupo> grupos = grupoRepository.findAll();
        List<GrupoDTO>  gruposDTO = new ArrayList<>();

        marcas.forEach(marca ->
                marcasDTO.add(new MarcaDTO(marca.getId(), marca.getNome())));
        grupos.forEach(grupo ->
                gruposDTO.add(new GrupoDTO(grupo.getId(), grupo.getNome())));
        model.addAttribute("marcas", marcasDTO);
        model.addAttribute("grupos", gruposDTO);
        return "/produto/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("produto") ProdutoDTO produto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/produto/novoForm";
        produtoService.salvar(produto);
        return "redirect:/produto/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        ProdutoDTO produto = produtoService.obterProdutoPorId(id);

        Iterable<Marca> marcas = marcaRepository.findAll();
        List<MarcaDTO>  marcasDTO = new ArrayList<>();

        Iterable<Grupo> grupos = grupoRepository.findAll();
        List<GrupoDTO>  gruposDTO = new ArrayList<>();

        marcas.forEach(marca ->
                marcasDTO.add(new MarcaDTO(marca.getId(), marca.getNome())));
        grupos.forEach(grupo ->
                gruposDTO.add(new GrupoDTO(grupo.getId(), grupo.getNome())));
        model.addAttribute("produto", produto);
        model.addAttribute("marcas", marcasDTO);
        model.addAttribute("grupos", gruposDTO);
        return "/produto/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("produto") ProdutoDTO produto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            Iterable<Marca> marcas = marcaRepository.findAll();
            List<MarcaDTO>  marcasDTO = new ArrayList<>();

            Iterable<Grupo> grupos = grupoRepository.findAll();
            List<GrupoDTO>  gruposDTO = new ArrayList<>();

            marcas.forEach(marca ->
                    marcasDTO.add(new MarcaDTO(marca.getId(), marca.getNome())));
            grupos.forEach(grupo ->
                    gruposDTO.add(new GrupoDTO(grupo.getId(), grupo.getNome())));
            model.addAttribute("marcas", marcasDTO);
            model.addAttribute("grupos", gruposDTO);
            return "/produto/editarForm";
        }
        produtoService.atualizarProduto(produto);
        return "redirect:/produto/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        produtoService.excluirProduto(id);
        return "redirect:/produto/listar";
    }

}
