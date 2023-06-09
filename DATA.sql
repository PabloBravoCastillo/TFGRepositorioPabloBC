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
INSERT INTO `categoria` VALUES (1,'Boxeo'),(2,'Tenis'),(3,'Padel');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `clases`
--

LOCK TABLES `clases` WRITE;
/*!40000 ALTER TABLE `clases` DISABLE KEYS */;
INSERT INTO `clases` VALUES (30,_binary '\0','Clases para aprender boxeo','11:05:00','10:20:00','boxeo.jpg','Boxeo',23,_binary '\0',1,44,_binary '\0'),(31,_binary '\0','Clases para aprender boxeo','11:55:00','11:10:00','boxeo.jpg','Boxeo',23,_binary '\0',1,44,_binary '\0'),(32,_binary '\0','Clases para aprender boxeo','12:45:00','12:00:00','boxeo.jpg','Boxeo',23,_binary '\0',1,44,_binary '\0'),(33,_binary '\0','Clases para aprender boxeo','13:35:00','12:50:00','boxeo.jpg','Boxeo',23,_binary '\0',1,44,_binary '\0'),(34,_binary '\0','Clases para aprender boxeo','14:25:00','13:40:00','boxeo.jpg','Boxeo',23,_binary '\0',1,44,_binary '\0'),(35,_binary '\0','Clases para aprender boxeo','15:15:00','14:30:00','boxeo.jpg','Boxeo',23,_binary '\0',1,44,_binary '\0'),(36,_binary '\0','Clases para aprender tenis','19:30:00','18:00:00','tenis.jpg','Tenis',24,_binary '\0',1,45,_binary '\0'),(37,_binary '\0','Clases para aprender tenis','21:00:00','19:30:00','tenis.jpg','Tenis',24,_binary '\0',1,45,_binary '\0'),(38,_binary '\0','Aprende a nadar','18:20:00','17:25:00','natacion.jpg','Natación',10,_binary '\0',1,46,_binary '\0'),(39,_binary '\0','Aprende a nadar','19:20:00','18:25:00','natacion.jpg','Natación',10,_binary '\0',1,46,_binary '\0'),(40,_binary '\0','Aprende a nadar','20:20:00','19:25:00','natacion.jpg','Natación',10,_binary '\0',1,46,_binary '\0'),(41,_binary '\0','Aprende a nadar','21:20:00','20:25:00','natacion.jpg','Natación',10,_binary '\0',1,46,_binary '\0'),(42,_binary '\0','Clases de padel para niños entre 6 y 12 años','18:15:00','17:15:00','padel.jpg','Padel',5,_binary '\0',1,47,_binary '\0'),(43,_binary '\0','Clases de padel para niños entre 6 y 12 años','19:15:00','18:15:00','padel.jpg','Padel',5,_binary '\0',1,47,_binary '\0'),(44,_binary '\0','Clases de padel para niños entre 6 y 12 años','20:15:00','19:15:00','padel.jpg','Padel',5,_binary '\0',1,47,_binary '\0'),(45,_binary '\0','Clases de padel para niños entre 6 y 12 años','21:15:00','20:15:00','padel.jpg','Padel',5,_binary '\0',1,47,_binary '\0');
/*!40000 ALTER TABLE `clases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `detalles`
--

LOCK TABLES `detalles` WRITE;
/*!40000 ALTER TABLE `detalles` DISABLE KEYS */;
INSERT INTO `detalles` VALUES (1,0,'wf',23,23,1,NULL),(2,0,'Boxeo',23,23,2,NULL),(3,0,'Padel',35,35,2,NULL),(4,0,'Boxeo',23,23,3,NULL),(5,0,'Pablo',0,0,4,7),(6,0,'Pablo',0,0,5,6),(7,0,'teeeeeeeeeee',45,45,6,28),(8,0,'teeeeeeeeeee',45,45,7,29);
/*!40000 ALTER TABLE `detalles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `entrenador`
--

LOCK TABLES `entrenador` WRITE;
/*!40000 ALTER TABLE `entrenador` DISABLE KEYS */;
INSERT INTO `entrenador` VALUES (1,'Entrenador personal especializado en perdida de peso','istockphoto-675179390-612x612.jpg','Juan Perez',1,'Málaga',_binary '\0',NULL,NULL),(2,'dsfs','default.jpg','sfsfss',2,'Sevilla',_binary '\0',NULL,NULL),(5,'Entrenador especializado en padel','entrenador padel.jpg','Pedro',5,'Málaga',_binary '\0',NULL,NULL),(6,'Clases para aprender tenis','entrenador tenis.jpg','Tenis',6,'Sevilla',_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `entrenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `modalidad`
--

LOCK TABLES `modalidad` WRITE;
/*!40000 ALTER TABLE `modalidad` DISABLE KEYS */;
INSERT INTO `modalidad` VALUES (44,'2023-06-02','Boxeo',NULL,1,'boxeo.jpg','Presencial','Málaga',45,5,'14:30:00','09:35:00','Clases para aprender boxeo',23),(45,'2023-06-10','Tenis',NULL,1,'tenis.jpg','Online','Málaga',90,0,'20:30:00','16:30:00','Clases para aprender tenis',24),(46,'2023-06-02','Natación',NULL,1,'natacion.jpg','Online','Málaga',55,5,'21:00:00','16:30:00','Aprende a nadar',10),(47,'2023-06-04','Padel',NULL,1,'padel.jpg','Presencial','Sevilla',60,0,'20:45:00','16:15:00','Clases de padel para niños entre 6 y 12 años',5);
/*!40000 ALTER TABLE `modalidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
INSERT INTO `ordenes` VALUES (1,'2023-05-15 01:32:42',NULL,'0000000001',23,3),(2,'2023-05-15 02:04:01',NULL,'0000000002',58,3),(3,'2023-05-17 11:36:28',NULL,'0000000003',23,3),(4,'2023-05-31 12:03:49',NULL,'0000000004',0,3),(5,'2023-05-31 12:11:13',NULL,'0000000005',0,3),(6,'2023-05-31 15:01:45',NULL,'0000000006',45,3),(7,'2023-05-31 15:05:49',NULL,'0000000007',45,3);
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'p@p.p','p@p.p','p@p.p','$2a$10$Nnt.Hl4eBX7p9fPDNByd.OfGVJk9vFm8DTiU8EKOMNtOkNjKZIaZu',NULL,'ADMIN',NULL),(2,'a','a@p.p','a','$2a$10$oVDaBUnAAL81ZMMPKIPAL.fOxz9pOZfhaxgZwpP1WGrH0yN0.ABgq',NULL,'ADMIN',NULL),(4,'vvvv','v@p.p','v','$2a$10$pOa5ucIzfr.wlq6ZZdl/r.tV8/fSuIthKP92Dg3qIoij4jrR0GtaS',NULL,'USER',NULL),(5,'l','l@p.p','l','$2a$10$hSEEVtf4H.YErMEx3DdtC.aR1qTa1MEbhjVrE7HCEVb2H1d0BwagG',NULL,'ADMIN',NULL),(6,'r','r@p.p','r','$2a$10$U5.IAiK5JE.hMr55dEVn6utfqc5dfCrfov.B2KqExBdU5mzsqoewa',NULL,'ADMIN',NULL),(7,'f','f@p.p','f','$2a$10$HkGZHU4PTvDvsXxnJA6py.ElpwS.7ns0WSk9PVqqAR/vBQPD1uU6e',NULL,'USER',NULL);
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

-- Dump completed on 2023-06-01 19:34:06
