/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/3/20 21:45:52                           */
/*==============================================================*/


drop table if exists ums_admin;

drop table if exists ums_admin_login_log;

drop table if exists ums_admin_permission_relation;

drop table if exists ums_admin_role_relation;

drop table if exists ums_menu;

drop table if exists ums_permission;

drop table if exists ums_resource;

drop table if exists ums_resource_category;

drop table if exists ums_role;

drop table if exists ums_role_menu_relation;

drop table if exists ums_role_permission_relation;

drop table if exists ums_role_resource_relation;

/*==============================================================*/
/* Table: ums_admin                                             */
/*==============================================================*/
create table ums_admin
(
   id                   bigint not null auto_increment,
   username             varchar(64) comment '用户名',
   password             varchar(64) comment '密码',
   icon                 varchar(500) comment '头像',
   email                varchar(100) comment '邮箱',
   nick_name            varchar(200) comment '昵称',
   note                 varchar(500) comment '备注信息',
   create_time          datetime comment '创建时间',
   login_time           datetime comment '最后登录时间',
   status               int(1) default 1 comment '帐号启用状态：0->禁用；1->启用',
   primary key (id)
);

alter table ums_admin comment '后台用户表';

/*==============================================================*/
/* Table: ums_admin_login_log                                   */
/*==============================================================*/
create table ums_admin_login_log
(
   id                   bigint not null auto_increment,
   admin_id             bigint,
   create_time          datetime,
   ip                   varchar(64),
   address              varchar(100),
   user_agent           varchar(100) comment '浏览器登录类型',
   primary key (id)
);

alter table ums_admin_login_log comment '后台用户登录日志表';

/*==============================================================*/
/* Table: ums_admin_permission_relation                         */
/*==============================================================*/
create table ums_admin_permission_relation
(
   id                   bigint not null auto_increment,
   admin_id             bigint,
   permission_id        bigint,
   type                 int(1),
   primary key (id)
);

alter table ums_admin_permission_relation comment '后台用户和权限关系表(除角色中定义的权限以外的加减权限)';

/*==============================================================*/
/* Table: ums_admin_role_relation                               */
/*==============================================================*/
create table ums_admin_role_relation
(
   id                   bigint not null auto_increment,
   admin_id             bigint,
   role_id              bigint,
   primary key (id)
);

alter table ums_admin_role_relation comment '后台用户和角色关系表';

/*==============================================================*/
/* Table: ums_menu                                              */
/*==============================================================*/
create table ums_menu
(
   id                   bigint not null auto_increment,
   parent_id            bigint comment '父级ID',
   create_time          datetime comment '创建时间',
   title                varchar(100) comment '菜单名称',
   level                int(4) comment '菜单级数',
   sort                 int(4) comment '菜单排序',
   name                 varchar(100) comment '前端名称',
   icon                 varchar(200) comment '前端图标',
   hidden               int(1) comment '前端隐藏',
   primary key (id)
);

alter table ums_menu comment '后台菜单表';

/*==============================================================*/
/* Table: ums_permission                                        */
/*==============================================================*/
create table ums_permission
(
   id                   bigint not null auto_increment,
   pid                  bigint comment '父级权限id',
   name                 varchar(100) comment '名称',
   value                varchar(200) comment '权限值',
   icon                 varchar(500) comment '图标',
   type                 int(1) comment '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
   uri                  varchar(200) comment '前端资源路径',
   status               int(1) comment '启用状态；0->禁用；1->启用',
   create_time          datetime comment '创建时间',
   sort                 int comment '排序',
   primary key (id)
);

alter table ums_permission comment '后台用户权限表';

/*==============================================================*/
/* Table: ums_resource                                          */
/*==============================================================*/
create table ums_resource
(
   id                   bigint not null auto_increment,
   category_id          bigint comment '资源分类ID',
   create_time          datetime comment '创建时间',
   name                 varchar(200) comment '资源名称',
   url                  varchar(200) comment '资源URL',
   description          varchar(500) comment '描述',
   primary key (id)
);

