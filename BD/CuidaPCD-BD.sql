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
);

