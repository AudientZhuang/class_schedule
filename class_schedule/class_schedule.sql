/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : class_schedule

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-11-24 10:53:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '软件1班');
INSERT INTO `classes` VALUES ('2', '物联网');

-- ----------------------------
-- Table structure for classes_course
-- ----------------------------
DROP TABLE IF EXISTS `classes_course`;
CREATE TABLE `classes_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classes_id` int(11) NOT NULL,
  `content` varchar(100) NOT NULL,
  `x` tinyint(2) NOT NULL,
  `y` tinyint(2) NOT NULL,
  `len` tinyint(2) NOT NULL,
  `weeks` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classes_course_ibfk_1` (`classes_id`),
  CONSTRAINT `classes_course_ibfk_1` FOREIGN KEY (`classes_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes_course
-- ----------------------------
INSERT INTO `classes_course` VALUES ('1', '1', '语文', '1', '1', '1', '111111');
INSERT INTO `classes_course` VALUES ('2', '1', '数学', '2', '2', '2', '22222222');
INSERT INTO `classes_course` VALUES ('3', '1', '英语', '3', '3', '3', '33333333');
INSERT INTO `classes_course` VALUES ('5', '2', '高数', '1', '1', '1', '11111');
INSERT INTO `classes_course` VALUES ('6', '2', '大学英语', '2', '2', '2', '2222');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `number` varchar(12) NOT NULL,
  `name` varchar(20) NOT NULL,
  `classes_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classes_id` (`classes_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`classes_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `content` varchar(100) NOT NULL,
  `x` tinyint(2) NOT NULL,
  `y` tinyint(2) NOT NULL,
  `len` tinyint(2) NOT NULL,
  `weeks` varchar(20) NOT NULL,
  `classes_course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('4', '1', '啊哈哈哈', '3', '3', '3', '333333', '0');
INSERT INTO `student_course` VALUES ('5', '1', '啧啧啧', '2', '2', '2', '2', '2');
