-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.4-m7


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema cash_card_system
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ cash_card_system;
USE cash_card_system;

--
-- Table structure for table `cash_card_system`.`admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cash_card_system`.`admin`
--

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`,`user_name`,`password`) VALUES 
 (1,'admin','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


--
-- Table structure for table `cash_card_system`.`customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `nfc_id` text,
  `f_name` varchar(45) DEFAULT NULL,
  `l_name` varchar(45) DEFAULT NULL,
  `contact_no` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cash_card_system`.`customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customer_id`,`nfc_id`,`f_name`,`l_name`,`contact_no`,`user_name`,`password`,`status`,`balance`) VALUES 
 (1,'7845484225','Alex','Paul','+615588992','alex','alex123','Active',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Table structure for table `cash_card_system`.`payee_account`
--

DROP TABLE IF EXISTS `payee_account`;
CREATE TABLE `payee_account` (
  `payee_account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`payee_account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cash_card_system`.`payee_account`
--

/*!40000 ALTER TABLE `payee_account` DISABLE KEYS */;
INSERT INTO `payee_account` (`payee_account_id`,`account_name`,`password`,`balance`) VALUES 
 (1,'Sample seller-1','seller1',0);
/*!40000 ALTER TABLE `payee_account` ENABLE KEYS */;


--
-- Table structure for table `cash_card_system`.`payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `payee_account_id` int(11) NOT NULL,
  `date` varchar(10) DEFAULT NULL,
  `time` varchar(12) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `fk_transaction_payee_account_idx` (`payee_account_id`),
  KEY `fk_transaction_customer1_idx` (`customer_id`),
  CONSTRAINT `fk_transaction_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_payee_account` FOREIGN KEY (`payee_account_id`) REFERENCES `payee_account` (`payee_account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cash_card_system`.`payment`
--

/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


--
-- Table structure for table `cash_card_system`.`reload`
--

DROP TABLE IF EXISTS `reload`;
CREATE TABLE `reload` (
  `reload_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `admin_id` int(11) NOT NULL,
  `date` varchar(10) DEFAULT NULL,
  `time` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`reload_id`),
  KEY `fk_reload_customer1_idx` (`customer_id`),
  KEY `fk_reload_admin1_idx` (`admin_id`),
  CONSTRAINT `fk_reload_admin1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reload_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cash_card_system`.`reload`
--

/*!40000 ALTER TABLE `reload` DISABLE KEYS */;
/*!40000 ALTER TABLE `reload` ENABLE KEYS */;


--
-- Table structure for table `cash_card_system`.`withdraw`
--

DROP TABLE IF EXISTS `withdraw`;
CREATE TABLE `withdraw` (
  `withdraw_id` int(11) NOT NULL AUTO_INCREMENT,
  `payee_account_id` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `admin_id` int(11) NOT NULL,
  `date` varchar(10) DEFAULT NULL,
  `time` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`withdraw_id`),
  KEY `fk_withdraw_payee_account1_idx` (`payee_account_id`),
  KEY `fk_withdraw_admin1_idx` (`admin_id`),
  CONSTRAINT `fk_withdraw_admin1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_withdraw_payee_account1` FOREIGN KEY (`payee_account_id`) REFERENCES `payee_account` (`payee_account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cash_card_system`.`withdraw`
--

/*!40000 ALTER TABLE `withdraw` DISABLE KEYS */;
/*!40000 ALTER TABLE `withdraw` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
