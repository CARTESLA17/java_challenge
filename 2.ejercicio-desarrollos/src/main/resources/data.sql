INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('AR','ARGENTINA', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('BR','BRASIL', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('UY','URUGUAY', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('CH','CHILE', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

CREATE TABLE IF NOT EXISTS tipo_persona (
  id int(11) NOT NULL,
  descripcion varchar(50) NOT NULL,
  version_number int(11) NOT NULL,
  creation_timestamp date NOT NULL,
  modification_timestamp date NOT NULL,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;

INSERT INTO tipo_persona (id, descripcion,creation_timestamp, modification_timestamp, version_number)
VALUES (1,'Fisica', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

INSERT INTO tipo_persona (id, descripcion,creation_timestamp, modification_timestamp, version_number)
VALUES (2,'Juridica', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

CREATE TABLE IF NOT EXISTS titular ( 
  id int NOT NULL auto_increment,
  tipo_Persona int(1) NOT NULL,
  nombre varchar(80) NULL,
  apellido varchar(250) NULL,
  dni int(20) NULL,
  razon_Social varchar(100) NULL,
  year int(4) NULL,
  cuit int(20)NOT NULL,
  version_number int(11) NOT NULL auto_increment,
  creation_timestamp date NOT NULL,
  modification_timestamp date NOT NULL,
  PRIMARY KEY (id),  
) DEFAULT CHARSET=utf8;

ALTER TABLE titular
ADD CONSTRAINT CUIT_UNIQUE
UNIQUE ( cuit );

ALTER TABLE titular
ADD FOREIGN KEY (tipo_Persona) 
REFERENCES tipo_Persona(id);

INSERT INTO titular (tipo_Persona,nombre, apellido, dni, CUIT,creation_timestamp, modification_timestamp, version_number)
VALUES (1,'Pepito', 'Perez',2233,1234,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

INSERT INTO titular (tipo_Persona,razon_Social, year, CUIT,creation_timestamp, modification_timestamp, version_number)
VALUES (2,'Galletas tod', 1998,1235,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

INSERT INTO titular (tipo_Persona,razon_Social, year, CUIT,creation_timestamp, modification_timestamp, version_number)
VALUES (2,'Panecitos', 2004, 1111,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

INSERT INTO titular (tipo_Persona,razon_Social, year, CUIT,creation_timestamp, modification_timestamp, version_number)
VALUES (2,'Chocolates', 2007, 5544,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

CREATE TABLE IF NOT EXISTS tipo_movimiento(
  id INT NOT NULL,
  descripcion VARCHAR(10) NOT NULL,
  version_number int(11) NOT NULL,
  creation_timestamp date NOT NULL,
  modification_timestamp date NOT NULL,
  PRIMARY KEY(ID),
)DEFAULT CHARSET=utf8;

INSERT INTO tipo_movimiento (id, descripcion, version_number,creation_timestamp, modification_timestamp)
VALUES (1,'DEBITO', 1,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO tipo_movimiento (id, descripcion, version_number,creation_timestamp, modification_timestamp)
VALUES (2,'CREDITO', 1,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

CREATE TABLE IF NOT EXISTS moneda(
  id INT NOT NULL,
  descripcion VARCHAR(10) NOT NULL,
  version_number int(11) NOT NULL,
  creation_timestamp date NOT NULL,
  modification_timestamp date NOT NULL,
PRIMARY KEY(ID),
)DEFAULT CHARSET=utf8;

INSERT INTO moneda(id,descripcion,creation_timestamp, modification_timestamp, version_number) 
VALUES (1,'PESOS',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

INSERT INTO moneda(id,descripcion,creation_timestamp, modification_timestamp, version_number)
VALUES (2,'DOLARES',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

INSERT INTO moneda(id,descripcion,creation_timestamp, modification_timestamp, version_number)
VALUES (3,'EUROS',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

CREATE TABLE IF NOT EXISTS cuenta(
  id int NOT NULL AUTO_INCREMENT,
  moneda INT NOT NULL,  
  saldo DECIMAL(20,2) NOT NULL,
  titular INT NOT NULL,
  version_number int(11) NOT NULL,
  creation_timestamp date NOT NULL,
  modification_timestamp date NOT NULL,
  PRIMARY KEY(ID), 
)DEFAULT CHARSET=utf8;

ALTER TABLE cuenta
ADD FOREIGN KEY (moneda) 
REFERENCES moneda(id);

ALTER TABLE cuenta
ADD FOREIGN KEY (titular) 
REFERENCES titular(id);

INSERT INTO cuenta(moneda, saldo, titular, creation_timestamp, modification_timestamp, version_number)
VALUES (1, 10.00, 1,CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

INSERT INTO cuenta(moneda, saldo, titular, creation_timestamp, modification_timestamp, version_number)
VALUES (2, 345.00, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

INSERT INTO cuenta(moneda, saldo, titular, creation_timestamp, modification_timestamp, version_number)
VALUES (3, 200.00, 4, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),1);

CREATE TABLE IF NOT EXISTS movimientos(
	id int NOT NULL AUTO_INCREMENT,
	fecha DATE NOT NULL,
	descripcion VARCHAR(200) NOT NULL,
	importe DECIMAL(20,2) NOT NULL,
	cuenta int NOT NULL,
	tipo_movimiento INT NOT NULL,
	version_number int(11) NOT NULL,
    creation_timestamp date NOT NULL,
    modification_timestamp date NOT NULL,
	PRIMARY KEY(ID),
)DEFAULT CHARSET = UTF8;

ALTER TABLE movimientos
ADD FOREIGN KEY (cuenta) 
REFERENCES cuenta(id);





	

	
	


	
	
		


