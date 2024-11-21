-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2024 at 04:53 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aplikasi_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `nimPengguna` bigint(10) NOT NULL,
  `kodeAdmin` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`nimPengguna`, `kodeAdmin`) VALUES
(1111, 'Super');

-- --------------------------------------------------------

--
-- Table structure for table `bindam`
--

CREATE TABLE `bindam` (
  `nimPengguna` bigint(10) NOT NULL,
  `kelompokBindam` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bindam`
--

INSERT INTO `bindam` (`nimPengguna`, `kelompokBindam`) VALUES
(2309116011, 1),
(2309116012, 1),
(2309116013, 2),
(2309116014, 2),
(2309116016, 3),
(2309116017, 4),
(2309116018, 4),
(2309116019, 5),
(2309116020, 5),
(2309116021, 6),
(2309116022, 6),
(2309116023, 7),
(2309116024, 7),
(2309116025, 8),
(2309116026, 8),
(2309116027, 9),
(2309116028, 9),
(2309116029, 10),
(2309116030, 10),
(2309116044, 3);

-- --------------------------------------------------------

--
-- Table structure for table `panitia`
--

CREATE TABLE `panitia` (
  `nimPengguna` bigint(10) NOT NULL,
  `divisiPanitia` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `panitia`
--

INSERT INTO `panitia` (`nimPengguna`, `divisiPanitia`) VALUES
(2309116037, 'Acara'),
(2309116041, 'Kesehatan'),
(2309116043, 'Humas'),
(2309116049, 'Keamanan');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `uid` varchar(10) NOT NULL,
  `nimPengguna` bigint(10) NOT NULL,
  `namaPengguna` varchar(100) NOT NULL,
  `jenisKelamin` enum('Pria','Wanita') NOT NULL,
  `password` varchar(6) NOT NULL,
  `role` enum('Admin','Panitia','Bindam') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`uid`, `nimPengguna`, `namaPengguna`, `jenisKelamin`, `password`, `role`) VALUES
('ESMkatGjpw', 1111, 'SuperAdmin', 'Pria', 'aaaa', 'Admin'),
('zYaXwVbCz', 2309116011, 'Yasmin Alya Aziza', '', 'Yasmi1', 'Bindam'),
('mNoPqRsTu', 2309116012, 'M. Nur Fadilah', '', 'Fadil1', 'Bindam'),
('oRsTuVwXp', 2309116013, 'M. Rizky Setiawan', '', 'Rizky1', 'Bindam'),
('pQrStUvWx', 2309116014, 'Reyfaldho Alfarazel', '', 'Reyfa1', 'Bindam'),
('uWxYzABpQ', 2309116016, 'Nazwa Tri Ananda', '', 'Nazwa1', 'Bindam'),
('wXyZAbCzD', 2309116017, 'M. Rofif Taqiyyuddin Nabiil', '', 'Rofif1', 'Bindam'),
('yZbCdEfGh', 2309116018, 'M. Alfian Adien', '', 'Alfia1', 'Bindam'),
('tUvWxYzAB', 2309116019, 'Nyoman Arini Trirahayu', '', 'Nyoma1', 'Bindam'),
('uVwXyZCDv', 2309116020, 'M. Hafidh Shovi', '', '1111', 'Bindam'),
('vXyZAbCwX', 2309116021, 'Amalia Kartika Sari', '', 'Amali1', 'Bindam'),
('wZbCdEfGh', 2309116022, 'Mita Wahyu Astami', '', 'MitaW1', 'Bindam'),
('xYzAbCdEf', 2309116023, 'Fatur Raflin', '', 'Fatur1', 'Bindam'),
('yAbCdEfGh', 2309116024, 'Allya Putri Ditya', '', 'Allya1', 'Bindam'),
('zBcDeFgHi', 2309116025, 'M. Arifin Dava', '', 'Arifi1', 'Bindam'),
('aCkLmNpQr', 2309116026, 'M. Luqman', '', 'Luqma1', 'Bindam'),
('bHnOpQrSt', 2309116027, 'M. Faiz', '', 'Faiz1', 'Bindam'),
('cIjKpQwXy', 2309116028, 'Alya Rizqi Ramadhani', '', 'AlyaR1', 'Bindam'),
('dJkLmNOpQ', 2309116029, 'Fadhil Ahmad Khairan', '', 'Fadhi1', 'Bindam'),
('eKlMnOpQr', 2309116030, 'M. Alief Aditya', '', 'Alief1', 'Bindam'),
('aBzCdEfGh', 2309116037, 'Dhea Amalia Putri', '', 'Deya22', 'Panitia'),
('qRsTuVwXy', 2309116041, 'David Sebastian Sutandy', '', 'David1', 'Panitia'),
('aBcDeFgHi', 2309116043, 'Nova Nur Fauziah', '', 'Nova37', 'Panitia'),
('fGhIjKlMn', 2309116044, 'Nurul Hafizah', '', 'Nurul1', 'Bindam'),
('tUvWxYzAb', 2309116049, 'Esra Fernanda Siregar', '', 'Regar1', 'Panitia'),
('jKkLmNoPq', 2309116058, 'Sawung Galih Triatmojo', '', 'Jvv1r', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `penilaian`
--

CREATE TABLE `penilaian` (
  `idPenilaian` char(6) NOT NULL,
  `nilaiKomunikasi` int(1) NOT NULL,
  `keteranganKomunikasi` varchar(1000) NOT NULL,
  `nilaiEtika` int(1) NOT NULL,
  `keteranganEtika` varchar(1000) NOT NULL,
  `nilaiKerjasama` int(1) NOT NULL,
  `keteranganKerjasama` varchar(1000) NOT NULL,
  `nilaiKepemimpinan` int(1) NOT NULL,
  `keteranganKepemimpinan` varchar(1000) NOT NULL,
  `nilaiKeaktifan` int(1) NOT NULL,
  `keteranganKeaktifan` varchar(1000) NOT NULL,
  `mingguKe` int(1) NOT NULL,
  `peserta_nimPeserta` bigint(10) NOT NULL,
  `pengguna_nimPengguna` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penilaian`
--

INSERT INTO `penilaian` (`idPenilaian`, `nilaiKomunikasi`, `keteranganKomunikasi`, `nilaiEtika`, `keteranganEtika`, `nilaiKerjasama`, `keteranganKerjasama`, `nilaiKepemimpinan`, `keteranganKepemimpinan`, `nilaiKeaktifan`, `keteranganKeaktifan`, `mingguKe`, `peserta_nimPeserta`, `pengguna_nimPengguna`) VALUES
('xjaOxz', 4, 'Bagus', 3, 'Agak Beretika', 1, 'Individualis', 2, 'Kurang Bonding', 2, 'Pasif karena individualis', 1, 2409116002, 2309116019);

-- --------------------------------------------------------

--
-- Table structure for table `peserta`
--

CREATE TABLE `peserta` (
  `uid` varchar(10) NOT NULL,
  `nimPeserta` bigint(10) NOT NULL,
  `namaPeserta` varchar(100) NOT NULL,
  `jenisKelamin` enum('Pria','Wanita') NOT NULL,
  `noHp` char(14) NOT NULL,
  `kelompokPeserta` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peserta`
--

INSERT INTO `peserta` (`uid`, `nimPeserta`, `namaPeserta`, `jenisKelamin`, `noHp`, `kelompokPeserta`) VALUES
('CdEfGhIjKl', 2409116002, 'Nurhidayah', '', '6281234567818', 5),
('UvWxYzAbCd', 2409116004, 'Indah Putri Lestari', '', '6281234567892', 1),
('MnOpQrStUv', 2409116007, 'Jen Agresia Misti', '', '6281234567832', 8),
('AbCdEfGhIj', 2409116009, 'Nayla Camelia Indraswari', '', '6281234567836', 9),
('EfGhIjKlMn', 2409116010, 'Narendra Augusta Srianandha', '', '6281234567839', 9),
('OpQrStUvWx', 2409116011, 'Nabila Imtiyaz Agustin', '', '6281234567840', 9),
('AbcDefGhij', 2409116016, 'Fathinatuz Zaina', '', '6281234567890', 1),
('MnOpQrStUv', 2409116018, 'Rahmad Ramadhan', '', '6281234567806', 2),
('KlMnOpQrSt', 2409116020, 'Zahra Aulia Rahmah', '', '6281234567891', 1),
('GhIjKlMnOp', 2409116022, 'Zelsya Rizqita Azhara', '', '6281234567847', 10),
('WxYzAbCdEf', 2409116023, 'Dilla Maharani', '', '6281234567807', 3),
('OpQrStUvWx', 2409116025, 'Ahmad Sepriza', '', '6281234567894', 1),
('QrStUvWxYz', 2409116026, 'Larry Polin Anugrah', '', '6281234567822', 6),
('AbCdEfGhIj', 2409116028, 'Amelia Annisa Sulaiman', '', '6281234567849', 10),
('KlMnOpQrSt', 2409116029, 'Mochammad Rezky Ramadhan', '', '6281234567811', 3),
('EfGhIjKlMn', 2409116030, 'Syauqi Etna Lazhuardhy', '', '6281234567893', 1),
('WxYzAbCdEf', 2409116031, 'Muhammad Sadikin Samir', '', '6281234567817', 5),
('StUvWxYzAb', 2409116032, 'Maifariza Aulia Dyas', '', '6281234567804', 2),
('CdEfGhIjKl', 2409116036, 'Sayid Rafi A\'thaya', '', '6281234567844', 9),
('KlMnOpQrSt', 2409116038, 'Husaini Iyastama H.', '', '6281234567837', 9),
('OpQrStUvWx', 2409116045, 'Muhammad Rizky Febrianto', '', '6281234567827', 7),
('YzAbCdEfGh', 2409116046, 'Chiqo Nanda Rial Pratama', '', '6281234567828', 7),
('IjKlMnOpQr', 2409116048, 'Rini Wulandari', '', '6281234567842', 9),
('CdEfGhIjKl', 2409116049, 'Rabiatul Hikmah', '', '6281234567831', 7),
('WxYzAbCdEf', 2409116051, 'Nur Ihsan', '', '6281234567820', 5),
('CdEfGhIjKl', 2409116054, 'Prakasa Wira Mukti', '', '6281234567805', 2),
('QrStUvWxYz', 2409116055, 'Abdurrahman Al Farisy', '', '6281234567835', 8),
('IjKlMnOpQr', 2409116059, 'Ghifari Al Azhar', '', '6281234567803', 2),
('YzAbCdEfGh', 2409116061, 'Nayla Lelyanggraheni Hutomo', '', '6281234567802', 2),
('EfGhIjKlMn', 2409116063, 'Fikri Abiyyu Rahman', '', '6281234567826', 6),
('StUvWxYzAb', 2409116064, 'Darel Prasetya Fawwaz', '', '6281234567830', 7),
('IjKlMnOpQr', 2409116067, 'Satria Rajawali Ektya Antara', '', '6281234567816', 4),
('MnOpQrStUv', 2409116068, 'Asriah Ainun Fazah', '', '6281234567819', 5),
('IjKlMnOpQr', 2409116073, 'Alvionej Resna Lawrend Pandiangan', '', '6281234567829', 7),
('OpQrStUvWx', 2409116075, 'Elmy Fadillah', '', '6281234567814', 4),
('StUvWxYzAb', 2409116077, 'M. Irdhan Nur Faudzan', '', '6281234567843', 9),
('AbCdEfGhIj', 2409116079, 'Moch Farris Alfiansyah', '', '6281234567810', 3),
('EfGhIjKlMn', 2409116082, 'Jihan Alya Naflah', '', '6281234567813', 4),
('YzAbCdEfGh', 2409116083, 'Raihan Fariz Novanto', '', '6281234567841', 9),
('GhIjKlMnOp', 2409116084, 'Dyea Puspita Sari', '', '6281234567834', 8),
('WxYzAbCdEf', 2409116086, 'Indah Maramin Al Inayah', '', '6281234567846', 10),
('UvWxYzAbCd', 2409116088, 'Aris Candra Muzaffar', '', '6281234567838', 9),
('GhIjKlMnOp', 2409116089, 'Rizky Yunia', '', '6281234567808', 3),
('YzAbCdEfGh', 2409116090, 'Nabil Daffa Athalasyah', '', '6281234567815', 4),
('GhIjKlMnOp', 2409116092, 'Nova Rasyadina Anwar', '', '6281234567821', 5),
('AbCdEfGhIj', 2409116093, 'Dafa Firdaus', '', '6281234567823', 6),
('UvWxYzAbCd', 2409116096, 'Chaesarrio Taufiqul Hakim', '', '6281234567812', 4),
('WxYzAbCdEf', 2409116097, 'Moreno Ferdinand Farhantino', '', '6281234567833', 8),
('KlMnOpQrSt', 2409116099, 'Nasywa Al Wafa', '', '6281234567850', 10),
('QrStUvWxYz', 2409116100, 'Miftahethul Firdaus', '', '6281234567848', 10),
('QrStUvWxYz', 2409116106, 'Muhammad Arifin Alqi. AB', '', '6281234567809', 3),
('MnOpQrStUv', 2409116107, 'Dimas Aji Mukti', '', '6281234567845', 9),
('KlMnOpQrSt', 2409116108, 'Maria Claudia Meo', '', '6281234567824', 6),
('UvWxYzAbCd', 2409116120, 'Zyrus Alfredo Randan Malinggato', '', '6281234567825', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`nimPengguna`);

--
-- Indexes for table `bindam`
--
ALTER TABLE `bindam`
  ADD PRIMARY KEY (`nimPengguna`);

--
-- Indexes for table `panitia`
--
ALTER TABLE `panitia`
  ADD PRIMARY KEY (`nimPengguna`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`nimPengguna`);

--
-- Indexes for table `penilaian`
--
ALTER TABLE `penilaian`
  ADD PRIMARY KEY (`idPenilaian`),
  ADD UNIQUE KEY `PENILAIAN_IDX` (`peserta_nimPeserta`),
  ADD UNIQUE KEY `PENILAIAN_IDX2` (`pengguna_nimPengguna`);

--
-- Indexes for table `peserta`
--
ALTER TABLE `peserta`
  ADD PRIMARY KEY (`nimPeserta`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `ADMIN_PENGGUNA_FK` FOREIGN KEY (`nimPengguna`) REFERENCES `pengguna` (`nimPengguna`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `bindam`
--
ALTER TABLE `bindam`
  ADD CONSTRAINT `BINDAM_PENGGUNA_FK` FOREIGN KEY (`nimPengguna`) REFERENCES `pengguna` (`nimPengguna`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `panitia`
--
ALTER TABLE `panitia`
  ADD CONSTRAINT `PANITIA_PENGGUNA_FK` FOREIGN KEY (`nimPengguna`) REFERENCES `pengguna` (`nimPengguna`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `penilaian`
--
ALTER TABLE `penilaian`
  ADD CONSTRAINT `PENILAIAN_PENGGUNA_FK` FOREIGN KEY (`pengguna_nimPengguna`) REFERENCES `pengguna` (`nimPengguna`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `PENILAIAN_PESERTA_FK` FOREIGN KEY (`peserta_nimPeserta`) REFERENCES `peserta` (`nimPeserta`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
