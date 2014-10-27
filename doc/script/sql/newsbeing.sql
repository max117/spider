/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50704
Source Host           : localhost:3306
Source Database       : newsbeing

Target Server Type    : MYSQL
Target Server Version : 50704
File Encoding         : 65001

Date: 2014-10-27 18:40:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for nb_area
-- ----------------------------
DROP TABLE IF EXISTS `nb_area`;
CREATE TABLE `nb_area` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ParentID` int(11) NOT NULL COMMENT 'tree view area dir ;0 = root ',
  `AreaTag` varchar(100) NOT NULL COMMENT 'Area name or tag',
  `AreaIntro` varchar(2000) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nb_area
-- ----------------------------
INSERT INTO `nb_area` VALUES ('1', '0', '多伦多', 'GTA 大多伦多地区及周边');
INSERT INTO `nb_area` VALUES ('2', '0', '温哥华', '大温哥华地区及周边');
INSERT INTO `nb_area` VALUES ('3', '0', '纽约', '纽约州地区及周边');
INSERT INTO `nb_area` VALUES ('4', '0', '洛杉矶', '洛杉矶地区及周边');
INSERT INTO `nb_area` VALUES ('5', '0', '西雅图', '西雅图地区及周边');
INSERT INTO `nb_area` VALUES ('6', '0', '旧金山', '旧金山地区及周边');
INSERT INTO `nb_area` VALUES ('7', '1', 'Toronto city', '多伦多市区 TTC地铁覆盖区域');
INSERT INTO `nb_area` VALUES ('8', '1', 'Markham', '马克汉姆 多伦多近郊 华人聚集地');
INSERT INTO `nb_area` VALUES ('9', '1', 'Vaughan', '旺市 多伦多近郊 华人聚集地');
INSERT INTO `nb_area` VALUES ('10', '1', 'Richmond hill', '列治文山 多伦多近郊 华人聚集地');
INSERT INTO `nb_area` VALUES ('11', '1', 'Mississauga', '密西沙加');
INSERT INTO `nb_area` VALUES ('12', '1', 'Pickering', '皮克林');
INSERT INTO `nb_area` VALUES ('13', '1', 'Hamilton', '汉密尔顿');
INSERT INTO `nb_area` VALUES ('14', '1', 'Niagara', '尼亚加拉大瀑布');
INSERT INTO `nb_area` VALUES ('15', '7', 'North York', '北约克 华人聚集区');
INSERT INTO `nb_area` VALUES ('16', '7', 'Scarborough', '士嘉堡 新华人聚集区');
INSERT INTO `nb_area` VALUES ('17', '7', 'East York', '东约克 市中心');
INSERT INTO `nb_area` VALUES ('18', '7', 'York', '约克 市中心');
INSERT INTO `nb_area` VALUES ('19', '7', 'Etobicoke', '怡陶碧谷');
INSERT INTO `nb_area` VALUES ('20', '7', 'Thornhill', '汤山 老华人聚集');

-- ----------------------------
-- Table structure for nb_business
-- ----------------------------
DROP TABLE IF EXISTS `nb_business`;
CREATE TABLE `nb_business` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CompanyName` varchar(200) NOT NULL COMMENT 'It''s the name of company regist in office staff',
  `CompanyTitle` varchar(400) NOT NULL COMMENT 'show on web site or people usely call them',
  `CompanyIntro` text NOT NULL COMMENT 'long txt to intro business',
  `ServiceCall` varchar(100) NOT NULL COMMENT 'telephone of company for call',
  `ServiceMail` varchar(100) NOT NULL COMMENT 'email or other''s IM info',
  `ServiceAddress` varchar(1000) NOT NULL COMMENT 'number , street , area ,country ',
  `ServiceHours` varchar(400) NOT NULL COMMENT 'open hours info',
  `CatalogTags` varchar(2000) NOT NULL COMMENT 'all catalog name match the item will be addtion field',
  `AreaTags` varchar(1000) NOT NULL COMMENT 'country city hot area match the item ',
  `FrontCover` int(13) NOT NULL DEFAULT '0' COMMENT 'foreign key of table nb_business_res.ID',
  `Contacts` varchar(20) NOT NULL COMMENT 'who answer the call or boss name',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of nb_business
