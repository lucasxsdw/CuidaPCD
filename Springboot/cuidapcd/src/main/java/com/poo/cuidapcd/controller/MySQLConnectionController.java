package com.poo.cuidapcd.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.poo.cuidapcd.conexao.ClienteDAO;
import com.poo.cuidapcd.conexao.EnderecoDAO;
import com.poo.cuidapcd.conexao.ProfissionalDAO;
import com.poo.cuidapcd.conexao.UsuarioDAO;
import com.poo.cuidapcd.entity.Cliente;
import com.poo.cuidapcd.entity.Profissional;

import jakarta.servlet.http.HttpSession;



@Controller
public class MySQLConnectionController {
    
    @Autowired
    ProfissionalDAO profissionaldao;

    @Autowired
    UsuarioDAO usuariodao;

    @Autowired
    EnderecoDAO enderecodao;

    @Autowired
    ClienteDAO clientedao;

  

    
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @GetMapping("/testConnection")
    @ResponseBody
    public String testDatabaseConnection() {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            if (connection != null) {
                return "<h1>Conexão com o MySQL estabelecida com sucesso!</h1>";
            } else {
                return "<h1>Falha ao estabelecer a conexão com o MySQL.</h1>";
            }
        } catch (SQLException e) {
            return "<h1>Erro ao conectar com o MySQL: " + e.getMessage() + "</h1>";
        }
    }

    @GetMapping("/CadastrarProfissional")
    public String mostrarFormulario() {
        return "cadastroProfissional";
    }



@PostMapping("/cadastroProfissional")
public String receberFormularioProfissional(@ModelAttribute Profissional profissional,
                                             @RequestParam("perfilFoto") MultipartFile fotoPerfil,
                                             @RequestParam("certificado") MultipartFile certificado,
                                             @RequestParam("curriculo") MultipartFile curriculo) {
    try {

        boolean unicoUsuario = usuariodao.verificarCadastroUsuario(profissional.getEmail(), profissional.getCpf(), profissional.getTelefone());
        boolean unicoProfissional = profissionaldao.verificarCadastroProfissional(profissional.getRegistroProfissional(), profissional.getCnpj());

        if(unicoUsuario && unicoProfissional){

            String uploadDir = "uploads/"; 
            Path uploadPath = Paths.get(uploadDir);
            
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath); 
        }
        
        
        if (!fotoPerfil.isEmpty()) {
            
            String fileName = UUID.randomUUID() + "_" + fotoPerfil.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            
          
            Files.write(filePath, fotoPerfil.getBytes());
            
          
            profissional.setArquivoFoto(fileName);
        }

        if (!curriculo.isEmpty()) {
            
            String fileName = UUID.randomUUID() + "_" + curriculo.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            
            
            Files.write(filePath, curriculo.getBytes());
            
           
            profissional.setArquivoCurriculo(fileName);
        }

        if (!certificado.isEmpty()) {
          
            String fileName = UUID.randomUUID() + "_" + certificado.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            
           
            Files.write(filePath, certificado.getBytes());
            
            
            profissional.setArquivoCertificado(fileName);
        }
        
        
  
        usuariodao.cadastrarUsuarioProfissional(profissional);
        profissionaldao.cadastrarProfissional(profissional);
        enderecodao.cadastrarEndereco(profissional);
        
        
        return "redirect:/login";
        } else {
            return "redirect:/CadastrarProfissional"; 
        }
    } catch (IOException e) {
        e.printStackTrace();
        return "redirect:/CadastrarProfissional"; 
    }
}

@PostMapping("/cadastroCliente")
public String receberFormularioCliente(@ModelAttribute Cliente cliente,
                                             @RequestParam("perfilFoto") MultipartFile fotoPerfil) {
    try {

        boolean unicoUsuario = usuariodao.verificarCadastroUsuario(cliente.getEmail(), cliente.getCpf(), cliente.getTelefone());

        if(unicoUsuario){

            
            String uploadDir = "uploads/";
            Path uploadPath = Paths.get(uploadDir);
            
            
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath); 
        }
        
        
        if (!fotoPerfil.isEmpty()) {
            
            String fileName = UUID.randomUUID() + "_" + fotoPerfil.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            
            
            Files.write(filePath, fotoPerfil.getBytes());
            
           
            cliente.setArquivoFoto(fileName);
        }
        
        
       
        usuariodao.cadastrarUsuarioCliente(cliente);
        clientedao.cadastrarCliente(cliente);
        
      
        return "redirect:/login"; 
        } else {
            return "redirect:/CadastrarCliente";
        }
    } catch (IOException e) {   
        e.printStackTrace();
        return "redirect:/CadastrarCliente";
    }
}




    public boolean verificarLogin(String email, String senha) {
        boolean autenticado = false;
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
    
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    autenticado = true;
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return autenticado;
    }



    

    @PostMapping("/enviarFormulario/Cliente")
    public void receberFormularioCliente(@ModelAttribute Cliente cliente) {

        String sqlUsuario = "INSERT INTO usuario (nome, email, senha, telefone, cpf) VALUES (?, ?, ?, ?, ?)";
        String sqlCliente = "INSERT INTO cliente (id, preferencias) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlUsuario)) {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getSenha());
            preparedStatement.setString(4, cliente.getTelefone());
            preparedStatement.setString(5, cliente.getCpf());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlCliente)) {
                preparedStatement.setString(1, cliente.getCpf());
                preparedStatement.setString(2, cliente.getPreferencias());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }

    @PostMapping("/Usuario/Editar/Enviar/{id}")
    public String atualizarProfissional(@PathVariable Long id, @ModelAttribute Profissional profissional, HttpSession session) {
        usuariodao.atualizarUsuario(id, profissional.getNome());
        profissionaldao.atualizarProfissional(id, profissional);
        enderecodao.atualizarEndereco(
            id,
            profissional.getEndereco().getCidade(),  
            profissional.getEndereco().getBairro(),  
            profissional.getEndereco().getRua(),     
            profissional.getEndereco().getEstado());
        return "redirect:/deslogar";
    }
    

    @PostMapping("/Usuario/Editar/EnviarCliente/{id}")
    public String atualizarCliente(@PathVariable Long id, @ModelAttribute Cliente cliente, HttpSession session) {
        usuariodao.atualizarUsuario(id, cliente.getNome());
        clientedao.atualizarCliente(id, cliente.getPreferencias());
        return "redirect:/deslogar";
    }

    @GetMapping("/Deletar/{id}")
    public String deletarUsuario(@PathVariable Long id, HttpSession session) {
        usuariodao.deletarUsuario(id);
        return "redirect:/deslogar";
    }
    
}
