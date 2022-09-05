/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : geo_investigation_v3

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 05/09/2022 16:09:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_crop_type
-- ----------------------------
DROP TABLE IF EXISTS `t_crop_type`;
CREATE TABLE `t_crop_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_user` bigint(20) NULL DEFAULT NULL,
  `is_manager` int(255) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_crop_type
-- ----------------------------
INSERT INTO `t_crop_type` VALUES (2, '小麦', NULL, NULL, '2022-08-18 11:11:28', '2022-08-18 11:11:28');
INSERT INTO `t_crop_type` VALUES (4, '水稻', NULL, NULL, '2022-08-22 10:53:01', '2022-08-22 10:53:01');
INSERT INTO `t_crop_type` VALUES (6, 'qq', 6, 0, '2022-08-30 16:48:34', '2022-08-30 16:48:34');
INSERT INTO `t_crop_type` VALUES (7, 'rryu', 6, 0, '2022-08-30 16:55:08', '2022-08-30 16:55:08');
INSERT INTO `t_crop_type` VALUES (8, '33', 6, NULL, '2022-08-30 17:11:48', '2022-08-30 17:11:48');
INSERT INTO `t_crop_type` VALUES (9, 'zxcv', 6, 0, '2022-09-05 11:58:18', '2022-09-05 11:58:18');

-- ----------------------------
-- Table structure for t_crop_variety
-- ----------------------------
DROP TABLE IF EXISTS `t_crop_variety`;
CREATE TABLE `t_crop_variety`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_user` bigint(255) NULL DEFAULT NULL,
  `is_manager` int(255) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_crop_variety
-- ----------------------------
INSERT INTO `t_crop_variety` VALUES (5, 6, 'rr', 4, 1, '2022-08-30 16:51:46', '2022-08-30 16:51:46');

-- ----------------------------
-- Table structure for t_disease_img
-- ----------------------------
DROP TABLE IF EXISTS `t_disease_img`;
CREATE TABLE `t_disease_img`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(20) NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_disease_img
-- ----------------------------

-- ----------------------------
-- Table structure for t_disease_type
-- ----------------------------
DROP TABLE IF EXISTS `t_disease_type`;
CREATE TABLE `t_disease_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_user` bigint(20) NULL DEFAULT NULL,
  `is_manager` int(255) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_disease_type
-- ----------------------------
INSERT INTO `t_disease_type` VALUES (2, '花粉病', NULL, NULL, '2022-08-17 16:10:17', '2022-08-17 16:10:17');
INSERT INTO `t_disease_type` VALUES (4, 'gg', 6, 0, '2022-08-30 16:47:54', '2022-08-30 16:47:54');
INSERT INTO `t_disease_type` VALUES (5, 'qq', 6, 1, '2022-08-30 16:59:28', '2022-08-30 16:59:28');
INSERT INTO `t_disease_type` VALUES (6, '33', 6, NULL, '2022-08-30 17:12:37', '2022-08-30 17:12:37');

-- ----------------------------
-- Table structure for t_drought_img
-- ----------------------------
DROP TABLE IF EXISTS `t_drought_img`;
CREATE TABLE `t_drought_img`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(255) NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_drought_img
-- ----------------------------

-- ----------------------------
-- Table structure for t_land_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_land_attribute`;
CREATE TABLE `t_land_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `land_type_id` bigint(20) NOT NULL,
  `name_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `required` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_land_attribute
