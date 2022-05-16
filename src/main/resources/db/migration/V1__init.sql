CREATE TABLE IF NOT EXISTS profesor(
   id SERIAL,
   nombre VARCHAR (100) NOT NULL,
   materia VARCHAR (100) NULL,
   PRIMARY KEY (id)
   );

CREATE TABLE IF NOT EXISTS alumno(
  id SERIAL,
  name VARCHAR (100) NOT NULL,
  materias VARCHAR (100) NULL,
  asistencias INT  NOT NULL,
  profesor_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(profesor_id) references profesor(id)
  );



CREATE TABLE IF NOT EXISTS representante(
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,

  PRIMARY KEY (id)
  );