package com.poo.cuidapcd.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poo.cuidapcd.conexao.UsuarioDAO;
import com.poo.cuidapcd.entity.Usuario;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private MySQLConnectionController usuarioService;

    //@Autowired
    //@Lazy
    //private LoginController logged;

    @Autowired
    private UsuarioDAO user;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Processa o login
    @PostMapping("/loginAutenticar")
    public String autenticarLogin(@RequestParam("email") String email,
                                   @RequestParam("senha") String senha,
                                   RedirectAttributes redirectAttributes,
                                   HttpSession session) {
        boolean autenticado = usuarioService.verificarLogin(email, senha);

        if (autenticado) {
            //return logar(user.encontrarUsuario(email, senha, session));
            Usuario usuario = user.encontrarUsuario(email, senha);
            session.setAttribute("usuario", usuario);
            //return new ModelAndView("redirect:/index");
            return "redirect:/index";
        } else {
            redirectAttributes.addFlashAttribute("erro", "Usuário ou senha inválidos.");
            //ModelAndView negado = new ModelAndView("redirect:/login");
            return "redirect:/login";
        }
    }

    @GetMapping("/index")
    public String logado(HttpSession session, Model model) {
        // Recupera o usuário da sessão
        Usuario usuario = (Usuario) session.getAttribute("usuario");
    
        // Verifica se o usuário está logado
        if (usuario != null) {
            // Adiciona o usuário ao modelo para que ele possa ser acessado na view
            model.addAttribute("usuario", usuario);
        }
        return "index";
    }

    //public ModelAndView logar(Usuario usuario, HttpSession session) {

        //session.setAttribute("usuario", usuario);
        //ModelAndView modelAndView = new ModelAndView("redirect:/index");
        //modelAndView.addObject("usuario", usuario);

        //return modelAndView;
    //}
}
