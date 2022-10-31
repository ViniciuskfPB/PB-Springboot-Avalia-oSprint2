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

insert into filmes (nome, descricao, ano) VALUES ('Batman', 'Filme Batman', '1992');
insert into filmes (nome, descricao, ano) VALUES ('Batman Forever', 'Filme Batman Forever', '1995');
insert into filmes (nome, descricao, ano) VALUES ('Batman e Robin', 'Filme Batman e Robin ', '1997');
insert into filmes (nome, descricao, ano) VALUES ('Batman Begins', 'Filme Batman Begins', '2005');
insert into filmes (nome, descricao, ano) VALUES ('The Dark Knight', 'The Dark Knight', '2008');
insert into filmes (nome, descricao, ano) VALUES ('The Dark Knight Rises', 'Filme The Dark Knight Rises', '2012');
insert into filmes (nome, descricao, ano) VALUES ('Capitão América: O Primeiro Vingador', 'Filme Capitão América: O Primeiro Vingador', '2011');
insert into filmes (nome, descricao, ano) VALUES ('The Avengers', 'Filme The Avengers', '2012');
insert into filmes (nome, descricao, ano) VALUES ('Iron Man 3', 'Filme Iron Man 3', '2013');
insert into filmes (nome, descricao, ano) VALUES ('Thor: The Dark World', 'Filme Thor: The Dark World', '2013');
insert into filmes (nome, descricao, ano) VALUES ('Ant-Man', 'Filme Ant-Man', '2015');
insert into filmes (nome, descricao, ano) VALUES ('Doctor Strange', 'Filme Doctor Strange', '2016');
insert into filmes (nome, descricao, ano) VALUES ('Thor: Ragnarok', 'Filme Thor: Ragnarok', '2017');
insert into filmes (nome, descricao, ano) VALUES ('Captain Marvel', 'Filme Captain Marvel', '2019');
insert into filmes (nome, descricao, ano) VALUES ('Eternals', 'Filme Eternals', '2021');
insert into filmes (nome, descricao, ano) VALUES ('Spider-Man: Homecoming', 'Filme Spider-Man: Homecoming', '2017');
insert into filmes (nome, descricao, ano) VALUES ('Matrix', 'Filme Matrix', '1999');
insert into filmes (nome, descricao, ano) VALUES ('Coringa', 'Filme Coringa', '2019');
insert into filmes (nome, descricao, ano) VALUES ('Adão Negro', 'Filme Adão Negro', '2022');
insert into filmes (nome, descricao, ano) VALUES ('Aquaman', 'Filme Aquaman', '2018');
