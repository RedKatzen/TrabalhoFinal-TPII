package br.com.ienh.aulaspringjava.controller;

import br.com.ienh.aulaspringjava.service.IMCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/imc")
@Controller
public class IMC {

    @Autowired
    private IMCService imcService;

    @GetMapping("/")
    public String imcForm(){
        return "imcForm";
    }

    @PostMapping("/calcular")
    public String calcular(double peso, double altura, Model model) {
        double imc = imcService.calcular(peso, altura);
        String resultado = imcService.classificacao(imc);
        model.addAttribute("imc", imc);
        model.addAttribute("resultado", resultado);
        return "resultado";
    }
}
