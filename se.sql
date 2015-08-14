-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2015 at 10:42 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `se`
--

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE IF NOT EXISTS `history` (
  `id_team` varchar(10) CHARACTER SET utf8 NOT NULL,
  `id_student` varchar(10) CHARACTER SET utf8 NOT NULL,
  `degree` double NOT NULL,
  `reason` varchar(50) CHARACTER SET utf8 NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_team`,`id_student`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id_team`, `id_student`, `degree`, `reason`, `date`) VALUES
('1', '1', 3, 'no', '2014-10-28'),
('1', '1', 2, 'شرح+حضر', '2014-11-10'),
('1', '2', 2, 'all', '2014-11-03'),
('1', '2', 1, 'شرح+حضر', '2014-11-10'),
('1', '3', 2, 'all', '2014-11-17'),
('3', '1', 2, 'all', '2014-12-28');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `id_team` varchar(10) CHARACTER SET utf8 NOT NULL,
  `id_student` varchar(10) CHARACTER SET utf8 NOT NULL,
  `name_student` varchar(200) CHARACTER SET utf8 NOT NULL,
  `num_sec` int(2) NOT NULL,
  `dept` varchar(2) CHARACTER SET utf8 NOT NULL,
  `total_degress` double NOT NULL,
  PRIMARY KEY (`id_team`,`id_student`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id_team`, `id_student`, `name_student`, `num_sec`, `dept`, `total_degress`) VALUES
('1', '1', 'ashraf atef', 2, 'cs', 18),
('1', '2', 'revo', 1, 'cs', 3),
('1', '3', 'abdo', 2, 'cs', 2),
('3', '1', 'ashraf atef', 2, 'cs', 2),
('3', '2', 'adbo', 2, 'cs', 0),
('3', '3', 'mohamed mostafa abd elrazek', 3, 'cs', 0),
('5', '1', 'rashad', 2, 'cs', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
