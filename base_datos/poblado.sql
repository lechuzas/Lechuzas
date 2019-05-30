----------------------------------------------------------------------------------------- USUARIO ------------------------------------------------------------------------------------------
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('pwharin0@nps.gov', 'SNbzVUJrUh2b', 'pwharin0', 'Pepi', 'Wharin', 1);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('tpadginton1@foxnews.com', 'hEtuoSec5M', 'tpadginton1', 'Tedman', 'Padginton', 2);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('a@a.edu', '1234', 'nkerry2', 'Neila', 'Kerry', 1);
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
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('luna@gmail.com', '123', 'luna97', 'Luna', 'Felipe', 2);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('ailyn@gmail.com', 'ailyn12051998', 'ailynrp12', 'Ailyn', 'Rebollar', 1);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('fernando@vexi.mx', '16011601', 'fernando1601', 'Fernando', 'Bernal', 1);
insert into usuario (correo, contrasenia, nombre_usuario, nombre, paterno, rol) values ('fluna@gmail.com', 'aluna798', 'Aluna23', 'Felipe', 'Luna', 1);


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

------------------------------------------------------- TEMA -----------------------------------------------------------

insert into tema (correo,nombre_tema,id_color) values('ailyn@gmail.com', 'Villas Navideñas', 1);
insert into tema (correo,nombre_tema,id_color) values('luna@gmail.com', 'Parques', 2);
insert into tema (correo,nombre_tema,id_color) values('fernando@vexi.mx', 'Pueblos mágicos', 3);
insert into tema (correo,nombre_tema,id_color) values('fluna@gmail.com', 'Playas mexicanas', 4);

------------------------------------------------------------- MARCADOR -----------------------------------------------------------------------

insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (1,2,23.382390,-102.291477,'Villa iluminada de Atlixco, Puebla');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (1,2,20.672087,-103.414486,'La Luz de la Navidad, Zapopan');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (1,2,32.545175,-115.345638,'Villa Navideña, Mexicali');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (1,2,19.267831,-90.252865,'Gran Feria Navideña Sobre Hielo, Campeche');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (2,3,19.357115,-99.270035,'Parque a la mexicana, CDMX');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (2,3,19.468877,-99.197005,'Parque bicentenario, CDMX');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (2,3,19.352431,-99.142202,'Parque masayoshi ohira, CDMX');


--------------------------- MARCADOR (Fernando) -----------------------------------------------------------------------
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (3,3,16.918273, -96.361418,'Mitla, OAXACA');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (3,3,19.811388, -97.511312,'Tlatlauquitepec, PUEBLA');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (3,3,18.674851, -88.393988,'Bacalar, Quintana Roo');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (3,3,19.5124692,-101.6112934,'Pátzcuaro, Michoacan');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (3,3,21.1571086,-100.9463213,'Dolores Hidalgo, Guanajato');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (3,3,18.987323,-99.1101053,'Tepoztlán, Morelos.');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (3,3,20.2038618,-98.5847642,'Huasca de Ocampo, Hidalgo');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (3,3,20.7385123,-99.9481284,'Bernal, Querétaro.');


--------------------------- MARCADOR (Felipe) -----------------------------------------------------------------------
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (4,4,20.6539376,-87.1419091,'Del Carmen');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (4,4,21.1213284,-86.919446,'Cancún');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (4,4,20.6408575,-105.2947369,'Puerto Vallarta');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (4,4,20.2096191,-87.4894285,'Tulum');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (4,4,19.8305579,-90.6150296,'San Felipe');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (4,4,18.6504452,-91.8335075,'Del C');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (4,4,18.1342154,-94.4980524,'Coatzacoalcos');
insert into marcador (id_tema,id_color,latitud,longitud,descripcion) values (4,4,18.2465024,-94.6472769,'Playa linda');


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
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (1,'pwharin0@nps.gov','comentario_1',1,1234);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (2,'tpadginton1@foxnews.com','comentario_2',2,1232);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (3,'nkerry2@princeton.edu','comentario_3',3,3494);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (4,'gwallington3@webmd.com','comentario_4',4,8498);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (5,'belwood4@ft.com','comentario_5',5,405);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (6,'glemmens5@sourceforge.net','comentario_6',6,8475);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (7,'hterlinden6@archive.org','comentario_7',7,9586);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (1,'stredgold7@google.ru','comentario_8',8,9596);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (1,'jhadingham8@indiatimes.com','comentario_9',9,94575);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (2,'ored9@stanford.edu','comentario_10',10,948);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (3,'ainklea@rambler.ru','comentario_11',11,945);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (4,'dmephanb@businessinsider.com','comentario_12',12,95);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (5,'vnowlandc@addthis.com','comentario_13',13,73);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (6,'pletherburyd@eepurl.com','comentario_14',14,948);
insert into comentario(id_marcador,correo,descripcion,id_calificacion,num_calificaciones) values (7,'daizikove@engadget.com','comentario_15',15,958);
