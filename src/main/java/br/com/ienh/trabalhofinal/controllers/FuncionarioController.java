package br.com.ienh.trabalhofinal.controllers;

import br.com.ienh.trabalhofinal.dto.FuncionarioDTO;
import br.com.ienh.trabalhofinal.services.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("funcionarios", funcionarioService.listar());
        return "/funcionario/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("funcionario") FuncionarioDTO funcionario){
        return "/funcionario/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("funcionario") FuncionarioDTO funcionario, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/funcionario/novoForm";
        funcionarioService.salvar(funcionario);
        return "redirect:/funcionario/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("funcionario", funcionarioService.obterFuncionarioPorId(id));
        return "/funcionario/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("funcionario") FuncionarioDTO funcionario, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/funcionario/editarForm";
        funcionarioService.atualizarFuncionario(funcionario);
        return "redirect:/funcionario/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        funcionarioService.excluirFuncionario(id);
        return "redirect:/funcionario/listar";
    }
}
