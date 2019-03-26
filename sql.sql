DROP SCHEMA IF EXISTS `legohouse`;
CREATE SCHEMA `legohouse`;

DROP TABLE IF EXISTS `legohouse`.`users`;
CREATE TABLE `legohouse`.`users`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(45) UNIQUE,
	`password` VARCHAR(45),
    `admin` INT(1) DEFAULT 0 NOT NULL,
    PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS `legohouse`.`orders`;
CREATE TABLE `legohouse`.`orders`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`dateplaced` DATETIME NOT NULL,
    `dateshipped` DATETIME DEFAULT NULL,
    `height` INT NOT NULL,
    `width` INT NOT NULL,
    `length` INT NOT NULL,
    PRIMARY KEY(`id`),
    CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES users(`id`)
);