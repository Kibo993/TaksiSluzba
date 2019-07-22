-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 02, 2017 at 09:49 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `taksisluzba`
--
CREATE DATABASE IF NOT EXISTS `taksisluzba` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `taksisluzba`;

-- --------------------------------------------------------

--
-- Table structure for table `evidencijavoznje`
--

CREATE TABLE `evidencijavoznje` (
  `datumVoznje` date NOT NULL,
  `taksistaID` int(11) NOT NULL,
  `voziloID` int(11) NOT NULL,
  `kilometrazaOd` double DEFAULT NULL,
  `kilometrazaDo` double DEFAULT NULL,
  `zarada` double DEFAULT NULL,
  `sluzbenikID` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `evidencijavoznje`
--

INSERT INTO `evidencijavoznje` (`datumVoznje`, `taksistaID`, `voziloID`, `kilometrazaOd`, `kilometrazaDo`, `zarada`, `sluzbenikID`) VALUES
('2017-03-01', 9, 2, 1010, 1090, 12000, 1),
('2017-03-03', 8, 13, 12132, 12232, 20000, 1),
('2017-03-21', 9, 12, 3720, 3780, 13300, 1),
('2017-05-11', 11, 12, 3780, 3940, 14500, 2),
('2017-05-14', 13, 10, 144490, 144567, 12000, 2),
('2017-05-15', 12, 11, 9923, 10015, 11000, 2),
('2017-05-17', 12, 12, 3940, 4027, 18300, 1),
('2017-05-18', 9, 11, 10015, 10104, 12300, 1),
('2017-05-19', 9, 10, 144567, 144610, 13300, 2),
('2017-05-19', 12, 2, 144567, 144610, 13300, 1),
('2017-05-20', 11, 11, 10104, 10178, 16000, 1),
('2017-05-21', 9, 2, 1097, 1115, 12600, 2),
('2017-05-22', 8, 11, 10178, 10235, 13590, 1),
('2017-05-24', 9, 15, 98000, 98073, 17000, 2),
('2017-05-25', 13, 11, 10235, 10298, 11870, 2),
('2017-05-27', 14, 15, 98073, 98120, 14000, 1),
('2017-06-01', 12, 13, 12232, 12320, 19800, 3),
('2017-06-12', 15, 16, 14000, 14053.3, 11090, 2),
('2017-06-14', 15, 16, 14053.3, 14100.2, 12000, 1),
('2017-08-22', 8, 2, 1231.2, 1255.9, 11500, 1),
('2017-08-22', 9, 13, 12320, 12367.8, 13400, 1),
('2017-08-22', 11, 2, 1255.9, 1290, 8000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sluzbenik`
--

CREATE TABLE `sluzbenik` (
  `sluzbenikID` int(5) NOT NULL,
  `ime` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `korisnickoIme` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `korisnickaSifra` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sluzbenik`
--

INSERT INTO `sluzbenik` (`sluzbenikID`, `ime`, `prezime`, `korisnickoIme`, `korisnickaSifra`) VALUES
(1, 'Bojan', 'Dukić', 'boki', 'boki123'),
(2, 'Miroljub', 'Jovanović', 'miki', 'kimisa21'),
(3, 'Lazar', 'Bojanić', 'zigy', 'mna2538');

-- --------------------------------------------------------

--
-- Table structure for table `taksista`
--

CREATE TABLE `taksista` (
  `taksistaID` int(11) NOT NULL,
  `datumZaposlenja` date NOT NULL,
  `imeTaksiste` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `prezimeTaksiste` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `jmbg` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `kontakt` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ulica` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `broj` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ukupnaZarada` double NOT NULL,
  `stanicaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `taksista`
--

INSERT INTO `taksista` (`taksistaID`, `datumZaposlenja`, `imeTaksiste`, `prezimeTaksiste`, `jmbg`, `kontakt`, `ulica`, `broj`, `ukupnaZarada`, `stanicaID`) VALUES
(8, '2017-05-12', 'Jovan', 'Draganović', '0409986710204', '0645890322', 'Savska', '12', 95399, 2),
(9, '2016-04-11', 'Dragoljub', 'Jovićević', '1102967730129', '0119328746', 'Zaplanjska', '23', 146700, 8),
(11, '2017-02-19', 'Miloš', 'Felba', '0109988731096', '0118377492', 'Bulevar Kralja Aleksandra', '164', 30500, 12),
(12, '2017-03-29', 'Marko', 'Savić', '3011985740841', '0608362956', 'Sarajevska', '54', 71600, 18),
(13, '2017-03-12', 'Uroš', 'Lazović', '0503988742419', '0119283746', 'Pajsijeva', '39', 23870, 16),
(14, '2017-04-28', 'Jovan', 'Simović', '0901989710236', '0612592834', 'Gavrila Principa', '34', 14000, 24),
(15, '2017-04-12', 'Stanislav', 'Kojić', '2903981710239', '0112689930', 'Cerski Venac', '25', 23090, 16),
(16, '2017-05-12', 'Filip', 'Stanić', '0403988710114', '0642930293', 'Balkanska', '23', 0, 18);

-- --------------------------------------------------------

--
-- Table structure for table `taksistanica`
--

CREATE TABLE `taksistanica` (
  `stanicaID` int(5) NOT NULL,
  `adresa` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `ptt` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `opstina` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `taksistanica`
--

INSERT INTO `taksistanica` (`stanicaID`, `adresa`, `ptt`, `opstina`) VALUES
(1, 'Slanački put', '11000', 'Palilula'),
(2, 'Stevana Dukića', '11000', 'Palilula'),
(3, 'Makedonska', '11000', 'Stari Grad'),
(4, 'Bulevar Arsenija Čarnojevića', '11070', 'Novi Beograd'),
(5, 'Serdara Janka Vukotića', '11000', 'Rakovica'),
(6, 'Vladimira Popovića', '11070', 'Novi Beograd'),
(7, 'Bogdana Žerajića', '11000', 'Rakovica'),
(8, 'Jovana Ristića', '11000', 'Savski Venac'),
(9, 'Vojvode Stepe', '11000', 'Voždovac'),
(10, 'Kokanova', '11000', 'Voždovac'),
(11, 'Cerski venac', '11000', 'Čukarica'),
(12, 'Bulevar kralja Aleksandra', '11000', 'Zvezdara'),
(13, 'Vojislava Ilića', '11000', 'Voždovac'),
(14, 'Vojvode Toze', '11000', 'Voždovac'),
(15, 'Hadži Melentijeva', '11000', 'Vračar'),
(16, 'Maksima Gorkog', '11000', 'Voždovac'),
(17, 'Svetog Marka', '11000', 'Palilula'),
(18, 'Karađorđeva', '11000', 'Savski Venac'),
(19, 'Prote Mateje', '11000', 'Vračar'),
(20, 'Pasterova', '11000', 'Savski Venac'),
(21, 'Dr Koste Todorovića', '11000', 'Savski Venac'),
(22, 'Mileševska', '11000', 'Vračar'),
(23, 'Bulevar despota Stefana', '11000', 'Palilula'),
(24, 'Trg Slavija', '11000', 'Vračar'),
(25, 'Studentski trg', '11000', 'Stari Grad'),
(26, 'Zvornička', '11000', 'Savski Venac'),
(27, 'Plato dr Zorana Đinđića', '11000', 'Stari Grad'),
(28, 'Bele Bartoka', '11210', 'Borča'),
(29, 'Pukovnika Milenka Pavlovića', '11080', 'Zemun'),
(30, 'Franje Krča', '11080', 'Zemun'),
(31, 'Aerodrom Beograd', '11180', 'Surčin'),
(32, 'Beogradskog bataljona', '11000', 'Čukarica'),
(33, 'Radnih akcija', '11000', 'Čukarica');

-- --------------------------------------------------------

--
-- Table structure for table `vozilo`
--

CREATE TABLE `vozilo` (
  `voziloID` int(11) NOT NULL,
  `datumPocetkaSluzbe` date NOT NULL,
  `vin` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `registarskaOznaka` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `marka` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `model` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ukupnaKilometraza` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `vozilo`
--

INSERT INTO `vozilo` (`voziloID`, `datumPocetkaSluzbe`, `vin`, `registarskaOznaka`, `marka`, `model`, `ukupnaKilometraza`) VALUES
(2, '2017-02-16', '12544512875208483', 'BG253TX', 'Citroen', 'c4', 1231.2),
(10, '2017-05-12', '12345678901234567', 'BG764TX', 'Renault', 'Laguna 2', 144610),
(11, '2017-05-12', '99976493679263092', 'BG8362TX', 'Dačia', 'Logan', 10298),
(12, '2017-02-05', '74026402754093267', 'BG2578TX', 'Škoda', 'Superb', 4092.4),
(13, '2017-02-12', '74639482090016748', 'BG888TX', 'Škoda', 'Superb', 12320),
(15, '2017-05-17', '63720193847503028', 'BG8829TX', 'Citroen', 'C5', 98120),
(16, '2017-05-13', '38201742938472614', 'BG625TX', 'Ford', 'Focus', 14100.2),
(17, '2017-05-15', '63028766483920384', 'BG2577TX', 'Mazda', '3', 110.3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `evidencijavoznje`
--
ALTER TABLE `evidencijavoznje`
  ADD PRIMARY KEY (`datumVoznje`,`taksistaID`,`voziloID`),
  ADD KEY `SluzbenikID` (`sluzbenikID`),
  ADD KEY `taksistaID` (`taksistaID`),
  ADD KEY `voziloID` (`voziloID`);

--
-- Indexes for table `sluzbenik`
--
ALTER TABLE `sluzbenik`
  ADD PRIMARY KEY (`sluzbenikID`);

--
-- Indexes for table `taksista`
--
ALTER TABLE `taksista`
  ADD PRIMARY KEY (`taksistaID`),
  ADD KEY `stanicaID` (`stanicaID`);

--
-- Indexes for table `taksistanica`
--
ALTER TABLE `taksistanica`
  ADD PRIMARY KEY (`stanicaID`);

--
-- Indexes for table `vozilo`
--
ALTER TABLE `vozilo`
  ADD PRIMARY KEY (`voziloID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `taksistanica`
--
ALTER TABLE `taksistanica`
  MODIFY `stanicaID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `evidencijavoznje`
--
ALTER TABLE `evidencijavoznje`
  ADD CONSTRAINT `evidencijavoznje_ibfk_3` FOREIGN KEY (`sluzbenikID`) REFERENCES `sluzbenik` (`sluzbenikID`),
  ADD CONSTRAINT `evidencijavoznje_ibfk_5` FOREIGN KEY (`taksistaID`) REFERENCES `taksista` (`taksistaID`),
  ADD CONSTRAINT `evidencijavoznje_ibfk_6` FOREIGN KEY (`voziloID`) REFERENCES `vozilo` (`voziloID`);

--
-- Constraints for table `taksista`
--
ALTER TABLE `taksista`
  ADD CONSTRAINT `taksista_ibfk_1` FOREIGN KEY (`stanicaID`) REFERENCES `taksistanica` (`stanicaID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
