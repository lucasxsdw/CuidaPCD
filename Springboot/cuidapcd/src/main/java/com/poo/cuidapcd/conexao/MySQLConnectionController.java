package com.poo.cuidapcd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
