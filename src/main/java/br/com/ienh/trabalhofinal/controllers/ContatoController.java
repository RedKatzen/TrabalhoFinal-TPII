package br.com.ienh.trabalhofinal.controllers;

import br.com.ienh.trabalhofinal.dto.ContatoDTO;
import org.springframework.validation.BindingResult;
import br.com.ienh.trabalhofinal.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("contatos", contatoService.listar());
        return "/contato/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("contato") ContatoDTO contato){
        return "/contato/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@ModelAttribute("contato") ContatoDTO contato, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/contato/novoForm";
        contatoService.salvar(contato);
        return "redirect:/contato/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@ModelAttribute("contato") ContatoDTO contato, Model model){
        model.addAttribute("contato", contatoService.obterContatoPorId(contato.id()));
        return "/contato/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@ModelAttribute("contato") ContatoDTO contato, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/contato/editarForm";
        contatoService.atualizarContato(contato);
        return "redirect:/contato/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@ModelAttribute("contato") ContatoDTO contato){
        contatoService.excluirContato(contato.id());
        return "redirect:/contato/listar";
    }

}
