-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 12, 2019 at 05:01 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE HOTELMANAGEMENT;
USE HOTELMANAGEMENT;
--
-- Database: `hotelmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `Name` varchar(100) NOT NULL,
  `Contact no.` varchar(100) NOT NULL,
  `id` int(3) NOT NULL,
  `idtype` varchar(100) NOT NULL,
  `idnumber` varchar(100) NOT NULL,
  `Room No.` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`Name`, `Contact no.`, `id`, `idtype`, `idnumber`, `Room No.`) VALUES
('Prathamesh', '9819154387', 24, 'Aadhar Card', '09727h737', 101),
('Sahil', '9819829092', 25, 'Pan Card', '9329774764ijjs', 201),
('Pratham', '9892939025', 26, 'Aadhar Card', '9837hydywh7', 102),
('Pratham', '9892939025', 27, 'Aadhar Card', '9837hydywh7', 203);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `id` int(11) NOT NULL,
  `Room No.` int(100) DEFAULT NULL,
  `Type` varchar(100) NOT NULL,
  `Check in` date DEFAULT NULL,
  `Checkout` date DEFAULT NULL,
  `Availability` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`id`, `Room No.`, `Type`, `Check in`, `Checkout`, `Availability`) VALUES
(1, 101, 'AC', '2019-10-07', '2019-10-17', 'Unavailable'),
(3, 102, 'AC', '2019-10-12', '2019-10-13', 'Unavailable'),
(4, 103, 'AC', NULL, NULL, 'Available'),
(5, 104, 'AC', NULL, NULL, 'Available'),
(6, 105, 'AC', NULL, NULL, 'Available'),
(7, 201, 'Regular', '2019-10-01', '2019-10-08', 'Unavailable'),
(8, 202, 'Regular', NULL, NULL, 'Available'),
(9, 203, 'Regular', '2019-10-12', '2019-10-17', 'Unavailable'),
(10, 204, 'Regular', NULL, NULL, 'Available'),
(11, 205, 'Regular', NULL, NULL, 'Available');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
