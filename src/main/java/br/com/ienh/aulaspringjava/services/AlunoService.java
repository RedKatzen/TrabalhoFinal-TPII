package br.com.ienh.aulaspringjava.services;

import br.com.ienh.aulaspringjava.dto.AlunoDTO;
import br.com.ienh.aulaspringjava.entities.Aluno;
import br.com.ienh.aulaspringjava.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public List<AlunoDTO> listar(){
        List<AlunoDTO> alunos = new ArrayList<>();
        alunoRepository.findAll().forEach(aluno -> {
            AlunoDTO alunoDTO = new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getNumeroMatricula(), aluno.getEndereco(),  aluno.getNascimento());
            alunos.add(alunoDTO);
        });
        return alunos;
    }

    public void salvar(AlunoDTO aluno){
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(aluno.nome());
        novoAluno.setCpf(aluno.cpf());
        novoAluno.setNumeroMatricula(aluno.numeroMatricula());
        novoAluno.setEndereco(aluno.endereco());
        novoAluno.setNascimento(aluno.nascimento());
        alunoRepository.save(novoAluno);
    }

    public void atualizarAluno(AlunoDTO aluno){
        Aluno novoAluno = new Aluno();
        novoAluno.setId(aluno.id());
        novoAluno.setNome(aluno.nome());
        novoAluno.setCpf(aluno.cpf());
        novoAluno.setNumeroMatricula(aluno.numeroMatricula());
        novoAluno.setEndereco(aluno.endereco());
        novoAluno.setNascimento(aluno.nascimento());
        alunoRepository.save(novoAluno);
    }

    public AlunoDTO obterAlunoPorId(int id){
        AlunoDTO alunoDTO = null;
        Aluno aluno = alunoRepository.findById(id).get();
        alunoDTO = new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getNumeroMatricula(), aluno.getEndereco(),  aluno.getNascimento());
        return alunoDTO;
    }

    public void excluirAluno(int id){
        alunoRepository.deleteById(id);
    }


}
