-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: itfaiye
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `kullaniciAdi` varchar(50) NOT NULL,
  `sifre` varchar(50) NOT NULL,
  `adminYetkiId` int(11) NOT NULL,
  PRIMARY KEY (`kullaniciAdi`),
  KEY `adminYetkiId` (`adminYetkiId`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`adminYetkiId`) REFERENCES `adminyetki` (`adminYetkiId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('dvs','dsf',3),('isocan','123',1),('veyse12','sss5',1),('veysel','1513',3);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adminyetki`
--

DROP TABLE IF EXISTS `adminyetki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminyetki` (
  `adminYetkiId` int(11) NOT NULL AUTO_INCREMENT,
  `ekleme` tinyint(1) NOT NULL,
  `silme` tinyint(1) NOT NULL,
  `guncelleme` tinyint(1) NOT NULL,
  `ad` varchar(45) NOT NULL,
  PRIMARY KEY (`adminYetkiId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminyetki`
--

LOCK TABLES `adminyetki` WRITE;
/*!40000 ALTER TABLE `adminyetki` DISABLE KEYS */;
INSERT INTO `adminyetki` VALUES (1,1,1,0,'süper admin'),(3,0,0,1,'buğra'),(4,1,0,1,'ismail'),(5,1,0,0,'veysel');
/*!40000 ALTER TABLE `adminyetki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adres`
--

DROP TABLE IF EXISTS `adres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adres` (
  `adresId` int(11) NOT NULL AUTO_INCREMENT,
  `acikAdres` text NOT NULL,
  `caddeId` int(11) NOT NULL,
  PRIMARY KEY (`adresId`),
  KEY `caddeId` (`caddeId`),
  CONSTRAINT `adres_ibfk_1` FOREIGN KEY (`caddeId`) REFERENCES `cadde` (`caddeId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adres`
--

LOCK TABLES `adres` WRITE;
/*!40000 ALTER TABLE `adres` DISABLE KEYS */;
INSERT INTO `adres` VALUES (3,'sinan apt.',2),(6,'yağmur',1),(7,'hghjghjbh',2),(8,'etr',3),(9,'wefea',3),(10,'veysel sok',3),(11,'djshskjkşl',3);
/*!40000 ALTER TABLE `adres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arac`
--

DROP TABLE IF EXISTS `arac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arac` (
  `plaka` varchar(8) NOT NULL,
  `marka` varchar(30) NOT NULL,
  `model` varchar(30) NOT NULL,
  `ozellikleri` text,
  `kapasiteLitre` int(11) DEFAULT NULL,
  PRIMARY KEY (`plaka`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arac`
--

LOCK TABLES `arac` WRITE;
/*!40000 ALTER TABLE `arac` DISABLE KEYS */;
INSERT INTO `arac` VALUES ('34fsj45','mercedes','sprinter','2.5dci',155);
/*!40000 ALTER TABLE `arac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadde`
--

DROP TABLE IF EXISTS `cadde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cadde` (
  `caddeId` int(11) NOT NULL,
  `caddeAdi` varchar(30) NOT NULL,
  `mahalleId` int(11) NOT NULL,
  PRIMARY KEY (`caddeId`),
  KEY `mahalleId` (`mahalleId`),
  CONSTRAINT `cadde_ibfk_1` FOREIGN KEY (`mahalleId`) REFERENCES `mahalle` (`mahalleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadde`
--

LOCK TABLES `cadde` WRITE;
/*!40000 ALTER TABLE `cadde` DISABLE KEYS */;
INSERT INTO `cadde` VALUES (1,'sivas',1),(2,'kanal boyu',1),(3,'bağdat',1);
/*!40000 ALTER TABLE `cadde` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calisan`
--

DROP TABLE IF EXISTS `calisan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calisan` (
  `calisanId` int(11) NOT NULL AUTO_INCREMENT,
  `ekipId` int(11) NOT NULL,
  `tcNo` varchar(11) NOT NULL,
  `meslekId` int(11) NOT NULL,
  `resimId` int(11) NOT NULL,
  PRIMARY KEY (`calisanId`),
  KEY `ekipId` (`ekipId`),
  KEY `tcNo` (`tcNo`),
  KEY `meslekId` (`meslekId`),
  KEY `resimId` (`resimId`),
  CONSTRAINT `calisan_ibfk_1` FOREIGN KEY (`ekipId`) REFERENCES `ekip` (`ekipId`),
  CONSTRAINT `calisan_ibfk_2` FOREIGN KEY (`tcNo`) REFERENCES `vatandas` (`tcNo`),
  CONSTRAINT `calisan_ibfk_3` FOREIGN KEY (`meslekId`) REFERENCES `meslek` (`meslekId`),
  CONSTRAINT `calisan_ibfk_4` FOREIGN KEY (`resimId`) REFERENCES `resim` (`resimId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calisan`
--

LOCK TABLES `calisan` WRITE;
/*!40000 ALTER TABLE `calisan` DISABLE KEYS */;
INSERT INTO `calisan` VALUES (2,2,'25277130434',2,13),(3,5,'21749238028',3,1),(4,6,'25277730434',6,1),(5,7,'16786136918',5,12),(6,5,'13682721538',5,1),(7,7,'25277130434',4,6),(8,7,'21749238028',3,7),(9,2,'21749238028',2,8),(10,2,'13682721538',2,14),(11,3,'17267536210',3,15),(12,4,'17315534694',5,16),(13,5,'13682721538',4,17),(15,6,'25277130434',3,19);
/*!40000 ALTER TABLE `calisan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinsiyet`
--

DROP TABLE IF EXISTS `cinsiyet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cinsiyet` (
  `cinsiyetId` int(11) NOT NULL,
  `cinciyetAd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cinsiyetId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinsiyet`
--

LOCK TABLES `cinsiyet` WRITE;
/*!40000 ALTER TABLE `cinsiyet` DISABLE KEYS */;
INSERT INTO `cinsiyet` VALUES (1,'bay'),(2,'bayan');
/*!40000 ALTER TABLE `cinsiyet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ekip`
--

DROP TABLE IF EXISTS `ekip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ekip` (
  `ekipId` int(11) NOT NULL AUTO_INCREMENT,
  `ekipAdi` varchar(50) NOT NULL,
  `aciklama` text,
  PRIMARY KEY (`ekipId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ekip`
--

LOCK TABLES `ekip` WRITE;
/*!40000 ALTER TABLE `ekip` DISABLE KEYS */;
INSERT INTO `ekip` VALUES (2,'fena ekip','ekipq'),(3,'ewre','er'),(4,'fırtına',''),(5,'rüzgar',''),(6,'kaya',''),(7,'çamur','');
/*!40000 ALTER TABLE `ekip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ekipman`
--

DROP TABLE IF EXISTS `ekipman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ekipman` (
  `ekipmanId` int(11) NOT NULL AUTO_INCREMENT,
  `ekipmanAdi` varchar(30) NOT NULL,
  `icerik` text NOT NULL,
  `kullanimAlani` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ekipmanId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ekipman`
--

LOCK TABLES `ekipman` WRITE;
/*!40000 ALTER TABLE `ekipman` DISABLE KEYS */;
INSERT INTO `ekipman` VALUES (1,'kurtarma','halat , merdiven , vb mazemeler.','kurtarma çalışmaları'),(2,'kurtar2','demir makası','kurtarma çalışmaları');
/*!40000 ALTER TABLE `ekipman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ihbar`
--

DROP TABLE IF EXISTS `ihbar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ihbar` (
  `ihbarId` int(11) NOT NULL AUTO_INCREMENT,
  `tcNo` varchar(11) NOT NULL,
  `calisanId` int(11) NOT NULL,
  PRIMARY KEY (`ihbarId`),
  KEY `tcNo` (`tcNo`),
  KEY `calisanId` (`calisanId`),
  CONSTRAINT `ihbar_ibfk_1` FOREIGN KEY (`tcNo`) REFERENCES `vatandas` (`tcNo`),
  CONSTRAINT `ihbar_ibfk_2` FOREIGN KEY (`calisanId`) REFERENCES `calisan` (`calisanId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ihbar`
--

LOCK TABLES `ihbar` WRITE;
/*!40000 ALTER TABLE `ihbar` DISABLE KEYS */;
INSERT INTO `ihbar` VALUES (2,'21749238028',2),(3,'25277130434',3),(4,'25277130434',10),(5,'25277130434',5);
/*!40000 ALTER TABLE `ihbar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ilce`
--

DROP TABLE IF EXISTS `ilce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ilce` (
  `ilceId` int(11) NOT NULL AUTO_INCREMENT,
  `ilceAdi` varchar(30) NOT NULL,
  PRIMARY KEY (`ilceId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ilce`
--

LOCK TABLES `ilce` WRITE;
/*!40000 ALTER TABLE `ilce` DISABLE KEYS */;
INSERT INTO `ilce` VALUES (1,'battalgazi'),(2,'yeşilyurt'),(5,'darende'),(6,'arguvan');
/*!40000 ALTER TABLE `ilce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kullanici`
--

DROP TABLE IF EXISTS `kullanici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kullanici` (
  `kullaniciAdi` varchar(30) NOT NULL,
  `sifre` varchar(30) NOT NULL,
  `calisanId` int(11) NOT NULL,
  PRIMARY KEY (`kullaniciAdi`),
  KEY `calisanId` (`calisanId`),
  CONSTRAINT `kullanici_ibfk_1` FOREIGN KEY (`calisanId`) REFERENCES `calisan` (`calisanId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullanici`
--

LOCK TABLES `kullanici` WRITE;
/*!40000 ALTER TABLE `kullanici` DISABLE KEYS */;
INSERT INTO `kullanici` VALUES ('can1017','1017',5),('delali','ben1',4),('face','knlk',2),('ismail','ismail',2),('kdrdkmn','123',10),('kubragde','199544',11),('seda','jhghj',3),('sedag','123',12),('veysel','123',2),('youtube','qw',8);
/*!40000 ALTER TABLE `kullanici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kullaniciyetki`
--

DROP TABLE IF EXISTS `kullaniciyetki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kullaniciyetki` (
  `kullanciAdi` varchar(30) DEFAULT NULL,
  `yetkiId` int(11) NOT NULL,
  KEY `kullanciAdi` (`kullanciAdi`),
  KEY `yetkiId` (`yetkiId`),
  CONSTRAINT `kullaniciyetki_ibfk_1` FOREIGN KEY (`kullanciAdi`) REFERENCES `kullanici` (`kullaniciAdi`),
  CONSTRAINT `kullaniciyetki_ibfk_2` FOREIGN KEY (`yetkiId`) REFERENCES `yetki` (`yetkiId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullaniciyetki`
--

LOCK TABLES `kullaniciyetki` WRITE;
/*!40000 ALTER TABLE `kullaniciyetki` DISABLE KEYS */;
INSERT INTO `kullaniciyetki` VALUES ('veysel',2),('sedag',2),('ismail',1),('ismail',5),('can1017',5),('kdrdkmn',1),('kubragde',1),('seda',5),('youtube',2),('youtube',5),('delali',1),('delali',2),('delali',5),('face',1),('face',2);
/*!40000 ALTER TABLE `kullaniciyetki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mahalle`
--

DROP TABLE IF EXISTS `mahalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mahalle` (
  `mahalleId` int(11) NOT NULL AUTO_INCREMENT,
  `mahalleAdi` varchar(30) NOT NULL,
  `ilceId` int(11) NOT NULL,
  PRIMARY KEY (`mahalleId`),
  KEY `ilceId` (`ilceId`),
  CONSTRAINT `mahalle_ibfk_1` FOREIGN KEY (`ilceId`) REFERENCES `ilce` (`ilceId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mahalle`
--

LOCK TABLES `mahalle` WRITE;
/*!40000 ALTER TABLE `mahalle` DISABLE KEYS */;
INSERT INTO `mahalle` VALUES (1,'küçük hüseyin bey',2),(2,'kernek',5),(4,'cezacı',2),(5,'dsadfdggd',1),(6,'sıddık mah.',6);
/*!40000 ALTER TABLE `mahalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meslek`
--

DROP TABLE IF EXISTS `meslek`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meslek` (
  `meslekId` int(11) NOT NULL AUTO_INCREMENT,
  `meslekAd` varchar(30) NOT NULL,
  `aciklama` text,
  PRIMARY KEY (`meslekId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meslek`
--

LOCK TABLES `meslek` WRITE;
/*!40000 ALTER TABLE `meslek` DISABLE KEYS */;
INSERT INTO `meslek` VALUES (2,'teknisyen','makina bakımından sorumlu eleman'),(3,'doktor',''),(4,'att',''),(5,'şöför',''),(6,'müdür','');
/*!40000 ALTER TABLE `meslek` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mudahale`
--

DROP TABLE IF EXISTS `mudahale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mudahale` (
  `mudahaleId` int(11) NOT NULL AUTO_INCREMENT,
  `olayId` int(11) NOT NULL,
  `ekipmanId` int(11) NOT NULL,
  `ekipId` int(11) NOT NULL,
  `aracPlaka` varchar(8) NOT NULL,
  PRIMARY KEY (`mudahaleId`),
  KEY `olayId` (`olayId`),
  KEY `ekipmanId` (`ekipmanId`),
  KEY `ekipId` (`ekipId`),
  KEY `aracPlaka` (`aracPlaka`),
  CONSTRAINT `mudahale_ibfk_1` FOREIGN KEY (`olayId`) REFERENCES `olay` (`olayId`),
  CONSTRAINT `mudahale_ibfk_2` FOREIGN KEY (`ekipmanId`) REFERENCES `ekipman` (`ekipmanId`),
  CONSTRAINT `mudahale_ibfk_3` FOREIGN KEY (`ekipId`) REFERENCES `ekip` (`ekipId`),
  CONSTRAINT `mudahale_ibfk_4` FOREIGN KEY (`aracPlaka`) REFERENCES `arac` (`plaka`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mudahale`
--

LOCK TABLES `mudahale` WRITE;
/*!40000 ALTER TABLE `mudahale` DISABLE KEYS */;
INSERT INTO `mudahale` VALUES (1,3,1,6,'34fsj45'),(2,6,2,7,'34fsj45');
/*!40000 ALTER TABLE `mudahale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `olay`
--

DROP TABLE IF EXISTS `olay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `olay` (
  `olayId` int(11) NOT NULL AUTO_INCREMENT,
  `oluSayisi` int(11) DEFAULT NULL,
  `yaraliSayisi` int(11) DEFAULT NULL,
  `olayTarihi` datetime NOT NULL,
  `olayTipiId` int(11) NOT NULL,
  `adresId` int(11) NOT NULL,
  `ihbarId` int(11) NOT NULL,
  PRIMARY KEY (`olayId`),
  KEY `olayTipiId` (`olayTipiId`),
  KEY `adresId` (`adresId`),
  KEY `ihbarId` (`ihbarId`),
  CONSTRAINT `olay_ibfk_1` FOREIGN KEY (`olayTipiId`) REFERENCES `olaytipi` (`olayTipiId`),
  CONSTRAINT `olay_ibfk_2` FOREIGN KEY (`adresId`) REFERENCES `adres` (`adresId`),
  CONSTRAINT `olay_ibfk_3` FOREIGN KEY (`ihbarId`) REFERENCES `ihbar` (`ihbarId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `olay`
--

LOCK TABLES `olay` WRITE;
/*!40000 ALTER TABLE `olay` DISABLE KEYS */;
INSERT INTO `olay` VALUES (3,50,100,'2018-03-18 02:00:00',1,3,2),(4,0,0,'2017-07-21 03:00:00',3,10,4),(5,0,0,'2018-05-11 03:00:00',3,3,2),(6,0,0,'2017-01-20 02:00:00',5,11,5);
/*!40000 ALTER TABLE `olay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `olaytipi`
--

DROP TABLE IF EXISTS `olaytipi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `olaytipi` (
  `olayTipiId` int(11) NOT NULL AUTO_INCREMENT,
  `olayTipiAdi` varchar(30) NOT NULL,
  `aciklama` text,
  PRIMARY KEY (`olayTipiId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `olaytipi`
--

LOCK TABLES `olaytipi` WRITE;
/*!40000 ALTER TABLE `olaytipi` DISABLE KEYS */;
INSERT INTO `olaytipi` VALUES (1,'doğal','asas'),(3,'yangın','ateşli yangın lar adsaddsfds :)'),(5,'sel1',''),(6,'deprem',''),(10,'trafik kazası',''),(11,'sdf sdf','sdf');
/*!40000 ALTER TABLE `olaytipi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resim`
--

DROP TABLE IF EXISTS `resim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resim` (
  `resimId` int(11) NOT NULL AUTO_INCREMENT,
  `dosyaUzantisi` varchar(5000) NOT NULL,
  PRIMARY KEY (`resimId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resim`
--

LOCK TABLES `resim` WRITE;
/*!40000 ALTER TABLE `resim` DISABLE KEYS */;
INSERT INTO `resim` VALUES (1,'gfsr'),(2,'reghry'),(3,'y5rtere'),(4,'u56875u6yu75'),(5,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\0IMG-20170916-WA0006.jpg'),(6,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\0IMG-20170916-WA0003.jpg'),(7,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\0IMG-20170916-WA0003.jpg'),(8,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\01456693840382.jpg'),(9,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\5IMG_20161221_162936454.jpg'),(10,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\220170305_132724.jpg'),(11,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\220170303_131345.jpg'),(12,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\520170124_000307.jpg'),(13,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\220170303_221756.jpg'),(14,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\0IMG-20170305-WA0006.jpg'),(15,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\0IMG-20170305-WA0008.jpg'),(16,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\1220170303_221536.jpg'),(17,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\0buton.psd'),(18,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\020170923_131209.jpg'),(19,'C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\020170923_183155.jpg');
/*!40000 ALTER TABLE `resim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tttt`
--

DROP TABLE IF EXISTS `tttt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tttt` (
  `kullanciAdi` varchar(30) NOT NULL,
  `yetkiId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tttt`
--

LOCK TABLES `tttt` WRITE;
/*!40000 ALTER TABLE `tttt` DISABLE KEYS */;
/*!40000 ALTER TABLE `tttt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vatandas`
--

DROP TABLE IF EXISTS `vatandas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vatandas` (
  `tcNo` varchar(11) NOT NULL,
  `isim` varchar(30) NOT NULL,
  `soyIsim` varchar(30) NOT NULL,
  `dogumTarihi` datetime NOT NULL,
  `telefonNumarasi` varchar(11) DEFAULT NULL,
  `cinsiyetId` int(11) NOT NULL,
  PRIMARY KEY (`tcNo`),
  KEY `cinsiyetId` (`cinsiyetId`),
  CONSTRAINT `vatandas_ibfk_1` FOREIGN KEY (`cinsiyetId`) REFERENCES `cinsiyet` (`cinsiyetId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vatandas`
--

LOCK TABLES `vatandas` WRITE;
/*!40000 ALTER TABLE `vatandas` DISABLE KEYS */;
INSERT INTO `vatandas` VALUES ('0','isim yok','isim yok','1999-12-31 02:00:00','00000000000',2),('0101','jhjb','hbh','1980-01-22 03:00:00','1121212',2),('1111111111','isim yok','isim yok','1996-02-05 02:00:00','00000000000',1),('13682721538','kadir','dikmen','2001-01-23 02:00:00','515615',1),('16786136918','ismail can','karaçor','1995-09-27 02:00:00','5468545707',1),('17267536210','kübra','güde','1995-08-23 03:00:00','545151515',2),('17315534694','seda','güde','1993-11-09 02:00:00','87654321',2),('21749238028','yağmur','doğan','1996-02-05 02:00:00','5375964316',2),('25277130434','veysel','sebu','1996-01-24 02:00:00','5315238003',1),('25277730434','zeynep','doğan','2001-01-21 02:00:00','25151515',2);
/*!40000 ALTER TABLE `vatandas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yetki`
--

DROP TABLE IF EXISTS `yetki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yetki` (
  `yetkiId` int(11) NOT NULL AUTO_INCREMENT,
  `yetkiAd` varchar(30) NOT NULL,
  `aciklama` text,
  PRIMARY KEY (`yetkiId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yetki`
--

LOCK TABLES `yetki` WRITE;
/*!40000 ALTER TABLE `yetki` DISABLE KEYS */;
INSERT INTO `yetki` VALUES (1,'depo sorumlusu','nbnm'),(2,'yönetici','njknj'),(5,'bilgi daire','sasddsffd');
/*!40000 ALTER TABLE `yetki` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-16 12:07:32
