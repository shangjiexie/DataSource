/*
Navicat MySQL Data Transfer

Source Server         : mydatasource
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : supermarket

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-04-30 00:09:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `resource_id` varchar(64) DEFAULT NULL COMMENT '商品id',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `status` int(1) DEFAULT NULL COMMENT '订单状态',
  `counts` int(2) DEFAULT '1',
  `resource_type_id` varchar(16) DEFAULT NULL COMMENT '商品类型id',
  `resource_type_name` varchar(16) DEFAULT NULL COMMENT '商品类型中文名称',
  `resource_dec` varchar(16) DEFAULT NULL COMMENT '商品描述',
  `resource_price` varchar(16) DEFAULT NULL COMMENT '商品价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '04673841553083500309', '123', '2', '1', '2', '名称', '发送到发送到', '66');
INSERT INTO `cart` VALUES ('2', '06879501554106353100', '123', '1', '1', '2', '香蕉', '电饭锅东方红', '666');
INSERT INTO `cart` VALUES ('3', '62979771553088210171', '123', '3', '1', '2', '水果', '阿斯蒂芬斯蒂芬', '6666');
INSERT INTO `cart` VALUES ('4', '41138841554105475422', '123', '2', '1', '3', '3', '叮叮当当', '123');
INSERT INTO `cart` VALUES ('5', '22360971554102016847', '123', '2', '1', '3', '3', '发发发', '111');

-- ----------------------------
-- Table structure for `guess_user_like`
-- ----------------------------
DROP TABLE IF EXISTS `guess_user_like`;
CREATE TABLE `guess_user_like` (
  `id` varchar(64) NOT NULL COMMENT '用户日志表id',
  `resource_type` varchar(16) DEFAULT NULL COMMENT '浏览商品的种类',
  `visitorCount` int(11) DEFAULT NULL COMMENT '浏览商品的数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of guess_user_like
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(64) NOT NULL COMMENT '订单编号',
  `order_resource_id` varchar(64) DEFAULT NULL COMMENT '订单对应的商品Id',
  `order_user_id` varchar(64) DEFAULT NULL COMMENT '订单对应的用户Id',
  `order_price` varchar(16) DEFAULT NULL COMMENT '订单交易价格',
  `order_time` datetime DEFAULT NULL COMMENT '订单时间',
  `order_province` varchar(32) DEFAULT NULL COMMENT '省',
  `order_city` varchar(32) DEFAULT NULL COMMENT '市',
  `order_county` varchar(32) DEFAULT NULL COMMENT '县/区',
  `order_adress` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `order_status` int(1) DEFAULT NULL COMMENT '订单状态（1，待发货、2待收货、3已收获，待评价、4已完成）',
  `order_count` int(6) DEFAULT '1' COMMENT '订单数量',
  `order_discounts_id` varchar(64) DEFAULT NULL COMMENT '优惠券id',
  `order_user_phone` varchar(64) DEFAULT NULL COMMENT '手机',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('0234fbc3-65ba-409f-8512-9e9c4b3bc25d', '04673841553083500309', '123', '18', '2019-04-20 23:48:54', '14', '1402', '140211', '设计系', '2', '1', '0', '15755337603');
INSERT INTO `orders` VALUES ('0309a4ff-2bc0-4568-aad4-f60b09df88bb', '33612871556534851369', 'ccdbab24f1484886a918207776ca59471554167478947', '66', '2019-04-30 12:32:46', '', '', '', '安徽省合肥市高新区', '1', '1', '', '15755337602');
INSERT INTO `orders` VALUES ('1', '22360971554102016847', 'ccdbab24f1484886a918207776ca59471554167478947', '66', '2019-04-04 13:45:11', '1', '2', '3', '合肥动漫基地', '3', '1', '2', '15755337603');
INSERT INTO `orders` VALUES ('2', '41138841554105475422', 'ccdbab24f1484886a918207776ca59471554167478947', '108', '2019-04-10 15:02:47', '2', '3', '2', '合肥滨湖区', '2', '1', '1', '15755337603');
INSERT INTO `orders` VALUES ('39a84b31-940e-4bf6-a090-b09596723abd', '04673841553083500309', 'ccdbab24f1484886a918207776ca59471554167478947', '18', '2019-04-20 04:07:02', '14', '1404', '140423', 'fgggggggggg', '3', '1', '0', '15755337603');
INSERT INTO `orders` VALUES ('4', '74918171554106428144', 'ccdbab24f1484886a918207776ca59471554167478947', '188', '2019-04-15 14:49:05', '4', '4', '2', '合肥高新区', '4', '1', '1', '15755320967');
INSERT INTO `orders` VALUES ('5d33302c-d93b-4162-b37d-4778d1a77ca6', '41138841554105475422', 'ccdbab24f1484886a918207776ca59471554167478947', '123', '2019-04-30 08:26:23', '', '', '', '安徽省合肥市高新区', '2', '1', '', '15755337602');

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `resource_id` varchar(64) NOT NULL DEFAULT 'id',
  `resource_name` varchar(64) DEFAULT NULL COMMENT '名称',
  `resource_dec` varchar(256) DEFAULT NULL COMMENT '描述',
  `resource_type` varchar(16) DEFAULT NULL COMMENT '类型',
  `resource_price` varchar(16) DEFAULT NULL COMMENT '价格',
  `resource_img` varchar(128) DEFAULT NULL COMMENT '图片',
  `resource_specification` varchar(32) DEFAULT NULL COMMENT '商品规格',
  `resource_inventory` int(8) DEFAULT '100' COMMENT '库存',
  `resource_sales_volume` int(8) DEFAULT '0' COMMENT '销量',
  `resource_evaluate_count` int(8) DEFAULT '0' COMMENT '累计评价数',
  `resource_view_count` int(8) DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('04673841553083500309', '橘子', '这是一个橘子的描述', '10001', '18', '/20190323110932kejian1.jpg', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('05138421554105438705', '传参', '这是一个很好的描述', '10002', '188', '/20190401155708kejian9.jpg', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('16059341556535001834', '这一个商品', '发广告', '10003', '77', '/20190429184951kejian19.jpg', '1个/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('19786311556548746934', '嘎达', '发多少', '10004', '32', '/20190429223901kejian31.jpg', '1个/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('22360971554102016847', '发发发', '发发发', '10005', '111', '/20190401150006kejian6.jpg', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('28800371554106426229', '来了', '反反复复付发', '10006', '66', '/20190401161341kejian4.jpg', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('33612871556534851369', '滚滚滚滚滚滚', '合肥电饭锅和', '10007', '66', '/20190429184719kejian11.jpg', '1KG/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('41138841554105475422', '方法', '叮叮当当', '10008', '123', '/20190401155751kejian2.png', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('41910941556547208027', 'u8ityu', '这个贵', '10009', '7787', '/20190429221301kejian12.jpg', '1袋/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('45605201556548709419', '你的', '飞电风扇', '10001', '111', '/20190429223819kejian29.jpg', '1袋/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('48466621554190552868', '这是个假货', '这是一个假货', '10002', '188', '/20190402153534kejian5.jpg', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('54824041556547035834', '反倒是股份', '过过过', '10003', '123', '/20190429221027kejian25.jpg', '1袋/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('56690041554105432330', '传参', '这是一个很好的描述', '10004', '188', '/20190401155708kejian9.jpg', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('58123741556534633029', '水果', '打算', '10005', '111', '/20190429184329as.png', '1个/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('58433281556548876057', '富士达', '放', '10006', '342', '/20190429224107kejian17.jpg', '1个/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('60149191556546784215', '我的额', 'uoippigod', '10001', '890', '/20190429220617kejian9.jpg', '1个/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('60180421554101882087', '这是一个香蕉', '这是一个非常甜的香蕉', '10001', '199', '/20190401145738kejian6.jpg', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('65104651556534684337', '测试', '过过过过过过过过到', '10001', '111', '/201904291844208745_UG.gif', '1KG/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('67081011556534817697', '这是个小狗狗', '的点点滴滴', '10001', '888', '/20190429184643kejian9.jpg', '1个/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('78409311554101940031', '现浇', '哒哒的', '10001', '1111', '/20190401145833kejian3.jpg', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('78832571554105444291', '传参', '这是一个很好的描述', '10001', '188', '/20190401155708kejian9.jpg', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('84666481556534821178', '这是个小狗狗', '的点点滴滴', '10003', '888', '/20190429184643kejian9.jpg', '1个/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('85588631553310581202', '苹果', '这是一个苹果的描述', '10001', '15', '/20190323110932kejian1.jpg', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('88754501556534675909', '测试', '过过过过过过过过到', '10003', '111', '/201904291844208745_UG.gif', '1KG/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('91184481556548575676', '反反复复付', '发的斯蒂芬水电费', '10002', '41111', '/20190429223606kejian30.jpg', '1个/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('91939811556547112246', '发广告', '发广告过过过', '10006', '66', '/20190429221137kejian32.jpg', '1袋/份', '1', '0', '0', '0');
INSERT INTO `resource` VALUES ('92822621554105442451', '传参', '这是一个很好的描述', '10001', '188', '/20190401155708kejian9.jpg', '1KG/份', '100', '0', '0', '0');
INSERT INTO `resource` VALUES ('97010991556548643264', '刚刚', '更大幅度的', '10003', '432223', '/20190429223717kejian20.jpg', '1KG/份', '1', '0', '0', '0');

-- ----------------------------
-- Table structure for `resource_comment`
-- ----------------------------
DROP TABLE IF EXISTS `resource_comment`;
CREATE TABLE `resource_comment` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `resource_id` varchar(64) DEFAULT NULL COMMENT '资源id',
  `comment_score` int(1) DEFAULT '0' COMMENT '评论的分数',
  `comment_content` varchar(128) DEFAULT NULL COMMENT '评论的内容',
  `comment_time` datetime DEFAULT NULL COMMENT '创建时间',
  `comment_user_id` varchar(64) DEFAULT NULL COMMENT '评论者id',
  `comment_user_name` varchar(255) DEFAULT NULL COMMENT '评论者姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=570 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_comment
-- ----------------------------
INSERT INTO `resource_comment` VALUES ('5', '14283991554203968056', '3', '8', '2019-04-04 09:38:06', '8', '8');
INSERT INTO `resource_comment` VALUES ('12', '14283991554203968056', '3', '234', '2019-04-06 19:16:07', '234', '234');
INSERT INTO `resource_comment` VALUES ('25', '14283991554203968056', '4', '1', '2019-04-03 18:43:56', '1', '1');
INSERT INTO `resource_comment` VALUES ('26', '14283991554203968056', '5', '1567', '2019-04-03 20:09:44', '1', '1');
INSERT INTO `resource_comment` VALUES ('27', '14283991554203968056', '2', '1', '2019-04-03 20:09:54', '1', '1');
INSERT INTO `resource_comment` VALUES ('468', '14283991554203968056', '5', '576', '2019-04-04 09:17:44', '5', '5');
INSERT INTO `resource_comment` VALUES ('567', '14283991554203968056', '0', '56', '2019-04-04 09:18:01', '8', '8');
INSERT INTO `resource_comment` VALUES ('568', '123', '5', '1', '2019-04-13 14:23:06', '1', '1');
INSERT INTO `resource_comment` VALUES ('569', '22360971554102016847', '3', 'f', '2019-04-29 23:14:50', 'ccdbab24f1484886a918207776ca59471554167478947', 'sjxie');

-- ----------------------------
-- Table structure for `resource_img`
-- ----------------------------
DROP TABLE IF EXISTS `resource_img`;
CREATE TABLE `resource_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_name` varchar(64) NOT NULL,
  `img_url` varchar(128) NOT NULL,
  `resource_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_img
-- ----------------------------

-- ----------------------------
-- Table structure for `resource_status`
-- ----------------------------
DROP TABLE IF EXISTS `resource_status`;
CREATE TABLE `resource_status` (
  `id` varchar(32) NOT NULL,
  `status_id` int(11) NOT NULL,
  `status_name` varchar(32) DEFAULT '' COMMENT '订单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_status
-- ----------------------------
INSERT INTO `resource_status` VALUES ('1', '1', '购物车');
INSERT INTO `resource_status` VALUES ('2', '2', '交易完成');
INSERT INTO `resource_status` VALUES ('3', '4', '收藏');
INSERT INTO `resource_status` VALUES ('4', '4', '待发货');
INSERT INTO `resource_status` VALUES ('5', '5', '待收货');
INSERT INTO `resource_status` VALUES ('6', '6', '待评价');

-- ----------------------------
-- Table structure for `resource_type`
-- ----------------------------
DROP TABLE IF EXISTS `resource_type`;
CREATE TABLE `resource_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` varchar(16) NOT NULL,
  `type_name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_type
-- ----------------------------
INSERT INTO `resource_type` VALUES ('1', '10001', '休闲');
INSERT INTO `resource_type` VALUES ('2', '10002', '饮品');
INSERT INTO `resource_type` VALUES ('3', '10003', '奶制');
INSERT INTO `resource_type` VALUES ('4', '10004', '膨化');
INSERT INTO `resource_type` VALUES ('5', '10005', '饼干');
INSERT INTO `resource_type` VALUES ('6', '10006', '糖果');
INSERT INTO `resource_type` VALUES ('7', '10007', '面包');
INSERT INTO `resource_type` VALUES ('8', '10008', '促销');
INSERT INTO `resource_type` VALUES ('9', '10009', '秒杀');

-- ----------------------------
-- Table structure for `supermarket_analyze`
-- ----------------------------
DROP TABLE IF EXISTS `supermarket_analyze`;
CREATE TABLE `supermarket_analyze` (
  `id` varchar(64) NOT NULL COMMENT '销售统计ID',
  `time` datetime NOT NULL COMMENT '销售时间',
  `registorCount` float DEFAULT NULL COMMENT '注册人数',
  `marketCount` float DEFAULT NULL COMMENT '销售额',
  `visitorCount` int(8) DEFAULT NULL COMMENT '访问量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supermarket_analyze
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(64) CHARACTER SET utf8 NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `user_sex` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `user_age` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `user_image` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `user_email` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `user_password` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码',
  `user_adress` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户详细地址',
  `user_type` varchar(2) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户类型',
  `user_phone` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('ccdbab24f1484886a918207776ca59471554167478946', 'zhangsan', '男', '23', null, '66', '123456', '88', '2', '10');
INSERT INTO `user` VALUES ('ccdbab24f1484886a918207776ca59471554167478947', 'sjxie', '女', '25', '5', '39406396@qq.com', '123456', '安徽省合肥市高新区', '1', '15755337602');
INSERT INTO `user` VALUES ('e1c1ec06b1194182b75ad05fb0ed11061555725403306', '谢尚杰', null, null, null, '1239406396@qq.com', 'xsj123', null, '2', '15755337603');
