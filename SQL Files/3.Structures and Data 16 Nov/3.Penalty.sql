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

Date: 2017-11-14 20:47:04
*/


-- ----------------------------
-- Table structure for Penalty
-- ----------------------------
DROP TABLE TRANSPORTMANAGEMENT.Penalty;
CREATE TABLE TRANSPORTMANAGEMENT.Penalty (
PID NUMBER NOT NULL ,
Section VARCHAR2(255 BYTE) NOT NULL ,
Name VARCHAR2(255 BYTE) NOT NULL ,
Fine NUMBER NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of Penalty
-- ----------------------------
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('1', '3.5', 'facilisi cras non velit nec nisi', '6159.51');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('2', '0.8.1', 'pede venenatis non', '4911.39');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('3', '0.24', 'fusce lacus purus aliquet at feugiat', '743.31');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('4', '9.7.7', 'eu felis fusce posuere', '2354.35');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('5', '5.0', 'sagittis nam congue risus semper', '8896.62');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('6', '9.5', 'in ante vestibulum ante', '6566.57');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('7', '0.3.6', 'ut at dolor', '7769.21');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('8', '0.38', 'potenti nullam porttitor lacus at', '4634.17');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('9', '1.0.8', 'ac diam cras', '3032.65');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('10', '7.7.9', 'condimentum neque sapien placerat ante nulla', '9304.55');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('11', '0.13', 'in hac habitasse platea', '122.13');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('12', '7.77', 'dignissim vestibulum vestibulum ante ipsum primis', '1869.20');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('13', '3.0', 'turpis donec posuere metus vitae ipsum', '4284.29');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('14', '0.41', 'eu magna vulputate luctus cum', '3185.66');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('15', '5.6', 'lectus aliquam sit amet diam in', '5233.27');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('16', '2.8.6', 'maecenas tristique est et tempus semper', '8176.53');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('17', '3.76', 'natoque penatibus et magnis dis', '9141.24');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('18', '8.58', 'amet nunc viverra dapibus', '5994.39');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('19', '3.50', 'sociis natoque penatibus et magnis dis', '4185.47');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('20', '1.34', 'erat id mauris vulputate elementum nullam', '6829.73');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('21', '5.5.5', 'auctor sed tristique in', '6101.59');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('22', '0.87', 'vel enim sit amet', '6208.27');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('23', '9.6.2', 'faucibus orci luctus et', '801.76');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('24', '4.40', 'vel pede morbi porttitor', '7784.15');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('25', '6.2', 'quam pharetra magna ac consequat', '5469.05');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('26', '1.0.9', 'montes nascetur ridiculus', '6848.85');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('27', '0.6.5', 'nisi volutpat eleifend donec', '5611.13');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('28', '9.4.8', 'vivamus vestibulum sagittis sapien cum sociis', '6419.12');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('29', '8.86', 'sed interdum venenatis turpis enim blandit', '7470.92');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('30', '0.1.9', 'penatibus et magnis dis parturient montes', '4088.27');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('31', '9.37', 'fusce congue diam id ornare imperdiet', '9444.67');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('32', '0.30', 'potenti nullam porttitor lacus', '8562.03');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('33', '0.49', 'donec posuere metus vitae', '6503.72');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('34', '0.20', 'posuere felis sed lacus morbi sem', '2637.83');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('35', '2.9', 'maecenas ut massa quis augue', '4679.58');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('36', '0.9.3', 'ipsum primis in faucibus orci luctus', '4218.35');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('37', '7.6', 'purus eu magna vulputate luctus cum', '5383.26');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('38', '0.1.8', 'vestibulum ante ipsum', '2073.26');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('39', '9.8', 'etiam justo etiam pretium iaculis justo', '9245.41');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('40', '1.3.9', 'dui vel sem', '111.38');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('41', '0.8.7', 'dui maecenas tristique est et', '5137.38');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('42', '4.7', 'faucibus orci luctus et ultrices', '173.02');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('43', '2.4', 'tristique in tempus sit amet', '7520.88');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('44', '0.4.3', 'dolor sit amet consectetuer adipiscing elit', '4504.79');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('45', '3.9.5', 'orci nullam molestie nibh in lectus', '5191.18');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('46', '0.59', 'blandit mi in porttitor pede', '8773.68');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('47', '0.92', 'eros viverra eget', '5801.47');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('48', '9.7', 'suspendisse potenti nullam porttitor', '9213.15');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('49', '8.6', 'facilisi cras non velit nec', '449.28');
INSERT INTO TRANSPORTMANAGEMENT.Penalty VALUES ('50', '0.59', 'id luctus nec', '9686.88');

-- ----------------------------
-- Indexes structure for table Penalty
-- ----------------------------

-- ----------------------------
-- Checks structure for table Penalty
-- ----------------------------
ALTER TABLE TRANSPORTMANAGEMENT.Penalty ADD CHECK (PID IS NOT NULL);
ALTER TABLE TRANSPORTMANAGEMENT.Penalty ADD CHECK (Section IS NOT NULL);
ALTER TABLE TRANSPORTMANAGEMENT.Penalty ADD CHECK (Name IS NOT NULL);
ALTER TABLE TRANSPORTMANAGEMENT.Penalty ADD CHECK (Fine IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table Penalty
-- ----------------------------
ALTER TABLE TRANSPORTMANAGEMENT.Penalty ADD PRIMARY KEY (PID);
