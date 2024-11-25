package com.poo.cuidapcd.entity;

public class Especialidade {
    private String nomeEspecialidade;
    private String descricao;
    public Especialidade(String nomeEspecialidade, String descricao) {
        this.nomeEspecialidade = nomeEspecialidade;
        this.descricao = descricao;
    }
    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }
    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
