

SET FOREIGN_KEY_CHECKS=0;
/*

CREATE USER 'ecas'@'%' IDENTIFIED BY 'ecasoptr';
CREATE DATABASE ecasdb;
*/
DROP  TABLE IF EXISTS   ecasdb.ecas_login_oauth;
CREATE TABLE ecasdb.ecas_login_oauth(
   user_id varchar(36) NOT  null,
   auth_id varchar(36) NOT NULL,
   auth_name VARCHAR(36) DEFAULT NULL,
   auth_access_token VARCHAR (256) DEFAULT NULL ,
   auth_expires int(10),
   auth_time    timestamp NOT NULL default CURRENT_TIMESTAMP,
   auth_ip  VARCHAR (256)
) DEFAULT CHARSET=utf8;

DROP  TABLE IF EXISTS   ecasdb.ecas_user_info;
CREATE TABLE ecasdb.ecas_user_info (
    user_id VARCHAR(36) NOT NULL,
    user_name VARCHAR(36) DEFAULT NULL,
    password VARCHAR(256) NOT NULL,
    gender CHAR(1) DEFAULT NULL,
    age TINYINT(3),
    email VARCHAR(256) DEFAULT NULL,
    phone INT(11),
    birthday DATETIME DEFAULT NULL,
    create_time DATETIME NOT NULL,
    modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)  DEFAULT CHARSET=UTF8;

DROP  TABLE IF EXISTS   ecasdb.ecas_role_info;
CREATE TABLE ecasdb.ecas_role_info(
   role_id varchar(36) NOT  null,
   role_name VARCHAR(36) DEFAULT NULL,
   role_type char(1),
   create_time datetime not null,
   modify_time timestamp NOT NULL default CURRENT_TIMESTAMP
) DEFAULT CHARSET=utf8;


DROP  TABLE IF EXISTS   ecasdb.ecas_permission_info;
CREATE TABLE ecasdb.ecas_permission_info(
   permission_id varchar(36) NOT  null,
   permission_name VARCHAR(36) DEFAULT NULL,
   permission_desc VARCHAR(255) DEFAULT NULL,
   security_level  VARCHAR (4) NOT NULL,
   create_user VARCHAR(40) NOT NULL ,
   create_time datetime not null,
   modify_user VARCHAR(40) NOT NULL,
   modify_time timestamp NOT NULL default CURRENT_TIMESTAMP
) DEFAULT CHARSET=utf8;


DROP  TABLE IF EXISTS   ecasdb.ecas_menu_info;
CREATE TABLE ecasdb.ecas_menu_info(
   menu_id varchar(36) NOT  null,
   menu_name VARCHAR(36) DEFAULT NULL,
   menu_level char(1) DEFAULT NULL ,
   menu_type char(1),
   create_time datetime not null,
   modify_time timestamp NOT NULL default CURRENT_TIMESTAMP
)DEFAULT CHARSET=utf8;

DROP  TABLE IF EXISTS   ecasdb.ecas_user_role;
CREATE TABLE ecasdb.ecas_user_role(
   serial_number int(32) NOT NULL,
   user_id varchar(36) NOT  NULL,
   role_id varchar(36) NOT  null,
   create_time datetime not null,
   modify_time timestamp NOT NULL default CURRENT_TIMESTAMP
) DEFAULT CHARSET=utf8;

DROP  TABLE IF EXISTS   ecasdb.ecas_role_permission;
CREATE TABLE ecasdb.ecas_role_permission(
   serial_number int(32) NOT NULL,
   role_id VARCHAR (36) NOT NULL,
   permission_id varchar(36) NOT  null,
   create_time datetime not null,
   modify_time timestamp NOT NULL default CURRENT_TIMESTAMP
)DEFAULT CHARSET=utf8;




DROP  TABLE IF EXISTS   ecasdb.ecas_permission_menu;
CREATE TABLE ecasdb.ecas_permission_menu(
   serial_number int(32) NOT NULL,
   permission_id VARCHAR (36) NOT NULL,
   menu_id varchar(36) NOT  null,
   create_time datetime not null,
   modify_time timestamp NOT NULL default CURRENT_TIMESTAMP
)DEFAULT CHARSET=utf8;

DROP  TABLE IF EXISTS   ecasdb.ecas_resource_info;
CREATE TABLE ecasdb.ecas_resource_info(
   resource_id VARCHAR (36) NOT NULL,
   resource_name varchar(50) NOT  null,
   resource_type  char(1) DEFAULT NULL,
   create_time datetime not null,
   modify_time timestamp NOT NULL default CURRENT_TIMESTAMP
)DEFAULT CHARSET=utf8;

DROP  TABLE IF EXISTS   ecasdb.ecas_role_resource;
CREATE TABLE ecasdb.ecas_role_resource(
   serial_number int(32) NOT NULL,
   role_id VARCHAR (36) NOT NULL,
   resource_id varchar(50) NOT  null,
   create_time datetime not null,
   modify_time timestamp NOT NULL default CURRENT_TIMESTAMP
)DEFAULT CHARSET=utf8;


DROP  TABLE IF EXISTS   ecasdb.ecas_department_info;
CREATE TABLE ecasdb.ecas_department_info(
   department_id VARCHAR (36) NOT NULL,
   department_name varchar(50) NOT  NULL,
   department_desc VARCHAR(255) DEFAULT NULL,
   department_level char(1) NOT NULL,
   parent_depart_id VARCHAR(36),
   child_depart_id VARCHAR (36),
  create_user VARCHAR(40) NOT NULL ,
   create_time datetime not null,
   modify_user VARCHAR(40) NOT NULL,
   modify_time timestamp NOT NULL default CURRENT_TIMESTAMP
)DEFAULT CHARSET=utf8;


DROP  TABLE IF EXISTS   ecasdb.ecas_user_department;
CREATE TABLE ecasdb.ecas_ecas_user_department(
   serial_number int(32) NOT NULL,
   user_id VARCHAR(36) NOT NULL ,
   department_id VARCHAR (36) NOT NULL,
   create_time datetime NOT NULL ,
   modify_time timestamp NOT NULL default CURRENT_TIMESTAMP
)DEFAULT CHARSET=utf8;


DROP  TABLE IF EXISTS   ecasdb.ecas_organization_info;
CREATE TABLE ecasdb.ecas_organization_info(
   organization_id VARCHAR (36) NOT NULL,
   organization_name varchar(50) NOT  NULL,
   organization_desc varchar(255) DEFAULT NULL,
   organization_level char(1) NOT NULL,
   parent_id     VARCHAR(36) ,
   child_id    VARCHAR (36),
   registration_code varchar(50),
   create_user VARCHAR(40) NOT NULL ,
   create_time datetime not null,
   modify_user VARCHAR(40) NOT NULL,
   modify_time timestamp NOT NULL default CURRENT_TIMESTAMP
)DEFAULT CHARSET=utf8;




