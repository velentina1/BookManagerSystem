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

 Date: 26/09/2023 15:31:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for borrowinfo
-- ----------------------------
DROP TABLE IF EXISTS `borrowinfo`;
CREATE TABLE `borrowinfo`  (
  `userId` int NOT NULL,
  `bookId` int NOT NULL,
  `borrowtime` datetime NULL DEFAULT NULL COMMENT '借阅时间',
  `returntime` datetime NULL DEFAULT NULL COMMENT '归还时间',
  `isreturn` int NULL DEFAULT NULL COMMENT '是否归还',
  PRIMARY KEY (`userId`, `bookId`) USING BTREE,
  INDEX `bookId`(`bookId` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrowinfo
-- ----------------------------
INSERT INTO `borrowinfo` VALUES (1, 1, '2023-09-10 00:00:00', NULL, 0);
INSERT INTO `borrowinfo` VALUES (1, 2, '2023-09-15 00:00:00', NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
