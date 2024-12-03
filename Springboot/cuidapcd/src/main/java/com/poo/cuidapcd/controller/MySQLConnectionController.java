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

import org.springframework.web.bind.annotation.RequestBody;


//Isso aqui vai virar o DAO, so é o controller por enquanto pra testar se ta funcionando a conexão de um modo mais rapido as
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

  //config img
   // @Value("${file.upload-dir}")
    //private String uploadDir;

    
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

/* config img
@PostMapping("/cadastroProfissional")
public String receberFormularioProfissional(@ModelAttribute Profissional profissional,
                                             @RequestParam("perfilFoto") MultipartFile fotoPerfil,  
                                              @RequestParam("curriculo") MultipartFile curriculo, 
                                               @RequestParam("certificado") MultipartFile certificado) {
    try {
        // Verifica se a foto foi enviada
        if (!fotoPerfil.isEmpty()) {
            // Salva a foto no diretório
            String fileName = UUID.randomUUID() + "_" + fotoPerfil.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.createDirectories(filePath.getParent()); // Garante que o diretório existe
            Files.write(filePath, fotoPerfil.getBytes()); // Escreve o arquivo no diretório

            // Atualiza o caminho da foto no profissional
            profissional.setArquivoFoto(fileName);
        }

        // Salva o usuário e o profissional
        usuariodao.cadastrarUsuario(profissional);
        profissionaldao.cadastrarProfissional(profissional);
        enderecodao.cadastrarEndereco(profissional);

        // Retorna sucesso
        return "redirect:/login"; // ou o nome da página de sucesso
    } catch (IOException e) {
        e.printStackTrace();
        return "redirect:/formulario"; // ou o nome da página de erro
    }
}
*/
//


@PostMapping("/cadastroProfissional")
public String receberFormularioProfissional(@ModelAttribute Profissional profissional,
                                             @RequestParam("perfilFoto") MultipartFile fotoPerfil,
                                             @RequestParam("certificado") MultipartFile certificado,
                                             @RequestParam("curriculo") MultipartFile curriculo) {
    try {

        boolean unicoUsuario = usuariodao.verificarCadastroUsuario(profissional.getEmail(), profissional.getSenha(), profissional.getCpf(), profissional.getTelefone());
        boolean unicoProfissional = profissionaldao.verificarCadastroProfissional(profissional.getRegistroProfissional(), profissional.getCnpj());

        if(unicoUsuario && unicoProfissional){

            // Define o diretório de upload
            String uploadDir = "uploads/"; // Diretório fora de src/
            Path uploadPath = Paths.get(uploadDir);
            
            // Garante que o diretório de upload exista
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath); // Cria o diretório se não existir
        }
        
        // Verifica se a foto foi enviada
        if (!fotoPerfil.isEmpty()) {
            // Gera um nome único para o arquivo
            String fileName = UUID.randomUUID() + "_" + fotoPerfil.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            
            // Salva o arquivo
            Files.write(filePath, fotoPerfil.getBytes());
            
            // Atualiza o caminho da foto no objeto profissional
            profissional.setArquivoFoto(fileName);
        }

        if (!curriculo.isEmpty()) {
            // Gera um nome único para o arquivo
            String fileName = UUID.randomUUID() + "_" + curriculo.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            
            // Salva o arquivo
            Files.write(filePath, curriculo.getBytes());
            
            // Atualiza o caminho da foto no objeto profissional
            profissional.setArquivoCurriculo(fileName);
        }

        if (!certificado.isEmpty()) {
            // Gera um nome único para o arquivo
            String fileName = UUID.randomUUID() + "_" + certificado.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            
            // Salva o arquivo
            Files.write(filePath, certificado.getBytes());
            
            // Atualiza o caminho da foto no objeto profissional
            profissional.setArquivoCertificado(fileName);
        }
        
        
        // Salva o usuário e o profissional
        usuariodao.cadastrarUsuarioProfissional(profissional);
        profissionaldao.cadastrarProfissional(profissional);
        enderecodao.cadastrarEndereco(profissional);
        
        // Retorna sucesso
        return "redirect:/login"; // ou o nome da página de sucesso
        } else {
            return "redirect:/CadastrarProfissional"; // ou o nome da página de erro
        }
    } catch (IOException e) {
        e.printStackTrace();
        return "redirect:/CadastrarProfissional"; // ou o nome da página de erro
    }
}