-- ----------------------------
INSERT INTO `t_land_attribute` VALUES (1, 2, '森林起源类型', 'origin of forest', '无', 0, NULL, NULL);
INSERT INTO `t_land_attribute` VALUES (2, 2, '森林用途', 'Forest use', '无', 1, NULL, NULL);
INSERT INTO `t_land_attribute` VALUES (4, 2, '植被高度', 'vegetation height', '无', 1, '2022-06-13 22:12:48', '2022-06-13 22:12:49');
INSERT INTO `t_land_attribute` VALUES (5, 2, '覆盖度', 'degree of coverage', '无', 1, '2022-06-13 22:22:05', '2022-06-13 22:22:05');
INSERT INTO `t_land_attribute` VALUES (8, 4, '333', '33', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_land_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `t_land_attribute_value`;
CREATE TABLE `t_land_attribute_value`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `land_attr_id` bigint(20) NOT NULL,
  `value_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_land_attribute_value
-- ----------------------------
INSERT INTO `t_land_attribute_value` VALUES (10, 8, '22', '22', NULL, NULL);

-- ----------------------------
-- Table structure for t_land_type
-- ----------------------------
DROP TABLE IF EXISTS `t_land_type`;
CREATE TABLE `t_land_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简体中文名称',
  `name_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '英文名称',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父类型id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_land_type
-- ----------------------------
INSERT INTO `t_land_type` VALUES (1, '林地', 'woodlands', NULL, NULL, NULL);
INSERT INTO `t_land_type` VALUES (2, '常绿阔叶林', 'Evergreen Broadleaved Forests', 1, NULL, NULL);
INSERT INTO `t_land_type` VALUES (3, '落叶阔叶林', 'Deciduous Broadleaved Forests', 1, NULL, NULL);
INSERT INTO `t_land_type` VALUES (4, '草地', 'grassland', NULL, NULL, NULL);
INSERT INTO `t_land_type` VALUES (5, '温性草甸草原', 'Warm meadow', 4, NULL, NULL);

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, 'system:permission:add', '添加新的权限', NULL, '2022-08-09 10:01:34', '2022-08-09 10:01:34');
INSERT INTO `t_permission` VALUES (2, 'system:permission:update', '修改权限', NULL, '2022-08-15 10:07:57', '2022-08-15 10:07:57');
INSERT INTO `t_permission` VALUES (3, 'system:permission:page', '分页查询权限列表', NULL, '2022-08-15 10:08:23', '2022-08-15 10:08:23');
INSERT INTO `t_permission` VALUES (4, 'system:role:add', '添加新的角色', NULL, '2022-08-15 10:08:57', '2022-08-15 10:08:57');
INSERT INTO `t_permission` VALUES (5, 'system:role:update', '修改角色', NULL, '2022-08-15 10:09:15', '2022-08-15 10:09:15');
INSERT INTO `t_permission` VALUES (6, 'system:role:delete', '删除角色', NULL, '2022-08-15 10:09:37', '2022-08-15 10:09:37');
INSERT INTO `t_permission` VALUES (7, 'system:role:page', '分页查询角色', NULL, '2022-08-15 10:11:33', '2022-08-15 10:11:33');
INSERT INTO `t_permission` VALUES (8, 'system:role:addPermission', '给角色添加权限', NULL, '2022-08-15 10:11:42', '2022-08-15 10:11:42');
INSERT INTO `t_permission` VALUES (9, 'system:role:getPermission', '获取该角色的所有权限', NULL, '2022-08-15 10:12:06', '2022-08-15 10:12:06');
INSERT INTO `t_permission` VALUES (10, 'system:role:deletePermission', '删除该角色的某个权限', NULL, '2022-08-15 10:12:15', '2022-08-15 10:12:15');
INSERT INTO `t_permission` VALUES (11, 'system:user:add', '添加用户', NULL, '2022-08-15 10:13:18', '2022-08-15 10:13:18');
INSERT INTO `t_permission` VALUES (12, 'system:user:update', '编辑用户', NULL, '2022-08-15 10:13:29', '2022-08-15 10:13:29');
INSERT INTO `t_permission` VALUES (13, 'system:user:delete', '删除用户', NULL, '2022-08-15 10:13:40', '2022-08-15 10:13:40');
INSERT INTO `t_permission` VALUES (14, 'system:user:page', '分页列表用户', NULL, '2022-08-15 10:14:00', '2022-08-15 10:14:00');
INSERT INTO `t_permission` VALUES (15, 'system:user:addRole', '给用户分配角色', NULL, '2022-08-15 10:14:12', '2022-08-15 10:14:12');
INSERT INTO `t_permission` VALUES (16, 'system:user:deleteRole', '删除用户的角色', NULL, '2022-08-15 10:14:19', '2022-08-15 10:14:19');
INSERT INTO `t_permission` VALUES (17, 'system:user:getRole', '查询用户的角色', NULL, '2022-08-15 10:14:29', '2022-08-15 10:14:29');
INSERT INTO `t_permission` VALUES (18, 'system:disease:add', '添加病害类型', NULL, '2022-08-22 10:35:17', '2022-08-22 10:35:17');
INSERT INTO `t_permission` VALUES (19, 'system:disease:update', '修改病害类型', NULL, '2022-08-22 10:38:42', '2022-08-22 10:38:42');
INSERT INTO `t_permission` VALUES (20, 'system:disease:delete', '删除病害类型', NULL, '2022-08-22 10:38:58', '2022-08-22 10:38:58');
INSERT INTO `t_permission` VALUES (21, 'system:disease:get', '查询所有的病害类型', NULL, '2022-08-22 10:39:09', '2022-08-22 10:39:09');
INSERT INTO `t_permission` VALUES (22, 'system:pest:add', '添加虫害类型', NULL, '2022-08-22 10:39:54', '2022-08-22 10:39:54');
INSERT INTO `t_permission` VALUES (23, 'system:pest:update', '修改虫害类型', NULL, '2022-08-22 10:40:11', '2022-08-22 10:40:11');
INSERT INTO `t_permission` VALUES (24, 'system:pest:delete', '删除虫害类型', NULL, '2022-08-22 10:40:31', '2022-08-22 10:40:31');
INSERT INTO `t_permission` VALUES (25, 'system:pest:get', '获取所有的虫害类型', NULL, '2022-08-22 10:40:56', '2022-08-22 10:40:56');
INSERT INTO `t_permission` VALUES (26, 'system:crop:addtype', '添加作物类型', NULL, '2022-08-22 10:41:38', '2022-08-22 10:41:38');
INSERT INTO `t_permission` VALUES (27, 'system:crop:updatetype', '修改作物类型', NULL, '2022-08-22 10:41:57', '2022-08-22 10:41:57');
INSERT INTO `t_permission` VALUES (28, 'system:crop:deletetype', '删除作物类型', NULL, '2022-08-22 10:42:16', '2022-08-22 10:42:16');
INSERT INTO `t_permission` VALUES (29, 'system:crop:gettype', '查询所有的作物类型', NULL, '2022-08-22 10:42:32', '2022-08-22 10:42:32');
INSERT INTO `t_permission` VALUES (30, 'system:crop:addvariety', '添加作物品种', NULL, '2022-08-22 10:43:16', '2022-08-22 10:43:16');
INSERT INTO `t_permission` VALUES (31, 'system:crop:updatevariety', '修改作物品种', NULL, '2022-08-22 10:43:31', '2022-08-22 10:43:31');
INSERT INTO `t_permission` VALUES (32, 'system:crop:deletevariety', '删除作物品种', NULL, '2022-08-22 10:44:00', '2022-08-22 10:44:00');
INSERT INTO `t_permission` VALUES (33, 'system:crop:getvariety', '查询所有的作物品种', NULL, '2022-08-22 10:44:06', '2022-08-22 10:44:06');
INSERT INTO `t_permission` VALUES (34, 'system:severity:add', '添加严重程度', NULL, '2022-08-22 10:45:01', '2022-08-22 10:45:01');
INSERT INTO `t_permission` VALUES (35, 'system:severity:update', '修改严重程度', NULL, '2022-08-22 10:45:53', '2022-08-22 10:45:53');
INSERT INTO `t_permission` VALUES (36, 'system:severity:delete', '删除严重程度', NULL, '2022-08-22 10:46:13', '2022-08-22 10:46:13');
INSERT INTO `t_permission` VALUES (37, 'system:severity:get', '查询所有的严重程度', NULL, '2022-08-22 10:46:46', '2022-08-22 10:46:46');
INSERT INTO `t_permission` VALUES (38, 'system:landtype:get', '获取土地类型', '', '2022-08-22 11:19:48', '2022-08-22 11:19:48');
INSERT INTO `t_permission` VALUES (39, 'system:landattribute:get', '获取土地属性及属性值', NULL, '2022-08-31 11:28:56', '2022-08-31 11:28:56');
INSERT INTO `t_permission` VALUES (40, 'system:landtype:add', '添加土地类型', NULL, '2022-08-31 11:29:22', '2022-08-31 11:29:22');
INSERT INTO `t_permission` VALUES (41, 'system:landattribute:add', '添加土地属性', NULL, '2022-08-31 11:29:52', '2022-08-31 11:29:52');
INSERT INTO `t_permission` VALUES (42, 'system:landattributevalue:add', '添加土地属性值', NULL, '2022-08-31 11:30:25', '2022-08-31 11:30:25');
INSERT INTO `t_permission` VALUES (43, 'system:landtype:update', '修改土地类型', NULL, '2022-08-31 11:30:45', '2022-08-31 11:30:45');
INSERT INTO `t_permission` VALUES (44, 'system:landtype:delete', '删除土地类型', NULL, '2022-08-31 11:31:09', '2022-08-31 11:31:09');
INSERT INTO `t_permission` VALUES (45, 'system:landattribute:update', '修改土地属性', NULL, '2022-08-31 11:31:46', '2022-08-31 11:31:46');
INSERT INTO `t_permission` VALUES (46, 'system:landattributevalue:update', '修改土地属性值', NULL, '2022-08-31 11:32:05', '2022-08-31 11:32:05');
INSERT INTO `t_permission` VALUES (47, 'system:landattribute:delete', '删除土地属性', NULL, '2022-08-31 11:32:22', '2022-08-31 11:32:22');
INSERT INTO `t_permission` VALUES (48, 'system:landattributevalue:delete', '删除土地属性值', NULL, '2022-08-31 11:32:39', '2022-08-31 11:32:39');

-- ----------------------------
-- Table structure for t_pest_img
-- ----------------------------
DROP TABLE IF EXISTS `t_pest_img`;
CREATE TABLE `t_pest_img`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(20) NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_pest_img
-- ----------------------------

-- ----------------------------
-- Table structure for t_pest_type
-- ----------------------------
DROP TABLE IF EXISTS `t_pest_type`;
CREATE TABLE `t_pest_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_user` bigint(20) NULL DEFAULT NULL,
  `is_manager` int(255) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_pest_type
-- ----------------------------
INSERT INTO `t_pest_type` VALUES (3, 'rr', 6, 0, '2022-08-30 16:48:09', '2022-08-30 16:48:09');
INSERT INTO `t_pest_type` VALUES (4, 'rrr', NULL, NULL, '2022-08-30 16:57:08', '2022-08-30 16:57:08');
INSERT INTO `t_pest_type` VALUES (5, 'ff', 6, 1, '2022-08-30 16:59:14', '2022-08-30 16:59:14');
INSERT INTO `t_pest_type` VALUES (6, '33', 4, 0, '2022-08-30 17:11:13', '2022-08-30 17:11:13');

-- ----------------------------
-- Table structure for t_record
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `survey_time` bigint(20) NULL DEFAULT NULL,
  `lat` decimal(10, 6) NULL DEFAULT NULL,
  `lng` decimal(10, 6) NULL DEFAULT NULL,
  `crop_type` bigint(20) NULL DEFAULT NULL,
  `crop_variety` bigint(20) NULL DEFAULT NULL,
  `disease_type` bigint(20) NULL DEFAULT NULL,
  `disease_severity` bigint(20) NULL DEFAULT NULL,
  `pest_type` bigint(20) NULL DEFAULT NULL,
  `pest_severity` bigint(20) NULL DEFAULT NULL,
  `drought_severity` bigint(20) NULL DEFAULT NULL,
  `land_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_record
-- ----------------------------
INSERT INTO `t_record` VALUES (3, 6, 0, 344.500000, 234.200000, 0, 0, 0, 0, 0, 0, 0, 'qwer', '2022-09-05 11:57:12', '2022-09-05 11:57:12');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'administrator', '管理员', NULL, NULL);
INSERT INTO `t_role` VALUES (2, 'user', '普通用户', NULL, NULL);
INSERT INTO `t_role` VALUES (3, 'superAdministrator', '超级管理员', '2022-08-08 15:35:40', '2022-08-08 15:35:40');
INSERT INTO `t_role` VALUES (5, 'test2', 'string', '2022-08-22 11:24:35', '2022-08-22 11:24:35');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (1, 1, 1, '2022-08-22 10:57:41', '2022-08-22 10:57:41');
INSERT INTO `t_role_permission` VALUES (2, 1, 2, '2022-08-22 10:57:46', '2022-08-22 10:57:46');
INSERT INTO `t_role_permission` VALUES (3, 1, 3, '2022-08-22 10:57:49', '2022-08-22 10:57:49');
INSERT INTO `t_role_permission` VALUES (4, 1, 4, '2022-08-22 10:57:52', '2022-08-22 10:57:52');
INSERT INTO `t_role_permission` VALUES (5, 1, 5, '2022-08-22 10:57:57', '2022-08-22 10:57:57');
INSERT INTO `t_role_permission` VALUES (6, 1, 6, '2022-08-22 10:58:06', '2022-08-22 10:58:06');
INSERT INTO `t_role_permission` VALUES (7, 1, 7, '2022-08-22 10:58:10', '2022-08-22 10:58:10');
INSERT INTO `t_role_permission` VALUES (8, 1, 8, '2022-08-22 10:58:14', '2022-08-22 10:58:14');
INSERT INTO `t_role_permission` VALUES (9, 1, 9, '2022-08-22 10:58:18', '2022-08-22 10:58:18');
INSERT INTO `t_role_permission` VALUES (10, 1, 10, '2022-08-22 10:58:24', '2022-08-22 10:58:24');
INSERT INTO `t_role_permission` VALUES (11, 1, 11, '2022-08-22 10:58:26', '2022-08-22 10:58:26');
INSERT INTO `t_role_permission` VALUES (12, 1, 12, '2022-08-22 10:58:31', '2022-08-22 10:58:31');
INSERT INTO `t_role_permission` VALUES (13, 1, 13, '2022-08-22 10:58:36', '2022-08-22 10:58:36');
INSERT INTO `t_role_permission` VALUES (14, 1, 14, '2022-08-22 10:58:39', '2022-08-22 10:58:39');
INSERT INTO `t_role_permission` VALUES (15, 1, 15, '2022-08-22 10:58:43', '2022-08-22 10:58:43');
INSERT INTO `t_role_permission` VALUES (16, 1, 16, '2022-08-22 10:58:47', '2022-08-22 10:58:47');
INSERT INTO `t_role_permission` VALUES (17, 1, 17, '2022-08-22 10:58:50', '2022-08-22 10:58:50');
INSERT INTO `t_role_permission` VALUES (18, 1, 18, '2022-08-22 10:58:54', '2022-08-22 10:58:54');
INSERT INTO `t_role_permission` VALUES (19, 1, 19, '2022-08-22 10:58:58', '2022-08-22 10:58:58');
INSERT INTO `t_role_permission` VALUES (20, 1, 20, '2022-08-22 10:59:02', '2022-08-22 10:59:02');
INSERT INTO `t_role_permission` VALUES (21, 1, 21, '2022-08-22 10:59:06', '2022-08-22 10:59:06');
INSERT INTO `t_role_permission` VALUES (22, 1, 22, '2022-08-22 10:59:09', '2022-08-22 10:59:09');
INSERT INTO `t_role_permission` VALUES (23, 1, 23, '2022-08-22 10:59:14', '2022-08-22 10:59:14');
INSERT INTO `t_role_permission` VALUES (24, 1, 24, '2022-08-22 10:59:17', '2022-08-22 10:59:17');
INSERT INTO `t_role_permission` VALUES (25, 1, 25, '2022-08-22 10:59:22', '2022-08-22 10:59:22');
INSERT INTO `t_role_permission` VALUES (26, 1, 26, '2022-08-22 10:59:26', '2022-08-22 10:59:26');
INSERT INTO `t_role_permission` VALUES (27, 1, 27, '2022-08-22 10:59:31', '2022-08-22 10:59:31');
INSERT INTO `t_role_permission` VALUES (28, 1, 28, '2022-08-22 10:59:35', '2022-08-22 10:59:35');
INSERT INTO `t_role_permission` VALUES (29, 1, 29, '2022-08-22 10:59:39', '2022-08-22 10:59:39');
INSERT INTO `t_role_permission` VALUES (30, 1, 30, '2022-08-22 10:59:42', '2022-08-22 10:59:42');
INSERT INTO `t_role_permission` VALUES (31, 1, 31, '2022-08-22 10:59:46', '2022-08-22 10:59:46');
INSERT INTO `t_role_permission` VALUES (32, 1, 32, '2022-08-22 10:59:49', '2022-08-22 10:59:49');
INSERT INTO `t_role_permission` VALUES (33, 1, 33, '2022-08-22 10:59:52', '2022-08-22 10:59:52');
INSERT INTO `t_role_permission` VALUES (34, 1, 34, '2022-08-22 10:59:55', '2022-08-22 10:59:55');
INSERT INTO `t_role_permission` VALUES (35, 1, 35, '2022-08-22 10:59:59', '2022-08-22 10:59:59');
INSERT INTO `t_role_permission` VALUES (36, 1, 36, '2022-08-22 11:00:03', '2022-08-22 11:00:03');
INSERT INTO `t_role_permission` VALUES (37, 1, 37, '2022-08-22 11:00:06', '2022-08-22 11:00:06');
INSERT INTO `t_role_permission` VALUES (40, 1, 38, '2022-08-31 11:33:17', '2022-08-31 11:33:17');
INSERT INTO `t_role_permission` VALUES (41, 1, 39, '2022-08-31 11:33:21', '2022-08-31 11:33:21');
INSERT INTO `t_role_permission` VALUES (42, 1, 40, '2022-08-31 11:33:27', '2022-08-31 11:33:27');
INSERT INTO `t_role_permission` VALUES (43, 1, 41, '2022-08-31 11:33:32', '2022-08-31 11:33:32');
INSERT INTO `t_role_permission` VALUES (44, 1, 42, '2022-08-31 11:33:39', '2022-08-31 11:33:39');
INSERT INTO `t_role_permission` VALUES (45, 1, 43, '2022-08-31 11:33:43', '2022-08-31 11:33:43');
INSERT INTO `t_role_permission` VALUES (46, 1, 44, '2022-08-31 11:33:48', '2022-08-31 11:33:48');
INSERT INTO `t_role_permission` VALUES (47, 1, 45, '2022-08-31 11:33:51', '2022-08-31 11:33:51');
INSERT INTO `t_role_permission` VALUES (48, 1, 46, '2022-08-31 11:33:55', '2022-08-31 11:33:55');
INSERT INTO `t_role_permission` VALUES (49, 1, 47, '2022-08-31 11:33:58', '2022-08-31 11:33:58');
INSERT INTO `t_role_permission` VALUES (50, 1, 48, '2022-08-31 11:34:02', '2022-08-31 11:34:02');

