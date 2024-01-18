
INSERT INTO autor (name, last_name, nationality) VALUES ('Edgar Allan', 'Poe', 'Estados Unidos');
INSERT INTO autor (name, last_name, nationality) VALUES ('Jane', 'Austen', 'Reino Unido');
INSERT INTO autor (name, last_name, nationality) VALUES ('Miguel', 'De Crevantes', 'España');
INSERT INTO autor (name, last_name, nationality) VALUES ('Paulo', 'Coelho', 'Brasil');
INSERT INTO autor (name, last_name, nationality) VALUES ('Gabriel', 'García Márquez', 'Colombia-Mexico');

INSERT INTO categoria (name) VALUES ('Literatura');
INSERT INTO categoria (name) VALUES ('Consulta');
INSERT INTO categoria (name) VALUES ('Divulgativos');
INSERT INTO categoria (name) VALUES ('Técnico');
INSERT INTO categoria (name) VALUES ('Ilustrado');
INSERT INTO categoria (name) VALUES ('Infantil');

INSERT INTO editorial (name, address) VALUES ('Penguin House','Nueva York, EUA.');
INSERT INTO editorial (name, address) VALUES ('Faber & Faber','Londres, Inglaterra.');
INSERT INTO editorial (name, address) VALUES ('Alfaguara','Madrid, España.');
INSERT INTO editorial (name, address) VALUES ('Penguin Clasics','Nueva York, EUA.');
INSERT INTO editorial (name, address) VALUES ('Cátedra','Madrid, España.');
INSERT INTO editorial (name, address) VALUES ('Diana','CDMX, México.');

INSERT INTO libro (pages, units, id_autor, id_categoria, id_editorial, isbn, title) VALUES (208, 15, 4, 1, 1, '6073199449', 'El alquimista');
INSERT INTO libro (pages, units, id_autor, id_categoria, id_editorial, isbn, title) VALUES (464, 20, 5, 1, 6, '6070728793', 'Cien años de soledad');
INSERT INTO libro (pages, units, id_autor, id_categoria, id_editorial, isbn, title) VALUES (224, 05, 3, 1, 4, '6073144539', 'Don Quijote de la Mancha');
INSERT INTO libro (pages, units, id_autor, id_categoria, id_editorial, isbn, title) VALUES (448, 10, 2, 5, 2, '8415618786', 'Orgullo y prejuicio');
INSERT INTO libro (pages, units, id_autor, id_categoria, id_editorial, isbn, title) VALUES (5, 05, 1, 1, 1, 'XXXXXXXXXX', 'El cuervo');

INSERT INTO socio (name, last_name, address) VALUES ('Alvaro','Osorio','Huiloapan, Ver.');
INSERT INTO socio (name, last_name, address) VALUES ('Itzel','Limon','Rio Blanco, Ver.');
INSERT INTO socio (name, last_name, address) VALUES ('Jose','Suarez','Nogales, Ver.');

INSERT INTO prestamo (id_libro, id_socio, loan_date, return_date) VALUES (3, 1, '15-01-2024', '20-01-2024');
