CREATE USER IF NOT EXISTS 'CITSIM22_03'@'localhost' IDENTIFIED BY '12345';
GRANT ALL PRIVILEGES ON * . * TO 'CITSIM22_03'@'localhost';
drop database if exists upmClassroom;
create database upmClassroom;
use upmClassroom;

CREATE TABLE Usuario (
    dni VARCHAR(9) PRIMARY KEY,
	nombre VARCHAR(50),
	primer_apellido VARCHAR(50),
    segundo_apellido VARCHAR(50),
    correo VARCHAR(50),
    contrasenya VARCHAR(50)
);

CREATE TABLE Aula (
	id INT PRIMARY KEY auto_increment,
	nombre_centro VARCHAR(50),
	superficie INT,
    aforo INT,
    tipo_aula  VARCHAR(50)
);

CREATE TABLE UsuarioSuscritoAula (
	id INT PRIMARY KEY auto_increment,
    dni VARCHAR(9),
	idAula INT
);

CREATE TABLE Alumno (
    dni VARCHAR(9),
    num_matricula VARCHAR(6),
	PRIMARY KEY(num_matricula),
    FOREIGN KEY(dni) REFERENCES Usuario(dni)
);

CREATE TABLE PDI (
    dni VARCHAR(9),
    codigo_trabajador VARCHAR(50),
    categoria  VARCHAR(50),
	PRIMARY KEY(codigo_trabajador),
    FOREIGN KEY(dni) REFERENCES Usuario(dni)
);

CREATE TABLE PAS (
    dni VARCHAR(9),
    codigo_persona VARCHAR(50),
    anyo_incorporacion INT,
	PRIMARY KEY(codigo_persona),
    FOREIGN KEY(dni) REFERENCES Usuario(dni)
);

INSERT INTO Usuario(dni, nombre, primer_apellido, segundo_apellido, correo, contrasenya) VALUES 
("00000000A", "Maria", "Rosetta", "Fermosa", "mariaFermosa@alumnos.upm.es", "2d05e80b9b2bb6aaaf273c957e8c18b3"),
("11111111B", "Pedro", "Quesadilla", "Intolerante", "pedreteDelPueblo@upm.es", "2d05e80b9b2bb6aaaf273c957e8c18b3"),
("22222222C", "Rosita", "Pesada", "Cebollina", "cebollinaRosita@upm.es", "2d05e80b9b2bb6aaaf273c957e8c18b3"),
("33333333D", "Clara", "Liviana", "Ajito", "ajitoclaro@alumnos.upm.es", "2d05e80b9b2bb6aaaf273c957e8c18b3"),
("44444444E", "Pipo", "Capo", "Cabagge", "pipovive14@upm.es", "2d05e80b9b2bb6aaaf273c957e8c18b3"),
("55555555K", "Kia", "Romero", "Soles", "kiaDeCuenca@upm.es", "2d05e80b9b2bb6aaaf273c957e8c18b3");

INSERT INTO Aula(nombre_centro, superficie, aforo, tipo_aula) VALUES 
("IES Santa Cruz", 45, 24, "Laboratorio"),
("IES Santa Cruz", 45, 24, "Mixta"),
("IES Santa Cruz", 45, 24, "Laboratorio"),
("IES Santa Cruz", 50, 30, "Laboratorio");

INSERT INTO UsuarioSuscritoAula (dni, idAula) VALUES
("00000000A", 1), ("00000000A", 2), ("00000000A", 3), ("00000000A", 4), ("11111111B", 2), ("11111111B", 4), ("33333333D", 1), ("44444444E", 4);

INSERT INTO Alumno (dni, num_matricula) VALUES
("00000000A", "br0214"),
("33333333D", "bq2314");

INSERT INTO PDI (dni, codigo_trabajador, categoria) VALUES
("11111111B", "AAAAAAA", "AYUDANTE"),
("44444444E", "BBBBBBB", "PROFESOR_TITULAR");

INSERT INTO PAS (dni, codigo_persona, anyo_incorporacion) VALUES
("22222222C", "CCCCCCC", 2020),
("55555555K", "DDDDDDD", 2019);