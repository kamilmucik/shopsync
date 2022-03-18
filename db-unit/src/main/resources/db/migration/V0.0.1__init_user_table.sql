CREATE TABLE `app_user` (
  `id` bigint NOT NULL,
  `email` varchar(50) NOT NULL,
  `is_enabled` bit(1) DEFAULT b'0',
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `is_locked` bit(1) DEFAULT b'0',
  `password` varchar(80) DEFAULT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `is_subscribed` bit(1) DEFAULT b'0',
  `verificationKey` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `app_user` (`id`, `email`, `is_enabled`, `first_name`, `last_name`, `is_locked`, `password`, `role_name`, `is_subscribed`, `verificationKey`) VALUES
(1, 'user@estrix.pl', b'1', 'user', 'github', b'0', '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_USER', b'0', NULL),
(2, 'admin@estrix.pl', b'1', 'admin', 'github', b'0', '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_ADMIN', b'0', NULL),
(3, 'superuser@estrix.pl', b'1', 'superuser', 'github', b'0', '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_SUPERUSER', b'0', NULL),
(4, 'operator@estrix.pl', b'1', 'operator', 'github', b'0', '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_SCANER_OPERATOR', b'0', NULL);
