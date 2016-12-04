CREATE DATABASE cadastroPJ;
USE cadastroPJ;
CREATE TABLE Representante(
	CodRepresentante INT(11) AUTO_INCREMENT,
	Cpf CHAR(14),
	Nome VARCHAR(30),
	Telefone CHAR(14),
	XDEAD BOOLEAN DEFAULT FALSE,
/*Chave Primária - CodRepresentante*/
	PRIMARY KEY(CodRepresentante)
);

CREATE TABLE PessoaJur (
	CodPessoaJur INT(11) AUTO_INCREMENT,
	CodRepresentante INT(11),/* Representante */
	Cnpj CHAR(18),
	RazaoSocial VARCHAR(30),
	NomeFantasia VARCHAR(30),
	TelefoneDd CHAR(14),
	InscriMunicipal VARCHAR(30),
	InscriEstadual VARCHAR(30),
	Email VARCHAR(30),
	DataConstituicao DATE DEFAULT '1900-01-01',
	Atividades VARCHAR(50),
	GeneroAtividade VARCHAR(30),
	EspecieAtividade VARCHAR(30),
	Cep CHAR(9),
	Numero INT(11),
	Complemento VARCHAR(30),
	Logradouro VARCHAR(30),
	Bairro VARCHAR(30),
	Cidade VARCHAR(30),
	Estado CHAR(2),
	Pais VARCHAR(20),
	XDEAD BOOLEAN DEFAULT FALSE,
/*Chave Primária - CodPessoaJur*/
	PRIMARY KEY(CodPessoaJur),
/*Chave Estrangeira*/
	FOREIGN KEY(CodRepresentante) REFERENCES Representante(CodRepresentante)
);


CREATE TABLE Usuario(
	CodUsuario INT(11) AUTO_INCREMENT,
	Login VARCHAR(20),
	Senha VARCHAR(32),
	XDEAD BOOLEAN DEFAULT FALSE,
/*Chave Primária - CodUsuario*/
	PRIMARY KEY(CodUsuario)
);



/*Inserir Usuarios*/
INSERT INTO Usuario
VALUES (NULL,'admin','202cb962ac59075b964b07152d234b70',FALSE),
(NULL,'adm','202cb962ac59075b964b07152d234b70',FALSE);

/*Inserir Representante*/
INSERT INTO Representante
VALUES (null, '111.111.111-11', 'joaquim', '(11)1111-1111', FALSE),
(null, '222.222.222-22', 'Marcelo Rocha', '(22)2222-2222', FALSE),
(null, '333.333.333-33', 'Heisenberg', '(33)3333-3333', FALSE);

/*Inserir Pessoa Juridica*/
INSERT INTO PessoaJur
VALUES (NULL, 1, '96.362.345/0001-64', 'Razao Social', 'Nome Fantasia', '(12)1234-1234', 'InscriMuniciapal', 'InscriEstadual', 'email@email.com', 
        '2010-11-01', 'Atividades', 'GeneroAtividade', 'EspecieAtividade', '05234-020', 100, 'Estrada das Lagrimas', 'Logradouro', 'Vila Ouro', 'São Paulo',
		'SP', 'Brasil', FALSE),
(NULL, 2, '34.041.258/0001-58', 'Razao 2', 'Nome Fan', '(12)4321-1234', 'InscriMuniciapal', 'InscriEstadual', 'gmail@gmail.com', 
        '2015-10-02', 'Atividades', 'GeneroAtividade', 'EspecieAtividade', '06236-060', 150, 'Estrada das Lagrimas', 'Logradouro', 'Vila Prata', 'São Paulo',
		'SP', 'Brasil', FALSE);
