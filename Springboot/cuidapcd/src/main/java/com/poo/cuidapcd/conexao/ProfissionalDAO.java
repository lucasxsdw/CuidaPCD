package com.poo.cuidapcd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.poo.cuidapcd.entity.Especialidade;
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

        String sqlProf = "INSERT INTO profissional (id, formacao, experiencia, sobre, cnpj, registroProfissional, arquivoCurriculo, arquivoCertificado, arquivoFoto, especialidade, especialidadeDescricao) VALUES ((SELECT id FROM usuario WHERE cpf = ?), ?, ?, ?, ?, ?, ?, ?, ?, (SELECT nome FROM especialidade WHERE nome = ?), (SELECT descricao FROM especialidade WHERE descricao = ?))";

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
                preparedStatement.setString(10, profissional.getEspecialidade().name());
                preparedStatement.setString(11, profissional.getEspecialidade().getDescricao());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public Profissional buscarProfissionalPorId(Long idProfissional) {
    Profissional profissional = null;

    String sql = """
        SELECT 
            u.id AS usuario_id,
            u.nome AS usuario_nome,
            u.email AS usuario_email,
            u.telefone AS usuario_telefone,
            u.cpf AS usuario_cpf,
            p.formacao AS profissional_formacao,
            p.experiencia AS profissional_experiencia,
            p.sobre AS profissional_sobre,
            p.cnpj AS profissional_cnpj,
            p.registroProfissional AS profissional_registro,
            p.arquivoCurriculo AS profissional_curriculo,
            p.arquivoCertificado AS profissional_certificado,
            p.arquivoFoto AS profissional_foto,
            p.especialidade AS especialidade,
            p.especialidadeDescricao AS descricao,
            e.rua AS endereco_rua,
            e.numero AS endereco_numero,
            e.bairro AS endereco_bairro,
            e.cidade AS endereco_cidade,
            e.estado AS endereco_estado,
            e.cep AS endereco_cep
        FROM 
            Profissional p
        JOIN 
            Usuario u ON p.id = u.id
        LEFT JOIN 
            Endereco e ON e.id = p.id
        WHERE 
            p.id = ?
    """;

    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setLong(1, idProfissional);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                Long id = resultSet.getLong("usuario_id");
                String nome = resultSet.getString("usuario_nome");
                String email = resultSet.getString("usuario_email");
                String telefone = resultSet.getString("usuario_telefone");
                String cpf = resultSet.getString("usuario_cpf");
                String formacao = resultSet.getString("profissional_formacao");
                String experiencia = resultSet.getString("profissional_experiencia");
                String sobre = resultSet.getString("profissional_sobre");
                String cnpj = resultSet.getString("profissional_cnpj");
                String registroProfissional = resultSet.getString("profissional_registro");
                String arquivoCurriculo = resultSet.getString("profissional_curriculo");
                String arquivoCertificado = resultSet.getString("profissional_certificado");
                String arquivoFoto = resultSet.getString("profissional_foto");
                String rua = resultSet.getString("endereco_rua");
                String bairro = resultSet.getString("endereco_bairro");
                String cidade = resultSet.getString("endereco_cidade");
                String estado = resultSet.getString("endereco_estado");
                String cep = resultSet.getString("endereco_cep");
                String numero = resultSet.getString("endereco_numero");
                Especialidade especialidade = Especialidade.valueOf(resultSet.getString("especialidade"));
                profissional = new Profissional(
                    id, nome, email, "", telefone, cpf, 
                    formacao, experiencia, sobre, cnpj, registroProfissional,
                    arquivoCurriculo, arquivoCertificado, arquivoFoto, rua, bairro, cidade, estado, cep, numero, especialidade
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return profissional;
    }   
    
    public List<Profissional> buscarTodosProfissionais() {
    List<Profissional> profissionais = new ArrayList<>();

    String sql = """
        SELECT 
            u.id AS usuario_id,
            u.nome AS usuario_nome,
            u.email AS usuario_email,
            u.telefone AS usuario_telefone,
            u.cpf AS usuario_cpf,
            p.formacao AS profissional_formacao,
            p.experiencia AS profissional_experiencia,
            p.sobre AS profissional_sobre,
            p.cnpj AS profissional_cnpj,
            p.registroProfissional AS profissional_registro,
            p.arquivoCurriculo AS profissional_curriculo,
            p.arquivoCertificado AS profissional_certificado,
            p.arquivoFoto AS profissional_foto,
            p.especialidade AS especialidade,
            p.especialidadeDescricao AS descricao,
            e.rua AS endereco_rua,
            e.numero AS endereco_numero,
            e.bairro AS endereco_bairro,
            e.cidade AS endereco_cidade,
            e.estado AS endereco_estado,
            e.cep AS endereco_cep
        FROM 
            Profissional p
        JOIN 
            Usuario u ON p.id = u.id
        LEFT JOIN 
            Endereco e ON e.id = p.id
    """;

    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         PreparedStatement statement = connection.prepareStatement(sql)) {

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Long id = resultSet.getLong("usuario_id");
                String nome = resultSet.getString("usuario_nome");
                String email = resultSet.getString("usuario_email");
                String telefone = resultSet.getString("usuario_telefone");
                String cpf = resultSet.getString("usuario_cpf");
                String formacao = resultSet.getString("profissional_formacao");
                String experiencia = resultSet.getString("profissional_experiencia");
                String sobre = resultSet.getString("profissional_sobre");
                String cnpj = resultSet.getString("profissional_cnpj");
                String registroProfissional = resultSet.getString("profissional_registro");
                String arquivoCurriculo = resultSet.getString("profissional_curriculo");
                String arquivoCertificado = resultSet.getString("profissional_certificado");
                String arquivoFoto = resultSet.getString("profissional_foto");
                String rua = resultSet.getString("endereco_rua");
                String bairro = resultSet.getString("endereco_bairro");
                String cidade = resultSet.getString("endereco_cidade");
                String estado = resultSet.getString("endereco_estado");
                String cep = resultSet.getString("endereco_cep");
                String numero = resultSet.getString("endereco_numero");
                Especialidade especialidade = Especialidade.valueOf(resultSet.getString("especialidade"));

                Profissional profissional = new Profissional(
                    id, nome, email, "", telefone, cpf, 
                    formacao, experiencia, sobre, cnpj, registroProfissional,
                    arquivoCurriculo, arquivoCertificado, arquivoFoto, rua, bairro, cidade, estado, cep, numero, especialidade
                );
                profissionais.add(profissional);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return profissionais;
}

        preparedStatement.setString(5, profissional.getRegistroProfissional());

public boolean verificarCadastroProfissional(String registro, String cnpj) {
    boolean unico = true;
    String sql = "SELECT * FROM profissional WHERE registroProfissional = ? OR cnpj = ?";
    
    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        
        preparedStatement.setString(1, registro);
        preparedStatement.setString(2, cnpj);

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


public void atualizarProfissional(Long id, Profissional profissional) {
    String sql = """
        UPDATE profissional 
        SET formacao = ?, experiencia = ?, sobre = ?
        WHERE id = ?
    """;

    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, profissional.getFormacao());
        preparedStatement.setString(2, profissional.getExperiencia());
        preparedStatement.setString(3, profissional.getSobre());
        preparedStatement.setLong(4, profissional.getId()); // Define o ID para a cláusula WHERE

        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


//

}
