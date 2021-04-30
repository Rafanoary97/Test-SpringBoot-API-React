-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 30 avr. 2021 à 06:43
-- Version du serveur :  8.0.21
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cars`
--

-- --------------------------------------------------------

--
-- Structure de la table `cars`
--

DROP TABLE IF EXISTS `cars`;
CREATE TABLE IF NOT EXISTS `cars` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_comment` bigint DEFAULT NULL,
  `image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `text_head` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cars`
--

INSERT INTO `cars` (`id`, `id_comment`, `image`, `text_head`) VALUES
(10, 0, 'https://blog.vivacar.fr/wp-content/uploads/2019/07/lamborghini-huracan-1.webp', 'Car 3'),
(9, 0, 'https://www.levif.be/medias/11186/5727495.jpg', 'Car 2'),
(5, 0, 'https://www.challenges.fr/assets/img/2018/08/27/cover-r4x3w1000-5b84072224873-pbc18-conference-09-jpg.jpg', 'Car 1');

-- --------------------------------------------------------

--
-- Structure de la table `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE IF NOT EXISTS `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_image` bigint DEFAULT NULL,
  `id_user` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `post_comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `comments`
--

INSERT INTO `comments` (`id`, `id_image`, `id_user`, `name`, `post_comment`) VALUES
(1, 6, 2, 'rafanoary', 'belle voiture !'),
(3, 6, 2, 'rafanoary', 'holla !'),
(4, 5, 2, 'rafanoary', 'belle voiture !'),
(5, 10, 2, 'rafanoary', 'woahh top!!'),
(6, 9, 2, 'rafanoary', 'Petite voiture'),
(10, 5, 2, 'rafanoary', 'ca marche'),
(11, 9, 9, 'Rafanoary Daniela', 'Bonjour!');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` bigint DEFAULT NULL,
  `session` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `email`, `name`, `password`, `session`) VALUES
(2, 'rafanoarynirinadaniela@gmail.com', 'rafanoary', 123456789, b'0'),
(5, 'nirinadaniela97@gmail.com', 'dani', 9999910, b'0'),
(9, 'tk@gmail.com', 'Rafanoary Daniela', 123456789, b'0');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
