package br.com.ienh.trabalhofinal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Start {

    @GetMapping("/start")
    public String start() {
        return "start";
    }
}
