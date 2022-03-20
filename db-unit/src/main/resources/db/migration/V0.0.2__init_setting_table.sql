DROP TABLE IF EXISTS appsetting;

CREATE TABLE IF NOT EXISTS appsetting (
  id INTEGER NOT NULL AUTO_INCREMENT,
  lastupdate varchar(255) DEFAULT NULL,
  setting_code varchar(250) NOT NULL,
  setting_name varchar(250) NOT NULL,
  setting_type varchar(250) NOT NULL,
  setting_value varchar(250) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO appsetting ( id,lastupdate, setting_code , setting_name , setting_type , setting_value ) VALUES (3, '','3','3','3','3');
INSERT INTO appsetting ( id,lastupdate, setting_code , setting_name , setting_type , setting_value ) VALUES (2, '','code','name','type','value');
