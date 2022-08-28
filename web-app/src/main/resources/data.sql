
INSERT INTO appsetting ( id,lastupdate, setting_code , setting_name , setting_type , setting_value ) VALUES (3, '','3','3','3','3');
INSERT INTO appsetting ( id,lastupdate, setting_code , setting_name , setting_type , setting_value ) VALUES (2, '','code','name','type','value');

INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('user@estrix.pl', 1, 'user', 'github', 0, '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_USER');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('admin@estrix.pl', 1, 'admin', 'github', 0, '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_ADMIN');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('superuser@estrix.pl', 1, 'superuser', 'github', 0, '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_SUPERUSER');
INSERT INTO appuser (email, is_enabled, first_name, last_name, is_locked, password, role_name) VALUES
('operator@estrix.pl', 1, 'operator', 'github', 0, '$2a$10$ZTyfrBmpaq0KaVw8/JVWUOdY2tcgOpKb4sMkd5koVD91wOYVaM6Pq', 'ROLE_SCANER_OPERATOR');


INSERT INTO shop ( id, lastupdate, shop_name , shop_url , shop_api_url ) VALUES (1, '','shop_name_1','shop_url','shop_api_url');
INSERT INTO shop ( id, lastupdate, shop_name , shop_url , shop_api_url ) VALUES (2, '','shop_name_2','shop_url','shop_api_url');
INSERT INTO shop ( id, lastupdate, shop_name , shop_url , shop_api_url ) VALUES (3, '','shop_name_3','shop_url','shop_api_url');
INSERT INTO shop ( id, lastupdate, shop_name , shop_url , shop_api_url ) VALUES (4, '','shop_name_4','shop_url','shop_api_url');
INSERT INTO shop ( id, lastupdate, shop_name , shop_url , shop_api_url ) VALUES (5, '','shop_name_5','shop_url','shop_api_url');
INSERT INTO shop ( id, lastupdate, shop_name , shop_url , shop_api_url ) VALUES (6, '','shop_name_6','shop_url','shop_api_url');
INSERT INTO shop ( id, lastupdate, shop_name , shop_url , shop_api_url ) VALUES (7, '','shop_name_7','shop_url','shop_api_url');
INSERT INTO shop ( id, lastupdate, shop_name , shop_url , shop_api_url ) VALUES (8, '','shop_name_8','shop_url','shop_api_url');

INSERT INTO warehouse ( id, lastupdate, warehouse_name , warehouse_url , warehouse_api_url ) VALUES (1, '','warehouse_name','warehouse_url','warehouse_api_url');