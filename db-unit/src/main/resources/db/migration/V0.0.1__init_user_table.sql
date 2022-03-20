DROP TABLE IF EXISTS appuser;

CREATE TABLE `appuser` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `is_enabled` bit(1) DEFAULT b'0',
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `is_locked` bit(1) DEFAULT b'0',
  `password` varchar(80) DEFAULT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `is_subscribed` bit(1) DEFAULT b'0',
  `verificationKey` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('user@estrix.pl', b'1', 'user', 'github', b'0', '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_USER');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('admin@estrix.pl', b'1', 'admin', 'github', b'0', '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_ADMIN');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('superuser@estrix.pl', b'1', 'superuser', 'github', b'0', '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_SUPERUSER');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('operator@estrix.pl', b'1', 'operator', 'github', b'0', '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_SCANER_OPERATOR');
