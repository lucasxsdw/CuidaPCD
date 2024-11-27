package com.poo.cuidapcd.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {

    @Autowired
    private MySQLConnectionController usuarioService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Processa o login
    @PostMapping("/loginAutenticar")
    public String autenticarLogin(@RequestParam("email") String email,
                                   @RequestParam("senha") String senha,
                                   RedirectAttributes redirectAttributes) {
        boolean autenticado = usuarioService.verificarLogin(email, senha);

        if (autenticado) {
            return "redirect:/index";
        } else {
            redirectAttributes.addFlashAttribute("erro", "Usuário ou senha inválidos.");
            return "redirect:/login";
        }
    }

    @GetMapping("/index")
    public String logado() {
        return "index";
    }
}
