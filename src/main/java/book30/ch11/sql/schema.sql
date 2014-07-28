DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `number` varchar(10) NOT NULL,
  `name` varchar(55) NOT NULL,
  `point` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
  `id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(32) unsigned NOT NULL,
  `address` varchar(55) NOT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `contacts_fk1` FOREIGN KEY (`user_id`) REFERENCES `members` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;