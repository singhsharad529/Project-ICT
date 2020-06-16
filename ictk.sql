-- MySQL dump 10.13  Distrib 5.5.20, for Win32 (x86)
--
-- Host: localhost    Database: ictk
-- ------------------------------------------------------
-- Server version	5.5.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `username` varchar(45) NOT NULL,
  `userpass` varchar(45) DEFAULT NULL,
  `usertype` varchar(45) DEFAULT NULL,
  `fullname` varchar(45) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('A01','sharad01','admin','sharad kumar','9871750805','sharad01@gmail.com','activated'),('A02','vijay01','admin','vijay kumar','9756453456','vijay02@gmail.com','deactivated'),('A03','ramesh03','admin','ramesh jha','5624568790','ramesh03@gmail.com','deactivated'),('A04','sourabh04','admin','sourabh kumar','5645378987','sourabh04@gmail.c0m','deactivated'),('A05','henry05','admin','henry','5676875645','henry05@gmail.com','activated'),('E01','dev01','employee','dev kumar','8967564534','dev01@gmail.com','deactivated'),('E02','monu02','employee','monu kumar','91234567890','monu02@gmail.com','activated'),('E03','umang03','employee','umang garg','7263847464','umang03@gmail.com','activated'),('E04','ram04','employee','ram kumar','7835674578','ram04@gmail.com','activated'),('E05','mayank06','employee','mayank aggarwal','9812343456','mayank05@gmail.com','activated'),('E06','rony06','employee','rony','9878675645','rony06@gmail.com','activated');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prospect`
--

DROP TABLE IF EXISTS `prospect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prospect` (
  `prospld` int(11) NOT NULL,
  `prospname` varchar(50) DEFAULT NULL,
  `prospphone` varchar(50) DEFAULT NULL,
  `prospaddress` varchar(50) DEFAULT NULL,
  `interestedmodel` varchar(50) DEFAULT NULL,
  `interestedcolor` varchar(50) DEFAULT NULL,
  `dateofvisit` varchar(50) DEFAULT NULL,
  `hotness` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`prospld`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prospect`
--

LOCK TABLES `prospect` WRITE;
/*!40000 ALTER TABLE `prospect` DISABLE KEYS */;
INSERT INTO `prospect` VALUES (1,'james','9873837383','noida','audia5','black','12-06-1999','warm'),(2,'smith','9823546567','hapur','suzuki5','white','23-09-2010','cold'),(3,'clark','9716805427','jhansi','audi x3','grey','12-02-2019','cold'),(4,'ram','6787459845','raipur','kwit','green','12-09-2015','cold'),(5,'blake','9711969245','new york','ferrari-s9','dark blue','23-09-2012','cold'),(6,'bob','9098978676','london','ferrari-s7','blue','04-02-2015','hot'),(7,'james','9871750805','kanpur','hondacity2015','yellow','03-05-2011','warm');
/*!40000 ALTER TABLE `prospect` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-05 18:57:01
