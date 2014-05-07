-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 07 Μάη 2014 στις 09:56:10
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
  `appointment_id` int(20) NOT NULL AUTO_INCREMENT,
  `missed` tinyint(1) NOT NULL,
  `branch_id` varchar(10) NOT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `client_id` (`client_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Άδειασμα δεδομένων του πίνακα `appointments`
--

INSERT INTO `appointments` (`client_id`, `lawyer_id`, `date`, `appointment_id`, `missed`, `branch_id`) VALUES
('1', '1', '2014-05-04', 4, 0, '1'),
('2', '1', '2014-05-06', 5, 0, '1'),
('3', '2', '2014-05-08', 6, 1, '1'),
('3', '3', '2014-05-01', 7, 0, '2');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `case`
--

CREATE TABLE IF NOT EXISTS `case` (
  `case_id` int(10) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(10) NOT NULL,
  `legal_id` varchar(10) NOT NULL,
  `date_open` date NOT NULL,
  `date_close` date DEFAULT NULL,
  `risk` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Άδειασμα δεδομένων του πίνακα `case`
--

INSERT INTO `case` (`case_id`, `client_id`, `legal_id`, `date_open`, `date_close`, `risk`, `type`) VALUES
(4, '1', '1', '2014-04-06', NULL, 2, 1),
(5, '2', '1', '2014-05-04', '2014-05-07', 4, 2),
(6, '3', '2', '2014-05-02', '2014-05-03', 1, 3),
(7, '3', '3', '2014-05-04', NULL, 5, 1);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `client_id` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `client`
--

INSERT INTO `client` (`client_id`, `name`, `surname`) VALUES
('1', 'Kostis', 'Kosti'),
('2', 'Giannis', 'Gianni'),
('3', 'Giakoumis', 'Giakoumi');

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

--
-- Άδειασμα δεδομένων του πίνακα `comments`
--

INSERT INTO `comments` (`client_id`, `comment`, `lawyer_id`, `date`) VALUES
('1', 'Good Boy', '1', '2014-05-01'),
('1', 'Not Good', '2', '2014-05-06'),
('2', 'Very Risky', '3', '2014-05-06');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `lawyer`
--

CREATE TABLE IF NOT EXISTS `lawyer` (
  `lawyer_id` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  PRIMARY KEY (`lawyer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `lawyer`
--

INSERT INTO `lawyer` (`lawyer_id`, `name`, `surname`) VALUES
('1', 'Marios', 'Mariou'),
('2', 'Christos', 'Christou'),
('3', 'Polivios', 'Poliviou');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `recommendation`
--

CREATE TABLE IF NOT EXISTS `recommendation` (
  `case_id` int(10) NOT NULL,
  `recommendation` text NOT NULL,
  `opinion` text NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`case_id`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `recommendation`
--

INSERT INTO `recommendation` (`case_id`, `recommendation`, `opinion`, `date`) VALUES
(1, 'Recom', 'Opin', '2014-05-06'),
(2, 'Recom2', 'Opin2', '2014-05-09'),
(3, 'Recom4', 'Opin4', '2014-05-05'),
(3, 'Recom3', 'Opinion3', '2014-05-06');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`username`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`username`, `password`, `type`) VALUES
('lawyer', '1234', 2),
('manager', '1234', 1),
('receptioni', '1234', 3);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `warning_log`
--

CREATE TABLE IF NOT EXISTS `warning_log` (
  `lawyer_id` varchar(10) NOT NULL,
  `warning` text NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `warning_log`
--

INSERT INTO `warning_log` (`lawyer_id`, `warning`, `date`) VALUES
('1', 'Dont do this', '2014-05-04'),
('1', 'Stop', '2014-05-05');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
