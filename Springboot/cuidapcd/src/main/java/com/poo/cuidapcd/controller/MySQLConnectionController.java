package com.poo.cuidapcd.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poo.cuidapcd.conexao.EnderecoDAO;
import com.poo.cuidapcd.conexao.ProfissionalDAO;
import com.poo.cuidapcd.conexao.UsuarioDAO;
import com.poo.cuidapcd.entity.Cliente;
import com.poo.cuidapcd.entity.Profissional;

//Isso aqui vai virar o DAO, so é o controller por enquanto pra testar se ta funcionando a conexão de um modo mais rapido as
@Controller
public class MySQLConnectionController {
    
    @Autowired
    ProfissionalDAO profissionaldao;

    @Autowired
    UsuarioDAO usuariodao;

    @Autowired
    EnderecoDAO enderecodao;
    
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

    @GetMapping("/formulario")
    public String mostrarFormulario() {
        return "cadastroProfissional";
    }

    @PostMapping("/cadastroProfissional")
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
    }

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
        String sqlCliente = "INSERT INTO cliente (id, cpf, preferencias) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?, ?)";

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
                preparedStatement.setString(2, cliente.getCpf());
                preparedStatement.setString(3, cliente.getPreferencias());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }
}
