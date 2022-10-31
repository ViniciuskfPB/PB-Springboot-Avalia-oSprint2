Cod Sql
-----------------------------------------------------------------------
-Questão 1
CREATE DATABASE produtoscadastro;
USE produtoscadastro;

CREATE TABLE PRODUTO (
     id int NOT NULL AUTO_INCREMENT,
     nome VARCHAR(100),
     descricao VARCHAR(200),
     quantidade INT,
     preco FLOAT,
     PRIMARY KEY (id)
);

SELECT * from produto
-----------------------------------------------------------------------
-Questão 2
CREATE DATABASE listaFilmes;
USE listaFilmes;

CREATE TABLE filmes (
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100),
    descricao VARCHAR(200),
    ano YEAR,
    PRIMARY KEY (id)
);
insert into...
