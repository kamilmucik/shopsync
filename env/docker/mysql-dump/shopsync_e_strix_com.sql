-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: mysqlss:3306
-- Czas generowania: 11 Sie 2022, 12:23
-- Wersja serwera: 8.0.28
-- Wersja PHP: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `shopsync_e_strix_com`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `appsetting`
--

CREATE TABLE `appsetting` (
  `id` int NOT NULL,
  `lastupdate` varchar(255) DEFAULT NULL,
  `setting_code` varchar(250) NOT NULL,
  `setting_name` varchar(250) NOT NULL,
  `setting_type` varchar(250) NOT NULL,
  `setting_value` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `appsetting`
--

INSERT INTO `appsetting` (`id`, `lastupdate`, `setting_code`, `setting_name`, `setting_type`, `setting_value`) VALUES
(2, '', 'code', 'name', 'type', 'value2'),
(3, '', '3', '3', '3', '3');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `appuser`
--

CREATE TABLE `appuser` (
  `id` int NOT NULL,
  `email` varchar(50) NOT NULL,
  `is_enabled` bit(1) DEFAULT b'0',
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `is_locked` bit(1) DEFAULT b'0',
  `password` varchar(80) DEFAULT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `is_subscribed` bit(1) DEFAULT b'0',
  `verificationKey` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `appuser`
--

INSERT INTO `appuser` (`id`, `email`, `is_enabled`, `first_name`, `last_name`, `is_locked`, `password`, `role_name`, `is_subscribed`, `verificationKey`) VALUES
(1, 'user@estrix.pl', b'1', 'user', 'github', b'0', '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_USER', b'0', NULL),
(2, 'admin@estrix.pl', b'1', 'admin', 'github', b'0', '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_ADMIN', b'0', NULL),
(3, 'superuser@estrix.pl', b'1', 'superuser', 'github', b'0', '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_SUPERUSER', b'0', NULL),
(4, 'operator@estrix.pl', b'1', 'operator', 'github', b'0', '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_SCANER_OPERATOR', b'0', NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `schema_version`
--

CREATE TABLE `schema_version` (
  `version_rank` int NOT NULL,
  `installed_rank` int NOT NULL,
  `version` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `schema_version`
--

INSERT INTO `schema_version` (`version_rank`, `installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, 1, '0.0.1', 'init user table', 'SQL', 'V0.0.1__init_user_table.sql', -37326749, 'user', '2022-08-11 09:10:38', 133, 1),
(2, 2, '0.0.2', 'init setting table', 'SQL', 'V0.0.2__init_setting_table.sql', 981237571, 'user', '2022-08-11 09:10:39', 168, 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `appsetting`
--
ALTER TABLE `appsetting`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `appuser`
--
ALTER TABLE `appuser`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `schema_version`
--
ALTER TABLE `schema_version`
  ADD PRIMARY KEY (`version`),
  ADD KEY `schema_version_vr_idx` (`version_rank`),
  ADD KEY `schema_version_ir_idx` (`installed_rank`),
  ADD KEY `schema_version_s_idx` (`success`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `appsetting`
--
ALTER TABLE `appsetting`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT dla tabeli `appuser`
--
ALTER TABLE `appuser`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;