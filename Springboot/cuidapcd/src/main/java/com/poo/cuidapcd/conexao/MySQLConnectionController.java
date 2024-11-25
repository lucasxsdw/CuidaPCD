package com.poo.cuidapcd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poo.cuidapcd.entity.Cliente;
import com.poo.cuidapcd.entity.Profissional;

//Isso aqui vai virar o DAO, so é o controller por enquanto pra testar se ta funcionando a conexão de um modo mais rapido
@Controller
public class MySQLConnectionController {

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

    public void insertUsuario( String nome, String email, String senha, String telefone, String cpf) {

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
    }

    public boolean verificarLogin(String email, String senha){
        boolean autenticado = false;
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, senha);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Se encontrou um registro, o login é válido
                        autenticado = true;
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return autenticado;
    }

    @PostMapping("/enviarFormulario/Profissional")
    public void receberFormularioProfissional(@ModelAttribute Profissional profissional) {

        String sqlUsuario = "INSERT INTO usuario (nome, email, senha, telefone, cpf, endereco) VALUES (?, ?, ?, ?, ?)";
        String sqlProf = "INSERT INTO profissional (id, formacao, experiencia, regiao_de_atendimento, sobre, cnpj, registro_profissional, arquivo_curriculo, arquivo_certificado, arquivo_foto, cpf) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlUsuario)) {
            preparedStatement.setString(1, profissional.getNome());
            preparedStatement.setString(2, profissional.getEmail());
            preparedStatement.setString(3, profissional.getSenha());
            preparedStatement.setString(4, profissional.getTelefone());
            preparedStatement.setString(5, profissional.getCpf());
            preparedStatement.setString(6, profissional.getEndereco());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlProf)) {
                preparedStatement.setString(1, profissional.getCpf());
                preparedStatement.setString(2, profissional.getFormacao());
                preparedStatement.setString(3, profissional.getExperiencia());
                preparedStatement.setString(4, profissional.getRegiaoDeAtendimento());
                preparedStatement.setString(5, profissional.getSobre());
                preparedStatement.setString(6, profissional.getCnpj());
                preparedStatement.setString(7, profissional.getRegistroProfissional());
                preparedStatement.setString(8, profissional.getArquivoCurriculo());
                preparedStatement.setString(9, profissional.getArquivoCertificado());
                preparedStatement.setString(10, profissional.getArquivoFoto());
                preparedStatement.setString(11, profissional.getCpf());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }

    @PostMapping("/enviarFormulario/Cliente")
    public void receberFormularioCliente(@ModelAttribute Cliente cliente) {

        String sqlUsuario = "INSERT INTO usuario (nome, email, senha, telefone, cpf, endereco) VALUES (?, ?, ?, ?, ?)";
        String sqlCliente = "INSERT INTO cliente (id, cpf, preferencias) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?, ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlUsuario)) {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getSenha());
            preparedStatement.setString(4, cliente.getTelefone());
            preparedStatement.setString(5, cliente.getCpf());
            preparedStatement.setString(6, cliente.getEndereco());
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
