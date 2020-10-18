CREATE DATABASE IF NOT EXISTS `hb_employee_tracker`;
USE `hb_employee_tracker`;

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
    `id` int(11) NOT NULL AUTO_INCREMENT, 
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `company` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;