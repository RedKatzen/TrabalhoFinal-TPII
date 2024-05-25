package br.com.ienh.aulaspringjava.controller;

import br.com.ienh.aulaspringjava.dto.AlunoDTO;
import br.com.ienh.aulaspringjava.entities.Aluno;
import br.com.ienh.aulaspringjava.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("aluno") AlunoDTO aluno) {
        return "/aluno/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(AlunoDTO aluno) {
        alunoRepository.save(new Aluno(aluno.nome(), aluno.endereco(), aluno.numeroMatricula(), aluno.cpf(), aluno.nascimento()));
        return "redirect:/aluno/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model) {
        alunoRepository.findById(id).ifPresent(aluno -> model.addAttribute("aluno", aluno));
        return "/aluno/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(int id, String nome, String endereco, String matricula, String cpf, LocalDate nascimento) {
        alunoRepository.findById(id).ifPresent(aluno -> {
            aluno.setNome(nome);
            aluno.setEndereco(endereco);
            aluno.setNumeroMatricula(matricula);
            aluno.setCpf(cpf);
            aluno.setNascimento(nascimento);
            alunoRepository.save(aluno);
        });
        return "redirect:/aluno/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        alunoRepository.deleteById(id);
        return "redirect:/aluno/listar";
    }
}
