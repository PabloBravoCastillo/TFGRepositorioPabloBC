-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (5,'Boxeo','boxeo.jpg'),(6,'Natación','natacion.jpg'),(7,'Padel','padel.jpg'),(8,'Voleibol','voleibol.jpg'),(9,'Futbol','futbol.webp');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `clases`
--

LOCK TABLES `clases` WRITE;
/*!40000 ALTER TABLE `clases` DISABLE KEYS */;
INSERT INTO `clases` VALUES (46,_binary '','Entrenador de Boxeo','17:38:00','16:43:00','boxeo.jpg','Boxeo',0,_binary '',7,48,_binary ''),(47,_binary '\0','Entrenador de Boxeo','18:38:00','17:43:00','boxeo.jpg','Boxeo',0,_binary '\0',7,48,_binary '\0'),(48,_binary '\0','Entrenador de Boxeo','19:38:00','18:43:00','boxeo.jpg','Boxeo',0,_binary '\0',7,48,_binary '\0'),(49,_binary '\0','Entrenador de Boxeo','20:38:00','19:43:00','boxeo.jpg','Boxeo',0,_binary '\0',7,48,_binary '\0'),(50,_binary '\0','Entrenador de Boxeo','21:38:00','20:43:00','boxeo.jpg','Boxeo',0,_binary '\0',7,48,_binary '\0'),(51,_binary '\0','Entrenador de Boxeo','22:38:00','21:43:00','boxeo.jpg','Boxeo',0,_binary '\0',7,48,_binary '\0'),(52,_binary '\0','Clases de Natación','15:57:00','15:12:00','natacion.jpg','Natación',0,_binary '\0',7,49,_binary '\0'),(53,_binary '\0','Clases de Natación','16:47:00','16:02:00','natacion.jpg','Natación',0,_binary '\0',7,49,_binary '\0'),(54,_binary '\0','Clases de Natación','17:37:00','16:52:00','natacion.jpg','Natación',0,_binary '\0',7,49,_binary '\0'),(55,_binary '\0','Clases de Natación','18:27:00','17:42:00','natacion.jpg','Natación',0,_binary '\0',7,49,_binary '\0'),(56,_binary '\0','Clases de Natación','19:17:00','18:32:00','natacion.jpg','Natación',0,_binary '\0',7,49,_binary '\0'),(57,_binary '\0','Clases de Natación','20:07:00','19:22:00','natacion.jpg','Natación',0,_binary '\0',7,49,_binary '\0'),(58,_binary '\0','Clases de Natación','20:57:00','20:12:00','natacion.jpg','Natación',0,_binary '\0',7,49,_binary '\0'),(59,_binary '\0','Clases de Natación','21:47:00','21:02:00','natacion.jpg','Natación',0,_binary '\0',7,49,_binary '\0'),(60,_binary '\0','Clases de Natación','22:37:00','21:52:00','natacion.jpg','Natación',0,_binary '\0',7,49,_binary '\0'),(61,_binary '\0','Clases de Padel','11:35:00','10:50:00','padel.jpg','Padel',0,_binary '\0',7,50,_binary '\0'),(62,_binary '\0','Clases de Padel','12:30:00','11:45:00','padel.jpg','Padel',0,_binary '\0',7,50,_binary '\0'),(63,_binary '\0','Clases de Padel','13:25:00','12:40:00','padel.jpg','Padel',0,_binary '\0',7,50,_binary '\0'),(64,_binary '\0','Clases de Padel','14:20:00','13:35:00','padel.jpg','Padel',0,_binary '\0',7,50,_binary '\0'),(65,_binary '\0','Clases de Padel','15:15:00','14:30:00','padel.jpg','Padel',0,_binary '\0',7,50,_binary '\0'),(66,_binary '\0','Clases de Voleibol para jóvenes','18:08:00','17:18:00','voleibol.jpg','Voleibol',0,_binary '\0',7,51,_binary '\0'),(67,_binary '\0','Clases de Voleibol para jóvenes','19:08:00','18:18:00','voleibol.jpg','Voleibol',0,_binary '\0',7,51,_binary '\0'),(68,_binary '\0','Clases de Voleibol para jóvenes','20:08:00','19:18:00','voleibol.jpg','Voleibol',0,_binary '\0',7,51,_binary '\0'),(69,_binary '\0','Clases de Voleibol para jóvenes','21:08:00','20:18:00','voleibol.jpg','Voleibol',0,_binary '\0',7,51,_binary '\0'),(70,_binary '\0','Clases de Voleibol para jóvenes','22:08:00','21:18:00','voleibol.jpg','Voleibol',0,_binary '\0',7,51,_binary '\0'),(71,_binary '\0','Aprende a manejar el Balón de Futbol','19:13:00','18:18:00','futbol.webp','Futbol',0,_binary '\0',7,52,_binary '\0'),(72,_binary '\0','Aprende a manejar el Balón de Futbol','20:18:00','19:23:00','futbol.webp','Futbol',0,_binary '\0',7,52,_binary '\0'),(73,_binary '\0','Aprende a manejar el Balón de Futbol','21:23:00','20:28:00','futbol.webp','Futbol',0,_binary '\0',7,52,_binary '\0'),(74,_binary '\0','Clases para aprender boxeo','17:41:00','16:41:00','boxeo.jpg','Boxeo',0,_binary '\0',8,53,_binary '\0'),(75,_binary '\0','Clases para aprender boxeo','18:51:00','17:51:00','boxeo.jpg','Boxeo',0,_binary '\0',8,53,_binary '\0'),(76,_binary '\0','Clases para aprender boxeo','20:01:00','19:01:00','boxeo.jpg','Boxeo',0,_binary '\0',8,53,_binary '\0'),(77,_binary '\0','Clases para aprender boxeo','21:11:00','20:11:00','boxeo.jpg','Boxeo',0,_binary '\0',8,53,_binary '\0'),(78,_binary '\0','Clases para aprender boxeo','08:59:00','08:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,54,_binary '\0'),(79,_binary '\0','Clases para aprender boxeo','09:59:00','09:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,54,_binary '\0'),(80,_binary '\0','Clases para aprender boxeo','10:59:00','10:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,54,_binary '\0'),(81,_binary '\0','Clases para aprender boxeo','11:59:00','11:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,54,_binary '\0'),(82,_binary '\0','Clases para aprender boxeo','12:59:00','12:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,54,_binary '\0'),(83,_binary '\0','Clases para aprender boxeo','13:59:00','13:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,54,_binary '\0'),(84,_binary '\0','Clases para aprender boxeo','14:59:00','14:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,54,_binary '\0'),(85,_binary '\0','Clases para aprender boxeo','08:59:00','08:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,55,_binary '\0'),(86,_binary '\0','Clases para aprender boxeo','09:59:00','09:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,55,_binary '\0'),(87,_binary '\0','Clases para aprender boxeo','10:59:00','10:04:00','boxeo.jpg','Boxeo',0,_binary '',8,55,_binary ''),(88,_binary '\0','Clases para aprender boxeo','11:59:00','11:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,55,_binary '\0'),(89,_binary '\0','Clases para aprender boxeo','12:59:00','12:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,55,_binary '\0'),(90,_binary '\0','Clases para aprender boxeo','13:59:00','13:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,55,_binary '\0'),(91,_binary '\0','Clases para aprender boxeo','14:59:00','14:04:00','boxeo.jpg','Boxeo',0,_binary '\0',8,55,_binary '\0');
/*!40000 ALTER TABLE `clases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `detalles`
--

LOCK TABLES `detalles` WRITE;
/*!40000 ALTER TABLE `detalles` DISABLE KEYS */;
INSERT INTO `detalles` VALUES (9,0,'Boxeo',0,0,8,46);
/*!40000 ALTER TABLE `detalles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `entrenador`
--

LOCK TABLES `entrenador` WRITE;
/*!40000 ALTER TABLE `entrenador` DISABLE KEYS */;
INSERT INTO `entrenador` VALUES (7,'Entrenador de multideporte','istockphoto-675179390-612x612.jpg','Pablo BC',8,'Málaga',_binary '\0',NULL,NULL),(8,'Me dedico a impartir clases de boxeo','boxeoentre.jpg','Lucas',10,'Málaga',_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `entrenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `modalidad`
--

LOCK TABLES `modalidad` WRITE;
/*!40000 ALTER TABLE `modalidad` DISABLE KEYS */;
INSERT INTO `modalidad` VALUES (48,'2023-06-15',NULL,5,7,'boxeo.jpg','Presencial','Sevilla',55,5,'21:49:00','15:48:00','Entrenador de Boxeo',0),(49,'2023-06-23',NULL,6,7,'natacion.jpg','Presencial','Sevilla',45,5,'22:05:00','14:27:00','Clases de Natación',0),(50,'2023-06-18',NULL,7,7,'padel.jpg','Presencial','Málaga',45,10,'15:10:00','10:05:00','Clases de Padel',0),(51,'2023-06-14',NULL,8,7,'voleibol.jpg','Presencial','Sevilla',50,10,'22:00:00','16:28:00','Clases de Voleibol para jóvenes',0),(52,'2023-06-24',NULL,9,7,'futbol.webp','Presencial','Huelva',55,10,'21:25:00','17:23:00','Aprende a manejar el Balón de Futbol',0),(53,'2023-06-17',NULL,5,8,'boxeo.jpg','Presencial','Málaga',60,10,'20:58:00','15:41:00','Clases para aprender boxeo',0),(54,'2023-06-17',NULL,5,8,'boxeo.jpg','Presencial','Málaga',55,5,'14:14:00','07:09:00','Clases para aprender boxeo',0),(55,'2023-06-18',NULL,5,8,'boxeo.jpg','Presencial','Málaga',55,5,'14:14:00','07:09:00','Clases para aprender boxeo',0);
/*!40000 ALTER TABLE `modalidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
INSERT INTO `ordenes` VALUES (8,'2023-06-12 00:49:08',NULL,'0000000001',0,9);
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (8,'Málaga','p@p.p','Pablo BC','$2a$10$1nuNt1c/Ax7WRwcZ7du53ezoh9MbJ25B/DdW0FQKHWK16HI/1ORfC',NULL,'ADMIN',NULL),(9,'vvvv','v@p.p','v','$2a$10$ffw.XH5CS374tuHQKzTJ8eUE5Z4a9hpv3CvIXAbiK4CISBFgUKrwO',NULL,'USER',NULL),(10,'llllll','lp@p.p','lp','$2a$10$HA3DwwSTT3wub51S3k1lf.mKiNppMoPayXud271mnWVbVZ3pBlhXe',NULL,'ADMIN',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-12  7:26:25
