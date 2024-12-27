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

-- Tabla de enemigos
CREATE TABLE Enemigos (
    id_enemigo INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    salud INT NOT NULL,
    dano FLOAT NOT NULL,
    tipo ENUM('Común', 'Jefe', 'Mini-jefe') NOT NULL
);

-- Tabla de pisos
CREATE TABLE Pisos (
    id_piso INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT
);

-- Modificación de la tabla Habitaciones para relacionarla con Pisos
CREATE TABLE Habitaciones (
    id_habitacion INT PRIMARY KEY AUTO_INCREMENT,
    tipo_habitacion ENUM('Normal', 'Tesoro', 'Jefe', 'Secreta') NOT NULL,
    dificultad INT NOT NULL,
    id_piso INT NOT NULL,
    FOREIGN KEY (id_piso) REFERENCES Pisos(id_piso)
);

-- Relación entre habitaciones y enemigos
CREATE TABLE HabitacionEnemigos (
    id_habitacion INT,
    id_enemigo INT,
    PRIMARY KEY (id_habitacion, id_enemigo),
    FOREIGN KEY (id_habitacion) REFERENCES Habitaciones(id_habitacion),
    FOREIGN KEY (id_enemigo) REFERENCES Enemigos(id_enemigo)
);

-- Relación entre personajes y objetos (objetos recogidos)
CREATE TABLE PersonajeObjetos (
    id_personaje INT,
    id_objeto INT,
    PRIMARY KEY (id_personaje, id_objeto),
    FOREIGN KEY (id_personaje) REFERENCES Personajes(id_personaje),
    FOREIGN KEY (id_objeto) REFERENCES Objetos(id_objeto)
);
