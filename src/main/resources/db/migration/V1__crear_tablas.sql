-- Archivo: src/main/resources/db/migration/V1__crear_tablas.sql

DROP TABLE IF EXISTS topicos;
DROP TABLE IF EXISTS autores;
DROP TABLE IF EXISTS cursos;

-- Tabla de autores
CREATE TABLE autores (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Tabla de cursos
CREATE TABLE cursos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    categoria VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Tabla de topicos
CREATE TABLE `topicos` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(255) NOT NULL UNIQUE,
    `mensaje` VARCHAR(255) NOT NULL UNIQUE,
    `fecha_creacion` DATETIME(6) NOT NULL,
    `status` VARCHAR(255) NOT NULL,
    `autor_id` BIGINT NOT NULL,
    `curso_id` BIGINT NOT NULL,

    PRIMARY KEY (`id`),
    FOREIGN KEY (`autor_id`) REFERENCES `autores` (`id`),
    FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`)
);