-- ----------------------------

-- ----------------------------
-- Table structure for nb_business_res
-- ----------------------------
DROP TABLE IF EXISTS `nb_business_res`;
CREATE TABLE `nb_business_res` (
  `ID` int(13) NOT NULL AUTO_INCREMENT,
  `BusinessID` int(11) NOT NULL COMMENT 'foreign key of table nb_business.ID',
  `FileName` varchar(200) NOT NULL,
  `FileIntro` varchar(2000) NOT NULL,
  `FileUrl` varchar(200) NOT NULL COMMENT 'foreign url or img.newsbeing.com/xx',
  `FileType` tinyint(3) unsigned zerofill NOT NULL COMMENT '0:image 1:video 2:music',
  `FileUploadTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of nb_business_res
-- ----------------------------

-- ----------------------------
-- Table structure for nb_catalog
-- ----------------------------
DROP TABLE IF EXISTS `nb_catalog`;
CREATE TABLE `nb_catalog` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ParentID` int(11) NOT NULL DEFAULT '0' COMMENT 'tree view catalog dir ;0 = root ',
  `CatalogTag` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT 'name of the catalog',
  `ItemIntro` varchar(1000) CHARACTER SET utf8 NOT NULL COMMENT 'catalog introduce',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of nb_catalog
-- ----------------------------
INSERT INTO `nb_catalog` VALUES ('1', '0', '房屋相关', '');
INSERT INTO `nb_catalog` VALUES ('2', '0', '汽车相关', '');
INSERT INTO `nb_catalog` VALUES ('3', '0', '保险理财', '');
INSERT INTO `nb_catalog` VALUES ('4', '0', '生活服务', '');
INSERT INTO `nb_catalog` VALUES ('5', '1', '地产中介', '具有地产行业执照的中介人员');
INSERT INTO `nb_catalog` VALUES ('6', '3', '旅游保险', '承接短期，探亲保险业务人员');
INSERT INTO `nb_catalog` VALUES ('7', '4', '家庭旅馆', '合租短期新移民服务');
INSERT INTO `nb_catalog` VALUES ('8', '4', '接送服务', '机场及旅游经典接送服务');

-- ----------------------------
-- Table structure for nb_info
-- ----------------------------
DROP TABLE IF EXISTS `nb_info`;
CREATE TABLE `nb_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'The text print on search list',
  `Summary` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT 'summary of the item',
  `Content` text CHARACTER SET utf8 COMMENT 'html after parse ',
  `SnapContent` text CHARACTER SET utf8 COMMENT 'original html',
  `SourceUrl` varchar(400) CHARACTER SET utf8 DEFAULT NULL COMMENT 'original url from',
  `Snaptime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CatalogTags` varchar(2000) CHARACTER SET utf8 DEFAULT NULL COMMENT 'all catalog name match the item will be addtion field',
  `AreaTags` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT 'country city hot area match the item ',
  `MapGoogle` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT 'address by map',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of nb_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_service_grab
-- ----------------------------
DROP TABLE IF EXISTS `tb_service_grab`;
CREATE TABLE `tb_service_grab` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'key',
  `service_type` varchar(180) DEFAULT NULL COMMENT '服务类型',
  `service_category` varchar(180) DEFAULT NULL COMMENT '服务品类',
  `service_title` varchar(180) DEFAULT NULL COMMENT '发布标题',
  `service_content` text COMMENT '发布内容',
  `service_contact` varchar(180) DEFAULT NULL COMMENT '联系人',
  `service_price` varchar(180) DEFAULT NULL COMMENT '服务价格',
  `service_area` varchar(360) DEFAULT NULL COMMENT '服务区域',
  `service_tel` varchar(180) DEFAULT NULL COMMENT '联系电话',
  `service_mail` varchar(180) DEFAULT NULL COMMENT '联系邮箱',
  `service_address` varchar(360) DEFAULT NULL COMMENT '公司地址',
  `service_map` varchar(360) DEFAULT NULL COMMENT '地图信息',
  `service_language` varchar(180) DEFAULT NULL COMMENT '使用语言',
  `service_update_time` varchar(180) DEFAULT NULL COMMENT '更新时间',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2928 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_service_grab
-- ----------------------------
