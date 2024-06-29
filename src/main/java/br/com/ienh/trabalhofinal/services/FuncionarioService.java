package br.com.ienh.trabalhofinal.services;

import br.com.ienh.trabalhofinal.dto.FuncionarioDTO;
import br.com.ienh.trabalhofinal.entities.Funcionario;
import br.com.ienh.trabalhofinal.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> listar(){
        List<FuncionarioDTO> funcionarios = new ArrayList<>();
        funcionarioRepository.findAll().forEach(funcionario -> {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getIdentificador());
            funcionarios.add(funcionarioDTO);
        });
        return funcionarios;
    }

    public void salvar(FuncionarioDTO funcionario){
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setNome(funcionario.nome());
        novoFuncionario.setCpf(funcionario.cpf());
        novoFuncionario.setIdentificador(funcionario.identificador());
        funcionarioRepository.save(novoFuncionario);
    }

    public void atualizarFuncionario(FuncionarioDTO funcionario){
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setId(funcionario.id());
        novoFuncionario.setNome(funcionario.nome());
        novoFuncionario.setCpf(funcionario.cpf());
        novoFuncionario.setIdentificador(funcionario.identificador());
        funcionarioRepository.save(novoFuncionario);
    }

    public FuncionarioDTO obterFuncionarioPorId(int id){
        FuncionarioDTO funcionarioDTO = null;
        Funcionario funcionario = funcionarioRepository.findById(id).get();
        funcionarioDTO = new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getIdentificador());
        return funcionarioDTO;
    }

    public FuncionarioDTO obterFuncionarioPorNome(String nome){
        FuncionarioDTO funcionarioDTO = null;
        Funcionario funcionario = funcionarioRepository.findByNome(nome);
        funcionarioDTO = new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getIdentificador());
        return funcionarioDTO;
    }

    public void excluirFuncionario(int id){
        funcionarioRepository.deleteById(id);
    }
}
