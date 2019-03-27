--CREATE DATABASE "amatohtli";

-- Creación de la tabla Usuario -- 
CREATE TABLE "usuario"(
correo text NOT NULL,
contrasenia text NOT NULL,
nombre_usuario text NOT NULL,
nombre text,
paterno text,
rol integer,
PRIMARY KEY(correo));

-- Creación de la tabla Tema --
CREATE TABLE "tema"(
id_tema serial NOT NULL,
correo text NOT NULL,
nombre_tema text,
id_color integer,
CONSTRAINT "id_tema_u" UNIQUE(id_tema),
CONSTRAINT "correo_u" UNIQUE(nombre_tema),
CONSTRAINT "id_color_u" UNIQUE(id_color),
CONSTRAINT "id_tema_pkey" PRIMARY KEY(id_tema));

-- Creación del catálogo color --
CREATE TABLE "cat_color"(
id_color serial NOT NULL,
descripcion text NOT NULL,
CONSTRAINT "id_color_u" UNIQUE(id_color),
CONSTRAINT "id_color_pkey" PRIMARY KEY(id_color));

-- Creación de la tabla marcador --
CREATE TABLE "marcador"(
id_marcador serial NOT NULL,
id_tema integer NOT NULL,
id_color integer NOT NULL,
latitud double precision NOT NULL,
longitud double precision NOT NULL,
descripcion text,
CONSTRAINT "id_marcador_u" UNIQUE(id_marcador),
CONSTRAINT "id_marcador_pkey" PRIMARY KEY(id_marcador));


-- Creación de la tabla comentario --
CREATE TABLE "comentario"(
id_comentario serial NOT NULL,
id_marcador integer NOT NULL,
correo text NOT NULL,
descripcion text NOT NULL,
id_calificacion integer,
CONSTRAINT "id_comentario_u" UNIQUE(id_comentario),
CONSTRAINT "id_comentario_pkey" PRIMARY KEY(id_comentario));

-- Creación de la tabla calificación --
CREATE TABLE "calificacion"(
id_calificacion integer NOT NULL,
puntaje integer NOT NULL,
correo text NOT NULL,
CONSTRAINT "id_calificacion_u" UNIQUE(id_calificacion),
CONSTRAINT "puntaje_u" UNIQUE(puntaje));

-- Creación de las llaves foráneas -- 
ALTER TABLE "tema" ADD CONSTRAINT "fk_correo"
FOREIGN KEY (correo) REFERENCES "usuario"(correo)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "tema" ADD CONSTRAINT "fk_color"
FOREIGN KEY (id_color) REFERENCES "cat_color" (id_color)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "marcador" ADD CONSTRAINT "fk_tema"
FOREIGN KEY (id_tema) REFERENCES "tema" (id_tema)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "marcador" ADD CONSTRAINT "fk_color"
FOREIGN KEY (id_color) REFERENCES "tema" (id_color)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "comentario" ADD CONSTRAINT "fk_marcador"
FOREIGN KEY (id_marcador) REFERENCES "marcador" (id_marcador)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "comentario" ADD CONSTRAINT "fk_correo"
FOREIGN KEY (correo) REFERENCES "usuario" (correo)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "comentario" ADD CONSTRAINT "fk_calificacion"
FOREIGN KEY (id_calificacion) REFERENCES "calificacion" (id_calificacion)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "calificacion" ADD CONSTRAINT "fk_correo"
FOREIGN KEY (correo) REFERENCES "usuario" (correo)
ON DELETE CASCADE ON UPDATE CASCADE;

