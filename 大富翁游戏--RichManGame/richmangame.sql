/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : richmangame

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 20/01/2022 20:01:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gameinfo
-- ----------------------------
DROP TABLE IF EXISTS `gameinfo`;
CREATE TABLE `gameinfo`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `gameName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `coinsChanges` int(255) NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`, `id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gameinfo
-- ----------------------------
INSERT INTO `gameinfo` VALUES (1, '1', 2, 3, '2022-01-20 12:55:05');
INSERT INTO `gameinfo` VALUES (2, '1', 2, 3, '2022-01-20 12:55:25');
INSERT INTO `gameinfo` VALUES (3, '1', 2, 4, '2022-01-20 12:55:33');
INSERT INTO `gameinfo` VALUES (1, '1', 3, 4, '2022-01-20 13:13:19');
INSERT INTO `gameinfo` VALUES (1, '34', 4, 4, '2022-01-20 14:03:12');
INSERT INTO `gameinfo` VALUES (2, '34', 4, 4, '2022-01-20 14:10:56');
INSERT INTO `gameinfo` VALUES (1, 'GuessingGame', 773931, 10, '2022-01-20 14:11:23');
INSERT INTO `gameinfo` VALUES (1, 'GuessingGame', 0, 2, '2022-01-20 14:12:21');
INSERT INTO `gameinfo` VALUES (4, 'GuessingGame', 773931, -1, '2022-01-20 14:20:33');
INSERT INTO `gameinfo` VALUES (3, 'GuessingGame', 773931, 2, '2022-01-20 14:20:32');
INSERT INTO `gameinfo` VALUES (2, 'GuessingGame', 773931, 10, '2022-01-20 14:17:03');
INSERT INTO `gameinfo` VALUES (5, 'GuessingGame', 773931, -1, '2022-01-20 14:20:34');
INSERT INTO `gameinfo` VALUES (2, 'GuessingGame', 0, -1, '2022-01-20 14:34:09');
INSERT INTO `gameinfo` VALUES (6, 'NumberGuessingGame', 773931, 8, '2022-01-20 14:36:49');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `userId` int(255) NOT NULL,
  `gameCoins` int(255) NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passWord` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (115253, 100, '7', '7');
INSERT INTO `userinfo` VALUES (117364, 100, '8', '8');
INSERT INTO `userinfo` VALUES (513964, 100, '9', '9');
INSERT INTO `userinfo` VALUES (638163, 100, 'asd', 'asd');
INSERT INTO `userinfo` VALUES (670186, 0, '1', '2');
INSERT INTO `userinfo` VALUES (773931, 137, '2', '1');
INSERT INTO `userinfo` VALUES (857515, 100, '3', '3');
INSERT INTO `userinfo` VALUES (900533, 102, '5', '5');

SET FOREIGN_KEY_CHECKS = 1;
