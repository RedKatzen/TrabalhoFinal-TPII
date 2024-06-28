package br.com.ienh.trabalhofinal.controllers;

import br.com.ienh.trabalhofinal.dto.GrupoDTO;
import br.com.ienh.trabalhofinal.services.GrupoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("grupos", grupoService.listar());
        return "/grupo/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("grupo") GrupoDTO grupo){
        return "/grupo/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("grupo") GrupoDTO grupo, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/grupo/novoForm";
        grupoService.salvar(grupo);
        return "redirect:/grupo/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("grupo", grupoService.obterGrupoPorId(id));
        return "/grupo/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("grupo") GrupoDTO grupo, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/grupo/editarForm";
        grupoService.atualizarGrupo(grupo);
        return "redirect:/grupo/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        grupoService.excluirGrupo(id);
        return "redirect:/grupo/listar";
    }

}
