DROP TABLE IF EXISTS appsetting;
DROP TABLE IF EXISTS APPUSER;

CREATE TABLE IF NOT EXISTS appsetting (
  id INTEGER NOT NULL AUTO_INCREMENT,
  lastupdate varchar(255) DEFAULT NULL,
  setting_code varchar(250) NOT NULL,
  setting_name varchar(250) NOT NULL,
  setting_type varchar(250) NOT NULL,
  setting_value varchar(250) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS APPUSER (
  id INTEGER NOT NULL AUTO_INCREMENT,
  email varchar(50) NOT NULL,
  is_enabled tinyint(1) DEFAULT 0,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  is_locked tinyint(1) DEFAULT 0,
  password varchar(80) DEFAULT NULL,
  role_name varchar(20) DEFAULT NULL,
  is_subscribed tinyint(1) DEFAULT 0,
  verificationKey varchar(64) DEFAULT NULL
)

