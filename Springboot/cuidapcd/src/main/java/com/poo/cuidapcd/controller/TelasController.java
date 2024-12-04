package com.poo.cuidapcd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poo.cuidapcd.entity.Usuario;

import jakarta.servlet.http.HttpSession;


@Controller
public class TelasController {

    @GetMapping("/SobreNos")
    public String SobreNos(HttpSession session, Model model) {
    
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    
    if (usuario != null) {
        model.addAttribute("usuario", usuario);
    }
        return "sobrenos";
    }

    @GetMapping("/Politica")
    public String telaPolitica(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        }
        return "politicadeprivacidade";
    }

    @GetMapping("/BuscarProfissional")
    public String telaBuscar(HttpSession session, Model model) {
       
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        if (usuario != null) {
            
            model.addAttribute("usuario", usuario);
        }
        return "buscarProfissional";
    }

    @GetMapping("/")
    public String paginaInicial(){
        return "redirect:/index";
    }

    @GetMapping("/CadastrarCliente")
    public String cadastroCliente(){
        return "cadastroCliente";
    }

    @GetMapping("/Cadastro")
    public String cadastro(){
        return "escolhaDoUsuario";
    }
}
