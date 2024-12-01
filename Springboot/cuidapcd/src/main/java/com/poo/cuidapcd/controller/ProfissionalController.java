package com.poo.cuidapcd.controller;

import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
//config img
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poo.cuidapcd.conexao.ProfissionalDAO;
import com.poo.cuidapcd.entity.Profissional;
import com.poo.cuidapcd.service.ProfissionalService;

@RestController
@RequestMapping("/api/profissionais") // URL base da API
public class ProfissionalController {

    // config img
    @Value("${file.upload-dir}")
        private String uploadDir;

    @Autowired
    private ProfissionalDAO profissionalDAO;

    //
    @Autowired
    private ProfissionalService profissionalService; // Serviço que gerencia a lógica dos profissionais

    // Endpoint para obter todos os profissionais
    @GetMapping
    public List<Profissional> getProfissionais() {
        return profissionalService.listarProfissionais(); // Chama o serviço para pegar todos os profissionais
    }


    //config img

 /*@PostMapping("/uploadFoto/{id}")
    public ResponseEntity<String> uploadFoto(@PathVariable Long id,
                                             @RequestParam("file") MultipartFile file) {
        try {
            // Valida o profissional
            Profissional profissional = profissionalDAO.buscarProfissionalPorId(id);
            if (profissional == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profissional não encontrado");
            }

             // Salva o arquivo no diretório
             String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
             Path filePath = Paths.get(uploadDir + fileName);
             Files.createDirectories(filePath.getParent()); // Garante que o diretório existe
             Files.write(filePath, file.getBytes()); // Escreve o arquivo no diretório
 
             // Atualiza o profissional com o caminho da imagem
             profissional.setArquivoFoto(filePath.toString());
             profissionalDAO.atualizarProfissional(profissional); // Usa o método de atualização em vez de save()
 
             return ResponseEntity.ok("Foto salva com sucesso. Link: " + filePath.toString());
         } catch (IOException e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar arquivo");
         }
     } */
    


    //
}
