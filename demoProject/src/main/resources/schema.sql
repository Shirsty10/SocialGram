CREATE TABLE IF NOT EXISTS `account_msg` (
  `account_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `bday` varchar(10) NOT NULL,
  `bio` varchar(500) NOT NULL,
  `status` varchar(10) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL
);