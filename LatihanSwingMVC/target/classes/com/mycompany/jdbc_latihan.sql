/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.28-MariaDB : Database - jdbc_latihan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jdbc_latihan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `jdbc_latihan`;

/*Table structure for table `tabel_matkul` */

DROP TABLE IF EXISTS `tabel_matkul`;

CREATE TABLE `tabel_matkul` (
  `kode_matkul` varchar(10) NOT NULL,
  `nama_matkul` varchar(64) DEFAULT NULL,
  `sks` int(1) DEFAULT NULL,
  PRIMARY KEY (`kode_matkul`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tabel_matkul` */

insert  into `tabel_matkul`(`kode_matkul`,`nama_matkul`,`sks`) values 
('',NULL,NULL),
('IF2201','Algoritma dan Struktur Data',3),
('IF2202','Rekayasa Perangkat Lunak',3),
('IF2203','Arsistektur Komputer',2),
('IF2204','Jaringan Komputer',2),
('IF2205','Manajemen Proyek Perangkat Lunak',3),
('IF2206','Pemograman Berorientasi Objek',4),
('IF2207','Interaksi Manusia Komputer',3),
('IF2208','Keamanan Sistem',3),
('IF2209','Matematika Informatika',2),
('IF2210','Matematika Diskrit',2),
('IF2211','APPL',3),
('IF2212','DPPL',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
