-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 27, 2012 at 09:11 AM
-- Server version: 5.5.20
-- PHP Version: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `proyectofinal`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `idCategory` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) NOT NULL,
  PRIMARY KEY (`idCategory`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`idCategory`, `category`) VALUES
(13, 'celulares'),
(3, 'papeleria'),
(6, 'videojuegos'),
(14, 'computadoras'),
(12, 'perros'),
(11, 'gatos');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `idcustomer` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `company` varchar(30) NOT NULL,
  `address` varchar(60) NOT NULL,
  `city` varchar(80) NOT NULL,
  `phone` varchar(10) NOT NULL,
  PRIMARY KEY (`idcustomer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`idcustomer`, `nombre`, `company`, `address`, `city`, `phone`) VALUES
(2, 'Jorge', 'Coca Cola', 'siempre via 123', 'Mty', '88118882');

-- --------------------------------------------------------

--
-- Table structure for table `inventario`
--

CREATE TABLE IF NOT EXISTS `inventario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iditem` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `inventario`
--

INSERT INTO `inventario` (`id`, `iditem`, `name`, `quantity`) VALUES
(1, 7, 'gato rockstar', 5);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `idItem` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `idCategory` int(5) NOT NULL,
  `departamento` enum('electronica','mascotas','') DEFAULT NULL,
  PRIMARY KEY (`idItem`),
  KEY `idCategory` (`idCategory`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`idItem`, `name`, `description`, `price`, `quantity`, `idCategory`, `departamento`) VALUES
(1, 'laptop', 'Computadora marca ASUS', 5799, 19, 14, 'electronica'),
(2, 'celular', 'Celular marca Samsung SIII', 8999, 15, 13, 'electronica'),
(3, 'lapiz', 'Lapiz marca lapiz', 4, 586, 3, NULL),
(4, 'playstation 3', 'Consola para video juegos con la más alta calidad en gráficos', 4999, 7, 6, 'electronica'),
(5, 'perro', 'Perro marca pastor aleman', 2200, 2, 12, 'mascotas'),
(6, 'gato caguamas', 'Gato caguamero', 889, 3, 11, 'mascotas'),
(7, 'gato rockstar', 'Gato edicion rockstar 2009', 1350, 5, 11, 'mascotas'),
(8, 'xbox 360', 'consola', 2999, 3, 6, NULL),
(9, 'ps vita', 'consola portatil', 5900, 10, 6, NULL),
(10, 'diablo III', 'Juego RPG de PC', 800, 30, 6, NULL),
(11, 'The Darkness II', 'Juego para PS3', 699, 24, 6, NULL),
(12, 'The Elder Scrolls: Skyrim', 'Juego para PC, PS3 y 360', 499, 12, 6, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `itemnotsold`
--

CREATE TABLE IF NOT EXISTS `itemnotsold` (
  `idItemsold` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `idItem` int(11) NOT NULL,
  `idsale` int(11) NOT NULL,
  PRIMARY KEY (`idItemsold`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `itemnotsold`
--

INSERT INTO `itemnotsold` (`idItemsold`, `quantity`, `idItem`, `idsale`) VALUES
(1, 1, 6, 5),
(2, -1, 2, 12),
(3, 1, 2, 13),
(4, 1, 6, 17);

-- --------------------------------------------------------

--
-- Table structure for table `itemsold`
--

CREATE TABLE IF NOT EXISTS `itemsold` (
  `idItemSold` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `idItem` int(11) NOT NULL,
  `idSale` int(11) NOT NULL,
  PRIMARY KEY (`idItemSold`),
  KEY `idItem` (`idItem`),
  KEY `idSale` (`idSale`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `itemsold`
--

INSERT INTO `itemsold` (`idItemSold`, `quantity`, `idItem`, `idSale`) VALUES
(1, 4, 1, 1),
(2, 5, 2, 2),
(3, 2, 3, 3),
(4, 1, 6, 4),
(5, 1, 4, 4),
(6, 1, 2, 6),
(7, 1, 2, 7),
(8, 1, 2, 8),
(9, 1, 3, 9),
(10, 1, 3, 10),
(11, 1, 3, 11),
(12, 2, 2, 14),
(13, 1, 1, 15),
(14, 1, 4, 16),
(15, 1, 3, 18);

-- --------------------------------------------------------

--
-- Table structure for table `returneditem`
--

CREATE TABLE IF NOT EXISTS `returneditem` (
  `idreturnedItem` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `idItem` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`idreturnedItem`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `returneditem`
--

INSERT INTO `returneditem` (`idreturnedItem`, `quantity`, `idItem`, `date`) VALUES
(1, -1, 6, '2012-06-26'),
(2, -1, 2, '2012-06-26'),
(3, -1, 3, '2012-06-26'),
(4, -1, 2, '2012-06-26'),
(5, -1, 2, '2012-06-26'),
(6, -1, 2, '2012-06-26'),
(7, -2, 2, '2012-06-26'),
(8, -3, 2, '2012-06-26'),
(9, -1, 2, '2012-06-26'),
(10, -1, 4, '2012-06-27');

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE IF NOT EXISTS `sale` (
  `idSale` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `idUser` int(11) NOT NULL,
  `idcustomer` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`idSale`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`idSale`, `date`, `idUser`, `idcustomer`, `total`) VALUES
(1, '2012-06-26', 2, 0, 154),
(2, '2012-06-26', 2, 2, 12),
(3, '2012-06-26', 3, 2, 8),
(4, '2012-06-26', 3, 2, 5243),
(5, '2012-06-26', 3, 2, 0),
(6, '2012-06-26', 3, 2, 1000),
(7, '2012-06-26', 3, 2, 1000),
(8, '2012-06-26', 3, 2, 1000),
(9, '2012-06-26', 3, 2, 4),
(10, '2012-06-26', 3, 2, 4),
(11, '2012-06-26', 3, 2, 4),
(12, '2012-06-26', 3, 2, 0),
(13, '2012-06-26', 3, 2, 0),
(14, '2012-06-26', 3, 2, 2000),
(15, '2012-06-27', 6, 2, 5799),
(16, '2012-06-27', 6, 2, 4999),
(17, '2012-06-27', 6, 2, 0),
(18, '2012-06-27', 6, 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `type` enum('administrador','gerenteDeVentas','gerenteDeInventario','vendedor') NOT NULL DEFAULT 'vendedor',
  `status` enum('disponible','bloqueado') NOT NULL DEFAULT 'disponible',
  `hits` int(11) NOT NULL DEFAULT '0',
  `attempts` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `username`, `password`, `email`, `type`, `status`, `hits`, `attempts`) VALUES
(1, 'jorge', '123', 'a01033317@itesm.mx', 'administrador', 'disponible', 66, 1),
(2, 'alex', '123', 'a00803199@itesm.mx', 'vendedor', 'disponible', 13, 1),
(3, 'joab', '123', 'a00508885@itesm.mx', 'gerenteDeVentas', 'bloqueado', 3, 9),
(4, 'joab2', '123', 'maildejoab@gmail.com', 'gerenteDeVentas', 'disponible', 0, 0),
(5, 'admin', 'admin', 'jasfjka@faklsnfa.com', 'administrador', 'disponible', 78, 0),
(6, 'vendedor', '123', 'ventas@gmail.com', 'vendedor', 'disponible', 47, 1),
(7, 'gerenteventas', '123', 'gerenteventas@gmail.com', 'gerenteDeVentas', 'disponible', 27, 1),
(8, 'inventario', '123', 'fanksfkasnrfsa@kjafnfjksnskbp.com', 'gerenteDeInventario', 'disponible', 38, 1),
(10, 'jessica', '123', 'jessica@gmail.com', 'gerenteDeInventario', 'disponible', 1, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
