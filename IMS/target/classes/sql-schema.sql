drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(80) DEFAULT NULL,
    `value` INT(40) DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `customers`int,
    PRIMARY KEY (`order_id`),
     CONSTRAINT fk_customers FOREIGN KEY (customers) REFERENCES customers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `ims`.`orders_items` (
    `log_id` INT(11) NOT NULL AUTO_INCREMENT,
    `order_id` int,
    `items` int,
    PRIMARY KEY (`log_id`),
     CONSTRAINT fk_orders FOREIGN KEY (order_id) REFERENCES orders(order_id)  ON DELETE CASCADE,
     CONSTRAINT fk_items FOREIGN KEY (items) REFERENCES items(item_id)  ON DELETE CASCADE
    
);
CREATE TABLE IF NOT EXISTS `ims`.`accounts` (
    `account_id` INT(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(80) DEFAULT NULL,
    `password` VARCHAR(80) DEFAULT NULL,
    PRIMARY KEY (`account_id`)
    
);




