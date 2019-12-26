/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/12/26 16:13:41                          */
/*==============================================================*/


drop table if exists chef;

drop table if exists class;

drop table if exists details;

drop table if exists food;

drop table if exists "order";

drop table if exists user;

/*==============================================================*/
/* Table: chef                                                  */
/*==============================================================*/
create table chef
(
   cid                  int not null auto_increment comment '厨师ID',
   cname                varchar(128) binary not null comment '厨师名',
   cinfo                varchar(256) comment '厨师简介',
   cphoto               varchar(128) not null comment '厨师照片',
   ccreate              timestamp not null default CURRENT_TIMESTAMP comment '厨师新增时间',
   cupdate              timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '厨师修改时间',
   primary key (cid)
);

alter table chef comment '厨师表';

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class
(
   cid                  int not null comment '菜品类ID',
   cnumber              int not null comment '菜品类编号',
   cname                varchar(128) not null comment '菜品类名',
   classcreate          char(10) not null default CURRENT_TIMESTAMP comment '菜品类创建时间',
   classupdate          char(10) not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '菜品类更新时间',
   beiyong1             varchar(128) comment '备用1',
   primary key (cid)
);

alter table class comment '菜品分类表';

/*==============================================================*/
/* Table: details                                               */
/*==============================================================*/
create table details
(
   did                  varchar(32) not null comment '订单详情ID',
   fid                  varbinary(32) not null comment '菜品ID',
   oid                  varchar(32) not null comment '订单总表ID',
   dname                varchar(32) not null comment '当前菜品姓名',
   dprice               decimal(8,2) not null comment '菜品当前价格',
   dphoto               varchar(128) comment '菜品图片',
   quantity             int not null comment '订购菜品数量',
   beiyong1             varchar(32) comment '备用1',
   primary key (did),
   unique key AK_Key_2 (oid)
);

alter table details comment '订单详情表';

/*==============================================================*/
/* Table: food                                                  */
/*==============================================================*/
create table food
(
   fid                  varchar(32) not null comment '菜品ID',
   fname                varbinary(128) not null comment '菜品名',
   cnumber              int not null comment '菜品所属编号',
   price                decimal(8,2) not null comment '菜品价格',
   fphoto               varchar(128) not null comment '菜品图片',
   finfo                varchar(256) comment '菜品简介',
   fsell                int default 0 comment '菜品销量',
   cstock               int comment '菜品库存',
   status               int not null default 0 comment '菜品状态:0为正常,1为下架',
   fcreate              timestamp not null default CURRENT_TIMESTAMP comment '菜品创建时间',
   update               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '菜品更新时间',
   beiyong1             varchar(64) comment '备用1',
   primary key (fid)
);

alter table food comment '菜品表';

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
create table "order"
(
   oid                  varchar(32) not null comment '订单ID',
   uid                  int not null comment '买家ID',
   bname                varchar(128) not null comment '买家姓名',
   bphone               char(11) not null comment '买家电话',
   address              varchar(512) not null comment '买家地址',
   amount               decimal(8,2) not null comment '订单总额',
   pay                  int not null default 0 comment '订单支付状态：0为未支付，1为已支付',
   createtime           timestamp not null default CURRENT_TIMESTAMP comment '订单创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '订单修改时间',
   beiyong1             varchar(64) comment '备用1',
   primary key (oid),
   unique key AK_Key_2 (uid)
);

alter table "order" comment '订单表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   uid                  varbinary(32) not null comment '用户ID',
   uname                varchar(128) not null comment '用户名',
   upwd                 varchar(64) not null comment '用户密码',
   uphone               char(11) not null comment '用户手机号',
   ucreate              timestamp not null default CURRENT_TIMESTAMP comment '用户创建时间',
   update               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '用户更新时间',
   primary key (uid)
);

alter table user comment '用户表';

