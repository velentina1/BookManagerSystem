/*
 Navicat Premium Data Transfer

 Source Server         : 主数据库
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : bmsdb

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 08/10/2023 11:54:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for borrowinfo
-- ----------------------------
DROP TABLE IF EXISTS `borrowinfo`;
CREATE TABLE `borrowinfo`  (
  `borrowId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `bookId` int NOT NULL,
  `borrowtime` datetime NULL DEFAULT NULL COMMENT '借阅时间',
  `returntime` datetime NULL DEFAULT NULL COMMENT '归还时间',
  `isreturn` int NULL DEFAULT NULL COMMENT '是否归还',
  PRIMARY KEY (`borrowId`) USING BTREE,
  INDEX `bookId`(`bookId` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrowinfo
-- ----------------------------
INSERT INTO `borrowinfo` VALUES (10001, 1, 1, '2023-09-10 00:00:00', NULL, 0);
INSERT INTO `borrowinfo` VALUES (10002, 1, 2, '2023-09-15 00:00:00', '2023-10-08 00:00:00', 1);
INSERT INTO `borrowinfo` VALUES (10003, 2, 4, '2023-05-15 00:00:00', NULL, 0);
INSERT INTO `borrowinfo` VALUES (10004, 3, 3, '2023-04-30 00:00:00', '2023-10-08 00:00:00', 1);
INSERT INTO `borrowinfo` VALUES (10005, 3, 3, '2023-10-08 00:00:00', NULL, 0);
INSERT INTO `borrowinfo` VALUES (10006, 3, 3, '2023-10-08 00:00:00', '2023-10-08 00:00:00', 1);

SET FOREIGN_KEY_CHECKS = 1;
