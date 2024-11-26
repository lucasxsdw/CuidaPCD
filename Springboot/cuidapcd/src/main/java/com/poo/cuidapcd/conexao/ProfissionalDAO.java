package com.poo.cuidapcd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.poo.cuidapcd.entity.Profissional;

@Repository
public class ProfissionalDAO {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    public void cadastrarProfissional(Profissional profissional){

        String sqlProf = "INSERT INTO profissional (id, formacao, experiencia, sobre, cnpj, registro_profissional, arquivo_curriculo, arquivo_certificado, arquivo_foto) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlProf)) {
                System.out.println("profissional cpf: " +profissional.getCpf());
                preparedStatement.setString(1, profissional.getCpf());
                preparedStatement.setString(2, profissional.getFormacao());
                preparedStatement.setString(3, profissional.getExperiencia());
                preparedStatement.setString(4, profissional.getSobre());
                preparedStatement.setString(5, profissional.getCnpj());
                preparedStatement.setString(6, profissional.getRegistroProfissional());
                preparedStatement.setString(7, profissional.getArquivoCurriculo());
                preparedStatement.setString(8, profissional.getArquivoCertificado());
                preparedStatement.setString(9, profissional.getArquivoFoto());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}
