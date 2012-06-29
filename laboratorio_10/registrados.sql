-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 23, 2012 at 12:34 p.m.
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `usuarios`
--

-- --------------------------------------------------------

--
-- Table structure for table `registrados`
--

CREATE TABLE IF NOT EXISTS `registrados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `codigo` varchar(15) NOT NULL,
  `ciudad` varchar(20) NOT NULL,
  `hijos` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

--
-- Dumping data for table `registrados`
--

INSERT INTO `registrados` (`id`, `nombre`, `apellido`, `direccion`, `codigo`, `ciudad`, `hijos`, `email`) VALUES
(1, 'Lucho', 'Perez', 'G. Sada 2501', '23245', 'Monterrey', 2, 'luis.perez@itesm.mx'),
(2, 'Pablo', 'Lopez', 'Blanco Encalada 100', '12345', 'Santiago', 6, 'plopez@itesm.mx');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
