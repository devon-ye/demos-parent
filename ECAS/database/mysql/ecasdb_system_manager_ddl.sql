

SET FOREIGN_KEY_CHECKS=0;
/*

CREATE USER 'ecas'@'%' IDENTIFIED BY 'ecasoptr';
CREATE DATABASE ecasdb;
*/
DROP  TABLE IF EXISTS   ecasdb.sm_login_oauth;
CREATE TABLE ecasdb.sm_login_oauth(
   user_id varchar(64) NOT  null,
   auth_id varchar(64) NOT NULL,
   auth_name VARCHAR(64) DEFAULT NULL,
   auth_access_token VARCHAR (256) DEFAULT NULL ,
   auth_expires int(10),
   auth_time    timestamp NOT NULL default CURRENT_TIMESTAMP,
   auth_ip  VARCHAR (256)
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户认证表';

DROP  TABLE IF EXISTS   ecasdb.sm_user_info;
CREATE TABLE ecasdb.sm_user_info (
    id BIGINT(8)  not null AUTO_INCREMENT COMMENT '主键',
    user_id VARCHAR(64) NOT NULL COMMENT '、用户ID',
    user_name VARCHAR(64) DEFAULT NULL COMMENT '用户名',
    password VARCHAR(256) NOT NULL COMMENT '密码',
    id_card  VARCHAR(19) NOT NULL  COMMENT '证件号',
    id_type  TINYINT(1) DEFAULT 1  COMMENT '证件类型：１身份证，２护照',
    gender TINYINT(1) DEFAULT NULL COMMENT '性别：1 男，2 女',
    active_status TINYINT(1) DEFAULT 0 COMMENT '用户状态：０锁定，１活动，２注销',
    email VARCHAR(125) NOT NULL COMMENT '电子邮箱',
    marrige CHAR(1) NOT NULL DEFAULT '' COMMENT '婚姻状态：１未婚，２已婚，３离异',
    phone VARCHAR(11)  COMMENT '联系电话',
    birthday DATETIME DEFAULT NULL COMMENT '生日',
    address VARCHAR(512) DEFAULT NULL COMMENT '住址',
    gmt_create DATETIME NOT NULL  COMMENT '创建时间',
    create_id varchar(64) NOT NULL COMMENT '创建人id',
    gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
    PRIMARY KEY (id)
)  ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表';

DROP  TABLE IF EXISTS   ecasdb.sm_role_info;
CREATE TABLE ecasdb.sm_role_info(
   id  BIGINT(8)  not null AUTO_INCREMENT COMMENT '主键',
   role_id varchar(64) NOT  NULL COMMENT '角色编码',
   role_name VARCHAR(64) DEFAULT NULL COMMENT '角色名称',
   role_type char(1) COMMENT '角色类型',
   remark VARCHAR(128) COMMENT '备注',
   gmt_create DATETIME NOT NULL  COMMENT '创建时间',
   create_id varchar(64) NOT NULL COMMENT '创建人id',
   gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
   modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
   PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色信息表';


DROP  TABLE IF EXISTS   ecasdb.sm_permission;
CREATE TABLE ecasdb.sm_permission(
   id BIGINT(8)  not null AUTO_INCREMENT COMMENT '主键',
   permission_id varchar(64) NOT  NULL COMMENT '权限编码',
   permission_name VARCHAR(64) DEFAULT NULL COMMENT '权限名称',
   permission_desc VARCHAR(255) DEFAULT NULL COMMENT '权限描述',
   security_level  VARCHAR (4) NOT NULL COMMENT '权限等级',
   gmt_create DATETIME NOT NULL  COMMENT '创建时间',
   create_id varchar(64) NOT NULL COMMENT '创建人id',
   gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
   modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限信息表';


DROP  TABLE IF EXISTS   ecasdb.sm_menu;
CREATE TABLE ecasdb.sm_menu (
   id BIGINT(8)  NOT NULL AUTO_INCREMENT COMMENT '主键',
   menu_id varchar(64) NOT  NULL COMMENT '菜单编码',
   menu_name VARCHAR(128) NOT NULL COMMENT '菜单名称',
   mennu_en_name VARCHAR(128) DEFAULT NULL COMMENT '菜单英文名称',
   menu_level char(1) DEFAULT NULL COMMENT '菜单等级',
   menu_type char(1) COMMENT '菜单类型',
   child_menu_id VARCHAR (64) COMMENT '子菜单编码',
   gmt_create DATETIME NOT NULL  COMMENT '创建时间',
   create_id varchar(64) NOT NULL COMMENT '创建人id',
   gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
   modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
   PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单信息表';

DROP  TABLE IF EXISTS   ecasdb.sm_user_role;
CREATE TABLE ecasdb.sm_user_role(
   id BIGINT(8)  NOT NULL AUTO_INCREMENT COMMENT '主键',
   user_id varchar(64) NOT  NULL COMMENT '用户ID',
   role_id varchar(64) NOT  NULL COMMENT '角色ID',
    gmt_create DATETIME NOT NULL  COMMENT '创建时间',
    create_id varchar(64) NOT NULL COMMENT '创建人id',
    gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户角色管理表';

DROP  TABLE IF EXISTS   ecasdb.sm_role_permission;
CREATE TABLE ecasdb.sm_role_permission(
    id BIGINT(8)  not null AUTO_INCREMENT COMMENT '主键',
    role_id VARCHAR (64) NOT NULL COMMENT '',
    permission_id varchar(64) NOT  null COMMENT '',
    gmt_create DATETIME NOT NULL  COMMENT '创建时间',
    create_id varchar(64) NOT NULL COMMENT '创建人id',
    gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色权限管理表';




DROP  TABLE IF EXISTS   ecasdb.sm_permission_menu;
CREATE TABLE ecasdb.sm_permission_menu(
   id BIGINT(8)  not null AUTO_INCREMENT COMMENT '主键',
   permission_id VARCHAR (64) NOT NULL COMMENT '',
   menu_id varchar(64) NOT  null COMMENT '',
   gmt_create DATETIME NOT NULL  COMMENT '创建时间',
   create_id varchar(64) NOT NULL COMMENT '创建人id',
   gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
   modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
   PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限菜单管理表';

DROP  TABLE IF EXISTS   ecasdb.sm_resource;
CREATE TABLE ecasdb.sm_resource(
   id BIGINT(8)  not null AUTO_INCREMENT COMMENT '主键',
   resource_id VARCHAR (64) NOT NULL COMMENT '资源编码',
   resource_name varchar(50) NOT  null COMMENT '资源名称',
   resource_type  char(1) DEFAULT NULL COMMENT '资源类型',
   gmt_create DATETIME NOT NULL  COMMENT '创建时间',
   create_id varchar(64) NOT NULL COMMENT '创建人id',
   gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
   modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资源信息表';

DROP  TABLE IF EXISTS   ecasdb.sm_role_resource;
CREATE TABLE ecasdb.sm_role_resource(
   id BIGINT(8)  not null AUTO_INCREMENT COMMENT '主键',
   role_id VARCHAR (64) NOT NULL COMMENT '',
   resource_id varchar(50) NOT  null COMMENT '',
    gmt_create DATETIME NOT NULL  COMMENT '创建时间',
    create_id varchar(64) NOT NULL COMMENT '创建人id',
    gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
    PRIMARY KEY (id)
)DEFAULT CHARSET=utf8;


DROP  TABLE IF EXISTS   ecasdb.sm_department;
CREATE TABLE ecasdb.sm_department(
   id BIGINT(8)  not null AUTO_INCREMENT COMMENT '主键',
   department_name varchar(128) NOT  NULL COMMENT '',
   department_desc VARCHAR(255) DEFAULT NULL COMMENT '',
   department_level char(1) NOT NULL COMMENT '',
   parent_depart_id VARCHAR(64) COMMENT '',
   child_depart_id VARCHAR (64) COMMENT '',
    gmt_create DATETIME NOT NULL  COMMENT '创建时间',
    create_id varchar(64) NOT NULL COMMENT '创建人id',
    gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门信息表';


DROP  TABLE IF EXISTS   ecasdb.sm_user_department;
CREATE TABLE ecasdb.sm_user_department(
   id BIGINT(8)  not null AUTO_INCREMENT COMMENT '主键',
   user_id VARCHAR(64) NOT NULL COMMENT '',
   department_id VARCHAR (64) NOT NULL COMMENT '',
    gmt_create DATETIME NOT NULL  COMMENT '创建时间',
    create_id varchar(64) NOT NULL COMMENT '创建人id',
    gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户部门管理表';


DROP  TABLE IF EXISTS   ecasdb.sm_organization;
CREATE TABLE ecasdb.sm_organization(
   id BIGINT(8)  not null AUTO_INCREMENT COMMENT '主键',
   organization_id VARCHAR (64) NOT NULL COMMENT '',
   organization_name varchar(50) NOT  NULL COMMENT'',
   organization_desc varchar(255) DEFAULT NULL COMMENT '',
   organization_level char(1) NOT NULL COMMENT'',
   child_id    VARCHAR (64) COMMENT '',
   registration_code varchar(50) COMMENT '',
   gmt_create DATETIME NOT NULL  COMMENT '创建时间',
   create_id varchar(64) NOT NULL COMMENT '创建人id',
   gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
   modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
   PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='组织信息表';

DROP  TABLE IF EXISTS   ecasdb.sm_permission_group;
CREATE TABLE ecasdb.sm_permission_group(
   id BIGINT(8)  not null AUTO_INCREMENT COMMENT '主键',
   permission_group_id varchar(64) NOT  null COMMENT '',
   permission_group_name VARCHAR(64) DEFAULT NULL COMMENT '',
   security_level  VARCHAR (4) NOT NULL COMMENT '',
   gmt_create DATETIME NOT NULL  COMMENT '创建时间',
   create_id varchar(64) NOT NULL COMMENT '创建人id',
   gmt_modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
   modified_id varchar(64) DEFAULT "" COMMENT '更新人id',
   PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限组信息表';