-- ----------------------------
-- Table structure for t_severity
-- ----------------------------
DROP TABLE IF EXISTS `t_severity`;
CREATE TABLE `t_severity`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_severity
-- ----------------------------
INSERT INTO `t_severity` VALUES (3, 'string', '2022-08-22 11:13:02', '2022-08-22 11:13:02');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (6, 'string', 'string', 'string', '$2a$10$CvGwwYl3GtZSN9PhUW7JPuv4T/vmdJOnozQycaDRP/HJOL16qGLve', '2022-07-21 10:14:11', '2022-07-21 10:14:11');
INSERT INTO `t_user` VALUES (12, 'kk', 'string', 'string', '$2a$10$puBk/2MrmhSPQ6mvmgzQv.vD7yDExHMWzMjY2WEVlryB7JBMmlJYu', '2022-08-22 10:54:12', '2022-08-22 10:54:12');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (6, 6, 1, '2022-08-01 11:16:04', '2022-08-01 11:16:04');
INSERT INTO `t_user_role` VALUES (12, 12, 2, '2022-08-22 10:54:11', '2022-08-22 10:54:11');
INSERT INTO `t_user_role` VALUES (13, 12, 1, '2022-08-22 11:43:52', '2022-08-22 11:43:52');

SET FOREIGN_KEY_CHECKS = 1;
