package com.poo.cuidapcd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.cuidapcd.conexao.MySQLConnectionController;

@Service
public class UsuarioService {

    @Autowired
    private MySQLConnectionController mysqlController;

    public boolean autenticarUsuario(String nome, String senha) {
        return mysqlController.verificarLogin(nome, senha);
    }
}
