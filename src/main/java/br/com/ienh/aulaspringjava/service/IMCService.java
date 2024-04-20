package br.com.ienh.aulaspringjava.service;

import org.springframework.stereotype.Service;

@Service
public class IMCService {

    public double calcular(double peso, double altura) {
        return peso / (altura * altura);
    }

    public String classificacao(double imc) {
        return imc > 25 ? "Acima do peso" : "Abaixo do peso";
    }

}
