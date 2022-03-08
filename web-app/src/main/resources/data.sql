
INSERT INTO appsetting ( setting_code , setting_name , setting_type , setting_value ) VALUES ('3','3','3','3');
INSERT INTO appsetting ( setting_code , setting_name , setting_type , setting_value ) VALUES ('code','name','type','value');

INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('user@estrix.pl', 1, 'user', 'github', 0, '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_USER');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('admin@estrix.pl', 1, 'admin', 'github', 0, '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_ADMIN');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('superuser@estrix.pl', 1, 'superuser', 'github', 0, '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_SUPERUSER');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('operator@estrix.pl', 1, 'operator', 'github', 0, '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_SCANER_OPERATOR');

