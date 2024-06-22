package br.com.ienh.trabalhofinal.controllers;


import br.com.ienh.trabalhofinal.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping("/teste")
    public String teste(){
//        Iterable<Aluno> alunos = alunoRepository.findAll();
//        for(Aluno aluno : alunos){
//            System.out.println(aluno);
//        }

        System.out.println(alunoRepository.findByCpf("00216772"));

        return "teste";
    }

}
