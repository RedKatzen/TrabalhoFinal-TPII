package br.com.ienh.trabalhofinal.controllers;

import br.com.ienh.trabalhofinal.dto.ClienteDTO;
import br.com.ienh.trabalhofinal.dto.ContatoDTO;
import br.com.ienh.trabalhofinal.entities.Cliente;
import br.com.ienh.trabalhofinal.entities.Contato;
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

    Iterable<Cliente> clientes;

    List<ClienteDTO> clientesDTO;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("contatos", contatoService.listar());
        return "/contato/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("contato") ContatoDTO contato, Model model){
        clientes = clienteRepository.findAll();
        clientesDTO = new ArrayList<>();
        clientes.forEach(cliente ->
                clientesDTO.add(new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getContatos().get(0).getDescricao())));
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
        ContatoDTO contato = contatoService.obterContatoPorId(id);
        clientesDTO = new ArrayList<>();
        clientes = clienteRepository.findAll();
        clientes.forEach(cliente ->
                clientesDTO.add(new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getContatos().get(0).getDescricao())));

        model.addAttribute("contato", contato);
        model.addAttribute("clientes", clientesDTO);

        return "/contato/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("contato") ContatoDTO contato, BindingResult bindingResult, Model model) {
        clientesDTO = new ArrayList<>();
        clientes = clienteRepository.findAll();
        if (bindingResult.hasErrors()) {
            clientes.forEach(cliente ->
                    clientesDTO.add(new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getContatos().get(0).getDescricao())));
            model.addAttribute("clientes", clientesDTO);

            return "/contato/editarForm";
    }
        contatoService.atualizarContato(contato);
        return "redirect:/contato/listar";
}

    @GetMapping("/excluir/{id}")
    public String excluir(@ModelAttribute("contato") ContatoDTO contato){
        contatoService.excluirContato(contato.id());
        return "redirect:/contato/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarPorCliente(@PathVariable("id") int id, Model model){
        Cliente cliente = clienteRepository.findById(id).get();
        List<ContatoDTO> contatos = contatoService.obterContatosPorCliente(id);
        model.addAttribute("cliente", cliente);
        model.addAttribute("contatos", contatos);
        return "/contato/listarPorCliente";
    }
}
