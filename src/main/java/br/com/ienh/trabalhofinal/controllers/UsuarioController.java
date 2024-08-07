package br.com.ienh.trabalhofinal.controllers;

import br.com.ienh.trabalhofinal.dto.UsuarioDTO;
import br.com.ienh.trabalhofinal.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UserService userService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("usuarios", userService.listar());
        return "/usuario/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("usuario") UsuarioDTO usuario){
        return "/usuario/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("usuario") UsuarioDTO usuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/usuario/novoForm";
        userService.salvar(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("usuario", userService.obterUsuarioPorId(id));
        return "/usuario/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("usuario") UsuarioDTO usuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/usuario/editarForm";
        userService.atualizarUsuario(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        userService.excluirUsuario(id);
        return "redirect:/usuario/listar";
    }

}
