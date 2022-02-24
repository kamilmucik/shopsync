
INSERT INTO appsetting ( setting_code , setting_name , setting_type , setting_value ) VALUES ('3','3','3','3');

INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('user@estrix.pl', 1, 'user', 'github', 0, '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_USER');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('admin@estrix.pl', 1, 'admin', 'github', 0, '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_ADMIN');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('superuser@estrix.pl', 1, 'superuser', 'github', 0, '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_SUPERUSER');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('operator@estrix.pl', 1, 'operator', 'github', 0, '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_SCANER_OPERATOR');

