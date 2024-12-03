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
        // O usuário está logado, adiciona o objeto ao modelo para a view
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
                return "perfilUsuario";
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

    //TESTE BINHO PARA PERFIL DE USUARIO
   /*  @GetMapping("/api/profissionais")
    public List<Profissional> getProfissionais() {
        // Simule uma busca por múltiplos profissionais (o DAO deve ser ajustado se necessário)
        List<Profissional> profissionais = new ArrayList<>();
        // Adicione IDs dos profissionais que deseja buscar
        for (int i = 1; i <= 5; i++) { // Exemplo para buscar os primeiros 5
            Profissional profissional = profissionalDao.buscarProfissionalPorId((long) i);
            if (profissional != null) {
                profissionais.add(profissional);
            }
        }
        return profissionais;
    }*/
}
