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
   cid                  int not null auto_increment comment '��ʦID',
   cname                varchar(128) binary not null comment '��ʦ��',
   cinfo                varchar(256) comment '��ʦ���',
   cphoto               varchar(128) not null comment '��ʦ��Ƭ',
   ccreate              timestamp not null default CURRENT_TIMESTAMP comment '��ʦ����ʱ��',
   cupdate              timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '��ʦ�޸�ʱ��',
   primary key (cid)
);

alter table chef comment '��ʦ��';

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class
(
   cid                  int not null comment '��Ʒ��ID',
   cnumber              int not null comment '��Ʒ����',
   cname                varchar(128) not null comment '��Ʒ����',
   classcreate          char(10) not null default CURRENT_TIMESTAMP comment '��Ʒ�ഴ��ʱ��',
   classupdate          char(10) not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '��Ʒ�����ʱ��',
   beiyong1             varchar(128) comment '����1',
   primary key (cid)
);

alter table class comment '��Ʒ�����';

/*==============================================================*/
/* Table: details                                               */
/*==============================================================*/
create table details
(
   did                  varchar(32) not null comment '��������ID',
   fid                  varbinary(32) not null comment '��ƷID',
   oid                  varchar(32) not null comment '�����ܱ�ID',
   dname                varchar(32) not null comment '��ǰ��Ʒ����',
   dprice               decimal(8,2) not null comment '��Ʒ��ǰ�۸�',
   dphoto               varchar(128) comment '��ƷͼƬ',
   quantity             int not null comment '������Ʒ����',
   beiyong1             varchar(32) comment '����1',
   primary key (did),
   unique key AK_Key_2 (oid)
);

alter table details comment '���������';

/*==============================================================*/
/* Table: food                                                  */
/*==============================================================*/
create table food
(
   fid                  varchar(32) not null comment '��ƷID',
   fname                varbinary(128) not null comment '��Ʒ��',
   cnumber              int not null comment '��Ʒ�������',
   price                decimal(8,2) not null comment '��Ʒ�۸�',
   fphoto               varchar(128) not null comment '��ƷͼƬ',
   finfo                varchar(256) comment '��Ʒ���',
   fsell                int default 0 comment '��Ʒ����',
   cstock               int comment '��Ʒ���',
   status               int not null default 0 comment '��Ʒ״̬:0Ϊ����,1Ϊ�¼�',
   fcreate              timestamp not null default CURRENT_TIMESTAMP comment '��Ʒ����ʱ��',
   update               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '��Ʒ����ʱ��',
   beiyong1             varchar(64) comment '����1',
   primary key (fid)
);

alter table food comment '��Ʒ��';

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
create table "order"
(
   oid                  varchar(32) not null comment '����ID',
   uid                  int not null comment '���ID',
   bname                varchar(128) not null comment '�������',
   bphone               char(11) not null comment '��ҵ绰',
   address              varchar(512) not null comment '��ҵ�ַ',
   amount               decimal(8,2) not null comment '�����ܶ�',
   pay                  int not null default 0 comment '����֧��״̬��0Ϊδ֧����1Ϊ��֧��',
   createtime           timestamp not null default CURRENT_TIMESTAMP comment '��������ʱ��',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '�����޸�ʱ��',
   beiyong1             varchar(64) comment '����1',
   primary key (oid),
   unique key AK_Key_2 (uid)
);

alter table "order" comment '������';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   uid                  varbinary(32) not null comment '�û�ID',
   uname                varchar(128) not null comment '�û���',
   upwd                 varchar(64) not null comment '�û�����',
   uphone               char(11) not null comment '�û��ֻ���',
   ucreate              timestamp not null default CURRENT_TIMESTAMP comment '�û�����ʱ��',
   update               timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '�û�����ʱ��',
   primary key (uid)
);

alter table user comment '�û���';

