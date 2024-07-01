package br.com.ienh.trabalhofinal.controllers;

import br.com.ienh.trabalhofinal.dto.ClienteDTO;
import br.com.ienh.trabalhofinal.dto.ContatoDTO;
import br.com.ienh.trabalhofinal.entities.Cliente;
import br.com.ienh.trabalhofinal.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import br.com.ienh.trabalhofinal.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("contatos", contatoService.listar());
        return "/contato/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("contato") ContatoDTO contato, Model model){
        Iterable<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        clientes.forEach(cliente ->
                clientesDTO.add(new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf())));
        model.addAttribute("clientes", clientesDTO);
        return "/contato/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@ModelAttribute("contato") ContatoDTO contato, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/contato/novoForm";
        contatoService.salvar(contato);
        return "redirect:/contato/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") int id, Model model) {
        // Buscar o contato existente pelo ID
        ContatoDTO contato = contatoService.obterContatoPorId(id);
        // Carregar a lista de clientes
        Iterable<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        clientes.forEach(cliente ->
                clientesDTO.add(new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf())));
        // Adicionar os dados do contato e a lista de clientes ao modelo
        model.addAttribute("contato", contato);
        model.addAttribute("clientes", clientesDTO);

        return "/contato/editarForm";
    }
//    @GetMapping("/editar/{id}")
//    public String editarForm(@PathVariable int id, Model model){
//        ContatoDTO contatoDTO = contatoService.obterContatoPorId(id);
//        model.addAttribute("contato", contatoDTO);
//        return "/contato/editarForm";
//    }
@PostMapping("/editar")
public String editarSalvar(@Valid @ModelAttribute("contato") ContatoDTO contato, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
        // Carregar a lista de clientes para o modelo em caso de erro de validação
        Iterable<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        clientes.forEach(cliente ->
                clientesDTO.add(new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf())));
        model.addAttribute("clientes", clientesDTO);

        return "/contato/editarForm"; // Retorna ao formulário de edição se houver erros
    }
    contatoService.atualizarContato(contato);
    return "redirect:/contato/listar"; // Redireciona para a lista de contatos após a atualização
}
//    @PostMapping("/editar")
//    public String editarSalvar(@Valid @ModelAttribute("contato") ContatoDTO contatoDTO, BindingResult bindingResult, Model model){
//        if(bindingResult.hasErrors()){
//            return "/contato/editarForm";
//        }
//        contatoService.atualizarContato(contatoDTO);
//        return "redirect:/contato/listar";
//    }

    @GetMapping("/excluir/{id}")
    public String excluir(@ModelAttribute("contato") ContatoDTO contato){
        contatoService.excluirContato(contato.id());
        return "redirect:/contato/listar";
    }

}
