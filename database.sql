-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Jeu 22 Avril 2021 à 12:34
-- Version du serveur: 5.1.36
-- Version de PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `agence_voyage`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE IF NOT EXISTS `adresse` (
  `idAdresse` int(11) NOT NULL AUTO_INCREMENT,
  `pays` varchar(100) NOT NULL,
  `province` varchar(100) NOT NULL,
  `commune` varchar(100) NOT NULL,
  `quartier` varchar(100) NOT NULL,
  PRIMARY KEY (`idAdresse`),
  UNIQUE KEY `adr` (`quartier`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `adresse`
--

INSERT INTO `adresse` (`idAdresse`, `pays`, `province`, `commune`, `quartier`) VALUES
(1, 'RDC', 'SUD-KIVU', 'IBANDA', 'NDENDERE'),
(2, 'RDC', 'SUD-KIVU', 'KADUTU', 'NYAMUGO'),
(3, 'BURUNDI', 'BUJUMBURA', 'NTA', 'KINAMA'),
(4, 'BURUNDI', 'BUJUMBURA', 'URU', 'NGOZI');

-- --------------------------------------------------------

--
-- Structure de la table `agences`
--

CREATE TABLE IF NOT EXISTS `agences` (
  `idagence` int(11) NOT NULL AUTO_INCREMENT,
  `idAdresse` int(11) NOT NULL,
  `nom_agence` varchar(50) NOT NULL,
  `telephone` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idagence`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `agences`
--


-- --------------------------------------------------------

--
-- Structure de la table `agence_personnel`
--

CREATE TABLE IF NOT EXISTS `agence_personnel` (
  `idAgence_employe` int(11) NOT NULL AUTO_INCREMENT,
  `idagence` int(11) NOT NULL,
  `idpersonnel` int(11) NOT NULL,
  `date_affectation` date NOT NULL,
  PRIMARY KEY (`idAgence_employe`),
  KEY `ap_a` (`idagence`),
  KEY `ap_pers` (`idpersonnel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `agence_personnel`
--


-- --------------------------------------------------------

--
-- Structure de la table `colis`
--

CREATE TABLE IF NOT EXISTS `colis` (
  `idcolis` int(11) NOT NULL AUTO_INCREMENT,
  `idvehicule` int(11) NOT NULL,
  `idpersonnel` int(11) NOT NULL,
  `idpersonne` int(11) NOT NULL,
  `nature_colis` varchar(20) NOT NULL,
  `nature_emballage` varchar(20) NOT NULL,
  `Poids` float NOT NULL,
  `quantite` float NOT NULL,
  `prix` float NOT NULL,
  PRIMARY KEY (`idcolis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `colis`
--


-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE IF NOT EXISTS `compte` (
  `idcompte` int(11) NOT NULL AUTO_INCREMENT,
  `idpersonnel` int(11) NOT NULL,
  `mot_passe` varchar(10) NOT NULL,
  PRIMARY KEY (`idcompte`),
  KEY `c_pers` (`idpersonnel`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`idcompte`, `idpersonnel`, `mot_passe`) VALUES
(1, 1, '1234'),
(2, 2, '12345');

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `idcourse` int(11) NOT NULL AUTO_INCREMENT,
  `idvoyage` int(11) NOT NULL,
  `heure_depart` time NOT NULL,
  `heure_arrivee` time DEFAULT NULL,
  PRIMARY KEY (`idcourse`),
  KEY `cours_voy` (`idvoyage`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `course`
--


-- --------------------------------------------------------

--
-- Structure de la table `fonction`
--

CREATE TABLE IF NOT EXISTS `fonction` (
  `idfonction` int(11) NOT NULL AUTO_INCREMENT,
  `nom_fonction` varchar(10) NOT NULL,
  `salaire` float NOT NULL,
  PRIMARY KEY (`idfonction`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `fonction`
--

INSERT INTO `fonction` (`idfonction`, `nom_fonction`, `salaire`) VALUES
(1, 'DG', 50000),
(2, 'SECRETAIRE', 30000),
(3, 'CHAUFFEUR', 20000);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `idpersonne` int(11) NOT NULL AUTO_INCREMENT,
  `idAdresse` int(11) NOT NULL,
  `nom` varchar(10) NOT NULL,
  `prenom` varchar(10) DEFAULT NULL,
  `sexe` varchar(10) NOT NULL,
  `CNI` varchar(10) DEFAULT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idpersonne`),
  UNIQUE KEY `perso` (`CNI`),
  KEY `perso_adr` (`idAdresse`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`idpersonne`, `idAdresse`, `nom`, `prenom`, `sexe`, `CNI`, `telephone`) VALUES
(1, 1, 'EDOUARD', 'MIHONA', 'M', 'C12358', '68500468'),
(2, 3, 'HEKIMA', 'DIVIN', 'M', 'D45866', '6856665'),
(3, 4, 'JOLIE', 'FRANCINE', 'F', 'H38588', '558855'),
(4, 1, 'Faida', 'Mush', 'F', 'Cn12365', '8652255'),
(5, 1, 'Fabrice', 'Jean', 'M', 'C4555', '55888558');

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE IF NOT EXISTS `personnel` (
  `idpersonnel` int(11) NOT NULL AUTO_INCREMENT,
  `idpersonne` int(11) NOT NULL,
  `matricule` varchar(10) NOT NULL,
  PRIMARY KEY (`idpersonnel`),
  UNIQUE KEY `pers` (`matricule`),
  KEY `pers_perso` (`idpersonne`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `personnel`
--

INSERT INTO `personnel` (`idpersonnel`, `idpersonne`, `matricule`) VALUES
(1, 1, 'E001'),
(2, 2, 'D002');

-- --------------------------------------------------------

--
-- Structure de la table `personnel_fonction`
--

CREATE TABLE IF NOT EXISTS `personnel_fonction` (
  `idpersonnel_fonction` int(11) NOT NULL AUTO_INCREMENT,
  `idpersonnel` int(11) NOT NULL,
  `idfonction` int(11) NOT NULL,
  `date_entree` date NOT NULL,
  `date_sortie` date DEFAULT NULL,
  PRIMARY KEY (`idpersonnel_fonction`),
  KEY `pers_fonc` (`idpersonnel`),
  KEY `pers_fonc_fonc` (`idfonction`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `personnel_fonction`
--

INSERT INTO `personnel_fonction` (`idpersonnel_fonction`, `idpersonnel`, `idfonction`, `date_entree`, `date_sortie`) VALUES
(1, 1, 1, '2021-01-01', NULL),
(2, 2, 2, '2021-01-01', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `programme`
--

CREATE TABLE IF NOT EXISTS `programme` (
  `idprogramme` int(11) NOT NULL AUTO_INCREMENT,
  `date_p` date DEFAULT NULL,
  `heure_p` time DEFAULT NULL,
  `ville_depart` varchar(50) NOT NULL,
  `ville_arrivee` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idprogramme`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `programme`
--


-- --------------------------------------------------------

--
-- Structure de la table `programme_personnel`
--

CREATE TABLE IF NOT EXISTS `programme_personnel` (
  `idprogramme_personnel` int(11) NOT NULL AUTO_INCREMENT,
  `idprogramme` int(11) NOT NULL,
  `idpersonnel` int(11) NOT NULL,
  PRIMARY KEY (`idprogramme_personnel`),
  KEY `pr_pers` (`idpersonnel`),
  KEY `pers_pr` (`idprogramme`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `programme_personnel`
--


-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `idreservation` int(11) NOT NULL AUTO_INCREMENT,
  `idpersonne` int(11) NOT NULL,
  `nb_place_reservee` int(20) DEFAULT NULL,
  `prix` float NOT NULL,
  PRIMARY KEY (`idreservation`),
  KEY `r_pers` (`idpersonne`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `reservation`
--

INSERT INTO `reservation` (`idreservation`, `idpersonne`, `nb_place_reservee`, `prix`) VALUES
(1, 1, 3, 30),
(2, 2, 1, 10),
(3, 3, 1, 10);

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE IF NOT EXISTS `vehicule` (
  `idvehicule` int(11) NOT NULL AUTO_INCREMENT,
  `marque` varchar(10) NOT NULL,
  `immatricule` varchar(10) NOT NULL,
  `nombre_place` int(10) NOT NULL,
  PRIMARY KEY (`idvehicule`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `vehicule`
--

INSERT INTO `vehicule` (`idvehicule`, `marque`, `immatricule`, `nombre_place`) VALUES
(1, 'HIACE', 'B123', 18),
(2, 'HIACE', 'B12', 18),
(3, 'PROBOX', 'V12', 7);

-- --------------------------------------------------------

--
-- Structure de la table `vehicule_programme`
--

CREATE TABLE IF NOT EXISTS `vehicule_programme` (
  `idvehicule_programme` int(11) NOT NULL AUTO_INCREMENT,
  `idvehicule` int(11) NOT NULL,
  `idprogramme` int(11) NOT NULL,
  `nombre_place` int(10) NOT NULL,
  PRIMARY KEY (`idvehicule_programme`),
  KEY `pr_pr` (`idprogramme`),
  KEY `pr_v` (`idvehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `vehicule_programme`
--


-- --------------------------------------------------------

--
-- Structure de la table `voyage`
--

CREATE TABLE IF NOT EXISTS `voyage` (
  `idvoyage` int(11) NOT NULL AUTO_INCREMENT,
  `idprogramme` int(11) NOT NULL,
  `idreservation` int(11) NOT NULL,
  `num_empl` int(11) DEFAULT NULL,
  PRIMARY KEY (`idvoyage`),
  KEY `voy_prg` (`idprogramme`),
  KEY `res_vy` (`idreservation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `voyage`
--


--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `agence_personnel`
--
ALTER TABLE `agence_personnel`
  ADD CONSTRAINT `ap_a` FOREIGN KEY (`idagence`) REFERENCES `agences` (`idagence`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ap_pers` FOREIGN KEY (`idpersonnel`) REFERENCES `personnel` (`idpersonnel`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `c_pers` FOREIGN KEY (`idpersonnel`) REFERENCES `personnel` (`idpersonnel`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `cours_voy` FOREIGN KEY (`idvoyage`) REFERENCES `voyage` (`idvoyage`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `perso_adr` FOREIGN KEY (`idAdresse`) REFERENCES `adresse` (`idAdresse`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD CONSTRAINT `pers_perso` FOREIGN KEY (`idpersonne`) REFERENCES `personne` (`idpersonne`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `personnel_fonction`
--
ALTER TABLE `personnel_fonction`
  ADD CONSTRAINT `pers_fonc` FOREIGN KEY (`idpersonnel`) REFERENCES `personnel` (`idpersonnel`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pers_fonc_fonc` FOREIGN KEY (`idfonction`) REFERENCES `fonction` (`idfonction`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `programme_personnel`
--
ALTER TABLE `programme_personnel`
  ADD CONSTRAINT `pers_pr` FOREIGN KEY (`idprogramme`) REFERENCES `programme` (`idprogramme`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pr_pers` FOREIGN KEY (`idpersonnel`) REFERENCES `personnel` (`idpersonnel`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `r_pers` FOREIGN KEY (`idpersonne`) REFERENCES `personne` (`idpersonne`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `vehicule_programme`
--
ALTER TABLE `vehicule_programme`
  ADD CONSTRAINT `pr_pr` FOREIGN KEY (`idprogramme`) REFERENCES `programme` (`idprogramme`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pr_v` FOREIGN KEY (`idvehicule`) REFERENCES `vehicule` (`idvehicule`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `voyage`
--
ALTER TABLE `voyage`
  ADD CONSTRAINT `res_vy` FOREIGN KEY (`idreservation`) REFERENCES `reservation` (`idreservation`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `voy_prg` FOREIGN KEY (`idprogramme`) REFERENCES `programme` (`idprogramme`) ON DELETE CASCADE ON UPDATE CASCADE;
