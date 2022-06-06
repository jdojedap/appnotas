CREATE TABLE IF NOT EXISTS profesor(
   id SERIAL,
   nombre VARCHAR (100) NOT NULL,
   materia VARCHAR (100) NULL,
   PRIMARY KEY (id)
   );
CREATE TABLE IF NOT EXISTS representante(
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE IF NOT EXISTS usuario(
  id SERIAL,
  username VARCHAR (100) NOT NULL,
  password VARCHAR (100) NOT NULL,
  materias VARCHAR (100) NULL,
  asistencias INT  NOT NULL,
  profesor_id INT NOT NULL,
  representante_id INT NOT NULL,
  PRIMARY KEY (id)
  FOREIGN KEY(profesor_id) references profesor(id),
  FOREIGN KEY (representante_id) references representante(id)
);

CREATE TABLE IF NOT EXISTS alumno(
  id SERIAL,
  name VARCHAR (100) NOT NULL,
  materias VARCHAR (100) NULL,
  asistencias INT  NOT NULL,
  profesor_id INT NOT NULL,
  representante_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(profesor_id) references profesor(id),
  FOREIGN KEY (representante_id) references representante(id)
  );





