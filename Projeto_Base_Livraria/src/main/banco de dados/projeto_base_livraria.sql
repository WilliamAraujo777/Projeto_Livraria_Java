-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.18-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para bco_projetobase
CREATE DATABASE IF NOT EXISTS `bco_projetobase` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bco_projetobase`;

-- Copiando estrutura para tabela bco_projetobase.tbl_assuntos
CREATE TABLE IF NOT EXISTS `tbl_assuntos` (
  `IdAssunto` smallint(4) NOT NULL AUTO_INCREMENT,
  `Assunto` varchar(25) NOT NULL,
  PRIMARY KEY (`IdAssunto`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela bco_projetobase.tbl_assuntos: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `tbl_assuntos` DISABLE KEYS */;
INSERT INTO `tbl_assuntos` (`IdAssunto`, `Assunto`) VALUES
	(1, 'Ficção'),
	(2, 'Biologia'),
	(3, 'Eletrônica'),
	(4, 'Matemática'),
	(5, 'Aventura'),
	(6, 'Literatura'),
	(7, 'Informática'),
	(8, 'Suspense');
/*!40000 ALTER TABLE `tbl_assuntos` ENABLE KEYS */;

-- Copiando estrutura para tabela bco_projetobase.tbl_autores
CREATE TABLE IF NOT EXISTS `tbl_autores` (
  `IdAutor` smallint(6) NOT NULL AUTO_INCREMENT,
  `NomeAutor` varchar(50) NOT NULL,
  `SobrenomeAutor` varchar(60) NOT NULL,
  PRIMARY KEY (`IdAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela bco_projetobase.tbl_autores: ~19 rows (aproximadamente)
/*!40000 ALTER TABLE `tbl_autores` DISABLE KEYS */;
INSERT INTO `tbl_autores` (`IdAutor`, `NomeAutor`, `SobrenomeAutor`) VALUES
	(1, 'Daniel', 'Barret'),
	(2, 'Gerald', 'Carter'),
	(3, 'Mark', 'Sobell'),
	(4, 'William', 'Stanek'),
	(5, 'Richard', 'Blum'),
	(6, 'Christine', 'Bresnahan'),
	(7, 'Richard', 'Silverman'),
	(8, 'Robert', 'Byrnes'),
	(9, 'Jay', 'Ts'),
	(10, 'Robert', 'Eckstein'),
	(11, 'Paul', 'Horowitz'),
	(12, 'Winfield', 'Hill'),
	(13, 'Joel', 'Murach'),
	(14, 'Paul', 'Scherz'),
	(15, 'Simon', 'Monk'),
	(16, 'Kahney', 'Leander'),
	(17, 'J. R. R.', 'Tolkien'),
	(18, 'Rob', 'Kidd'),
	(19, 'Markus', 'Zusak');
/*!40000 ALTER TABLE `tbl_autores` ENABLE KEYS */;

