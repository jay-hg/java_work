-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.40-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_memomodule
--

CREATE DATABASE IF NOT EXISTS db_memomodule;
USE db_memomodule;

--
-- Definition of table `tb_memo`
--

DROP TABLE IF EXISTS `tb_memo`;
CREATE TABLE `tb_memo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `title` varchar(20) NOT NULL,
  `content` varchar(200) NOT NULL,
  `memotype` varchar(20) NOT NULL,
  `memotime` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_memo`
--

/*!40000 ALTER TABLE `tb_memo` DISABLE KEYS */;
INSERT INTO `tb_memo` (`id`,`username`,`title`,`content`,`memotype`,`memotime`) VALUES 
 (2,'王水水','文稿','文档文档文档文档文档文档文档文档文档文','会议','2011-05-30'),
 (3,'平平','光盘质量','光盘质量光盘质量光盘质量光盘质量光盘质量','光盘质量','2011-05-30'),
 (4,'小王','文档文档文档','文档文档文档文档文档文档文档文档文档文','文档','2011-05-30');
/*!40000 ALTER TABLE `tb_memo` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
