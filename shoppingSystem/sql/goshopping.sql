/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : goshopping

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-04-23 22:10:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `commodity_id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `number` int(11) NOT NULL,
  `class_name` varchar(32) NOT NULL,
  `sort` varchar(32) DEFAULT NULL,
  `size` varchar(32) DEFAULT NULL,
  `color` varchar(32) DEFAULT NULL,
  `detail` varchar(64) NOT NULL,
  `image` varchar(32) NOT NULL,
  PRIMARY KEY (`commodity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('1', '100', '100', '女装', '上衣', 'S', '白色', '无', '001');
INSERT INTO `commodity` VALUES ('2', '100', '100', '女装', '裤子', 'S', '白色', '无', '002');
INSERT INTO `commodity` VALUES ('3', '100', '100', '女装', '连衣裙', 'S', '黑色', '无', '003');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `commodity_id` int(11) NOT NULL,
  `number` int(255) NOT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `user_id` (`user_id`),
  KEY `commodity_id` (`commodity_id`),
  CONSTRAINT `detail_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `detail_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `shopping_cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `commodity_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`shopping_cart_id`),
  KEY `user_id` (`user_id`),
  KEY `commodity_id` (`commodity_id`),
  CONSTRAINT `shopping_cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `shopping_cart_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `phone` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', 'aa', '123456', '123456');
INSERT INTO `user` VALUES ('4', '陈海堂', '123456', '123456');
