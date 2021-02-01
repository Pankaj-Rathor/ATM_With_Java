-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2021 at 11:25 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sbi`
--

-- --------------------------------------------------------

--
-- Table structure for table `currentaccount`
--

CREATE TABLE `currentaccount` (
  `Uaccount` int(10) NOT NULL,
  `Uname` varchar(50) NOT NULL,
  `Upass` int(8) NOT NULL,
  `Ubalance` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `currentaccount`
--

INSERT INTO `currentaccount` (`Uaccount`, `Uname`, `Upass`, `Ubalance`) VALUES
(112233, 'Pankaj Rathor', 8827, 7500),
(112234, 'Pavan Rathor', 7879, 10000),
(112235, 'Gopal Rathor', 88899, 12000),
(112236, 'Nitesh Patel', 1234, 14000),
(112237, 'Shaily Sharma', 1302, 10000);

-- --------------------------------------------------------

--
-- Table structure for table `savingaccount`
--

CREATE TABLE `savingaccount` (
  `Uaccount` int(10) NOT NULL,
  `Uname` varchar(50) NOT NULL,
  `Upass` int(8) NOT NULL,
  `Ubalance` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `savingaccount`
--

INSERT INTO `savingaccount` (`Uaccount`, `Uname`, `Upass`, `Ubalance`) VALUES
(9424531, 'Ravi Patidar', 1234, 10000),
(9424532, 'Kamlesh Sharma', 1234, 10000),
(9424533, 'Ranu Patidar', 1234, 10000),
(9424534, 'Aksita Rathor', 1234, 10000),
(9424535, 'Prful Patidar', 1234, 10000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `currentaccount`
--
ALTER TABLE `currentaccount`
  ADD PRIMARY KEY (`Uaccount`);

--
-- Indexes for table `savingaccount`
--
ALTER TABLE `savingaccount`
  ADD PRIMARY KEY (`Uaccount`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