@PostMapping("/cadastroCliente")
public String receberFormularioCliente(@ModelAttribute Cliente cliente,
                                             @RequestParam("perfilFoto") MultipartFile fotoPerfil) {
    try {

        boolean unicoUsuario = usuariodao.verificarCadastroUsuario(cliente.getEmail(), cliente.getSenha(), cliente.getCpf(), cliente.getTelefone());

        if(unicoUsuario){

            // Define o diretório de upload
            String uploadDir = "uploads/"; // Diretório fora de src/
            Path uploadPath = Paths.get(uploadDir);
            
            // Garante que o diretório de upload exista
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath); // Cria o diretório se não existir
        }
        
        // Verifica se a foto foi enviada
        if (!fotoPerfil.isEmpty()) {
            // Gera um nome único para o arquivo
            String fileName = UUID.randomUUID() + "_" + fotoPerfil.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            
            // Salva o arquivo
            Files.write(filePath, fotoPerfil.getBytes());
            
            // Atualiza o caminho da foto no objeto profissional
            cliente.setArquivoFoto(fileName);
        }
        
        
        // Salva o usuário e o profissional
        usuariodao.cadastrarUsuarioCliente(cliente);
        clientedao.cadastrarCliente(cliente);
        
        // Retorna sucesso
        return "redirect:/login"; // ou o nome da página de sucesso
        } else {
            return "redirect:/CadastrarCliente"; // ou o nome da página de erro
        }
    } catch (IOException e) {   
        e.printStackTrace();
        return "redirect:/CadastrarCliente"; // ou o nome da página de erro
    }
}





