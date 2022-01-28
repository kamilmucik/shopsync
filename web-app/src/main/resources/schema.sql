
CREATE TABLE IF NOT EXISTS `app_setting` (
  `id` bigint NOT NULL,
  `last_update` varchar(255) DEFAULT NULL,
  `setting_code` varchar(250) NOT NULL,
  `setting_name` varchar(250) NOT NULL,
  `setting_type` varchar(250) NOT NULL,
  `setting_value` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
);
