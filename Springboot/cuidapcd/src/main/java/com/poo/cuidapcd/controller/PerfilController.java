package com.poo.cuidapcd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poo.cuidapcd.conexao.ProfissionalDAO;
import com.poo.cuidapcd.entity.Profissional;
import com.poo.cuidapcd.service.ProfissionalService;

@Controller
public class PerfilController {

    @Autowired
    private ProfissionalService profissionalService;
    
    @Autowired
    private ProfissionalDAO profissionalDao;

    @GetMapping("/perfil/{id}")
    public String exibirPerfil(@PathVariable Long id, Model model) {
        Profissional profissional = profissionalService.buscarUsuarioPorId(id);
        if (profissional == null) {
            throw new RuntimeException("Profissional não achado para o id: " + id);
        }
        model.addAttribute("profissional", profissional);
        return "perfilProfissional";
    }

    //TESTE BINHO PARA PERFIL DE USUARIO
    @GetMapping("/api/profissionais")
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
    }
}
