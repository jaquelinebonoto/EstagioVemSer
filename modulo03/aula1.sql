CREATE TABLE PAIS(
    IDPAIS NUMBER(38,0) NOT NULL PRIMARY KEY,
    NOMEPAIS VARCHAR2(50) NOT NULL,
    SIGLAPAIS VARCHAR2(3)
);
SELECT * FROM PAIS;

CREATE SEQUENCE PAIS_SEQ
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE TABLE ESTADO (
  IDESTADO NUMBER(38, 0) NOT NULL PRIMARY KEY,
  NOMEESTADO VARCHAR2(50) NOT NULL,
  ESTADOSIGLA VARCHAR2(3),
  FK_IDPAIS NUMBER(38,0)
);
ALTER TABLE ESTADO ADD FOREIGN KEY (FK_IDPAIS) REFERENCES PAIS(IDPAIS) ON DELETE CASCADE;

CREATE SEQUENCE ESTADO_SEQ
 START WITH     10
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

SELECT * FROM ESTADO;
DROP TABLE ESTADO;

CREATE TABLE CIDADE (
  IDCIDADE NUMBER(38, 0) NOT NULL PRIMARY KEY,
  NOMECIDADE VARCHAR2(50) NOT NULL,
  CIDADESIGLA VARCHAR(3),
  FK_IDESTADO NUMBER(38,0)
);
ALTER TABLE CIDADE ADD FOREIGN KEY (FK_IDESTADO) REFERENCES ESTADO(IDESTADO) ON DELETE CASCADE;

CREATE SEQUENCE CIDADE_SEQ
 START WITH     100
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
SELECT * FROM CIDADE;



INSERT INTO PAIS VALUES(PAIS_SEQ.NEXTVAL, 'BRASIL', 'BR');
INSERT INTO PAIS VALUES(PAIS_SEQ.NEXTVAL, 'ARGENTINA', 'AR');
INSERT INTO PAIS VALUES(PAIS_SEQ.NEXTVAL, 'ALEMANHA', 'DE');
INSERT INTO PAIS VALUES(PAIS_SEQ.NEXTVAL, 'EMIRADOS �RABES', 'EA');

SELECT * FROM PAIS;
DELETE FROM PAIS WHERE IDPAIS=3;


INSERT INTO ESTADO VALUES(ESTADO_SEQ.NEXTVAL, 'RIO GRANDE DO SUL', 'RS', 1);
INSERT INTO ESTADO VALUES(ESTADO_SEQ.NEXTVAL, 'SANTA CATARINA', 'SC', 1);
INSERT INTO ESTADO VALUES(ESTADO_SEQ.NEXTVAL, 'BAHIA', 'BA', 1);
INSERT INTO ESTADO VALUES(ESTADO_SEQ.NEXTVAL, 'CHEMNITZ', 'CH', 3);
INSERT INTO ESTADO VALUES(ESTADO_SEQ.NEXTVAL, 'BUENOS AIRES', 'BA', 2);
SELECT * FROM ESTADO;


 SELECT * FROM ESTADO 
 INNER JOIN PAIS ON ESTADO.FK_IDPAIS = PAIS.IDPAIS
 WHERE IDPAIS = 1;


INSERT INTO CIDADE VALUES(CIDADE_SEQ.NEXTVAL, 'PORTO ALEGRE', 'RS', 10);
INSERT INTO CIDADE VALUES(CIDADE_SEQ.NEXTVAL, 'CACHOEIRINHA', 'RS', 10);
INSERT INTO CIDADE VALUES(CIDADE_SEQ.NEXTVAL, 'CANOAS', 'RS', 10);
INSERT INTO CIDADE VALUES(CIDADE_SEQ.NEXTVAL, 'SANTA CRUZ', 'RS', 10);

SELECT * FROM CIDADE;

COMMIT;
