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
@RequestMapping("/api/profissionais") 
public class ProfissionalController {

    // config img
    @Value("${file.upload-dir}")
        private String uploadDir;

    @Autowired
    private ProfissionalDAO profissionalDAO;

    //
    @Autowired
    private ProfissionalService profissionalService; 


    @GetMapping
    public List<Profissional> getProfissionais() {
        return profissionalService.listarProfissionais(); 
    }


   
}
