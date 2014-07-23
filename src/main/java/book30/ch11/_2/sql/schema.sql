DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `number` varchar(10) NOT NULL,
  `name` varchar(55) NOT NULL,
  `point` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;