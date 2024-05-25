package br.com.ienh.aulaspringjava.controller;

import br.com.ienh.aulaspringjava.dto.ContatoDTO;
import br.com.ienh.aulaspringjava.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("contato") ContatoDTO contato, Model model){
        model.addAttribute("alunos", alunoRepository.findAll());
        return "/contato/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(ContatoDTO contato){

        return "redirect:/aluno/listar";
    }

}
