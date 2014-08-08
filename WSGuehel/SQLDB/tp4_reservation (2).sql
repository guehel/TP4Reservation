-- phpMyAdmin SQL Dump
-- version 4.0.2
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 08 Août 2014 à 09:09
-- Version du serveur: 5.6.11-log
-- Version de PHP: 5.3.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `tp4_reservation`
--
CREATE DATABASE IF NOT EXISTS `tp4_reservation` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `tp4_reservation`;

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE IF NOT EXISTS `chambre` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `chambre`
--

INSERT INTO `chambre` (`numero`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nom` (`nom`,`prenom`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`) VALUES
(2, 'Antonio', 'Jackson'),
(1, 'Bouanga', 'Guehel'),
(3, 'El kassir', 'Nawar'),
(4, 'Escobar', 'Pablo');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `idReservation` int(11) NOT NULL AUTO_INCREMENT,
  `arrivee` date DEFAULT NULL,
  `sejour` int(11) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `dateCreation` date DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idReservation`,`numero`),
  KEY `FK_Reservation_numero` (`numero`),
  KEY `FK_Reservation_id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `reservation`
--

INSERT INTO `reservation` (`idReservation`, `arrivee`, `sejour`, `numero`, `dateCreation`, `id`) VALUES
(1, NULL, NULL, 1, NULL, NULL);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK_Reservation_id` FOREIGN KEY (`id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FK_Reservation_numero` FOREIGN KEY (`numero`) REFERENCES `chambre` (`numero`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
