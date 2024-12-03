-- BD 2.0
drop database if exists CuidaPCD;
create database CuidaPCD;
use CuidaPCD;

create table Usuario (
    id int auto_increment,
    nome TEXT,
    email varchar(255) Unique,
    senha TEXT,
    telefone varchar(15) Unique,
    cpf varchar(15) Unique,
    primary key(id)
);

create table Cliente(
    id int,
    preferencias TEXT,
    arquivoFoto varchar(500),
    primary key (id),
    FOREIGN KEY (id) REFERENCES Usuario(id) ON DELETE CASCADE
);

create table Especialidade(
    nome varchar(100),
    descricao varchar(100),
    primary key(nome, descricao)
);

create table Profissional(
    formacao TEXT,
    experiencia TEXT,
    sobre TEXT,
    id int,
    cnpj varchar(20) Unique,
    registroProfissional varchar(30) Unique,
    arquivoCurriculo varchar(500),
    arquivoFoto varchar(500),
    arquivoCertificado varchar(500),
    especialidade varchar(100),
    especialidadeDescricao varchar(100),
    primary key (id),
    FOREIGN KEY (id) REFERENCES Usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (especialidade, especialidadeDescricao) REFERENCES Especialidade(nome, descricao)
);

create table Avaliacao(
    idCliente int,
    idProfissional int,
    nota int,
    comentario TEXT,
    dataAvaliacao datetime,
    primary key (idCliente, idProfissional),
    FOREIGN KEY (idProfissional) REFERENCES Profissional(id) ON DELETE CASCADE,
    FOREIGN KEY (idCliente) REFERENCES Cliente(id) ON DELETE CASCADE
);

create table Endereco(
    id int,
    rua TEXT,
    numero TEXT,
    bairro TEXT,
    cidade TEXT,
    estado TEXT,
    cep TEXT,
    primary key(id),
    FOREIGN KEY (id) REFERENCES Profissional(id) ON DELETE CASCADE
);

INSERT INTO Especialidade (nome, descricao) VALUES
('PSICOLOGIA_CLINICA', 'Psicologia Clínica'),
('PSICOLOGIA_INFANTIL', 'Psicologia Infantil'),
('NEUROPSICOLOGIA', 'Neuropsicologia'),
('PSICOLOGIA_ORGANIZACIONAL', 'Psicologia Organizacional'),
('PSICOTERAPIA_COGNITIVA', 'Psicoterapia Cognitiva-Comportamental'),
('PSICOLOGIA_ESCOLAR', 'Psicologia Escolar'),

-- Medicina
('CARDIOLOGIA', 'Cardiologia'),
('NEUROLOGIA', 'Neurologia'),
('PEDIATRIA', 'Pediatria'),
('GERIATRIA', 'Geriatria'),
('DERMATOLOGIA', 'Dermatologia'),

-- Fisioterapia
('FISIOTERAPIA_DESPORTIVA', 'Fisioterapia Desportiva'),
('FISIOTERAPIA_RESPIRATORIA', 'Fisioterapia Respiratória'),
('FISIOTERAPIA_NEUROFUNCIONAL', 'Fisioterapia Neurofuncional'),
('FISIOTERAPIA_PEDIATRICA', 'Fisioterapia Pediátrica'),
('FISIOTERAPIA_GERIATRICA', 'Fisioterapia Geriátrica'),

-- Nutrição
('NUTRICAO_CLINICA', 'Nutrição Clínica'),
('NUTRICAO_ESPORTIVA', 'Nutrição Esportiva'),
('NUTRICAO_MATERNO_INFANTIL', 'Nutrição Materno-Infantil'),
('NUTRICAO_VEGETARIANA', 'Nutrição Vegetariana'),
('NUTRICAO_ONCOLOGICA', 'Nutrição Oncológica'),

-- Odontologia
('ODONTOPEDIATRIA', 'Odontopediatria'),
('ORTODONTIA', 'Ortodontia'),
('IMPLANTODONTIA', 'Implantodontia'),
('PERIODONTIA', 'Periodontia'),
('ODONTOLOGIA_ESTETICA', 'Odontologia Estética');


