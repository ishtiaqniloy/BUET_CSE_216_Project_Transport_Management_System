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

Date: 2018-01-01 21:59:20
*/


-- ----------------------------
-- Table structure for SERVICE
-- ----------------------------
--DROP TABLE TRANSPORTMANAGEMENT.SERVICE;
CREATE TABLE TRANSPORTMANAGEMENT.SERVICE (
SID NUMBER NOT NULL ,
NAME VARCHAR2(255 BYTE) NOT NULL ,
FEE NUMBER NOT NULL ,
TYPE VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SERVICE
-- ----------------------------
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('51', 'ABC', '121.2110', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('64', 'abcde', '1234', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('102', 'asdk', '1212', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('52', 'sasa', '1231', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('53', 'kajshajlskdanlsd', '122', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('54', 'asjhjasd', '1212', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('65', 'sdds', '1231', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('55', 'llaksjldk', '234243', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('57', 'qwdsa', '1231', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('60', 'klkjlknldfks', '100', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('87', 'ABCDEF', '9876', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('1', 'Tax Token Renew', '5000', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('2', 'maecenas leo', '3054', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('3', 'mattis odio donec', '4257.09', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('4', 'libero ut massa volutpat convallis morbi', '4209.55', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('5', 'justo sollicitudin ut suscipit a feugiat', '3396.46', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('6', 'at turpis a pede posuere nonummy', '6567.89', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('7', 'mauris viverra diam vitae quam suspendisse', '5045.14', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('8', 'urna pretium nisl ut', '3075.66', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('9', 'sapien arcu sed augue aliquam', '6530.28', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('10', 'id mauris vulputate elementum nullam varius', '4262.54', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('11', 'in porttitor pede justo eu massa', '7352.25', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('12', 'Fitness Certificate Reissue', '1200', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('13', 'vestibulum eget vulputate ut ultrices', '3456.70', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('14', 'tortor id nulla ultrices aliquet', '9335.97', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('15', 'nulla justo aliquam', '1231', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('16', 'vel enim sit amet nunc viverra', '6056.38', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('17', 'ante vivamus tortor duis', '3319.43', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('18', 'at diam nam tristique', '2060.39', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('19', 'ut suscipit a feugiat et', '9401.14', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('20', 'faucibus accumsan odio curabitur convallis duis', '1817.76', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('21', 'dui vel sem sed sagittis nam', '4356.49', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('22', 'donec dapibus duis at', '797.71', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('23', 'nulla sed vel enim', '9379.04', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('24', 'cursus id turpis integer', '1745.10', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('25', 'volutpat dui maecenas tristique est et', '3127.96', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('26', 'quis turpis eget elit sodales', '7031.99', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('27', 'eu mi nulla ac', '4596.04', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('28', 'lacinia sapien quis libero nullam', '5155.01', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('29', 'est quam pharetra magna ac', '8680.38', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('30', 'scelerisque quam turpis adipiscing lorem', '4845.43', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('31', 'tempus sit amet', '8719.93', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('32', 'eget massa tempor', '3646.60', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('33', 'dolor sit amet', '7304.01', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('34', 'augue vestibulum rutrum', '7712.69', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('35', 'cras mi pede malesuada in imperdiet', '2031.42', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('36', 'platea dictumst morbi vestibulum velit id', '3094.89', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('37', 'enim lorem ipsum', '8324.43', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('38', 'ante ipsum primis', '1443.06', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('39', 'ut nulla sed accumsan felis ut', '4952.23', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('40', 'iaculis justo in hac habitasse', '6237.15', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('41', 'dui vel sem sed sagittis nam', '6086.96', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('42', 'ac nibh fusce lacus purus', '523.24', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('43', 'ligula in lacus', '6059.31', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('44', 'dolor sit amet', '9098.64', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('45', 'suspendisse accumsan tortor quis', '6371.53', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('46', 'enim sit amet nunc', '1855.61', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('47', 'in sagittis dui vel nisl', '8089.71', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('48', 'urna pretium nisl ut', '4944.26', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('49', 'ut blandit non interdum', '9433.80', 'Vehicle');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('50', 'pretium iaculis diam erat fermentum justo', '6722.08', 'License');
INSERT INTO TRANSPORTMANAGEMENT.SERVICE VALUES ('56', 'aijsd', '1231', 'License');

-- ----------------------------
-- Indexes structure for table SERVICE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SERVICE
-- ----------------------------
ALTER TABLE TRANSPORTMANAGEMENT.SERVICE ADD CHECK (SID IS NOT NULL);
ALTER TABLE TRANSPORTMANAGEMENT.SERVICE ADD CHECK (NAME IS NOT NULL);
ALTER TABLE TRANSPORTMANAGEMENT.SERVICE ADD CHECK (FEE IS NOT NULL);
ALTER TABLE TRANSPORTMANAGEMENT.SERVICE ADD CHECK (SID IS NOT NULL);
ALTER TABLE TRANSPORTMANAGEMENT.SERVICE ADD CHECK (Name IS NOT NULL);
ALTER TABLE TRANSPORTMANAGEMENT.SERVICE ADD CHECK (Fee IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SERVICE
-- ----------------------------
ALTER TABLE TRANSPORTMANAGEMENT.SERVICE ADD PRIMARY KEY (SID);
