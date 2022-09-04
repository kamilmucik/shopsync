DROP TABLE IF EXISTS appsetting;
DROP TABLE IF EXISTS APPUSER;
DROP TABLE IF EXISTS shop;
DROP TABLE IF EXISTS warehouse;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_image;
DROP TABLE IF EXISTS event_log;

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
);

CREATE TABLE IF NOT EXISTS shop (
  id INTEGER NOT NULL AUTO_INCREMENT,
  lastupdate varchar(255) DEFAULT NULL,
  shop_name varchar(250) NOT NULL,
  shop_url varchar(250) NOT NULL,
  shop_api_url varchar(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS warehouse (
  id INTEGER NOT NULL AUTO_INCREMENT,
  lastupdate varchar(255) DEFAULT NULL,
  warehouse_name varchar(250) NOT NULL,
  warehouse_url varchar(250) NOT NULL,
  warehouse_api_url varchar(250) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product (
  id INTEGER NOT NULL AUTO_INCREMENT,
  lastupdate varchar(255) DEFAULT NULL,
  warehouse_id INTEGER NOT NULL,
  prod_name varchar(250) NOT NULL,
  prod_main_img varchar(5000) NOT NULL,
  prod_amount varchar(250) NOT NULL,
  prod_description varchar(250) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product_image (
  id INTEGER NOT NULL AUTO_INCREMENT,
  product_id INTEGER NOT NULL,
  lastupdate varchar(255) DEFAULT NULL,
  img_url varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS event_log (
  id INTEGER NOT NULL AUTO_INCREMENT,
  lastupdate varchar(255) DEFAULT NULL,
  event_type varchar(255) NOT NULL,
  event_message varchar(255) NOT NULL,
  PRIMARY KEY (id)
);