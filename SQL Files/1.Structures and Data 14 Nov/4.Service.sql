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

Date: 2017-11-14 20:47:19
*/


-- ----------------------------
-- Table structure for Service
-- ----------------------------
DROP TABLE "TRANSPORTMANAGEMENT"."Service";
CREATE TABLE "TRANSPORTMANAGEMENT"."Service" (
"SID" NUMBER NOT NULL ,
"Name" VARCHAR2(255 BYTE) NOT NULL ,
"Fee" NUMBER NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of Service
-- ----------------------------
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('1', 'lacinia aenean sit amet justo morbi', '5308.45');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('2', 'maecenas leo odio', '5251.63');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('3', 'mattis odio donec vitae', '4257.09');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('4', 'libero ut massa volutpat convallis morbi', '4209.55');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('5', 'justo sollicitudin ut suscipit a feugiat', '3396.46');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('6', 'at turpis a pede posuere nonummy', '6567.89');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('7', 'mauris viverra diam vitae quam suspendisse', '5045.14');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('8', 'urna pretium nisl ut', '3075.66');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('9', 'sapien arcu sed augue aliquam', '6530.28');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('10', 'id mauris vulputate elementum nullam varius', '4262.54');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('11', 'in porttitor pede justo eu massa', '7352.25');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('12', 'tincidunt eget tempus vel pede', '5714.43');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('13', 'vestibulum eget vulputate ut ultrices', '3456.70');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('14', 'tortor id nulla ultrices aliquet', '9335.97');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('15', 'nulla justo aliquam', '3027.34');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('16', 'vel enim sit amet nunc viverra', '6056.38');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('17', 'ante vivamus tortor duis', '3319.43');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('18', 'at diam nam tristique', '2060.39');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('19', 'ut suscipit a feugiat et', '9401.14');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('20', 'faucibus accumsan odio curabitur convallis duis', '1817.76');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('21', 'dui vel sem sed sagittis nam', '4356.49');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('22', 'donec dapibus duis at', '797.71');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('23', 'nulla sed vel enim', '9379.04');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('24', 'cursus id turpis integer', '1745.10');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('25', 'volutpat dui maecenas tristique est et', '3127.96');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('26', 'quis turpis eget elit sodales', '7031.99');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('27', 'eu mi nulla ac', '4596.04');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('28', 'lacinia sapien quis libero nullam', '5155.01');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('29', 'est quam pharetra magna ac', '8680.38');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('30', 'scelerisque quam turpis adipiscing lorem', '4845.43');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('31', 'tempus sit amet', '8719.93');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('32', 'eget massa tempor', '3646.60');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('33', 'dolor sit amet', '7304.01');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('34', 'augue vestibulum rutrum', '7712.69');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('35', 'cras mi pede malesuada in imperdiet', '2031.42');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('36', 'platea dictumst morbi vestibulum velit id', '3094.89');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('37', 'enim lorem ipsum', '8324.43');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('38', 'ante ipsum primis', '1443.06');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('39', 'ut nulla sed accumsan felis ut', '4952.23');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('40', 'iaculis justo in hac habitasse', '6237.15');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('41', 'dui vel sem sed sagittis nam', '6086.96');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('42', 'ac nibh fusce lacus purus', '523.24');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('43', 'ligula in lacus', '6059.31');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('44', 'dolor sit amet', '9098.64');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('45', 'suspendisse accumsan tortor quis', '6371.53');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('46', 'enim sit amet nunc', '1855.61');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('47', 'in sagittis dui vel nisl', '8089.71');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('48', 'urna pretium nisl ut', '4944.26');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('49', 'ut blandit non interdum', '9433.80');
INSERT INTO "TRANSPORTMANAGEMENT"."Service" VALUES ('50', 'pretium iaculis diam erat fermentum justo', '6722.08');

-- ----------------------------
-- Indexes structure for table Service
-- ----------------------------

-- ----------------------------
-- Checks structure for table Service
-- ----------------------------
ALTER TABLE "TRANSPORTMANAGEMENT"."Service" ADD CHECK ("SID" IS NOT NULL);
ALTER TABLE "TRANSPORTMANAGEMENT"."Service" ADD CHECK ("Name" IS NOT NULL);
ALTER TABLE "TRANSPORTMANAGEMENT"."Service" ADD CHECK ("Fee" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table Service
-- ----------------------------
ALTER TABLE "TRANSPORTMANAGEMENT"."Service" ADD PRIMARY KEY ("SID");