alter table ums_resource comment '后台资源表';

/*==============================================================*/
/* Table: ums_resource_category                                 */
/*==============================================================*/
create table ums_resource_category
(
   id                   bigint not null auto_increment,
   create_time          datetime comment '创建时间',
   name                 varchar(200) comment '分类名称',
   sort                 int(4) comment '排序',
   primary key (id)
);

alter table ums_resource_category comment '资源分类表';

/*==============================================================*/
/* Table: ums_role                                              */
/*==============================================================*/
create table ums_role
(
   id                   bigint not null auto_increment,
   name                 varchar(100) comment '名称',
   description          varchar(500) comment '描述',
   admin_count          int comment '后台用户数量',
   create_time          datetime comment '创建时间',
   status               int(1) default 1 comment '启用状态：0->禁用；1->启用',
   sort                 int default 0,
   primary key (id)
);

alter table ums_role comment '后台用户角色表';

/*==============================================================*/
/* Table: ums_role_menu_relation                                */
/*==============================================================*/
create table ums_role_menu_relation
(
   id                   bigint not null auto_increment,
   role_id              bigint comment '角色ID',
   menu_id              bigint comment '菜单ID',
   primary key (id)
);

alter table ums_role_menu_relation comment '后台角色菜单关系表';

/*==============================================================*/
/* Table: ums_role_permission_relation                          */
/*==============================================================*/
create table ums_role_permission_relation
(
   id                   bigint not null auto_increment,
   role_id              bigint,
   permission_id        bigint,
   primary key (id)
);

alter table ums_role_permission_relation comment '后台用户角色和权限关系表';

/*==============================================================*/
/* Table: ums_role_resource_relation                            */
/*==============================================================*/
create table ums_role_resource_relation
(
   id                   bigint not null auto_increment,
   role_id              bigint comment '角色ID',
   resource_id          bigint comment '资源ID',
   primary key (id)
);

alter table ums_role_resource_relation comment '后台角色资源关系表';

alter table ums_admin_login_log add constraint FK_Reference_46 foreign key (admin_id)
      references ums_admin (id);

alter table ums_admin_permission_relation add constraint FK_Reference_73 foreign key (admin_id)
      references ums_admin (id);

alter table ums_admin_permission_relation add constraint FK_Reference_74 foreign key (permission_id)
      references ums_permission (id) on delete restrict on update restrict;

alter table ums_admin_role_relation add constraint FK_Reference_69 foreign key (admin_id)
      references ums_admin (id) on delete restrict on update restrict;

alter table ums_admin_role_relation add constraint FK_Reference_70 foreign key (role_id)
      references ums_role (id) on delete restrict on update restrict;

alter table ums_menu add constraint FK_Reference_80 foreign key (parent_id)
      references ums_menu (id) on delete restrict on update restrict;

alter table ums_permission add constraint FK_Reference_68 foreign key (pid)
      references ums_permission (id) on delete restrict on update restrict;

alter table ums_resource add constraint FK_Reference_85 foreign key (category_id)
      references ums_resource_category (id) on delete restrict on update restrict;

alter table ums_role_menu_relation add constraint FK_Reference_81 foreign key (role_id)
      references ums_role (id) on delete restrict on update restrict;

alter table ums_role_menu_relation add constraint FK_Reference_82 foreign key (menu_id)
      references ums_menu (id) on delete restrict on update restrict;

alter table ums_role_permission_relation add constraint FK_Reference_71 foreign key (role_id)
      references ums_role (id) on delete restrict on update restrict;

alter table ums_role_permission_relation add constraint FK_Reference_72 foreign key (permission_id)
      references ums_permission (id) on delete restrict on update restrict;

alter table ums_role_resource_relation add constraint FK_Reference_83 foreign key (role_id)
      references ums_role (id) on delete restrict on update restrict;

alter table ums_role_resource_relation add constraint FK_Reference_84 foreign key (resource_id)
      references ums_resource (id) on delete restrict on update restrict;

