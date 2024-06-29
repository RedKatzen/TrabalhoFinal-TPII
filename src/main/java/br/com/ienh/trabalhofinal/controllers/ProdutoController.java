package br.com.ienh.trabalhofinal.controllers;


import br.com.ienh.trabalhofinal.dto.ProdutoDTO;
import br.com.ienh.trabalhofinal.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("produtos", produtoService.listar());
        return "/produto/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("produto") ProdutoDTO produto){
        return "/produto/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("produto") ProdutoDTO produto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/produto/novoForm";
        produtoService.salvar(produto);
        return "redirect:/produto/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("produto", produtoService.obterProdutoPorId(id));
        return "/produto/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("produto") ProdutoDTO produto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/produto/editarForm";
        produtoService.atualizarProduto(produto);
        return "redirect:/produto/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        produtoService.excluirProduto(id);
        return "redirect:/produto/listar";
    }

}
