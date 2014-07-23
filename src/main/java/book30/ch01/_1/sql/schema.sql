DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(10) primary key,
  `name` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL
) DEFAULT CHARSET=utf8;