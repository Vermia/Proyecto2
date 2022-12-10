drop database if exists videojuegos_db;
create database videojuegos_db;
use videojuegos_db;

CREATE TABLE `videojuegos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(1000) NOT NULL,
  `lanzamiento` int(11) NOT NULL,
  `editora` varchar(100) NOT NULL,
  `plataforma` varchar(100) NOT NULL,
  `genero` varchar(100) NOT NULL,
  `ventasamerica` float(11) NOT NULL,
  `ventaseuropa` float(11) NOT NULL,
  `ventasjapon` float(11) NOT NULL,
  `ventasotros` float(11) NOT NULL,
  `ventasglobal` float(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3