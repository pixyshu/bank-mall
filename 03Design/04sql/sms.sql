/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/3/14 14:47:50                           */
/*==============================================================*/


drop table if exists sms_flash_promotion;

drop table if exists sms_flash_promotion_log;

drop table if exists sms_flash_promotion_product_relation;

drop table if exists sms_flash_promotion_session;

drop table if exists sms_home_new_product;

drop table if exists sms_home_recommend_product;

/*==============================================================*/
/* Table: sms_flash_promotion                                   */
/*==============================================================*/
create table sms_flash_promotion
(
   id                   bigint not null auto_increment,
   title                varchar(200) comment '活动标题',
   start_date           date comment '开始日期',
   end_date             date comment '结束日期',
   status               int(1) comment '上下线状态',
   create_time          datetime comment '秒杀时间段名称',
   primary key (id)
);

alter table sms_flash_promotion comment '限时购表';

/*==============================================================*/
/* Table: sms_flash_promotion_log                               */
/*==============================================================*/
create table sms_flash_promotion_log
(
   id                   int not null auto_increment,
   member_id            int,
   product_id           bigint,
   member_email         varchar(64) comment '会员邮件',
   product_name         varchar(100) comment '商品名字',
   subscribe_time       datetime comment '会员订阅时间',
   send_time            datetime comment '发送时间',
   primary key (id)
);

alter table sms_flash_promotion_log comment '限时购通知记录';

/*==============================================================*/
/* Table: sms_flash_promotion_product_relation                  */
/*==============================================================*/
create table sms_flash_promotion_product_relation
(
   id                   bigint not null auto_increment comment '编号',
   flash_promotion_id   bigint comment '活动编号',
   flash_promotion_session_id bigint comment '编号',
   product_id           bigint comment '产品编号',
   flash_promotion_price decimal(10,2) comment '限时购价格',
   flash_promotion_count int comment '限时购数量',
   flash_promotion_limit int comment '每人限购数量',
   sort                 int comment '排序',
   primary key (id)
);

alter table sms_flash_promotion_product_relation comment '商品限时购与商品关系表';

/*==============================================================*/
/* Table: sms_flash_promotion_session                           */
/*==============================================================*/
create table sms_flash_promotion_session
(
   id                   bigint not null auto_increment comment '编号',
   name                 varchar(200) comment '场次名称',
   start_time           time comment '每日开始时间',
   end_time             time comment '每日结束时间',
   status               int(1) comment '启用状态：0->不启用；1->启用',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table sms_flash_promotion_session comment '限时购场次表';

/*==============================================================*/
/* Table: sms_home_new_product                                  */
/*==============================================================*/
create table sms_home_new_product
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   product_name         varchar(64),
   recommend_status     int(1),
   sort                 int(1),
   primary key (id)
);

alter table sms_home_new_product comment '新鲜好物表';

/*==============================================================*/
/* Table: sms_home_recommend_product                            */
/*==============================================================*/
create table sms_home_recommend_product
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   product_name         varchar(64),
   recommend_status     int(1),
   sort                 int(1),
   primary key (id)
);

alter table sms_home_recommend_product comment '人气推荐商品表';

alter table sms_flash_promotion_product_relation add constraint FK_Reference_77 foreign key (flash_promotion_id)
      references sms_flash_promotion (id) on delete restrict on update restrict;

alter table sms_flash_promotion_product_relation add constraint FK_Reference_78 foreign key (flash_promotion_session_id)
      references sms_flash_promotion_session (id) on delete restrict on update restrict;

