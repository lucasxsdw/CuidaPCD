package com.poo.cuidapcd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poo.cuidapcd.conexao.ProfissionalDAO;
import com.poo.cuidapcd.entity.Profissional;
import com.poo.cuidapcd.entity.Usuario;
import com.poo.cuidapcd.service.ProfissionalService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PerfilController {

    @Autowired
    private ProfissionalService profissionalService;
    
    @Autowired
    private ProfissionalDAO profDAO;

    @GetMapping("/perfil/{id}")
    public String exibirPerfil(@PathVariable Long id, Model model, HttpSession session) {
        Profissional profissional = profissionalService.buscarUsuarioPorId(id);
        if (profissional == null) {
            throw new RuntimeException("Profissional não achado para o id: " + id);
        }
        model.addAttribute("profissional", profissional);

        Usuario usuario = (Usuario) session.getAttribute("usuario");
    
        if (usuario != null) {
       
            model.addAttribute("usuario", usuario);
        }
        return "perfilProfissional";
    }

    @GetMapping("/Usuario/{id}")
    public String exibirPerfilUsuario(@PathVariable Long id, Model model, HttpSession session){
        Profissional profissional = profDAO.buscarProfissionalPorId(id);
        Object usuario = session.getAttribute("usuario");
        model.addAttribute("usuario", usuario);
            if(profissional != null){
                return "dadosPerfilProfissional";
            } else {
                return "perfilCliente";
            }
    }

    @GetMapping("/Usuario/Editar/{id}")
    public String editarPerfilUsuario(@PathVariable Long id, Model model, HttpSession session){
        Profissional profissional = profDAO.buscarProfissionalPorId(id);
        Object usuario = session.getAttribute("usuario");
        model.addAttribute("usuario", usuario);
            if(profissional != null){
                return "atualizarDadosProfissional";
            } else {
                return "perfilClienteAtualizarDados";
            }
    }

   
}
