/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : vehiclesys

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2019-04-26 15:22:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car_info
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(50) DEFAULT NULL COMMENT '车辆品牌',
  `car_no` varchar(12) DEFAULT NULL COMMENT '车牌号码',
  `car_color` varchar(10) DEFAULT NULL COMMENT '车身颜色',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `owner_id` int(11) DEFAULT NULL COMMENT '车主ID',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
