/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : base
Target Host     : localhost:3306
Target Database : base
Date: 2016-01-10 13:49:34
*/

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `memo` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=800004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('500', '-1', '监控列表', null, null, '500', null);
INSERT INTO `sys_menu` VALUES ('800', '-1', '系统管理', null, null, '800', null);
INSERT INTO `sys_menu` VALUES ('500001', '500', '检测管理', 'monitor/detection.html', null, '1', null);
INSERT INTO `sys_menu` VALUES ('500002', '500', '净化管理', 'monitor/purify.html', null, '2', null);
INSERT INTO `sys_menu` VALUES ('500003', '500', '路灯管理', 'monitor/streetlight.html', null, '3', null);
INSERT INTO `sys_menu` VALUES ('800001', '800', '账户管理', 'system/user.html', null, '1', null);
INSERT INTO `sys_menu` VALUES ('800002', '800', '部门管理', 'system/dept.html', null, '2', null);
INSERT INTO `sys_menu` VALUES ('800003', '800', '角色管理', 'system/role.html', null, '3', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `memo` varchar(512) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(128) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

