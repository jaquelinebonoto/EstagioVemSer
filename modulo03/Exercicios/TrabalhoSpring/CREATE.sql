CREATE TABLE FILME (ID NUMBER NOT NULL PRIMARY KEY , TITULO VARCHAR2(50) NOT NULL, LANCAMENTO DATE, CATEGORIA VARCHAR2(50));
CREATE TABLE MIDIA(ID NUMBER NOT NULL PRIMARY KEY, TIPODEMIDIA VARCHAR2(50) NOT NULL, QUANTIDADE INTEGER);
CREATE TABLE VALOR_MIDIA (ID NUMBER NOT NULL PRIMARY KEY, VALOR DOUBLE, INICIOVIGENCIA DATE, FIMVIGENCIA DATE);
CREATE TABLE CLIENTE (ID NUMBER PRIMARY KEY NOT NULL, NOME VARCHAR2(100), TELEFONE LONG, ENDERECO VARCHAR2(100));
CREATE TABLE ALUGUEL (ID NUMBER PRIMARY KEY NOT NULL, DATASAIDA DATE, DATAPREVISTA DATE, DATARETORNO DATE, MULTA DOUBLE);

ALTER TABLE MIDIA ADD FOREIGN KEY (ID) REFERENCES VALORMIDIA(ID);
ALTER TABLE ALUGUEL ADD FOREIGN KEY (ID) REFERENCES MIDIA(ID);
ALTER TABLE ALUGUEL ADD FOREIGN KEY(ID) REFERENCES CLIENTE(ID);

CREATE SEQUENCE S_FILME;
CREATE SEQUENCE S_MIDIA;
CREATE SEQUENCE S_VALOR_MIDIA;
CREATE SEQUENCE S_CLIENTE;
CREATE SEQUENCE S_ALUGUEL;


DROP TABLE FILME;
DROP TABLE CLIENTE;
DROP TABLE VALORMIDIA;
DROP TABLE ALUGUEL;
DROP TABLE MIDIA;
