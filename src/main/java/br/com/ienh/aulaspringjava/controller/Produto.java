package br.com.ienh.aulaspringjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class Produto {

    @GetMapping("/visualizar")
    public String produto(int id, String tipo, Model model) {
        System.out.println("ID: " + id);
        System.out.println("Tipo: " + tipo);
        model.addAttribute("id", id);
        model.addAttribute("tipo", tipo);
        return "produto";
    }



}
