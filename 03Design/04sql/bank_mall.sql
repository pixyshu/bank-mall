/*
 Navicat Premium Data Transfer

 Source Server         : 101.35.51.48
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : 101.35.51.48:3306
 Source Schema         : bank_mall

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 21/03/2022 19:18:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pms_product
-- ----------------------------
DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '产品名称',
  `title` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '副标题',
  `pic` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片',
  `description` text COLLATE utf8mb4_bin COMMENT '产品介绍',
  `code` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '产品代码',
  `first_purchase_money` decimal(10,2) DEFAULT NULL COMMENT '首笔起点金额',
  `add_purchase_money` decimal(10,2) DEFAULT NULL COMMENT '递增起点金额',
  `max_purchase_money` decimal(10,2) DEFAULT NULL COMMENT '单笔最高金额',
  `rate` decimal(10,2) DEFAULT NULL COMMENT '年利率',
  `sum_sale_money` decimal(10,2) DEFAULT NULL COMMENT '总共售卖',
  `is_publish` int(1) DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `is_new` int(1) DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `is_recommand` int(1) DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `service_id` int(1) DEFAULT NULL COMMENT '以逗号分隔产品服务：1 保本保息，2 当日起息，3快存快取',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '逻辑删除（1 表示删除，0表示未删除）',
  `promotion_start_time` datetime DEFAULT NULL COMMENT '促销开始时间',
  `promotion_end_time` datetime DEFAULT NULL COMMENT '促销结束时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间（添加数据时主动创建）',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间（操作数据时被动更新）',
  `type_id` bigint(20) DEFAULT NULL COMMENT '产品分类ID（活期、定期、债券基金、偏债基金、FOF基金）',
  `purchase_time_long` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '产品持有时常',
  `risk_level` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '风险等级',
  `on_shelf_time` datetime DEFAULT NULL COMMENT '上架时间',
  `off_shelf_time` datetime DEFAULT NULL COMMENT '下架时间',
  `nav` decimal(10,2) DEFAULT NULL COMMENT '单位净值',
  `total_rate` decimal(10,2) DEFAULT NULL COMMENT '发行到今天的总利率',
  `delete_time` datetime DEFAULT NULL COMMENT '删除产品时间',
  `category_id` bigint(20) DEFAULT NULL COMMENT '产品分类ID',
  `detail_id` bigint(20) DEFAULT NULL COMMENT '产品详情ID',
  `advertise_id` bigint(20) DEFAULT NULL COMMENT '产品广告ID',
  `industry_id` bigint(20) DEFAULT NULL COMMENT '行业ID',
  `time_cycle_id` bigint(20) DEFAULT NULL COMMENT '产品周期ID',
  `isuue_id` bigint(20) DEFAULT NULL COMMENT '发行ID',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`category_id`),
  KEY `FK_Reference_2` (`detail_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`category_id`) REFERENCES `pms_product_category` (`id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`detail_id`) REFERENCES `pms_product_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT=' 理财产品';

-- ----------------------------
-- Records of pms_product
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_product_advertise
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_advertise`;
CREATE TABLE `pms_product_advertise` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `info` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '广告宣传语(管理规模超万亿、超100万人持有、金选标准)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='产品广告标签';

-- ----------------------------
-- Records of pms_product_advertise
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_product_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category`;
CREATE TABLE `pms_product_category` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '产品类型名称',
  `description` text COLLATE utf8mb4_bin COMMENT '描述',
  `is_show` int(1) DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='产品分类';

-- ----------------------------
-- Records of pms_product_category
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_product_detail
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_detail`;
CREATE TABLE `pms_product_detail` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `currency` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '产品币种',
  `invest_type` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '投资性质',
  `sale_area` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '销售地区',
  `income_type` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '收益类型',
  `rasie_way` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '募集方式',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间（添加数据时主动创建）',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间（操作数据时被动更新）',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '逻辑删除（1 表示删除，0表示未删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='产品详情表';

-- ----------------------------
-- Records of pms_product_detail
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_product_industry
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_industry`;
CREATE TABLE `pms_product_industry` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '行业名称',
  `code` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '行业代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='产品行业';

-- ----------------------------
-- Records of pms_product_industry
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_product_issue
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_issue`;
CREATE TABLE `pms_product_issue` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '发行机构名称',
  `code` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '发行机构代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='发行机构';

-- ----------------------------
-- Records of pms_product_issue
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_product_rule
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_rule`;
CREATE TABLE `pms_product_rule` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `info` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '产品规则信息',
  `code` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '产品规则信息代号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='产品交易规则表';

-- ----------------------------
-- Records of pms_product_rule
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_product_time_cycle
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_time_cycle`;
CREATE TABLE `pms_product_time_cycle` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` bigint(64) DEFAULT NULL COMMENT '产品周期时长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='产品周期';

-- ----------------------------
-- Records of pms_product_time_cycle
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sms_flash_promotion
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion`;
CREATE TABLE `sms_flash_promotion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '活动标题',
  `start_date` date DEFAULT NULL COMMENT '开始日期',
  `end_date` date DEFAULT NULL COMMENT '结束日期',
  `status` int(1) DEFAULT NULL COMMENT '上下线状态',
  `create_time` datetime DEFAULT NULL COMMENT '秒杀时间段名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='限时购表';

-- ----------------------------
-- Records of sms_flash_promotion
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sms_flash_promotion_log
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion_log`;
CREATE TABLE `sms_flash_promotion_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `member_email` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '会员邮件',
  `product_name` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品名字',
  `subscribe_time` datetime DEFAULT NULL COMMENT '会员订阅时间',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='限时购通知记录';

-- ----------------------------
-- Records of sms_flash_promotion_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sms_flash_promotion_product_relation
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion_product_relation`;
CREATE TABLE `sms_flash_promotion_product_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `flash_promotion_id` bigint(20) DEFAULT NULL COMMENT '活动编号',
  `flash_promotion_session_id` bigint(20) DEFAULT NULL COMMENT '编号',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品编号',
  `flash_promotion_price` decimal(10,2) DEFAULT NULL COMMENT '限时购价格',
  `flash_promotion_count` int(11) DEFAULT NULL COMMENT '限时购数量',
  `flash_promotion_limit` int(11) DEFAULT NULL COMMENT '每人限购数量',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_77` (`flash_promotion_id`),
  KEY `FK_Reference_78` (`flash_promotion_session_id`),
  CONSTRAINT `FK_Reference_77` FOREIGN KEY (`flash_promotion_id`) REFERENCES `sms_flash_promotion` (`id`),
  CONSTRAINT `FK_Reference_78` FOREIGN KEY (`flash_promotion_session_id`) REFERENCES `sms_flash_promotion_session` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='商品限时购与商品关系表';

-- ----------------------------
-- Records of sms_flash_promotion_product_relation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sms_flash_promotion_session
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion_session`;
CREATE TABLE `sms_flash_promotion_session` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '场次名称',
  `start_time` time DEFAULT NULL COMMENT '每日开始时间',
  `end_time` time DEFAULT NULL COMMENT '每日结束时间',
  `status` int(1) DEFAULT NULL COMMENT '启用状态：0->不启用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='限时购场次表';

-- ----------------------------
-- Records of sms_flash_promotion_session
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sms_home_new_product
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_new_product`;
CREATE TABLE `sms_home_new_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `recommend_status` int(1) DEFAULT NULL,
  `sort` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='新鲜好物表';

-- ----------------------------
-- Records of sms_home_new_product
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sms_home_recommend_product
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_recommend_product`;
CREATE TABLE `sms_home_recommend_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `recommend_status` int(1) DEFAULT NULL,
  `sort` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='人气推荐商品表';

-- ----------------------------
-- Records of sms_home_recommend_product
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='后台用户表';

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
BEGIN;
INSERT INTO `ums_admin` (`id`, `username`, `password`, `icon`, `email`, `nick_name`, `note`, `create_time`, `login_time`, `status`) VALUES (1, 'test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', 'test@qq.com', '测试账号', NULL, '2018-09-29 13:55:30', '2018-09-29 13:55:39', 1);
INSERT INTO `ums_admin` (`id`, `username`, `password`, `icon`, `email`, `nick_name`, `note`, `create_time`, `login_time`, `status`) VALUES (3, 'admin', '$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', 'admin@163.com', '系统管理员', '系统管理员', '2018-10-08 13:32:47', '2019-04-20 12:45:16', 1);
INSERT INTO `ums_admin` (`id`, `username`, `password`, `icon`, `email`, `nick_name`, `note`, `create_time`, `login_time`, `status`) VALUES (4, 'macro', '$2a$10$Bx4jZPR7GhEpIQfefDQtVeS58GfT5n6mxs/b4nLLK65eMFa16topa', 'string', 'macro@qq.com', 'macro', 'macro专用', '2019-10-06 15:53:51', '2020-02-03 14:55:55', 1);
INSERT INTO `ums_admin` (`id`, `username`, `password`, `icon`, `email`, `nick_name`, `note`, `create_time`, `login_time`, `status`) VALUES (6, 'productAdmin', '$2a$10$6/.J.p.6Bhn7ic4GfoB5D.pGd7xSiD1a9M6ht6yO0fxzlKJPjRAGm', NULL, 'product@qq.com', '商品管理员', '只有商品权限', '2020-02-07 16:15:08', NULL, 1);
INSERT INTO `ums_admin` (`id`, `username`, `password`, `icon`, `email`, `nick_name`, `note`, `create_time`, `login_time`, `status`) VALUES (7, 'orderAdmin', '$2a$10$UqEhA9UZXjHHA3B.L9wNG.6aerrBjC6WHTtbv1FdvYPUI.7lkL6E.', NULL, 'order@qq.com', '订单管理员', '只有订单管理权限', '2020-02-07 16:15:50', NULL, 1);
INSERT INTO `ums_admin` (`id`, `username`, `password`, `icon`, `email`, `nick_name`, `note`, `create_time`, `login_time`, `status`) VALUES (11, 'shuisheng', '$2a$10$MQUf.1emifRGsiS3aWVqOOGPxL5sNOAvzQFb3s5zGtN9RYeWL6api', 'http://1.con', 'test@163.com', 'test', 'note', '2022-03-21 15:24:21', NULL, 1);
INSERT INTO `ums_admin` (`id`, `username`, `password`, `icon`, `email`, `nick_name`, `note`, `create_time`, `login_time`, `status`) VALUES (12, 'testshuisheng', '$2a$10$C9LkUXPh8UP8bjhk9bzjMudrqh39/v133hFENK0M4UfQJ9gLmRZze', '123', '123@qq.com', 'shuisheng', 'note', '2022-03-21 16:33:24', NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for ums_admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_login_log`;
CREATE TABLE `ums_admin_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `user_agent` varchar(100) DEFAULT NULL COMMENT '浏览器登录类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8 COMMENT='后台用户登录日志表';

-- ----------------------------
-- Records of ums_admin_login_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ums_admin_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_permission_relation`;
CREATE TABLE `ums_admin_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户和权限关系表(除角色中定义的权限以外的加减权限)';

-- ----------------------------
-- Records of ums_admin_permission_relation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ums_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_role_relation`;
CREATE TABLE `ums_admin_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='后台用户和角色关系表';

-- ----------------------------
-- Records of ums_admin_role_relation
-- ----------------------------
BEGIN;
INSERT INTO `ums_admin_role_relation` (`id`, `admin_id`, `role_id`) VALUES (26, 3, 5);
INSERT INTO `ums_admin_role_relation` (`id`, `admin_id`, `role_id`) VALUES (27, 6, 1);
INSERT INTO `ums_admin_role_relation` (`id`, `admin_id`, `role_id`) VALUES (28, 7, 2);
INSERT INTO `ums_admin_role_relation` (`id`, `admin_id`, `role_id`) VALUES (29, 1, 5);
INSERT INTO `ums_admin_role_relation` (`id`, `admin_id`, `role_id`) VALUES (30, 4, 5);
COMMIT;

-- ----------------------------
-- Table structure for ums_menu
-- ----------------------------
DROP TABLE IF EXISTS `ums_menu`;
CREATE TABLE `ums_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `title` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `level` int(4) DEFAULT NULL COMMENT '菜单级数',
  `sort` int(4) DEFAULT NULL COMMENT '菜单排序',
  `name` varchar(100) DEFAULT NULL COMMENT '前端名称',
  `icon` varchar(200) DEFAULT NULL COMMENT '前端图标',
  `hidden` int(1) DEFAULT NULL COMMENT '前端隐藏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='后台菜单表';

-- ----------------------------
-- Records of ums_menu
-- ----------------------------
BEGIN;
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (1, 0, '2020-02-02 14:50:36', '商品', 0, 0, 'pms', 'product', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (2, 1, '2020-02-02 14:51:50', '商品列表', 1, 0, 'product', 'product-list', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (3, 1, '2020-02-02 14:52:44', '添加商品', 1, 0, 'addProduct', 'product-add', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (4, 1, '2020-02-02 14:53:51', '商品分类', 1, 0, 'productCate', 'product-cate', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (5, 1, '2020-02-02 14:54:51', '商品类型', 1, 0, 'productAttr', 'product-attr', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (6, 1, '2020-02-02 14:56:29', '品牌管理', 1, 0, 'brand', 'product-brand', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (7, 0, '2020-02-02 16:54:07', '订单', 0, 0, 'oms', 'order', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (8, 7, '2020-02-02 16:55:18', '订单列表', 1, 0, 'order', 'product-list', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (9, 7, '2020-02-02 16:56:46', '订单设置', 1, 0, 'orderSetting', 'order-setting', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (10, 7, '2020-02-02 16:57:39', '退货申请处理', 1, 0, 'returnApply', 'order-return', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (11, 7, '2020-02-02 16:59:40', '退货原因设置', 1, 0, 'returnReason', 'order-return-reason', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (12, 0, '2020-02-04 16:18:00', '营销', 0, 0, 'sms', 'sms', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (13, 12, '2020-02-04 16:19:22', '秒杀活动列表', 1, 0, 'flash', 'sms-flash', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (14, 12, '2020-02-04 16:20:16', '优惠券列表', 1, 0, 'coupon', 'sms-coupon', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (16, 12, '2020-02-07 16:22:38', '品牌推荐', 1, 0, 'homeBrand', 'product-brand', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (17, 12, '2020-02-07 16:23:14', '新品推荐', 1, 0, 'homeNew', 'sms-new', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (18, 12, '2020-02-07 16:26:38', '人气推荐', 1, 0, 'homeHot', 'sms-hot', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (19, 12, '2020-02-07 16:28:16', '专题推荐', 1, 0, 'homeSubject', 'sms-subject', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (20, 12, '2020-02-07 16:28:42', '广告列表', 1, 0, 'homeAdvertise', 'sms-ad', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (21, 0, '2020-02-07 16:29:13', '权限', 0, 0, 'ums', 'ums', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (22, 21, '2020-02-07 16:29:51', '用户列表', 1, 0, 'admin', 'ums-admin', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (23, 21, '2020-02-07 16:30:13', '角色列表', 1, 0, 'role', 'ums-role', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (24, 21, '2020-02-07 16:30:53', '菜单列表', 1, 0, 'menu', 'ums-menu', 0);
INSERT INTO `ums_menu` (`id`, `parent_id`, `create_time`, `title`, `level`, `sort`, `name`, `icon`, `hidden`) VALUES (25, 21, '2020-02-07 16:31:13', '资源列表', 1, 0, 'resource', 'ums-resource', 0);
COMMIT;

-- ----------------------------
-- Table structure for ums_permission
-- ----------------------------
DROP TABLE IF EXISTS `ums_permission`;
CREATE TABLE `ums_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `value` varchar(200) DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) DEFAULT NULL COMMENT '图标',
  `type` int(1) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `uri` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
  `status` int(1) DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='后台用户权限表';

-- ----------------------------
-- Records of ums_permission
-- ----------------------------
BEGIN;
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (1, 0, '商品', NULL, NULL, 0, NULL, 1, '2018-09-29 16:15:14', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (2, 1, '商品列表', 'pms:product:read', NULL, 1, '/pms/product/index', 1, '2018-09-29 16:17:01', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (3, 1, '添加商品', 'pms:product:create', NULL, 1, '/pms/product/add', 1, '2018-09-29 16:18:51', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (4, 1, '商品分类', 'pms:productCategory:read', NULL, 1, '/pms/productCate/index', 1, '2018-09-29 16:23:07', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (5, 1, '商品类型', 'pms:productAttribute:read', NULL, 1, '/pms/productAttr/index', 1, '2018-09-29 16:24:43', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (6, 1, '品牌管理', 'pms:brand:read', NULL, 1, '/pms/brand/index', 1, '2018-09-29 16:25:45', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (7, 2, '编辑商品', 'pms:product:update', NULL, 2, '/pms/product/updateProduct', 1, '2018-09-29 16:34:23', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (8, 2, '删除商品', 'pms:product:delete', NULL, 2, '/pms/product/delete', 1, '2018-09-29 16:38:33', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (9, 4, '添加商品分类', 'pms:productCategory:create', NULL, 2, '/pms/productCate/create', 1, '2018-09-29 16:43:23', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (10, 4, '修改商品分类', 'pms:productCategory:update', NULL, 2, '/pms/productCate/update', 1, '2018-09-29 16:43:55', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (11, 4, '删除商品分类', 'pms:productCategory:delete', NULL, 2, '/pms/productAttr/delete', 1, '2018-09-29 16:44:38', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (12, 5, '添加商品类型', 'pms:productAttribute:create', NULL, 2, '/pms/productAttr/create', 1, '2018-09-29 16:45:25', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (13, 5, '修改商品类型', 'pms:productAttribute:update', NULL, 2, '/pms/productAttr/update', 1, '2018-09-29 16:48:08', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (14, 5, '删除商品类型', 'pms:productAttribute:delete', NULL, 2, '/pms/productAttr/delete', 1, '2018-09-29 16:48:44', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (15, 6, '添加品牌', 'pms:brand:create', NULL, 2, '/pms/brand/add', 1, '2018-09-29 16:49:34', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (16, 6, '修改品牌', 'pms:brand:update', NULL, 2, '/pms/brand/update', 1, '2018-09-29 16:50:55', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (17, 6, '删除品牌', 'pms:brand:delete', NULL, 2, '/pms/brand/delete', 1, '2018-09-29 16:50:59', 0);
INSERT INTO `ums_permission` (`id`, `pid`, `name`, `value`, `icon`, `type`, `uri`, `status`, `create_time`, `sort`) VALUES (18, 0, '首页', NULL, NULL, 0, NULL, 1, '2018-09-29 16:51:57', 0);
COMMIT;

-- ----------------------------
-- Table structure for ums_resource
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource`;
CREATE TABLE `ums_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `category_id` bigint(20) DEFAULT NULL COMMENT '资源分类ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='后台资源表';

-- ----------------------------
-- Records of ums_resource
-- ----------------------------
BEGIN;
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (1, '2020-02-04 17:04:55', '商品品牌管理', '/brand/**', NULL, 1);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (2, '2020-02-04 17:05:35', '商品属性分类管理', '/productAttribute/**', NULL, 1);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (3, '2020-02-04 17:06:13', '商品属性管理', '/productAttribute/**', NULL, 1);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (4, '2020-02-04 17:07:15', '商品分类管理', '/productCategory/**', NULL, 1);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (5, '2020-02-04 17:09:16', '商品管理', '/product/**', NULL, 1);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (6, '2020-02-04 17:09:53', '商品库存管理', '/sku/**', NULL, 1);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (8, '2020-02-05 14:43:37', '订单管理', '/order/**', '', 2);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (9, '2020-02-05 14:44:22', ' 订单退货申请管理', '/returnApply/**', '', 2);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (10, '2020-02-05 14:45:08', '退货原因管理', '/returnReason/**', '', 2);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (11, '2020-02-05 14:45:43', '订单设置管理', '/orderSetting/**', '', 2);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (12, '2020-02-05 14:46:23', '收货地址管理', '/companyAddress/**', '', 2);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (13, '2020-02-07 16:37:22', '优惠券管理', '/coupon/**', '', 3);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (14, '2020-02-07 16:37:59', '优惠券领取记录管理', '/couponHistory/**', '', 3);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (15, '2020-02-07 16:38:28', '限时购活动管理', '/flash/**', '', 3);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (16, '2020-02-07 16:38:59', '限时购商品关系管理', '/flashProductRelation/**', '', 3);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (17, '2020-02-07 16:39:22', '限时购场次管理', '/flashSession/**', '', 3);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (18, '2020-02-07 16:40:07', '首页轮播广告管理', '/home/advertise/**', '', 3);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (19, '2020-02-07 16:40:34', '首页品牌管理', '/home/brand/**', '', 3);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (20, '2020-02-07 16:41:06', '首页新品管理', '/home/newProduct/**', '', 3);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (21, '2020-02-07 16:42:16', '首页人气推荐管理', '/home/recommendProduct/**', '', 3);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (22, '2020-02-07 16:42:48', '首页专题推荐管理', '/home/recommendSubject/**', '', 3);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (23, '2020-02-07 16:44:56', ' 商品优选管理', '/prefrenceArea/**', '', 5);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (24, '2020-02-07 16:45:39', '商品专题管理', '/subject/**', '', 5);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (25, '2020-02-07 16:47:34', '后台用户管理', '/admin/**', '', 4);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (26, '2020-02-07 16:48:24', '后台用户角色管理', '/role/**', '', 4);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (27, '2020-02-07 16:48:48', '后台菜单管理', '/menu/**', '', 4);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (28, '2020-02-07 16:49:18', '后台资源分类管理', '/resourceCategory/**', '', 4);
INSERT INTO `ums_resource` (`id`, `create_time`, `name`, `url`, `description`, `category_id`) VALUES (29, '2020-02-07 16:49:45', '后台资源管理', '/resource/**', '', 4);
COMMIT;

-- ----------------------------
-- Table structure for ums_resource_category
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource_category`;
CREATE TABLE `ums_resource_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) DEFAULT NULL COMMENT '分类名称',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='资源分类表';

-- ----------------------------
-- Records of ums_resource_category
-- ----------------------------
BEGIN;
INSERT INTO `ums_resource_category` (`id`, `create_time`, `name`, `sort`) VALUES (1, '2020-02-05 10:21:44', '商品模块', 0);
INSERT INTO `ums_resource_category` (`id`, `create_time`, `name`, `sort`) VALUES (2, '2020-02-05 10:22:34', '订单模块', 0);
INSERT INTO `ums_resource_category` (`id`, `create_time`, `name`, `sort`) VALUES (3, '2020-02-05 10:22:48', '营销模块', 0);
INSERT INTO `ums_resource_category` (`id`, `create_time`, `name`, `sort`) VALUES (4, '2020-02-05 10:23:04', '权限模块', 0);
INSERT INTO `ums_resource_category` (`id`, `create_time`, `name`, `sort`) VALUES (5, '2020-02-07 16:34:27', '内容模块', 0);
INSERT INTO `ums_resource_category` (`id`, `create_time`, `name`, `sort`) VALUES (6, '2020-02-07 16:35:49', '其他模块', 0);
COMMIT;

-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='后台用户角色表';

-- ----------------------------
-- Records of ums_role
-- ----------------------------
BEGIN;
INSERT INTO `ums_role` (`id`, `name`, `description`, `admin_count`, `create_time`, `status`, `sort`) VALUES (1, '商品管理员', '只能查看及操作商品', 0, '2020-02-03 16:50:37', 1, 0);
INSERT INTO `ums_role` (`id`, `name`, `description`, `admin_count`, `create_time`, `status`, `sort`) VALUES (2, '订单管理员', '只能查看及操作订单', 0, '2018-09-30 15:53:45', 1, 0);
INSERT INTO `ums_role` (`id`, `name`, `description`, `admin_count`, `create_time`, `status`, `sort`) VALUES (5, '超级管理员', '拥有所有查看和操作功能', 0, '2020-02-02 15:11:05', 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for ums_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_menu_relation`;
CREATE TABLE `ums_role_menu_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 COMMENT='后台角色菜单关系表';

-- ----------------------------
-- Records of ums_role_menu_relation
-- ----------------------------
BEGIN;
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (33, 1, 1);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (34, 1, 2);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (35, 1, 3);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (36, 1, 4);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (37, 1, 5);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (38, 1, 6);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (53, 2, 7);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (54, 2, 8);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (55, 2, 9);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (56, 2, 10);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (57, 2, 11);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (72, 5, 1);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (73, 5, 2);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (74, 5, 3);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (75, 5, 4);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (76, 5, 5);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (77, 5, 6);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (78, 5, 7);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (79, 5, 8);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (80, 5, 9);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (81, 5, 10);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (82, 5, 11);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (83, 5, 12);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (84, 5, 13);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (85, 5, 14);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (86, 5, 16);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (87, 5, 17);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (88, 5, 18);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (89, 5, 19);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (90, 5, 20);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (91, 5, 21);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (92, 5, 22);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (93, 5, 23);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (94, 5, 24);
INSERT INTO `ums_role_menu_relation` (`id`, `role_id`, `menu_id`) VALUES (95, 5, 25);
COMMIT;

-- ----------------------------
-- Table structure for ums_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_permission_relation`;
CREATE TABLE `ums_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='后台用户角色和权限关系表';

-- ----------------------------
-- Records of ums_role_permission_relation
-- ----------------------------
BEGIN;
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (1, 1, 1);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (2, 1, 2);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (3, 1, 3);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (4, 1, 7);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (5, 1, 8);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (6, 2, 4);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (7, 2, 9);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (8, 2, 10);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (9, 2, 11);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (10, 3, 5);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (11, 3, 12);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (12, 3, 13);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (13, 3, 14);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (14, 4, 6);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (15, 4, 15);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (16, 4, 16);
INSERT INTO `ums_role_permission_relation` (`id`, `role_id`, `permission_id`) VALUES (17, 4, 17);
COMMIT;

-- ----------------------------
-- Table structure for ums_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_resource_relation`;
CREATE TABLE `ums_role_resource_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8 COMMENT='后台角色资源关系表';

-- ----------------------------
-- Records of ums_role_resource_relation
-- ----------------------------
BEGIN;
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (103, 2, 8);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (104, 2, 9);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (105, 2, 10);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (106, 2, 11);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (107, 2, 12);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (142, 5, 1);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (143, 5, 2);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (144, 5, 3);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (145, 5, 4);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (146, 5, 5);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (147, 5, 6);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (148, 5, 8);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (149, 5, 9);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (150, 5, 10);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (151, 5, 11);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (152, 5, 12);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (153, 5, 13);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (154, 5, 14);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (155, 5, 15);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (156, 5, 16);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (157, 5, 17);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (158, 5, 18);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (159, 5, 19);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (160, 5, 20);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (161, 5, 21);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (162, 5, 22);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (163, 5, 23);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (164, 5, 24);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (165, 5, 25);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (166, 5, 26);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (167, 5, 27);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (168, 5, 28);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (169, 5, 29);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (170, 1, 1);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (171, 1, 2);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (172, 1, 3);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (173, 1, 4);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (174, 1, 5);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (175, 1, 6);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (176, 1, 23);
INSERT INTO `ums_role_resource_relation` (`id`, `role_id`, `resource_id`) VALUES (177, 1, 24);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;