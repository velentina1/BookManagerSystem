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

 Date: 26/09/2023 15:31:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bookid` int NOT NULL AUTO_INCREMENT COMMENT '书籍编号',
  `bookName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍名称',
  `publisher` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '出版社',
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者',
  `bookType` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍类型',
  `remain` int NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`bookid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '艺术设计必修课', '化学工业出版社', '霍金', '艺术类', 10);
INSERT INTO `book` VALUES (2, '中国力量超级工程', '四川少年儿童出版社', '四川少年', '科技类', 200);
INSERT INTO `book` VALUES (3, '复活', '春风文艺出版社', '列夫·托尔斯泰', '文学类', 299);
INSERT INTO `book` VALUES (4, '每天懂一点人情世故', '天津科学技术出版社', '章岩', '文学类', 1);
INSERT INTO `book` VALUES (5, '孩子你要学会保护自己', '科学普及出版社', '未知', '文学类', 5);
INSERT INTO `book` VALUES (6, '葫芦娃', '儿童出版社', '罗玲', '儿童类', 10);
INSERT INTO `book` VALUES (7, '神秘的宇宙', '团结出版社', '詹姆斯•金斯', '科技类', 99);
INSERT INTO `book` VALUES (8, '朗读者', '人民文学', '董卿', '文学类', 3);

SET FOREIGN_KEY_CHECKS = 1;
