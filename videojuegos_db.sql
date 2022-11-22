create database videojuegos_db;
use videojuegos_db;

CREATE TABLE `videojuegos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `lanzamiento` int(11) NOT NULL,
  `editora` varchar(20) NOT NULL,
  `plataforma` varchar(20) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `ventasAmerica` float(11) NOT NULL,
  `ventasEuropa` float(11) NOT NULL,
  `ventasJapon` float(11) NOT NULL,
  `ventasOtros` float(11) NOT NULL,
  `ventasGlobal` float(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1