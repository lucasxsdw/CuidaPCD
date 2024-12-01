package com.poo.cuidapcd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.poo.cuidapcd.entity.Cliente;

@Repository
public class ClienteDAO {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    public Cliente buscarClientePorId(Long idCliente) {
        Cliente cliente = null;
    
        String sql = """
            SELECT 
                u.id AS usuario_id,
                u.nome AS usuario_nome,
                u.email AS usuario_email,
                u.telefone AS usuario_telefone,
                u.cpf AS usuario_cpf,
                c.preferencias AS cliente_preferencias
                c.arquivoFoto AS arquivo_foto
            FROM 
                Usuario u
            JOIN 
                Cliente c ON u.id = c.id
            WHERE 
                u.id = ?
        """;
    
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        PreparedStatement statement = connection.prepareStatement(sql)) {
    
            statement.setLong(1, idCliente);
    
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Long id = resultSet.getLong("usuario_id");
                    String nome = resultSet.getString("usuario_nome");
                    String email = resultSet.getString("usuario_email");
                    String telefone = resultSet.getString("usuario_telefone");
                    String cpf = resultSet.getString("usuario_cpf");
                    String preferencias = resultSet.getString("cliente_preferencias");
                    String arquivoFoto = resultSet.getString("arquivo_foto");
                    cliente = new Cliente(id, nome, email, email, telefone, cpf, preferencias, arquivoFoto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return cliente;
        } 

        public void cadastrarCliente(Cliente cliente){

        String sqlProf = "INSERT INTO cliente (id, preferencias, arquivoFoto) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?, ?)";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlProf)) {
                System.out.println("profissional cpf: " +cliente.getCpf());
                preparedStatement.setString(1, cliente.getCpf());
                preparedStatement.setString(2, cliente.getPreferencias());
                preparedStatement.setString(3, cliente.getArquivoFoto());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
}
