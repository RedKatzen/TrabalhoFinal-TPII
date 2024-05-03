package br.com.ienh.aulaspringjava.controller;

import br.com.ienh.aulaspringjava.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("alunos", alunoRepository.findAll());
        return "/aluno/listar";
    }

}
