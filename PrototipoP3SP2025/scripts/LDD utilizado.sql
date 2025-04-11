CREATE SCHEMA IF NOT EXISTS `hoteles` DEFAULT CHARACTER SET utf8 ;
USE `hoteles` ;

CREATE TABLE IF NOT EXISTS habitaciones(
    codigo_habitaciones VARCHAR(10),
    nombre_habitaciones VARCHAR(20),
    checkin_habitaciones VARCHAR(1),
    PRIMARY KEY (codigo_habitaciones)) 
ENGINE = INNODB CHARACTER SET = LATIN1; 

CREATE TABLE IF NOT EXISTS empleados(
    codigo_empleados VARCHAR(10),
    nombre_empleados VARCHAR(20),
    puesto_empleados VARCHAR(20),
    estatus_empleados VARCHAR(1),
    PRIMARY KEY (codigo_empleados))
ENGINE = INNODB CHARSET =latin1;

CREATE TABLE IF NOT EXISTS clientes(
    codigo_clientes VARCHAR(10),
    nombre_clientes VARCHAR(20),
    estatus_clientes VARCHAR(1),
    PRIMARY KEY (codigo_clientes))
ENGINE = INNODB CHARACTER SET = LATIN1; 

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

INSERT INTO usuario (id_usuario, username, password) 
VALUES (2026, 'admin', SHA2('12345', 256));

CREATE TABLE `bitacora` (
  `id_bitacora` int auto_increment,
  `id_usuario` int(11) NOT NULL,
  `id_aplicacion` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `ip` varchar(45) DEFAULT NULL,
  `accion` varchar(50) DEFAULT NULL,
  `nombre_pc` varchar(50) DEFAULT NULL,
  primary key (id_bitacora)
) ENGINE = InnoDB DEFAULT CHARSET=latin1;
