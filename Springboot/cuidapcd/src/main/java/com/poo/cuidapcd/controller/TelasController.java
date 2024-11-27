package com.poo.cuidapcd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TelasController {

    @GetMapping("/SobreNos")
    public String SobreNos() {
        return "sobrenos";  // Aqui você pode retornar o nome da sua página HTML de login
    }

    @GetMapping("/Politica")
    public String telaPolitica() {
        return "politicadeprivacidade";  // Aqui você pode retornar o nome da sua página HTML de login
    }

    @GetMapping("/BuscarProfissional")
    public String telaBuscar() {
        return "buscarProfissional";  // Aqui você pode retornar o nome da sua página HTML de login
    }
}
