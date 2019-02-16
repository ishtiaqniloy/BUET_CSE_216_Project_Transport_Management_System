CREATE TABLESPACE tbs_perm_01
  DATAFILE 'tbs_perm_01.dat' 
    SIZE 20M
  ONLINE;

CREATE TEMPORARY TABLESPACE tbs_temp_01
  TEMPFILE 'tbs_temp_01.dbf'
    SIZE 5M
    AUTOEXTEND ON;

CREATE USER TransportManagement
  IDENTIFIED BY transport
  DEFAULT TABLESPACE tbs_perm_01
  TEMPORARY TABLESPACE tbs_temp_01
  QUOTA 20M on tbs_perm_01;



GRANT create session TO TransportManagement;
GRANT create table TO TransportManagement;
GRANT create view TO TransportManagement;
GRANT create any trigger TO TransportManagement;
GRANT create any procedure TO TransportManagement;
GRANT create sequence TO TransportManagement;
GRANT create synonym TO TransportManagement;

