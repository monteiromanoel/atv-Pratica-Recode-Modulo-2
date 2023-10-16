-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: agencia_viagem
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `nome` varchar(50) DEFAULT NULL,
  `logradouro` varchar(100) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `cep` varchar(15) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `documento` varchar(20) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(80) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `data_nasc` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('Manoel Monteiro','Rua 1, 100 - Centro','Suzano','12345-123','SP','1112345678','123456789',1,'manoel1@email.com','12345','28/02/1996'),('Maria Cardoso','Rua 123, 5 - Bairro Alto','Santos','32134-512','SP','1123456789','32145688766',2,'maria@email.com','3123412','09/03/1966'),('Alberto dos Santos','Rua 3, 200 - Centro','Rio de Janeiro','98765-022','RJ','0912345678','432134564',3,'alberto@email.com','1234567','11/03/1989');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id` int NOT NULL AUTO_INCREMENT,
  `num_passageiros` int NOT NULL,
  `data_reserva` date DEFAULT NULL,
  `preco` double(10,2) DEFAULT NULL,
  `idCliente` int DEFAULT NULL,
  `idViagem` int DEFAULT NULL,
  `tipo_pacote` varchar(45) DEFAULT NULL,
  `destino` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCliente_idx` (`idCliente`),
  KEY `idViagem_idx` (`idViagem`),
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `idViagem` FOREIGN KEY (`idViagem`) REFERENCES `viagem` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,2,'2023-09-21',19780.00,1,2,'convencional','Veneza - Itália'),(4,2,'2023-09-22',14599.00,1,4,'convencional','Las Vegas - Nevada'),(5,2,'2023-09-22',2300.00,1,6,'promocional','Balneário Camboriú - Brasil'),(7,3,'2023-09-23',3450.00,3,6,'promocional','Balneário Camboriú - Brasil');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viagem`
--

DROP TABLE IF EXISTS `viagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viagem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `destino` varchar(50) NOT NULL,
  `preco` double(10,2) NOT NULL,
  `data_ida` varchar(30) NOT NULL,
  `data_volta` varchar(30) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `adicional` varchar(100) DEFAULT NULL,
  `tipo_pacote` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viagem`
--

LOCK TABLES `viagem` WRITE;
/*!40000 ALTER TABLE `viagem` DISABLE KEYS */;
INSERT INTO `viagem` VALUES (2,'Veneza - Itália',9890.00,'12/10/2023','29/10/2023','Aproveite as belezas de Veneza','Hospedagem e Tour','convencional'),(3,'Disney World - Orlando',11890.99,'5/11/2023','15/11/2023','Divirta-se no mundo mágico da Disney','Hospedagem e alimentação','promocional'),(4,'Las Vegas - Nevada',7299.50,'17/11/2023','29/11/2023','Visite Las Vegas, a cidade que nunca dorme','Hospedagem e tour','convencional'),(5,'Tokio - Japão',13350.00,'22/11/2023','29/11/2023','Conheça o Japão','Hospedagem e tour','promocional'),(6,'Balneário Camboriú - Brasil',1150.00,'15/11/2023','25/11/2023','Conheça Balneário e suas praias','Hospedagem e alimentação','promocional'),(7,'Roma - Madrid',9835.00,'01/02/2024','13/02/2024','Visite a maravilhosa Madrid','Hospedagem e Tour','promocional');
/*!40000 ALTER TABLE `viagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'agencia_viagem'
--

--
-- Dumping routines for database 'agencia_viagem'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-16 15:27:48
