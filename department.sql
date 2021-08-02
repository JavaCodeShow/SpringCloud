/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : cloudDB01

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-10-10 16:18:52
*/

SET
FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`
(
    `deptId`    bigint(255) NOT NULL AUTO_INCREMENT,
    `deptName`  varchar(255) DEFAULT NULL,
    `db_source` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`deptId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept`
VALUES ('1', '开发部', 'cloudDB01');
INSERT INTO `dept`
VALUES ('2', '人事部', 'cloudDB01');
INSERT INTO `dept`
VALUES ('3', '财务部', 'cloudDB01');
INSERT INTO `dept`
VALUES ('4', '运维部', 'cloudDB01');
INSERT INTO `dept`
VALUES ('5', '市场部', 'cloudDB01');
