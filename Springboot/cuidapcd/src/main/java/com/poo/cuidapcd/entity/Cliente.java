package com.poo.cuidapcd.entity;

public class Cliente extends Usuario{
    private String preferencias;
    private String arquivoFoto;

    public Cliente(Long id, String nome, String email, String senha, String telefone, String cpf, 
            String preferencias, String arquivoFoto) {
        super(id, nome, email, senha, telefone, cpf);
        this.preferencias = preferencias;
        this.arquivoFoto = arquivoFoto;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public String getArquivoFoto() {
        return arquivoFoto;
    }

    public void setArquivoFoto(String arquivoFoto) {
        this.arquivoFoto = arquivoFoto;
    }

}
