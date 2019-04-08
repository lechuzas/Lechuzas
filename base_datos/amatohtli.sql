
-- Creación de la tabla usuario --
CREATE TABLE usuario(
correo text NOT NULL PRIMARY KEY,
contrasenia text NOT NULL,
nombre_usuario text NOT NULL,
nombre text,
paterno text,
rol integer);



-- Creación de la tabla calificación --
CREATE TABLE calificacion(
id_calificacion serial NOT NULL PRIMARY KEY,
puntaje integer NOT NULL,
correo text NOT NULL,
FOREIGN KEY (correo) REFERENCES usuario(correo));

-- Creación del catálogo color --
CREATE TABLE cat_color(
id_color serial NOT NULL PRIMARY KEY,
descripcion text NOT NULL);

-- Creación de la tabla Tema --
CREATE TABLE tema(
id_tema serial NOT NULL PRIMARY KEY,
correo text NOT NULL ,
nombre_tema text UNIQUE,
id_color integer UNIQUE,
FOREIGN KEY (correo) REFERENCES usuario(correo),
FOREIGN KEY (id_color) REFERENCES cat_color(id_color));

-- Creación de la tabla marcador --
CREATE TABLE marcador(
id_marcador serial NOT NULL PRIMARY KEY,
id_tema integer NOT NULL,
id_color integer NOT NULL,
latitud double precision NOT NULL,
longitud double precision NOT NULL,
descripcion text,
FOREIGN KEY (id_tema) REFERENCES tema(id_tema),
FOREIGN KEY (id_color) REFERENCES tema(id_color));

-- Creación de la tabla comentario --
CREATE TABLE comentario(
id_comentario serial NOT NULL PRIMARY KEY,
id_marcador integer NOT NULL,
correo text NOT NULL,
descripcion text NOT NULL,
id_calificacion integer,
FOREIGN KEY (id_marcador) REFERENCES marcador(id_marcador),
FOREIGN KEY (correo) REFERENCES usuario(correo),
FOREIGN KEY (id_calificacion) REFERENCES calificacion(id_calificacion));


