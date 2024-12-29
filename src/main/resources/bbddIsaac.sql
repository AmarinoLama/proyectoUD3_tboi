DROP DATABASE IF EXISTS TBOI_BBDD;
CREATE DATABASE IF NOT EXISTS TBOI_BBDD;

USE TBOI_BBDD;

-- Tabla base para personajes
CREATE TABLE Personajes (
    id_personaje INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(500),
    salud_base INT NOT NULL,
    dano_base FLOAT NOT NULL
);

-- Tabla de objetos genérica
CREATE TABLE Objetos (
    id_objeto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    efecto TEXT
);

-- Herencia: Objetos pasivos
CREATE TABLE ObjetosPasivos (
    id_objeto INT PRIMARY KEY,
    mejora_dano FLOAT,
    mejora_salud INT,
    mejora_velocidad FLOAT,
    mejora_lagrimas FLOAT,
    mejora_rango FLOAT,
    mejora_velocidad_proyectil FLOAT,
    mejora_suerte INT,
    FOREIGN KEY (id_objeto) REFERENCES Objetos(id_objeto)
);

-- Herencia: Objetos activos
CREATE TABLE ObjetosActivos (
    id_objeto INT PRIMARY KEY,
    tiempo_recarga INT,
    FOREIGN KEY (id_objeto) REFERENCES Objetos(id_objeto)
);

-- Herencia: Consumibles (runas, cartas, etc.)
CREATE TABLE Consumibles (
    id_objeto INT PRIMARY KEY,
    duracion_efecto INT,
    FOREIGN KEY (id_objeto) REFERENCES Objetos(id_objeto)
);

-- Modificación de la tabla Habitaciones para eliminar relación con Pisos
CREATE TABLE Habitaciones (
    id_habitacion INT PRIMARY KEY AUTO_INCREMENT,
    tipo_habitacion ENUM('Normal', 'Tesoro', 'Jefe', 'Secreta', 'Super Secreta', 'Ultra Secreta', 'Tienda', 'Angelical', 'Demoniaca', 'Sacrificio', 'Planetario', 'Biblioteca') NOT NULL
);

-- Relación entre personajes y objetos (objetos recogidos)
CREATE TABLE PersonajeObjetos (
    id_personaje INT,
    id_objeto INT,
    PRIMARY KEY (id_personaje, id_objeto),
    FOREIGN KEY (id_personaje) REFERENCES Personajes(id_personaje),
    FOREIGN KEY (id_objeto) REFERENCES Objetos(id_objeto)
);

-- Tabla Pools
CREATE TABLE Pools (
    id_pool INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    id_habitacion INT NOT NULL,
    FOREIGN KEY (id_habitacion) REFERENCES Habitaciones(id_habitacion)
);

-- Tabla intermedia para la relación Muchos a Muchos entre Pools y Objetos
CREATE TABLE PoolObjetos (
    id_pool INT,
    id_objeto INT,
    PRIMARY KEY (id_pool, id_objeto),
    FOREIGN KEY (id_pool) REFERENCES Pools(id_pool),
    FOREIGN KEY (id_objeto) REFERENCES Objetos(id_objeto)
);

-- Inserts para la tabla Objetos
INSERT INTO Objetos (id_objeto, nombre, efecto) VALUES
(1, 'Brimstone', 'Permite disparar un rayo láser de sangre cargado que atraviesa enemigos.'),
(2, 'The Book of Belial', 'Aumenta el daño temporalmente al activarse.'),
(3, 'The Fool Card', 'Te transporta de vuelta a la sala de inicio del piso actual.'),
(4, 'Magic Mushroom', 'Incrementa todas las estadísticas y proporciona un corazón adicional.'),
(5, 'The D6', 'Permite volver a tirar los objetos en las salas de tesoro y otros lugares.'),
(6, 'Polyphemus', 'Aumenta masivamente el daño pero reduce la velocidad de disparo.'),
(7, 'The Halo', 'Incrementa todas las estadísticas de manera moderada.'),
(8, 'Dead Cat', 'Te da 9 vidas pero reduce tus corazones a 1.'),
(9, 'Epic Fetus', 'Sustituye tus lágrimas por un misil guiado por un cursor.'),
(10, 'Sacred Heart', 'Aumenta enormemente el daño y da un efecto de persecución a tus lágrimas.'),
(11, 'Dr. Fetus', 'Sustituye tus lágrimas por bombas que pueden ser disparadas.'),
(12, 'Holy Mantle', 'Bloquea el primer golpe que recibas en cada habitación.'),
(13, 'Pyromaniac', 'Convierte el daño de explosión en curación y te vuelve inmune a explosiones.'),
(14, 'Tech X', 'Permite disparar anillos láser cargados que atraviesan enemigos.'),
(15, 'Ansuz', 'Revela el mapa completo del piso actual.'),
(16, 'Pretty Fly', 'Genera una mosca orbital que bloquea proyectiles enemigos.');

-- Inserts para la tabla ObjetosPasivos
INSERT INTO ObjetosPasivos (id_objeto, mejora_dano, mejora_salud, mejora_velocidad, mejora_lagrimas, mejora_rango, mejora_velocidad_proyectil, mejora_suerte) VALUES
(1, 2.0, 0, 0.0, 0.0, 0.0, 0.0, 0),
(4, 1.0, 1, 0.2, 0.2, 0.5, 0.2, 1),
(6, 5.0, 0, -0.2, -0.5, 0.0, 0.0, 0),
(7, 0.5, 1, 0.1, 0.1, 0.2, 0.1, 1),
(10, 2.3, 0, -0.15, 0.0, 0.0, 0.0, 0),
(12, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0),
(13, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0);

-- Inserts para la tabla ObjetosActivos
INSERT INTO ObjetosActivos (id_objeto, tiempo_recarga) VALUES
(2, 3),
(5, 2),
(9, 0);

-- Inserts para la tabla Consumibles
INSERT INTO Consumibles (id_objeto, duracion_efecto) VALUES
(3, 0),
(15, 0),
(16, 0);

-- Inserts para la tabla Habitaciones
INSERT INTO Habitaciones (id_habitacion, tipo_habitacion) VALUES
(1, 'Normal'),
(2, 'Tesoro'),
(3, 'Jefe'),
(4, 'Secreta'),
(5, 'Super Secreta'),
(6, 'Tienda'),
(7, 'Angelical'),
(8, 'Demoniaca'),
(9, 'Sacrificio'),
(10, 'Planetario'),
(11, 'Biblioteca');

-- Inserts para la tabla Pools
INSERT INTO Pools (id_pool, nombre, id_habitacion) VALUES
(1, 'Pool de Tesoro', 2),
(2, 'Pool de Jefe', 3),
(3, 'Pool de Tienda', 6),
(4, 'Pool de Ángel', 7),
(5, 'Pool de Demonio', 8);

-- Inserts para la tabla PoolObjetos
INSERT INTO PoolObjetos (id_pool, id_objeto) VALUES
(1, 1),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(2, 2),
(2, 10),
(3, 9),
(3, 13),
(4, 12),
(4, 14),
(5, 8),
(5, 10);
