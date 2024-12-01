package com.poo.cuidapcd.entity;

public enum Especialidade {
    // Psicologia
    PSICOLOGIA_CLINICA("Psicologia Clínica"),
    PSICOLOGIA_INFANTIL("Psicologia Infantil"),
    NEUROPSICOLOGIA("Neuropsicologia"),
    PSICOLOGIA_ORGANIZACIONAL("Psicologia Organizacional"),
    PSICOTERAPIA_COGNITIVA("Psicoterapia Cognitiva-Comportamental"),
    PSICOLOGIA_ESCOLAR("Psicologia Escolar"),

    // Medicina
    CARDIOLOGIA("Cardiologia"),
    NEUROLOGIA("Neurologia"),
    PEDIATRIA("Pediatria"),
    GERIATRIA("Geriatria"),
    DERMATOLOGIA("Dermatologia"),

    // Fisioterapia
    FISIOTERAPIA_DESPORTIVA("Fisioterapia Desportiva"),
    FISIOTERAPIA_RESPIRATORIA("Fisioterapia Respiratória"),
    FISIOTERAPIA_NEUROFUNCIONAL("Fisioterapia Neurofuncional"),
    FISIOTERAPIA_PEDIATRICA("Fisioterapia Pediátrica"),
    FISIOTERAPIA_GERIATRICA("Fisioterapia Geriátrica"),

    // Nutrição
    NUTRICAO_CLINICA("Nutrição Clínica"),
    NUTRICAO_ESPORTIVA("Nutrição Esportiva"),
    NUTRICAO_MATERNO_INFANTIL("Nutrição Materno-Infantil"),
    NUTRICAO_VEGETARIANA("Nutrição Vegetariana"),
    NUTRICAO_ONCOLOGICA("Nutrição Oncológica"),

    // Odontologia
    ODONTOPEDIATRIA("Odontopediatria"),
    ORTODONTIA("Ortodontia"),
    IMPLANTODONTIA("Implantodontia"),
    PERIODONTIA("Periodontia"),
    ODONTOLOGIA_ESTETICA("Odontologia Estética");

    private final String descricao;

    Especialidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

/*public class Especialidade {
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
}*/
