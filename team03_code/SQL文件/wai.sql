/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/12/26 16:13:41                          */
/*==============================================================*/
DROP TABLE IF EXISTS chef;
DROP TABLE IF EXISTS class;
DROP TABLE IF EXISTS details;
DROP TABLE IF EXISTS food;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS ordering;

/*==============================================================*/
/* Table: chef                                                  */
/*==============================================================*/
CREATE TABLE chef
(
   cid                  INT NOT NULL AUTO_INCREMENT COMMENT '厨师ID',
   cname                VARCHAR(128) BINARY NOT NULL COMMENT '厨师名',
   cinfo                VARCHAR(256) COMMENT '厨师简介',
   cphoto               VARCHAR(128) NOT NULL COMMENT '厨师照片',
   ccreate              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '厨师新增时间',
   cupdate              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '厨师修改时间',
   PRIMARY KEY (cid)
);

ALTER TABLE chef COMMENT '厨师表';

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
CREATE TABLE class
(
   cid                  INT NOT NULL COMMENT '菜品类ID',
   cnumber              INT NOT NULL COMMENT '菜品类编号',
   cname                VARCHAR(128) NOT NULL COMMENT '菜品类名',
   classcreate          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '菜品类创建时间',
   classupdate          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '菜品类更新时间',
   beiyong1             VARCHAR(128) COMMENT '备用1',
   PRIMARY KEY (cid)
);

ALTER TABLE class COMMENT '菜品分类表';

/*==============================================================*/
/* Table: details                                               */
/*==============================================================*/
CREATE TABLE details
(
   did                  VARCHAR(32) NOT NULL COMMENT '订单详情ID',
   fid                  VARBINARY(32) NOT NULL COMMENT '菜品ID',
   oid                  VARCHAR(32) NOT NULL COMMENT '订单总表ID',
   dname                VARCHAR(32) NOT NULL COMMENT '当前菜品姓名',
   dprice               DECIMAL(8,2) NOT NULL COMMENT '菜品当前价格',
   dphoto               VARCHAR(128) COMMENT '菜品图片',
   quantity             INT NOT NULL COMMENT '订购菜品数量',
   beiyong1             VARCHAR(32) COMMENT '备用1',
   PRIMARY KEY (did),
   UNIQUE KEY AK_Key_2 (oid)
);

ALTER TABLE details COMMENT '订单详情表';

/*==============================================================*/
/* Table: food                                                  */
/*==============================================================*/
CREATE TABLE food
(
   fid                  VARCHAR(32) NOT NULL COMMENT '菜品ID',
   fname                VARBINARY(128) NOT NULL COMMENT '菜品名',
   cnumber              INT NOT NULL COMMENT '菜品所属编号',
   price                DECIMAL(8,2) NOT NULL COMMENT '菜品价格',
   fphoto               VARCHAR(512) NOT NULL COMMENT '菜品图片',
   finfo                VARCHAR(256) COMMENT '菜品简介',
   fsell                INT DEFAULT 0 COMMENT '菜品销量:初始默认为0',
   cstock               INT COMMENT '菜品库存',
   fstatus               INT NOT NULL DEFAULT 0 COMMENT '菜品状态:0为正常,1为下架',
   fcreate              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '菜品创建时间',
   fupdate               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '菜品更新时间',
   beiyong1             VARCHAR(64) COMMENT '备用1',
   PRIMARY KEY (fid)
);

ALTER TABLE food COMMENT '菜品表';

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
CREATE TABLE ordering
(
   oid                  VARCHAR(32) NOT NULL COMMENT '订单ID',
   uid                  VARCHAR(32) NOT NULL COMMENT '买家ID',
   bname                VARCHAR(128) NOT NULL COMMENT '买家姓名',
   bphone               CHAR(11) NOT NULL COMMENT '买家电话',
   address              VARCHAR(512) NOT NULL COMMENT '买家地址',
   amount               DECIMAL(8,2) NOT NULL COMMENT '订单总额',
   pay                  INT NOT NULL DEFAULT 0 COMMENT '订单支付状态：0为未支付，1为已支付',
   createtime           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
   updatetime           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单修改时间',
   beiyong1             VARCHAR(64) COMMENT '备用1',
   PRIMARY KEY (oid)
   
);

ALTER TABLE ordering COMMENT '订单表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
CREATE TABLE users
(
   uid                  VARCHAR(32) NOT NULL COMMENT '用户ID',
   uname                VARCHAR(128) NOT NULL COMMENT '用户名',
   upwd                 VARCHAR(64) NOT NULL COMMENT '用户密码',
   uphone               CHAR(11) NOT NULL COMMENT '用户手机号',
   ucreate              TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
   userupdate               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户更新时间',
   PRIMARY KEY (uid)
);

ALTER TABLE users COMMENT '用户表';

