/*
 Navicat Premium Data Transfer

 Source Server         : Tun
 Source Server Type    : MySQL
 Source Server Version : 100136
 Source Host           : localhost:3306
 Source Schema         : car

 Target Server Type    : MySQL
 Target Server Version : 100136
 File Encoding         : 65001

 Date: 16/11/2018 22:38:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tblbrand
-- ----------------------------
DROP TABLE IF EXISTS `tblbrand`;
CREATE TABLE `tblbrand`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `headquarter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `short_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_manager` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_to_user`(`id_manager`) USING BTREE,
  CONSTRAINT `fk_to_user` FOREIGN KEY (`id_manager`) REFERENCES `tbluser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tblbrand
-- ----------------------------
INSERT INTO `tblbrand` VALUES (1, 'Honda', 'Japan', 'Honda', 'https://goo.gl/thcnAS', 1);
INSERT INTO `tblbrand` VALUES (2, 'Ford', 'Usa', 'Ford', 'https://goo.gl/Xn4zHQ', 1);
INSERT INTO `tblbrand` VALUES (3, 'Mazda', 'Japan', 'Mazda', 'https://goo.gl/Xn4zHQ', 2);
INSERT INTO `tblbrand` VALUES (4, 'KIA', 'Japan', 'KIA', 'https://goo.gl/46zg9f', 1);
INSERT INTO `tblbrand` VALUES (5, 'TOYOTA', 'Japan', 'TOYOTA', 'https://goo.gl/L67UR4', 1);
INSERT INTO `tblbrand` VALUES (6, 'BUGATTI', 'France', 'BUGATTI', 'https://goo.gl/exTSks', 2);
INSERT INTO `tblbrand` VALUES (7, 'AUDI', 'Germany', 'AUDI', 'https://goo.gl/wAHwxe', 1);
INSERT INTO `tblbrand` VALUES (8, 'CHEVROLET', 'USA', 'CHEVROLET', 'https://goo.gl/jReMVb', 1);
INSERT INTO `tblbrand` VALUES (9, 'Chrysler', 'USA', 'Chrysler', 'https://goo.gl/cv7vsB', 1);
INSERT INTO `tblbrand` VALUES (10, 'BMW', 'USA', 'BMW', 'https://goo.gl/Q66Mkw', 1);
INSERT INTO `tblbrand` VALUES (11, 'Bentley', 'England', 'Bentley', 'https://goo.gl/v7QtTb', 1);
INSERT INTO `tblbrand` VALUES (12, 'Cadillac ', 'USA', 'Cadillac ', 'https://goo.gl/VyF1Pp', 1);
INSERT INTO `tblbrand` VALUES (13, 'Ferrari', 'Italy', 'Ferrari', 'https://goo.gl/yj5vo5', 1);
INSERT INTO `tblbrand` VALUES (14, 'Hyundai', 'South Korea', 'Hyundai', 'https://goo.gl/njb4nh', 1);
INSERT INTO `tblbrand` VALUES (15, 'Infiniti', 'Japan', 'Infiniti', 'https://goo.gl/XkoDTj', 1);
INSERT INTO `tblbrand` VALUES (16, 'Jeep', 'USA', 'Jeep', 'https://goo.gl/gpgioJ', 1);
INSERT INTO `tblbrand` VALUES (17, 'Lamborghini', 'Italy', 'Lamborghini', 'https://goo.gl/6TwHku', 1);
INSERT INTO `tblbrand` VALUES (18, 'Lexus', 'Japan', 'Lexus', 'https://goo.gl/Yw6gCU', 1);
INSERT INTO `tblbrand` VALUES (19, 'Mercedes-Benz', 'Germany', 'Mercedes', 'https://goo.gl/jDYFwQ', 1);
INSERT INTO `tblbrand` VALUES (30, 'Land Rover', 'England', 'Land Rover', 'https://goo.gl/ViuFm5', 1);
INSERT INTO `tblbrand` VALUES (31, 'Vinfast', NULL, NULL, NULL, 2);

-- ----------------------------
-- Table structure for tblcar
-- ----------------------------
DROP TABLE IF EXISTS `tblcar`;
CREATE TABLE `tblcar`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` float(10, 2) NULL DEFAULT NULL,
  `images` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_brand` int(11) NOT NULL,
  `id_manager` int(11) NOT NULL,
  `views` int(11) NULL DEFAULT 0,
  `last_update` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_brand`(`id_brand`) USING BTREE,
  INDEX `key2`(`id_manager`) USING BTREE,
  CONSTRAINT `key` FOREIGN KEY (`id_brand`) REFERENCES `tblbrand` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `key2` FOREIGN KEY (`id_manager`) REFERENCES `tbluser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tblcar
-- ----------------------------
INSERT INTO `tblcar` VALUES (1, 'Mercedes', NULL, NULL, NULL, 19, 1, 0, '2018-11-08 20:58:37');
INSERT INTO `tblcar` VALUES (2, 'BMW', NULL, NULL, NULL, 10, 2, 0, '2018-11-08 21:06:42');

-- ----------------------------
-- Table structure for tblcategory
-- ----------------------------
DROP TABLE IF EXISTS `tblcategory`;
CREATE TABLE `tblcategory`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `category_detail_count` int(11) NULL DEFAULT NULL,
  `id_manager` int(11) NOT NULL,
  `last_update` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user`(`id_manager`) USING BTREE,
  CONSTRAINT `fk_user` FOREIGN KEY (`id_manager`) REFERENCES `tbluser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tblcategory
-- ----------------------------
INSERT INTO `tblcategory` VALUES (2, 'Name', NULL, 1, '2018-11-08 00:00:00');

-- ----------------------------
-- Table structure for tblnews
-- ----------------------------
DROP TABLE IF EXISTS `tblnews`;
CREATE TABLE `tblnews`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `last_update` datetime(0) NULL DEFAULT NULL,
  `views` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk`(`author`) USING BTREE,
  INDEX `fk2`(`id_category`) USING BTREE,
  CONSTRAINT `fk` FOREIGN KEY (`author`) REFERENCES `tbluser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk2` FOREIGN KEY (`id_category`) REFERENCES `tblcategory` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tblupdatecar
-- ----------------------------
DROP TABLE IF EXISTS `tblupdatecar`;
CREATE TABLE `tblupdatecar`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_manager` int(11) NOT NULL,
  `id_car` int(11) NOT NULL,
  `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `frk`(`id_manager`) USING BTREE,
  INDEX `frk2`(`id_car`) USING BTREE,
  CONSTRAINT `frk` FOREIGN KEY (`id_manager`) REFERENCES `tbluser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `frk2` FOREIGN KEY (`id_car`) REFERENCES `tblcar` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tblupdatecar
-- ----------------------------
INSERT INTO `tblupdatecar` VALUES (1, 1, 1, '2018-11-08 20:59:13');

-- ----------------------------
-- Table structure for tblupdatenews
-- ----------------------------
DROP TABLE IF EXISTS `tblupdatenews`;
CREATE TABLE `tblupdatenews`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_manager` int(11) NOT NULL,
  `id_news` int(11) NOT NULL,
  `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fkupdate`(`id_manager`) USING BTREE,
  INDEX `fkupdate2`(`id_news`) USING BTREE,
  CONSTRAINT `fkupdate` FOREIGN KEY (`id_manager`) REFERENCES `tbluser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fkupdate2` FOREIGN KEY (`id_news`) REFERENCES `tblnews` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbluser
-- ----------------------------
DROP TABLE IF EXISTS `tbluser`;
CREATE TABLE `tbluser`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date_of_birth` int(11) NULL DEFAULT 1900,
  `gender` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `decentralization` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbluser
-- ----------------------------
INSERT INTO `tbluser` VALUES (1, 'Kun', 0, NULL, 'Kun', '12345', '', 'https://goo.gl/thcnAS');
INSERT INTO `tbluser` VALUES (2, 'Tun', 1997, 'male', 'dvt0804', '12345', 'admin', 'https://goo.gl/Xn4zHQ');
INSERT INTO `tbluser` VALUES (3, NULL, NULL, NULL, 'DVT', 'tun', NULL, 'https://goo.gl/Xn4zHQ');
INSERT INTO `tbluser` VALUES (4, NULL, NULL, NULL, 'DVT', '123', NULL, 'https://goo.gl/46zg9f');

SET FOREIGN_KEY_CHECKS = 1;
