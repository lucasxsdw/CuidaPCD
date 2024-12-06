package com.poo.cuidapcd.entity;

public enum Especialidade {
    PSICOLOGIA_CLINICA("Psicologia Clínica"),
    PSICOLOGIA_INFANTIL("Psicologia Infantil"),
    NEUROPSICOLOGIA("Neuropsicologia"),
    PSICOLOGIA_ORGANIZACIONAL("Psicologia Organizacional"),
    PSICOTERAPIA_COGNITIVA("Psicoterapia Cognitiva-Comportamental"),
    PSICOLOGIA_ESCOLAR("Psicologia Escolar"),

    CARDIOLOGIA("Cardiologia"),
    NEUROLOGIA("Neurologia"),
    PEDIATRIA("Pediatria"),
    GERIATRIA("Geriatria"),
    DERMATOLOGIA("Dermatologia"),

    FISIOTERAPIA_DESPORTIVA("Fisioterapia Desportiva"),
    FISIOTERAPIA_RESPIRATORIA("Fisioterapia Respiratória"),
    FISIOTERAPIA_NEUROFUNCIONAL("Fisioterapia Neurofuncional"),
    FISIOTERAPIA_PEDIATRICA("Fisioterapia Pediátrica"),
    FISIOTERAPIA_GERIATRICA("Fisioterapia Geriátrica"),

    NUTRICAO_CLINICA("Nutrição Clínica"),
    NUTRICAO_ESPORTIVA("Nutrição Esportiva"),
    NUTRICAO_MATERNO_INFANTIL("Nutrição Materno-Infantil"),
    NUTRICAO_VEGETARIANA("Nutrição Vegetariana"),
    NUTRICAO_ONCOLOGICA("Nutrição Oncológica"),

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

