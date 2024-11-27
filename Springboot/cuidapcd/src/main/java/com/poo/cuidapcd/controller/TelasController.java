package com.poo.cuidapcd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TelasController {

    @GetMapping("/SobreNos")
    public String SobreNos() {
        return "sobrenos";
    }

    @GetMapping("/Politica")
    public String telaPolitica() {
        return "politicadeprivacidade";
    }

    @GetMapping("/BuscarProfissional")
    public String telaBuscar() {
        return "buscarProfissional";
    }
}