-- BD 1.0
/*drop database if exists CuidaPCD;
create database CuidaPCD;
use CuidaPCD;

create table Usuario (
id int auto_increment,
nome TEXT,
email varchar(255) Unique,
senha TEXT,
telefone varchar(15) Unique,
cpf varchar(15) Unique,
primary key(id)
);

create table Cliente(
id int,
preferencias TEXT,
arquivoFoto varchar(500),
primary key (id),
FOREIGN KEY (id) REFERENCES Usuario(id)
);

create table Profissional(
formacao TEXT,
experiencia TEXT,
sobre TEXT,
id int,
cnpj varchar(20) Unique,
registroProfissional varchar(30) Unique,
arquivoCurriculo varchar(500),
arquivoFoto varchar(500),
arquivoCertificado varchar(500),
especialidade ENUM(
        'PSICOLOGIA_CLINICA', 
        'PSICOLOGIA_INFANTIL', 
        'NEUROPSICOLOGIA', 
        'PSICOLOGIA_ORGANIZACIONAL', 
        'PSICOTERAPIA_COGNITIVA', 
        'PSICOLOGIA_ESCOLAR',
        'CARDIOLOGIA', 
        'NEUROLOGIA', 
        'PEDIATRIA', 
        'GERIATRIA', 
        'DERMATOLOGIA', 
        'FISIOTERAPIA_DESPORTIVA', 
        'FISIOTERAPIA_RESPIRATORIA', 
        'FISIOTERAPIA_NEUROFUNCIONAL', 
        'FISIOTERAPIA_PEDIATRICA', 
        'FISIOTERAPIA_GERIATRICA', 
        'NUTRICAO_CLINICA', 
        'NUTRICAO_ESPORTIVA', 
        'NUTRICAO_MATERNO_INFANTIL', 
        'NUTRICAO_VEGETARIANA', 
        'NUTRICAO_ONCOLOGICA', 
        'ODONTOPEDIATRIA', 
        'ORTODONTIA', 
        'IMPLANTODONTIA', 
        'PERIODONTIA', 
        'ODONTOLOGIA_ESTETICA'),
especialidadeDescricao varchar(100),
primary key (id),
FOREIGN KEY (id) REFERENCES Usuario(id)
);

create table Especialidade(
id int,
nome TEXT,
descricao TEXT,
FOREIGN KEY (id) REFERENCES Profissional(id)
);

create table Avaliacao(
idCliente int,
idProfissional int,
nota int,
comentario TEXT,
dataAvaliacao datetime,
primary key (idCliente, idProfissional),
FOREIGN KEY (idProfissional) REFERENCES Profissional(id),
FOREIGN KEY (idCliente) REFERENCES Cliente(id)
);

create table Endereco(
id int,
rua TEXT,
numero TEXT,
bairro TEXT,
cidade TEXT,
estado TEXT,
cep TEXT,
primary key(id),
FOREIGN KEY (id) REFERENCES Profissional(id)
);

create table Notificacao(
id int,
mensagem TEXT,
tipoNotificacao TEXT,
dataHora datetime,
FOREIGN KEY (id) REFERENCES Usuario(id)
);/*

-- BD antigo1
/*drop database if exists CuidaPCD;
create database CuidaPCD;
use CuidaPCD;

create table Usuario (
id int auto_increment,
nome TEXT,
email varchar(255) Unique,
senha TEXT,
telefone varchar(15) Unique,
cpf varchar(15) Unique,
primary key(id)
);

create table Cliente(
id int,
cpf varchar(15) Unique,
preferencias TEXT,
primary key (id, cpf),
FOREIGN KEY (id) REFERENCES Usuario(id),
FOREIGN KEY (cpf) REFERENCES Usuario(cpf)
);

create table Profissional(
formacao TEXT,
experiencia TEXT,
regiaoDeAtendimento TEXT,
sobre TEXT,
id int,
cnpj varchar(20) Unique,
registroProfissional varchar(30) Unique,
arquivoCurriculo mediumblob,
arquivoFoto mediumblob,
arquivoCertificado mediumblob,
primary key (id),
FOREIGN KEY (id) REFERENCES Usuario(id)
);

create table Especialidade(
id int,
nome TEXT,
descricao TEXT,
FOREIGN KEY (id) REFERENCES Profissional(id)
);

create table Avaliacao(
idCliente int,
idProfissional int,
nota int,
comentario TEXT,
dataAvaliacao datetime,
primary key (idCliente, idProfissional),
FOREIGN KEY (idProfissional) REFERENCES Profissional(id),
FOREIGN KEY (idCliente) REFERENCES Cliente(id)
);

create table Endereco(
id int,
rua TEXT,
numero TEXT,
bairro TEXT,
cidade TEXT,
estado TEXT,
cep TEXT,
primary key(id),
FOREIGN KEY (id) REFERENCES Profissional(id)
);

create table Notificacao(
id int,
mensagem TEXT,
tipoNotificacao TEXT,
dataHora datetime,
FOREIGN KEY (id) REFERENCES Usuario(id)
);*/


