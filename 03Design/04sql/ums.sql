/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/3/14 14:48:52                           */
/*==============================================================*/


drop table if exists ums_admin;

drop table if exists ums_admin_role;

drop table if exists ums_common_login_log;

drop table if exists ums_common_opt_log;

drop table if exists ums_menu;

drop table if exists ums_parameter;

drop table if exists ums_resource;

drop table if exists ums_role;

drop table if exists ums_role_authority;

drop table if exists ums_rule;

drop table if exists ums_rule_parameter;

drop table if exists ums_user;

/*==============================================================*/
/* Table: ums_admin                                             */
/*==============================================================*/
create table ums_admin
(
   id                   bigint not null auto_increment comment '主键',
   account              varchar(64) comment ' 账号',
   name                 varchar(64) comment '姓名',
   email                varchar(64) comment '邮箱',
   mobile               varchar(64) comment '手机号',
   sex                  varchar(20) comment '性别',
   status               bit comment '启用状态',
   avatar               varchar(128) comment '头像',
   work_description     varchar(256) comment '工作描述',
   password_error_last_time datetime comment '最后一次输错密码时间',
   password_error_num   int comment '密码错误次数',
   password_expire_time datetime comment '密码过期时间',
   password             varchar(128) comment '密码',
   last_login_time      datetime comment '最后登录时间',
   create_user          bigint comment '创建人ID',
   create_time          datetime comment '创建时间',
   update_user          bigint comment '更新人ID',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table ums_admin comment '管理员用户表';

/*==============================================================*/
/* Table: ums_admin_role                                        */
/*==============================================================*/
create table ums_admin_role
(
   id                   bigint not null comment '主键',
   role_id              bigint comment '角色ID',
   admin_id             bigint comment '用户ID',
   create_user          bigint comment '创建人ID',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table ums_admin_role comment ' 用户角色关系表';

/*==============================================================*/
/* Table: ums_common_login_log                                  */
/*==============================================================*/
create table ums_common_login_log
(
   id                   bigint not null auto_increment comment '主键',
   admin_id             bigint comment '登陆人ID',
   user_name            varchar(64) comment '登录人姓名',
   account              varchar(64) comment '登录人账号',
   description          varchar(256) comment '登录描述',
   login_date           datetime comment '登录时间',
   ua                   varchar(128) comment '浏览器请求头',
   browser              varchar(64) comment '浏览器名称',
   browser_version      varchar(64) comment '浏览器版本',
   operation_system     varchar(64) comment '操作系统',
   request_ip           varchar(64) comment '操作IP',
   location             varchar(64) comment '登录地点',
   create_time          datetime comment '创建时间',
   create_user          bigint comment '创建人ID',
   primary key (id)
);

alter table ums_common_login_log comment '后台用户登录日志表';

/*==============================================================*/
/* Table: ums_common_opt_log                                    */
/*==============================================================*/
create table ums_common_opt_log
(
   id                   bigint not null auto_increment comment '主键',
   request_ip           bigint comment '操作IP',
   type                 varchar(20) comment '日志类型 OPT:操作类型 EX:异常类型',
   user_name            varchar(64) comment '操作人',
   description          varchar(128) comment '操作描述',
   calss_path           varchar(64) comment '类路径',
   action_method        varchar(64) comment '请求方法',
   request_uri          varchar(64) comment '请求地址',
   http_method          varchar(64) comment '请求类型  GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求',
   params               longtext comment '请求参数',
   result               longtext comment '返回值',
   ex_desc              longtext comment '异常详情信息',
   ex_detail            longtext comment '异常描述',
   start_time           datetime comment '开始时间',
   finish_time          datetime comment '完成时间',
   consuming_time       bigint comment '消耗时间',
   ua                   varchar(64) comment '浏览器请求头',
   create_time          datetime comment '创建时间',
   create_user          bigint comment '创建人ID',
   primary key (id)
);

alter table ums_common_opt_log comment '用户操作日志表';

/*==============================================================*/
/* Table: ums_menu                                              */
/*==============================================================*/
create table ums_menu
(
   id                   bigint not null comment '主键',
   name                 varchar(64) comment '菜单名称',
   description          varchar(256) comment '功能描述',
   is_public            bit comment '是否是公开菜单',
   path                 varchar(256) comment '对应路由path',
   component            varchar(256) comment '对应路由组件component',
   is_enable            bit comment '是否启用',
   sort_value           int comment '排序',
   icon                 varchar(256) comment '菜单图标',
   group_               varchar(64) comment '菜单分组',
   pratent_id           bigint comment '父级菜单ID',
   create_user          bigint comment '创建人ID',
   create_time          datetime comment '创建时间',
   update_user          bigint comment '更新人ID',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table ums_menu comment '菜单表';

/*==============================================================*/
/* Table: ums_parameter                                         */
/*==============================================================*/
create table ums_parameter
(
   id                   bigint not null comment '主键',
   name                 varchar(64) comment '字段名',
   value                varchar(256) comment '字段值',
   type                 varchar(64) comment '字段类型',
   description          varchar(256) comment '规则描述',
   status               bit comment '是否启用状态',
   create_user          bigint comment '创建人ID',
   create_time          datetime comment '创建时间',
   update_user          bigint comment '更新人ID',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table ums_parameter comment '规则属性表';

/*==============================================================*/
/* Table: ums_resource                                          */
/*==============================================================*/
create table ums_resource
(
   id                   bigint not null comment '主键',
   code                 varchar(64) comment '资源编码',
   name                 varchar(64) comment '接口名称',
   menu_id              bigint comment '菜单ID',
   method               varchar(256) comment 'HTTP请求方式',
   url                  varchar(256) comment '接口请求url',
   description          varchar(256) comment '接口描述',
   create_user          bigint comment '创建人ID',
   create_time          datetime comment '创建时间',
   update_user          bigint comment '更新人ID',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table ums_resource comment '资源表';

/*==============================================================*/
/* Table: ums_role                                              */
/*==============================================================*/
create table ums_role
(
   id                   bigint not null comment '主键',
   code                 varchar(64) comment '角色编码',
   name                 varchar(64) comment '角色名称',
   description          varchar(256) comment '角色描述',
   status               bit comment '是否启用状态',
   readonly             bit comment '是否内置角色',
   create_user          bigint comment '创建人ID',
   create_time          datetime comment '创建时间',
   update_user          bigint comment '更新人ID',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table ums_role comment ' 角色表';

/*==============================================================*/
/* Table: ums_role_authority                                    */
/*==============================================================*/
create table ums_role_authority
(
   id                   bigint not null comment '主键',
   role_id              bigint comment '角色ID',
   authority_id         bigint comment '权限ID',
   authority_type       varchar(20) comment '权限类型 MUNE:菜单  RESOURCE:资源',
   create_user          bigint comment '创建人ID',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table ums_role_authority comment '角色权限关系表';

/*==============================================================*/
/* Table: ums_rule                                              */
/*==============================================================*/
create table ums_rule
(
   id                   bigint not null comment '主键',
   name                 varchar(64) comment '规则编码',
   description          varchar(256) comment '规则描述',
   risk_control         tinyint comment '风险控制(是否拒绝：1是 0否)',
   object               tinyint comment '对象（1个人客户、2 企业客户）',
   status               bit comment '是否启用状态',
   create_user          bigint comment '创建人ID',
   create_time          datetime comment '创建时间',
   update_user          bigint comment '更新人ID',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table ums_rule comment ' 规则表';

/*==============================================================*/
/* Table: ums_rule_parameter                                    */
/*==============================================================*/
create table ums_rule_parameter
(
   id                   bigint not null comment '主键',
   rule_id              bigint comment '规则主键',
   parameter_id         bigint comment '属性主键',
   create_user          bigint comment '创建人ID',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table ums_rule_parameter comment '规则配置表';

/*==============================================================*/
/* Table: ums_user                                              */
/*==============================================================*/
create table ums_user
(
   id                   bigint not null auto_increment,
   username             varchar(64) comment '用户名',
   password             varchar(64) comment '密码',
   nickname             varchar(64) comment '昵称',
   identity_no          varchar(64) comment '身份证号',
   phone                varchar(64) comment '手机号码',
   status               int(1) comment '帐号启用状态:0->禁用；1->启用',
   icon                 varchar(500) comment '头像',
   gender               int(1) comment '性别：0->未知；1->男；2->女',
   birthday             date comment '生日',
   city                 varchar(64) comment '所在城市',
   work_status          char(10) comment '工作状态：0->在业；1 ->无业',
   job                  varchar(100) comment '职业',
   personalized_signature varchar(200) comment '个性签名',
   source_type          int(1) comment '用户来源',
   create_time          datetime comment '注册时间',
   update_time          datetime comment '更新时间（操作数据时被动更新）',
   is_delete            tinyint comment '逻辑删除（1 表示删除，0表示未删除）',
   primary key (id)
);

alter table ums_user comment '客户表(逻辑删除)';

alter table ums_admin_role add constraint FK_pk_admin_id foreign key (admin_id)
      references ums_admin (id) on delete restrict on update restrict;

alter table ums_admin_role add constraint FK_pk_role_id foreign key (role_id)
      references ums_role (id) on delete restrict on update restrict;

alter table ums_common_login_log add constraint FK_pk_log_admin_id foreign key (admin_id)
      references ums_admin (id) on delete restrict on update restrict;

alter table ums_role_authority add constraint FK_PK_RESOURCE_ID foreign key (authority_id)
      references ums_resource (id) on delete restrict on update restrict;

alter table ums_role_authority add constraint FK_Reference_4 foreign key (role_id)
      references ums_role (id) on delete restrict on update restrict;

alter table ums_role_authority add constraint FK_pk_menu_id foreign key (authority_id)
      references ums_menu (id) on delete restrict on update restrict;

alter table ums_rule_parameter add constraint FK_pk_parameter foreign key (parameter_id)
      references ums_parameter (id) on delete restrict on update restrict;

alter table ums_rule_parameter add constraint FK_pl_rule_id foreign key (rule_id)
      references ums_rule (id) on delete restrict on update restrict;

