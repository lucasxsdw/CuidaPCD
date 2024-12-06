package com.poo.cuidapcd.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poo.cuidapcd.conexao.ClienteDAO;
import com.poo.cuidapcd.conexao.ProfissionalDAO;
import com.poo.cuidapcd.conexao.UsuarioDAO;
import com.poo.cuidapcd.entity.Cliente;
import com.poo.cuidapcd.entity.Profissional;
import com.poo.cuidapcd.entity.Usuario;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private MySQLConnectionController usuarioService;

  
    @Autowired
    private UsuarioDAO user;

    @Autowired
    private ProfissionalDAO profDAO;

    @Autowired
    private ClienteDAO clienteDAO;

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
           
            Profissional profissional = profDAO.buscarProfissionalPorId(user.buscarUsuario(email, senha));
            if(profissional != null){
                session.setAttribute("usuario", profissional);
            } else {
                Cliente cliente = clienteDAO.buscarClientePorId(user.buscarUsuario(email, senha));
                session.setAttribute("usuario", cliente);
            }
           
            return "redirect:/index";
        } else {
            redirectAttributes.addFlashAttribute("erro", "Usuário ou senha inválidos.");
          
            return "redirect:/login";
        }
    }

    @GetMapping("/index")
    public String logado(HttpSession session, Model model) {
    
        Usuario usuario = (Usuario) session.getAttribute("usuario");
    
      
        if (usuario != null) {
           
            model.addAttribute("usuario", usuario);
        }
        return "index";
    }

  

    @GetMapping("/deslogar")
    public String deslogar(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
    
}
