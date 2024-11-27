package com.poo.cuidapcd.entity;

public class Cliente extends Usuario{
    private String preferencias;

    public Cliente(int id, String nome, String email, String senha, String telefone, String cpf, 
            String preferencias) {
        super(id, nome, email, senha, telefone, cpf);
        this.preferencias = preferencias;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

}
