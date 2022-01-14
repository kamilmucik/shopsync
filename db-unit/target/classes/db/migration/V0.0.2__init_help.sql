CREATE TABLE `app_platform` (
  `id` bigint NOT NULL,
  `name` varchar(50) NOT NULL,
  `code` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `app_version` (
  `id` bigint NOT NULL,
  `number` varchar(50) NOT NULL,
  `enviroment` varchar(50) NOT NULL,
  `installer` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `platform` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;