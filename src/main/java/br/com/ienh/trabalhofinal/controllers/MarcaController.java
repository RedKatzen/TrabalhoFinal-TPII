package br.com.ienh.trabalhofinal.controllers;

import br.com.ienh.trabalhofinal.dto.ClienteDTO;
import br.com.ienh.trabalhofinal.dto.MarcaDTO;
import br.com.ienh.trabalhofinal.services.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("marcas", marcaService.listar());
        return "/marca/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("marca") MarcaDTO marca){
        return "/marca/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("marca") MarcaDTO marca, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/cliente/novoForm";
        marcaService.salvar(marca);
        return "redirect:/marca/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("marca", marcaService.obterMarcaPorId(id));
        return "/marca/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("marca") MarcaDTO marca, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/marca/editarForm";
        marcaService.atualizarMarca(marca);
        return "redirect:/marca/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        marcaService.excluirMarca(id);
        return "redirect:/marca/listar";
    }
}
