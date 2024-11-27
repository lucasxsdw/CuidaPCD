package com.poo.cuidapcd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poo.cuidapcd.entity.Profissional;
import com.poo.cuidapcd.service.ProfissionalService;

@Controller
public class PerfilController {

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping("/perfil/{id}")
    public String exibirPerfil(@PathVariable int id, Model model) {
        Profissional profissional = profissionalService.buscarUsuarioPorId(id);
        if (profissional == null) {
            throw new RuntimeException("Profissional não achado para o id: " + id);
        }
        model.addAttribute("profissional", profissional);
        return "perfilProfissional";
    }
}
