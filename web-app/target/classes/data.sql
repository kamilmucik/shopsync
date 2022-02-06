INSERT INTO app_setting ( ID , SETTING_CODE , SETTING_NAME , SETTING_TYPE , SETTING_VALUE ) VALUES (3, '3','3','3','3');



INSERT INTO `app_user` (`id`, `email`, `is_enabled`, `first_name`, `last_name`, `is_locked`, `password`, `role_name`) VALUES
(1, 'user@estrix.pl', 1, 'user', 'github', 1, '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_USER'),
(2, 'admin@estrix.pl', 1, 'admin', 'github', 1, '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_ADMIN'),
(3, 'superuser@estrix.pl', 1, 'superuser', 'github', 1, '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_SUPERUSER'),
(4, 'operator@estrix.pl', 1, 'operator', 'github', 1, '36767690feffd782e729ae821dff3355dda8ad40896263c007ad5a372cac7edc6da6cefca1bcdb11', 'ROLE_SCANER_OPERATOR');

