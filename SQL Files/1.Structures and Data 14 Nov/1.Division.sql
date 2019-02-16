/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : TransportManagementSystem
Source Server Version : 110200
Source Host           : :1521
Source Schema         : TRANSPORTMANAGEMENT

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-11-14 20:46:26
*/


-- ----------------------------
-- Table structure for Division
-- ----------------------------
DROP TABLE "TRANSPORTMANAGEMENT"."Division";
CREATE TABLE "TRANSPORTMANAGEMENT"."Division" (
"Div_ID" NUMBER NOT NULL ,
"Name" VARCHAR2(255 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of Division
-- ----------------------------
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('2', 'Volzhskiy');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('3', 'Xinying');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('1', 'Baoluan');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('4', 'Jiangjiazui');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('5', 'Papetoai');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('6', 'Lonpao Dajah');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('7', 'Dailekh');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('8', 'Zaraza');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('9', 'Eybens');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('10', 'Lotoshino');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('11', 'Antalaha');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('12', 'Phutthaisong');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('13', 'Chaupimarca');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('14', 'Heilbronn');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('15', 'Qal‘eh-ye Khvājeh');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('16', 'Lityn');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('17', 'Trieste');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('18', 'Whittier');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('19', 'Baih');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('20', 'Lin’an');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('21', 'Opařany');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('22', 'Sulengwaseng');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('23', 'Felgueiras');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('24', 'Itinga');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('25', 'Clearwater');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('26', 'Wydminy');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('27', 'Stockholm');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('28', 'Huainan');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('29', 'Quva');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('30', 'Levallois-Perret');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('31', 'Eséka');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('32', 'Toulon');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('33', 'HanHuang');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('34', 'Knoxville');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('35', 'La Jagua de Ibirico');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('36', 'Longwood');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('37', 'Schiedam postbusnummers');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('38', 'Lanta Timur');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('39', 'Wailebe');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('40', 'Tempursari Wetan');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('41', 'Daqiao');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('42', 'Bontoc');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('43', 'Benito Juarez');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('44', 'Livramento do Brumado');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('45', 'Dougang');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('46', 'Wulongshan');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('47', 'Liljendal');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('48', 'Mlandizi');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('49', 'Suez');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('50', 'Palma De Mallorca');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('51', 'Kissónerga');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('52', 'Gentilly');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('53', 'Inuyama');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('54', 'Freiburg im Breisgau');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('55', 'Perches');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('56', 'Barrio San Luis');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('57', 'Totolan');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('58', 'San Juan Bautista');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('59', 'Comagascas');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('60', 'Al Ḩaffah');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('61', 'Tampa');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('62', 'Baru');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('63', 'Cayambe');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('64', 'Ochër');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('65', 'Capâo Bonito');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('66', 'La Cañada');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('67', 'Caen');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('68', 'Zicheng');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('69', 'Iksha');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('70', 'Rakhmanovo');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('71', 'Yaguarón');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('72', 'Surin');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('73', 'Narsingdi');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('74', 'Malá Strana');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('75', 'San Pedro de Atacama');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('76', 'Yoiqag');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('77', 'Nu’erbage');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('78', 'Novorossiysk');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('79', 'Bururi');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('80', 'Kudowa-Zdrój');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('81', 'Besançon');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('82', 'Eláteia');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('83', 'Jāndiāla Sher Khān');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('84', 'Kertasari');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('85', 'Jomboy');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('86', 'Tyazhinskiy');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('87', 'Tymbark');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('88', 'Sumbersewu');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('89', 'Trawniki');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('90', 'Apengjiang');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('91', 'Medalem');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('92', 'Karengan');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('93', 'Līvāni');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('94', 'Saint-Jean-de-Monts');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('95', 'Ivanava');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('96', 'Qingu');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('97', 'Krajan Dua Putukrejo');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('98', 'Torkanivka');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('99', 'Toledo');
INSERT INTO "TRANSPORTMANAGEMENT"."Division" VALUES ('100', 'Alcanena');

-- ----------------------------
-- Indexes structure for table Division
-- ----------------------------

-- ----------------------------
-- Checks structure for table Division
-- ----------------------------
ALTER TABLE "TRANSPORTMANAGEMENT"."Division" ADD CHECK ("Div_ID" IS NOT NULL);
ALTER TABLE "TRANSPORTMANAGEMENT"."Division" ADD CHECK ("Name" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table Division
-- ----------------------------
ALTER TABLE "TRANSPORTMANAGEMENT"."Division" ADD PRIMARY KEY ("Div_ID");
