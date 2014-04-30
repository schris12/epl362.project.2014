-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 22 Απρ 2014 στις 14:00:35
-- Έκδοση διακομιστή: 5.6.16
-- Έκδοση PHP: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Βάση δεδομένων: `362`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `appointments`
--

CREATE TABLE IF NOT EXISTS `appointments` (
  `client_id` varchar(10) NOT NULL,
  `lawyer_id` varchar(10) NOT NULL,
  `date` date NOT NULL,
  `appointment_id` varchar(20) NOT NULL,
  `missed` tinyint(1) NOT NULL,
  `branch_id` varchar(10) NOT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `client_id` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `case`
--

CREATE TABLE IF NOT EXISTS `case` (
  `case_id` varchar(10) NOT NULL,
  `client_id` varchar(10) NOT NULL,
  `legal_id` varchar(10) NOT NULL,
  `date_open` date NOT NULL,
  `date_close` date NOT NULL,
  `risk` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Surname` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `client_id` varchar(10) NOT NULL,
  `comment` text NOT NULL,
  `lawyer_id` varchar(10) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`client_id`,`lawyer_id`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `lawyer`
--

CREATE TABLE IF NOT EXISTS `lawyer` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Surname` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `recommendation`
--

CREATE TABLE IF NOT EXISTS `recommendation` (
  `case_id` varchar(10) NOT NULL,
  `recommendation` text NOT NULL,
  `opinion` text NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`case_id`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `warning_log`
--

CREATE TABLE IF NOT EXISTS `warning_log` (
  `lawyer_id` varchar(10) NOT NULL,
  `warning` text NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