-- Copiando estrutura para tabela bco_projetobase.tbl_editoras
CREATE TABLE IF NOT EXISTS `tbl_editoras` (
  `IdEditora` smallint(6) NOT NULL AUTO_INCREMENT,
  `NomeEditora` varchar(50) NOT NULL,
  PRIMARY KEY (`IdEditora`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela bco_projetobase.tbl_editoras: ~15 rows (aproximadamente)
/*!40000 ALTER TABLE `tbl_editoras` DISABLE KEYS */;
INSERT INTO `tbl_editoras` (`IdEditora`, `NomeEditora`) VALUES
	(1, 'Prentice Hall'),
	(2, 'O´Reilly'),
	(3, 'Microsoft Press'),
	(4, 'Wiley'),
	(5, 'Mc Graw Hill'),
	(6, 'Bookman'),
	(7, 'Novatec'),
	(8, 'Apress'),
	(9, 'Sybex'),
	(10, 'Mike Murach and Associates'),
	(12, 'Martins Fontes'),
	(13, 'Agir'),
	(14, 'Melhoramentos'),
	(15, 'Intrínseca'),
	(16, 'Coração');
/*!40000 ALTER TABLE `tbl_editoras` ENABLE KEYS */;

-- Copiando estrutura para tabela bco_projetobase.tbl_livros
CREATE TABLE IF NOT EXISTS `tbl_livros` (
  `idLivro` smallint(6) NOT NULL AUTO_INCREMENT,
  `nomeLivro` varchar(70) NOT NULL,
  `ISBN13` varchar(13) NOT NULL,
  `dataPub` date DEFAULT NULL,
  `precoLivro` decimal(10,2) NOT NULL,
  `numeroPaginas` smallint(6) NOT NULL,
  `idEditora` smallint(4) NOT NULL,
  `idAssunto` smallint(4) NOT NULL,
  PRIMARY KEY (`idLivro`),
  KEY `fk_id_editora` (`idEditora`),
  KEY `fk_id_assunto` (`idAssunto`),
  CONSTRAINT `fk_id_assunto` FOREIGN KEY (`idAssunto`) REFERENCES `tbl_assuntos` (`IdAssunto`),
  CONSTRAINT `fk_id_editora` FOREIGN KEY (`idEditora`) REFERENCES `tbl_editoras` (`IdEditora`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela bco_projetobase.tbl_livros: ~12 rows (aproximadamente)
/*!40000 ALTER TABLE `tbl_livros` DISABLE KEYS */;
INSERT INTO `tbl_livros` (`idLivro`, `nomeLivro`, `ISBN13`, `dataPub`, `precoLivro`, `numeroPaginas`, `idEditora`, `idAssunto`) VALUES
	(1, 'Linux Command Line and Shell Scripting', '9781118983843', '2015-01-09', 165.55, 816, 4, 7),
	(2, 'SSH, o Shell Seguro', '9780596008956', '2005-05-17', 373.88, 672, 2, 7),
	(3, 'Using Samba', '9780596002565', '2003-12-21', 200.94, 449, 2, 7),
	(4, 'A Arte da Eletrônica', '9788582604342', '2017-03-08', 176.71, 1160, 6, 7),
	(5, 'Windows Server 2012 Inside Out', '9780735666313', '2013-01-25', 179.51, 1584, 3, 7),
	(6, 'Murach´s MySQL', '9781943872367', '2019-05-01', 237.64, 650, 10, 7),
	(7, 'Practical Electronics for Inventors', '9781259587542', '2016-07-11', 119.58, 1056, 5, 3),
	(8, 'O senhor dos anéis', '9788533613409', '2001-01-01', 49.90, 1211, 12, 1),
	(9, 'a menina que roubava livros', '9788598078175', '2007-02-14', 26.89, 480, 15, 1),
	(10, 'O Hobbit', '9788595084742', '2019-07-15', 39.29, 336, 12, 1),
	(11, 'Piratas Do Caribe - Jack Sparrow: Uma Tempestade Se Aproxima', '9788506050422', '2007-01-01', 49.00, 120, 14, 1),
	(12, 'A cabeça de steve jobs', '9788522009770', '2008-10-30', 69.60, 304, 12, 7);
/*!40000 ALTER TABLE `tbl_livros` ENABLE KEYS */;

-- Copiando estrutura para tabela bco_projetobase.tbl_livrosautores
CREATE TABLE IF NOT EXISTS `tbl_livrosautores` (
  `idLivro` smallint(6) NOT NULL,
  `idAutor` smallint(6) NOT NULL,
  PRIMARY KEY (`idLivro`,`idAutor`),
  KEY `fk_id_autor` (`idAutor`),
  CONSTRAINT `fk_id_autor` FOREIGN KEY (`idAutor`) REFERENCES `tbl_autores` (`IdAutor`),
  CONSTRAINT `fk_id_livros` FOREIGN KEY (`idLivro`) REFERENCES `tbl_livros` (`idLivro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela bco_projetobase.tbl_livrosautores: ~19 rows (aproximadamente)
/*!40000 ALTER TABLE `tbl_livrosautores` DISABLE KEYS */;
INSERT INTO `tbl_livrosautores` (`idLivro`, `idAutor`) VALUES
	(1, 5),
	(1, 6),
	(2, 1),
	(2, 7),
	(2, 8),
	(3, 2),
	(3, 9),
	(3, 10),
	(4, 11),
	(4, 12),
	(5, 4),
	(6, 13),
	(7, 14),
	(7, 15),
	(8, 17),
	(9, 19),
	(10, 17),
	(11, 18),
	(12, 16);
/*!40000 ALTER TABLE `tbl_livrosautores` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
