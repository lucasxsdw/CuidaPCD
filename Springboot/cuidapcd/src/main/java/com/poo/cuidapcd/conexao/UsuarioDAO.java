package com.poo.cuidapcd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.poo.cuidapcd.entity.Cliente;
import com.poo.cuidapcd.entity.Profissional;
import com.poo.cuidapcd.entity.Usuario;

@Repository
public class UsuarioDAO {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    public void cadastrarUsuarioProfissional(Profissional profissional){

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

    public void cadastrarUsuarioCliente(Cliente cliente){

        String sqlUsuario = "INSERT INTO usuario (nome, email, senha, telefone, cpf) VALUES (?, ?, ?, ?, ?)";

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
    }

    public Usuario encontrarUsuario(String email, String senha){
        String sql = "SELECT id AS id_usuario FROM usuario WHERE email = ? and senha = ?";

        Usuario usuario = null ;
        
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, senha);
    
            try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                Long id = resultSet.getLong("id_usuario");
                usuario = new Usuario(id, null, null, null, null, null);
            }
        }
            } catch (SQLException e) {
            e.printStackTrace();
            }
            return usuario;
        }

        public Long buscarUsuario(String email, String senha){
            String sql = "SELECT id AS id_usuario FROM usuario WHERE email = ? and senha = ?";
    
            Long id = null ;
            
            try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, senha);
        
                try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    id = resultSet.getLong("id_usuario");
                }
            }
                } catch (SQLException e) {
                e.printStackTrace();
                }
                return id;
            }

            public boolean verificarCadastroUsuario(String email, String cpf, String telefone) {
                boolean unico = true;
                String sql = "SELECT * FROM usuario WHERE email = ? OR cpf = ? Or telefone = ?";
                
                try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                     PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, cpf);
                    preparedStatement.setString(3, telefone);
            
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            unico = false;
                        }
                    }
            
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                return unico;
            }




             // config lucas 
      public void atualizarUsuario(Long id, String nome) {
        String sql = """
            UPDATE usuario 
            SET nome = ?
            WHERE id = ?
        """;
    
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nome); 
                preparedStatement.setLong(2, id); 
    
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarUsuario(Long id) {
        String sql = """
            DELETE 
            FROM Usuario 
            WHERE id = ?;
        """;
    
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id); 
    
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //



            
    }
    

