
CREATE TABLE PUBLIC.Empleado(
	dni INTEGER NOT NULL,
	nombre VARCHAR(50),
	apellido1 VARCHAR(50),
	apellido2 VARCHAR(50),
	PRIMARY KEY (dni)
)

CREATE TABLE PUBLIC.Fichaje(
	dni INTEGER NOT NULL,
	fecha DATE NOT NULL,
	hora TIME NOT NULL,
	esEntrada BOOLEAN NOT NULL,	
	esSalida BOOLEAN NOT NULL
)

ALTER TABLE Fichaje ADD PRIMARY KEY (dni,fecha,hora); 
ALTER TABLE Fichaje ADD FOREIGN KEY (dni) REFERENCES Empleado(dni);


INSERT INTO Empleado (dni,nombre,apellido1,apellido2) VALUES ('47495861', 'Francisco', 'Parada', 'Lopez'); 
INSERT INTO Empleado (dni,nombre,apellido1,apellido2) VALUES ('50930795', 'Irene', 'Montes', 'Franco'); 
INSERT INTO Empleado (dni,nombre,apellido1,apellido2) VALUES ('78787878', 'Mario', 'Carbajo', 'Cuadrado'); 

commit;

INSERT INTO Fichaje (dni, fecha, hora, esEntrada, esSalida) VALUES ('47495861', parseDateTime('20/12/2018','dd/MM/yyyy'),'08:00:00', true, false); 
INSERT INTO Fichaje (dni, fecha, hora, esEntrada, esSalida) VALUES ('47495861', parseDateTime('20/12/2018','dd/MM/yyyy'),'15:00:00', false, true); 
INSERT INTO Fichaje (dni, fecha, hora, esEntrada, esSalida) VALUES ('47495861', parseDateTime('20/12/2018','dd/MM/yyyy'),'16:00:00', true, false); 
INSERT INTO Fichaje (dni, fecha, hora, esEntrada, esSalida) VALUES ('47495861', parseDateTime('20/12/2018','dd/MM/yyyy'),'17:30:00', false, true); 


commit;

