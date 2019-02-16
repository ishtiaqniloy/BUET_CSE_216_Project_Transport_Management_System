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

Date: 2018-01-01 21:58:15
*/


-- ----------------------------
-- Table structure for DBUSER
-- ----------------------------
--DROP TABLE TRANSPORTMANAGEMENT.DBUSER;
CREATE TABLE TRANSPORTMANAGEMENT.DBUSER (
USERNAME VARCHAR2(255 BYTE) NOT NULL ,
PASSWORD VARCHAR2(255 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of DBUSER
-- ----------------------------
INSERT INTO TRANSPORTMANAGEMENT.DBUSER VALUES ('Nil', '11');
INSERT INTO TRANSPORTMANAGEMENT.DBUSER VALUES ('admin', 'admin');
INSERT INTO TRANSPORTMANAGEMENT.DBUSER VALUES ('Niloy', '1234');
INSERT INTO TRANSPORTMANAGEMENT.DBUSER VALUES ('NN', '11');
INSERT INTO TRANSPORTMANAGEMENT.DBUSER VALUES ('mm', 'mm');
INSERT INTO TRANSPORTMANAGEMENT.DBUSER VALUES ('MMMA', '1234');
INSERT INTO TRANSPORTMANAGEMENT.DBUSER VALUES ('asdaf', '12312');

-- ----------------------------
-- Indexes structure for table DBUSER
-- ----------------------------

-- ----------------------------
-- Checks structure for table DBUSER
-- ----------------------------
ALTER TABLE TRANSPORTMANAGEMENT.DBUSER ADD CHECK (USERNAME IS NOT NULL);
ALTER TABLE TRANSPORTMANAGEMENT.DBUSER ADD CHECK (PASSWORD IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table DBUSER
-- ----------------------------
ALTER TABLE TRANSPORTMANAGEMENT.DBUSER ADD PRIMARY KEY (USERNAME);