/*@PostMapping("/cadastroProfissional")
    public void receberFormularioProfissional(@ModelAttribute Profissional profissional) {
        usuariodao.cadastrarUsuario(profissional);

        int delayInSeconds = 2;
        try {
            Thread.sleep(delayInSeconds * 1000);
            profissionaldao.cadastrarProfissional(profissional);
            enderecodao.cadastrarEndereco(profissional);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    /*public void insertUsuario( String nome, String email, String senha, String telefone, String cpf) {

        String sql = "INSERT INTO usuario (nome, email, senha, telefone, cpf) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, senha);
            preparedStatement.setString(4, telefone);
            preparedStatement.setString(5, cpf);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }*/

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


   /* public void cadastrarUsuario(Profissional profissional){

        String sqlUsuario = "INSERT INTO usuario (nome, email, senha, telefone, cpf) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlUsuario)) {
            preparedStatement.setString(1, profissional.getNome());
            preparedStatement.setString(2, profissional.getEmail());
            preparedStatement.setString(3, profissional.getSenha());
            preparedStatement.setString(4, profissional.getTelefone());
            preparedStatement.setString(5, profissional.getCpf());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void cadastrarProfissional(Profissional profissional){

        String sqlProf = "INSERT INTO profissional (id, formacao, experiencia, sobre, cnpj, registro_profissional, arquivo_curriculo, arquivo_certificado, arquivo_foto, cpf) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlProf)) {
                preparedStatement.setString(1, profissional.getCpf());
                preparedStatement.setString(2, profissional.getFormacao());
                preparedStatement.setString(3, profissional.getExperiencia());
                preparedStatement.setString(4, profissional.getSobre());
                preparedStatement.setString(5, profissional.getCnpj());
                preparedStatement.setString(6, profissional.getRegistroProfissional());
                preparedStatement.setString(7, profissional.getArquivoCurriculo());
                preparedStatement.setString(8, profissional.getArquivoCertificado());
                preparedStatement.setString(9, profissional.getArquivoFoto());
                preparedStatement.setString(10, profissional.getCpf());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void cadastrarEndereco(Profissional profissional){
        String sqlEndereco = "INSERT INTO endereco (id, rua, bairro, cidade, cep, estado, numero) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlEndereco)) {
            preparedStatement.setString(1, profissional.getCpf());
            preparedStatement.setString(2, profissional.getEndereco().getRua());
            preparedStatement.setString(3, profissional.getEndereco().getBairro());
            preparedStatement.setString(4, profissional.getEndereco().getCidade());
            preparedStatement.setString(5, profissional.getEndereco().getCep());
            preparedStatement.setString(6, profissional.getEndereco().getEstado());
            preparedStatement.setString(7, profissional.getEndereco().getNumero());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

    }*/

    /*@PostMapping("/cadastroProfissional")
    public void receberFormularioProfissional(@ModelAttribute Profissional profissional) {

        String sqlUsuario = "INSERT INTO usuario (nome, email, senha, telefone, cpf) VALUES (?, ?, ?, ?, ?)";
        String sqlProf = "INSERT INTO profissional (id, formacao, experiencia, sobre, cnpj, registro_profissional, arquivo_curriculo, arquivo_certificado, arquivo_foto, cpf) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlEndereco = "INSERT INTO endereco (id, rua, bairro, cidade, cep, estado, numero) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?, ?, ?, ?, ?, ?)";
        //String sqlEspecialidade = "INSERT INTO especialidade (id, nomeEspecialidade, descricao) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?, ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlUsuario)) {
            preparedStatement.setString(1, profissional.getNome());
            preparedStatement.setString(2, profissional.getEmail());
            preparedStatement.setString(3, profissional.getSenha());
            preparedStatement.setString(4, profissional.getTelefone());
            preparedStatement.setString(5, profissional.getCpf());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlProf)) {
                preparedStatement.setString(1, profissional.getCpf());
                preparedStatement.setString(2, profissional.getFormacao());
                preparedStatement.setString(3, profissional.getExperiencia());
                preparedStatement.setString(4, profissional.getSobre());
                preparedStatement.setString(5, profissional.getCnpj());
                preparedStatement.setString(6, profissional.getRegistroProfissional());
                preparedStatement.setString(7, profissional.getArquivoCurriculo());
                preparedStatement.setString(8, profissional.getArquivoCertificado());
                preparedStatement.setString(9, profissional.getArquivoFoto());
                preparedStatement.setString(10, profissional.getCpf());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlEndereco)) {
            preparedStatement.setString(1, profissional.getCpf());
            preparedStatement.setString(2, profissional.getEndereco().getRua());
            preparedStatement.setString(3, profissional.getEndereco().getBairro());
            preparedStatement.setString(4, profissional.getEndereco().getCidade());
            preparedStatement.setString(5, profissional.getEndereco().getCep());
            preparedStatement.setString(6, profissional.getEndereco().getEstado());
            preparedStatement.setString(7, profissional.getEndereco().getNumero());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        /*try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlEspecialidade)) {
            preparedStatement.setString(1, profissional.getCpf());
            preparedStatement.setString(2, profissional.getEspecialidade().getNomeEspecialidade());
            preparedStatement.setString(3, profissional.getEspecialidade().getDescricao());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  */ 
    //}

    

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
    public String atualizarProfissional(@PathVariable long id, @ModelAttribute Profissional profissional, HttpSession session) {
        usuariodao.atualizarUsuario(id, profissional.getNome());
        profissionaldao.atualizarProfissional(id, profissional);
        enderecodao.atualizarEndereco(id, profissional);
        return "redirect:/deslogar";
    }
    
    public void atualizarProfissional(Profissional profissional) {
       
    }
}
