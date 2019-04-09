----------------------------------------------------------------------------------------- USUARIO ------------------------------------------------------------------------------------------
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('pwharin0@nps.gov', 'SNbzVUJrUh2b', 'pwharin0', 'Pepi', 'Wharin', 1);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('tpadginton1@foxnews.com', 'hEtuoSec5M', 'tpadginton1', 'Tedman', 'Padginton', 2);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('nkerry2@princeton.edu', 'Aul8h0', 'nkerry2', 'Neila', 'Kerry', 1);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('gwallington3@webmd.com', '7XWAUxgbK', 'gwallington3', 'Gerrilee', 'Wallington', 1);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('belwood4@ft.com', 'bYDsSxosWyOr', 'belwood4', 'Bondie', 'Elwood', 2);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('glemmens5@sourceforge.net', '0v3Xzsf1AC', 'glemmens5', 'Godiva', 'Lemmens', 2);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('hterlinden6@archive.org', 'qhCxKJHmTv', 'hterlinden6', 'Herman', 'Terlinden', 1);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('stredgold7@google.ru', '4bR1Q9KL', 'stredgold7', 'Seumas', 'Tredgold', 2);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('jhadingham8@indiatimes.com', 'k1KvnNlaQ', 'jhadingham8', 'Jacinthe', 'Hadingham', 1);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('ored9@stanford.edu', 'sIJfl3O1U', 'ored9', 'Otto', 'Red', 2);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('ainklea@rambler.ru', 'sZKndWVD', 'ainklea', 'Adelice', 'Inkle', 1);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('dmephanb@businessinsider.com', 'Md3ApHVM9Etn', 'dmephanb', 'Derron', 'Mephan', 2);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('vnowlandc@addthis.com', 'flloRzp7JrxL', 'vnowlandc', 'Vilhelmina', 'Nowland', 2);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('pletherburyd@eepurl.com', 'n8PpiHWE', 'pletherburyd', 'Phillis', 'Letherbury', 1);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('daizikove@engadget.com', 'vdbf2ZJIF', 'daizikove', 'Domingo', 'Aizikov', 1);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('ailyn@gmail.com', 'ailyn12051998', 'ailynrp12', 'Ailyn', 'Rebollar', 2);

--------------------- CAT COLOR ------------------------
insert into cat_color (descripcion) values ('#69dc00');
insert into cat_color (descripcion) values ('#d603db');
insert into cat_color (descripcion) values ('#48b63b');
insert into cat_color (descripcion) values ('#2cac22');
insert into cat_color (descripcion) values ('#1c451e');
insert into cat_color (descripcion) values ('#f18592');
insert into cat_color (descripcion) values ('#0a7719');
insert into cat_color (descripcion) values ('#cfda3c');
insert into cat_color (descripcion) values ('#92c188');
insert into cat_color (descripcion) values ('#ce0535');
insert into cat_color (descripcion) values ('#f72bb6');
insert into cat_color (descripcion) values ('#d4eb2c');
insert into cat_color (descripcion) values ('#7c1529');
insert into cat_color (descripcion) values ('#6cf45f');
insert into cat_color (descripcion) values ('#fa36bc');
insert into cat_color (descripcion) values ('#4E5FCE');

------------------------------------------------------- TEMA ------------------------------------------------------------

insert into tema (correo,nombre_tema,id_color) values('ailyn@gmail.com', 'Villas Navideñas', 2);


------------------------------------------------------------- MARCADOR -----------------------------------------------------------------------
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (2,2,23.382390,-102.291477,'Villa iluminada de Atlixco, Puebla');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (2,2,20.672087,-103.414486,'La Luz de la Navidad, Zapopan');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (2,2,32.545175,-115.345638,'Villa Navideña, Mexicali');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (2,2,19.267831,-90.252865,'Gran Feria Navideña Sobre Hielo, Campeche');



------------------ CALIFICACION -------------------------
insert into calificacion (puntaje,correo) values (1,'pwharin0@nps.gov');
insert into calificacion (puntaje,correo) values (2,'tpadginton1@foxnews.com');
insert into calificacion (puntaje,correo) values (3,'nkerry2@princeton.edu');
insert into calificacion (puntaje,correo) values (4,'gwallington3@webmd.com');
insert into calificacion (puntaje,correo) values (5,'belwood4@ft.com');
insert into calificacion (puntaje,correo) values (1,'glemmens5@sourceforge.net');
insert into calificacion (puntaje,correo) values (2,'hterlinden6@archive.org');
insert into calificacion (puntaje,correo) values (3,'stredgold7@google.ru');
insert into calificacion (puntaje,correo) values (4,'jhadingham8@indiatimes.com');
insert into calificacion (puntaje,correo) values (5,'ored9@stanford.edu');
insert into calificacion (puntaje,correo) values (1,'ainklea@rambler.ru');
insert into calificacion (puntaje,correo) values (2,'dmephanb@businessinsider.com');
insert into calificacion (puntaje,correo) values (3,'vnowlandc@addthis.com');
insert into calificacion (puntaje,correo) values (4,'pletherburyd@eepurl.com');
insert into calificacion (puntaje,correo) values (5,'daizikove@engadget.com');

---------------------------------------------------------- COMENTARIO --------------------------------------------------------------------------
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (1,'pwharin0@nps.gov','comentario_1',1);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (2,'tpadginton1@foxnews.com','comentario_2',2);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (3,'nkerry2@princeton.edu','comentario_3',3);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (4,'gwallington3@webmd.com','comentario_4',4);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (5,'belwood4@ft.com','comentario_5',5);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (6,'glemmens5@sourceforge.net','comentario_6',6);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (7,'hterlinden6@archive.org','comentario_7',7);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (8,'stredgold7@google.ru','comentario_8',8);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (9,'jhadingham8@indiatimes.com','comentario_9',9);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (10,'ored9@stanford.edu','comentario_10',10);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (11,'ainklea@rambler.ru','comentario_11',11);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (12,'dmephanb@businessinsider.com','comentario_12',12);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (13,'vnowlandc@addthis.com','comentario_13',13);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (14,'pletherburyd@eepurl.com','comentario_14',14);
insert into comentario(id_marcador,correo,descripcion,id_calificacion) values (15,'daizikove@engadget.com','comentario_15',15);
