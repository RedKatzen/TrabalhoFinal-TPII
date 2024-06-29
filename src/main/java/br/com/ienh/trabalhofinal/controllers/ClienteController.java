package br.com.ienh.trabalhofinal.controllers;

import br.com.ienh.trabalhofinal.dto.ClienteDTO;
import br.com.ienh.trabalhofinal.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("clientes", clienteService.listar());
        return "/cliente/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("cliente") ClienteDTO cliente){
        return "/cliente/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("cliente") ClienteDTO cliente, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/cliente/novoForm";
        clienteService.salvar(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("cliente", clienteService.obterClientePorId(id));
        return "/cliente/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("cliente") ClienteDTO cliente, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/cliente/editarForm";
        clienteService.atualizarCliente(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        clienteService.excluirCliente(id);
        return "redirect:/cliente/listar";
    }

}
