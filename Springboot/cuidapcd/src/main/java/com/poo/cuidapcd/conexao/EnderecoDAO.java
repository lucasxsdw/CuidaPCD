package com.poo.cuidapcd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.poo.cuidapcd.entity.Profissional;

@Repository
public class EnderecoDAO {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

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

    }


     // config lucas 
     public void atualizarEndereco(Long id, String cidade, String bairro, String rua, String estado) {
        String sql = """
            UPDATE Endereco 
            SET cidade = ?, bairro = ?, rua = ?, estado = ?
            WHERE id = ?
        """;
    
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, cidade); 
                preparedStatement.setString(2, bairro); 
                preparedStatement.setString(3, rua);
                preparedStatement.setString(4, estado);  
                preparedStatement.setLong(5, id); 
    
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
