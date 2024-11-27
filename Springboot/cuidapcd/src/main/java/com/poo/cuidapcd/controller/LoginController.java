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

    // Exibe a tela de login
    @GetMapping("/login")
    public String login() {
        return "login";  // Aqui você pode retornar o nome da sua página HTML de login
    }

    // Processa o login
    @PostMapping("/loginAutenticar")
    public String autenticarLogin(@RequestParam("email") String email,
                                   @RequestParam("senha") String senha,
                                   RedirectAttributes redirectAttributes) {
        // Chama o serviço para verificar o login
        boolean autenticado = usuarioService.verificarLogin(email, senha);

        // Se o login for bem-sucedido
        if (autenticado) {
            // Redireciona para a página principal ou para a página desejada
            return "redirect:/index";  // Ou outra página que você queira redirecionar após login
        } else {
            // Se o login falhar, exibe uma mensagem de erro
            redirectAttributes.addFlashAttribute("erro", "Usuário ou senha inválidos.");
            return "redirect:/login";  // Retorna para a página de login
        }
    }

    @GetMapping("/index")
    public String logado() {
        return "index";  // Aqui você pode retornar o nome da sua página HTML de login
    }
}
