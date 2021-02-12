INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`items` (`item_name`, `value`) VALUES ('jojo', 5);
INSERT INTO `ims`.`orders` ( `customers`) VALUES (1);
INSERT INTO `ims`.`orders_items` ( `order_id`,`items`) VALUES (1,1);
INSERT INTO `ims`.`accounts` ( `username`,`password`) VALUES ('dan','123');