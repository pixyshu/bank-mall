/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/3/20 22:03:06                           */
/*==============================================================*/


drop table if exists pms_product;

drop table if exists pms_product_advertise;

drop table if exists pms_product_category;

drop table if exists pms_product_detail;

drop table if exists pms_product_industry;

drop table if exists pms_product_issue;

drop table if exists pms_product_rule;

drop table if exists pms_product_time_cycle;

/*==============================================================*/
/* Table: pms_product                                           */
/*==============================================================*/
create table pms_product
(
   id                   bigint not null comment 'ID',
   name                 varchar(64) comment '产品名称',
   title                varchar(128) comment '副标题',
   pic                  varchar(255) comment '图片',
   description          text comment '产品介绍',
   code                 varchar(20) comment '产品代码',
   first_purchase_money decimal(10,2) comment '首笔起点金额',
   add_purchase_money   decimal(10,2) comment '递增起点金额',
   max_purchase_money   decimal(10,2) comment '单笔最高金额',
   rate                 decimal(10,2) comment '年利率',
   sum_sale_money       decimal(10,2) comment '总共售卖',
   is_publish           int(1) comment '上架状态：0->下架；1->上架',
   is_new               int(1) comment '新品状态:0->不是新品；1->新品',
   is_recommand         int(1) comment '推荐状态；0->不推荐；1->推荐',
   service_id           int(1) comment '以逗号分隔产品服务：1 保本保息，2 当日起息，3快存快取',
   is_delete            tinyint comment '逻辑删除（1 表示删除，0表示未删除）',
   promotion_start_time datetime comment '促销开始时间',
   promotion_end_time   datetime comment '促销结束时间',
   create_time          datetime comment '创建时间（添加数据时主动创建）',
   update_time          datetime comment '更新时间（操作数据时被动更新）',
   type_id              bigint comment '产品分类ID（活期、定期、债券基金、偏债基金、FOF基金）',
   purchase_time_long   varchar(64) comment '产品持有时常',
   risk_level           varchar(64) comment '风险等级',
   on_shelf_time        datetime comment '上架时间',
   off_shelf_time       datetime comment '下架时间',
   nav                  decimal(10,2) comment '单位净值',
   total_rate           decimal(10,2) comment '发行到今天的总利率',
   delete_time          datetime comment '删除产品时间',
   category_id          bigint comment '产品分类ID',
   detail_id            bigint comment '产品详情ID',
   advertise_id         bigint comment '产品广告ID',
   industry_id          bigint comment '行业ID',
   time_cycle_id        bigint comment '产品周期ID',
   isuue_id             bigint comment '发行ID',
   primary key (id)
);

alter table pms_product comment ' 理财产品';

/*==============================================================*/
/* Table: pms_product_advertise                                 */
/*==============================================================*/
create table pms_product_advertise
(
   id                   bigint not null comment '主键',
   info                 varchar(64) comment '广告宣传语(管理规模超万亿、超100万人持有、金选标准)',
   primary key (id)
);

alter table pms_product_advertise comment '产品广告标签';

/*==============================================================*/
/* Table: pms_product_category                                  */
/*==============================================================*/
create table pms_product_category
(
   id                   bigint not null comment 'ID',
   name                 varchar(64) comment '产品类型名称',
   description          text comment '描述',
   is_show              int(1) comment '显示状态：0->不显示；1->显示',
   sort                 int comment '排序',
   primary key (id)
);

alter table pms_product_category comment '产品分类';

/*==============================================================*/
/* Table: pms_product_detail                                    */
/*==============================================================*/
create table pms_product_detail
(
   id                   bigint not null comment 'ID',
   currency             varchar(20) comment '产品币种',
   invest_type          varchar(128) comment '投资性质',
   sale_area            varchar(128) comment '销售地区',
   income_type          varchar(128) comment '收益类型',
   rasie_way            varchar(128) comment '募集方式',
   create_time          datetime comment '创建时间（添加数据时主动创建）',
   update_time          datetime comment '更新时间（操作数据时被动更新）',
   is_delete            tinyint comment '逻辑删除（1 表示删除，0表示未删除）',
   primary key (id)
);

alter table pms_product_detail comment '产品详情表';

/*==============================================================*/
/* Table: pms_product_industry                                  */
/*==============================================================*/
create table pms_product_industry
(
   id                   bigint not null comment '主键',
   name                 varchar(255) comment '行业名称',
   code                 varchar(20) comment '行业代码',
   primary key (id)
);

alter table pms_product_industry comment '产品行业';

/*==============================================================*/
/* Table: pms_product_issue                                     */
/*==============================================================*/
create table pms_product_issue
(
   id                   bigint not null comment '主键',
   name                 varchar(255) comment '发行机构名称',
   code                 varchar(20) comment '发行机构代码',
   primary key (id)
);

alter table pms_product_issue comment '发行机构';

/*==============================================================*/
/* Table: pms_product_rule                                      */
/*==============================================================*/
create table pms_product_rule
(
   id                   bigint not null comment '主键',
   info                 varchar(255) comment '产品规则信息',
   code                 varchar(20) comment '产品规则信息代号',
   primary key (id)
);

alter table pms_product_rule comment '产品交易规则表';

/*==============================================================*/
/* Table: pms_product_time_cycle                                */
/*==============================================================*/
create table pms_product_time_cycle
(
   id                   bigint not null comment '主键',
   name                 bigint(64) comment '产品周期时长',
   primary key (id)
);

alter table pms_product_time_cycle comment '产品周期';

alter table pms_product add constraint FK_Reference_1 foreign key (category_id)
      references pms_product_category (id);

alter table pms_product add constraint FK_Reference_2 foreign key (detail_id)
      references pms_product_detail (id);

