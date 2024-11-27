package com.poo.cuidapcd.entity;


public class Profissional extends Usuario{
    private String formacao;
    private String experiencia;
    private String sobre;
    private String cnpj;
    private String registroProfissional;
    private String arquivoCurriculo;
    private String arquivoCertificado;
    private String arquivoFoto;
    private Endereco endereco;
    private Especialidade especialidade;

    public Profissional(int id, String nome, String email, String senha, String telefone, String cpf,
    String formacao, String experiencia, String sobre, String cnpj,
    String registroProfissional, String arquivoCurriculo, String arquivoCertificado, String arquivoFoto, String rua, String bairro, 
    String cidade, String estado, String cep, String numero, Especialidade especialidade) {
        super(id, nome, email, senha, telefone, cpf);
        this.formacao = formacao;
        this.experiencia = experiencia;
        this.sobre = sobre;
        this.cnpj = cnpj;
        this.registroProfissional = registroProfissional;
        this.arquivoCurriculo = arquivoCurriculo;
        this.arquivoCertificado = arquivoCertificado;
        this.arquivoFoto = arquivoFoto;
        this.endereco = new Endereco(rua, bairro, cidade, estado, cep, numero);
        this.especialidade = especialidade;
    }
    public String getFormacao() {
        return formacao;
    }
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    public String getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
    public String getSobre() {
        return sobre;
    }
    public void setSobre(String sobre) {
        this.sobre = sobre;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getRegistroProfissional() {
        return registroProfissional;
    }
    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }
    public String getArquivoCurriculo() {
        return arquivoCurriculo;
    }
    public void setArquivoCurriculo(String arquivoCurriculo) {
        this.arquivoCurriculo = arquivoCurriculo;
    }
    public String getArquivoCertificado() {
        return arquivoCertificado;
    }
    public void setArquivoCertificado(String arquivoCertificado) {
        this.arquivoCertificado = arquivoCertificado;
    }
    public String getArquivoFoto() {
        return arquivoFoto;
    }
    public void setArquivoFoto(String arquivoFoto) {
        this.arquivoFoto = arquivoFoto;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Especialidade getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
