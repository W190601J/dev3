/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17 : Database - sells
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sells` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `sells`;

/*Table structure for table `chef` */

DROP TABLE IF EXISTS `chef`;

CREATE TABLE `chef` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '厨师ID',
  `cname` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '厨师名',
  `cinfo` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '厨师简介',
  `cphoto` varchar(512) COLLATE utf8_bin NOT NULL COMMENT '厨师照片',
  `ccreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '厨师新增时间',
  `cupdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '厨师修改时间',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='厨师表';

/*Data for the table `chef` */

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `cid` int(11) NOT NULL COMMENT '菜品类ID',
  `cnumber` int(11) NOT NULL COMMENT '菜品类编号',
  `cname` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '菜品类名',
  `classcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '菜品类创建时间',
  `classupdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '菜品类更新时间',
  `beiyong1` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '备用1',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜品分类表';

/*Data for the table `class` */

/*Table structure for table `details` */

DROP TABLE IF EXISTS `details`;

CREATE TABLE `details` (
  `did` int(32) NOT NULL AUTO_INCREMENT COMMENT '订单详情ID',
  `fid` int(32) NOT NULL COMMENT '菜品ID',
  `oid` int(32) NOT NULL COMMENT '订单总表ID',
  `dname` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '当前菜品姓名',
  `dprice` decimal(8,2) NOT NULL COMMENT '菜品当前价格',
  `dphoto` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '菜品图片',
  `quantity` int(11) NOT NULL COMMENT '订购菜品数量',
  `beiyong1` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '备用1',
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单详情表';

/*Data for the table `details` */

/*Table structure for table `food` */

DROP TABLE IF EXISTS `food`;

CREATE TABLE `food` (
  `fid` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '菜品ID',
  `fname` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '菜品名',
  `cnumber` int(11) NOT NULL COMMENT '菜品所属编号',
  `price` decimal(8,2) NOT NULL COMMENT '菜品价格',
  `fphoto` varchar(512) COLLATE utf8_bin NOT NULL COMMENT '菜品图片',
  `finfo` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '菜品简介',
  `fsell` int(11) DEFAULT '0' COMMENT '菜品销量:初始默认为0',
  `cstock` int(11) DEFAULT NULL COMMENT '菜品库存',
  `fstatus` int(11) NOT NULL DEFAULT '0' COMMENT '菜品状态:0为正常,1为下架',
  `fcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '菜品创建时间',
  `fupdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '菜品更新时间',
  `beiyong1` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '备用1',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜品表';

/*Data for the table `food` */

/*Table structure for table `ordering` */

DROP TABLE IF EXISTS `ordering`;

CREATE TABLE `ordering` (
  `oid` int(32) NOT NULL COMMENT '订单ID',
  `uid` int(32) NOT NULL COMMENT '买家ID',
  `bname` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '买家姓名',
  `bphone` char(11) COLLATE utf8_bin NOT NULL COMMENT '买家电话',
  `address` varchar(512) COLLATE utf8_bin NOT NULL COMMENT '买家地址',
  `amount` decimal(8,2) NOT NULL COMMENT '订单总额',
  `pay` int(11) NOT NULL DEFAULT '0' COMMENT '订单支付状态：0为未支付，1为已支付',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单修改时间',
  `beiyong1` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '备用1',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单表';

/*Data for the table `ordering` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(32) NOT NULL COMMENT '用户ID',
  `uname` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `upwd` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `uphone` char(11) COLLATE utf8_bin NOT NULL COMMENT '用户手机号',
  `ucreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `userupdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户更新时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

/*Data for the table `users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
