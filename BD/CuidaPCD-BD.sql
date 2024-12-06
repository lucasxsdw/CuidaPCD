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

-- Cadastros pré realizados para teste
INSERT INTO Usuario (nome, email, senha, telefone, cpf)
VALUES ('Ana Silva', 'ana.silva@email.com', 'senha123', '11987654321', '123.456.789-00');

INSERT INTO Profissional (formacao, experiencia, sobre, id, cnpj, registroProfissional, arquivoCurriculo, arquivoFoto, arquivoCertificado, especialidade, especialidadeDescricao)
VALUES ('Psicologia', '5 anos de experiência atendendo adolescentes e adultos', 'Psicóloga especializada em terapia cognitiva-comportamental', 1, '12.345.678/0001-90', '12345', '2642b17b-c80a-4abd-b74a-4f1b1abdda9e_SNES - Mega Man X - X.png', '637c4d02-e190-44b9-ac11-5cefa9a0d295_medico1.jpeg', 'f41d7f39-2946-4fa0-b8d6-d7e82781e70a_SNES - Mega Man X - Weapons and Items.png', 'PSICOLOGIA_CLINICA', 'Psicologia Clínica');


INSERT INTO Usuario (nome, email, senha, telefone, cpf)
VALUES ('Carlos Souza', 'carlos.souza@email.com', 'senha456', '11998765432', '234.567.890-11');

INSERT INTO Profissional (formacao, experiencia, sobre, id, cnpj, registroProfissional, arquivoCurriculo, arquivoFoto, arquivoCertificado, especialidade, especialidadeDescricao)
VALUES ('Fisioterapeuta', '10 anos de experiência com fisioterapia desportiva', 'Fisioterapeuta especializado em reabilitação de atletas', 2, '23.456.789/0001-01', '67890', 'a443148b-fe5e-48b0-852d-f547490c72f4_2024-12-05 18-05-30.mkv', 'fe209d40-f67f-4728-a843-3ad2aa61d5c2_medico2.jpg', 'c2597cf8-149a-46a7-b011-d488f18a7f60_2024-12-05 18-07-46.mkv', 'FISIOTERAPIA_DESPORTIVA', 'Fisioterapia Desportiva');


INSERT INTO Usuario (nome, email, senha, telefone, cpf)
VALUES ('Juliana Costa', 'juliana.costa@email.com', 'senha789', '11999887766', '345.678.901-22');

INSERT INTO Cliente (id, preferencias, arquivoFoto)
VALUES (3, 'Prefere atendimento psicológico online, com foco em desenvolvimento pessoal.', 'fe209d40-f67f-4728-a843-3ad2aa61d5c2_medico2.jpg');


INSERT INTO Endereco (id, rua, numero, bairro, cidade, estado, cep)
VALUES (1, 'Rua da Paz', '123', 'Centro', 'Guanambi', 'Bahia', '46430-000');


INSERT INTO Endereco (id, rua, numero, bairro, cidade, estado, cep)
VALUES (2, 'Avenida Brasil', '456', 'Jardim das Flores', 'Candiba', 'Bahia', '46360-000');
