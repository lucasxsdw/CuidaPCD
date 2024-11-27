package com.poo.cuidapcd.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.cuidapcd.conexao.ProfissionalDAO;
import com.poo.cuidapcd.entity.Profissional;


@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalDAO profDao;

    public Profissional buscarUsuarioPorId(int id) {
        Profissional profissional = profDao.buscarProfissionalPorId(id);
        if (profissional == null) {
            throw new RuntimeException("Profissional não encontrado para o id: " + id);
        }
        
        return profissional;
    }
}
