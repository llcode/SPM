/*==============================================================*/
/* Table: activity                                              */
/*==============================================================*/


create table activity 
(
   activityid           numeric                        not null,
   userid               numeric                        null,
   title                varchar2(100)                   null,
   content              varchar2(1000)                  null,
   starttime            timestamp                       null,
   place                varchar2(100)                   null,
   cost                 numeric(7,2)                   null,
   status               char                           null,
   constraint PK_ACTIVITY primary key (activityid)
);

/*==============================================================*/
/* Table: album                                                 */
/*==============================================================*/
create table album 
(
   albumid              numeric                        not null,
   userid               numeric                        null,
   name                 varchar2(30)                    null,
   description          varchar2(200)                   null,
   power                char                           null,
   cover                numeric                        null,
   status               char                           null,
   constraint PK_ALBUM primary key (albumid)
);


/*==============================================================*/
/* Table: reply                                             */
/*==============================================================*/
create table reply 
(
   replyid            numeric                        not null,
   parentid              numeric                        null,
   content              varchar2(2000)                  null,
   userid               numeric                        null,
   type                 char                           null,
   createtime           timestamp                       null,
   modifytime           timestamp                       null,
   constraint PK_COMMENT primary key (replyid)
);

/*==============================================================*/
/* Table: finance                                               */
/*==============================================================*/
create table finance 
(
   financeid            numeric                        not null,
   classname            varchar2(10)                    null,
   excutedate               date                           null,
   status               char                           null,
   reason               varchar2(200)                   null,
   person               varchar2(30)                    null,
   money                numeric(8,2)                   null,
   balance              numeric(8,2)                   null,
   userinfoid           numeric                        null,
   constraint PK_FINANCE primary key (financeid)
);

/*==============================================================*/
/* Table: msg                                                   */
/*==============================================================*/
create table msg 
(
   msgid                   numeric                        not null,
   fromid               numeric                        null,
   toid                 numeric                        null,
   title                varchar2(50)                    null,
   content              varchar2(200)                   null,
   sendtime               timestamp                       null,
   status               char                           null,
   constraint PK_MSG primary key (msgid)
);

/*==============================================================*/
/* Table: photo                                                 */
/*==============================================================*/
create table photo 
(
   photoid              numeric                        not null,
   albumid              numeric                        null,
   title                varchar2(50)                    null,
   description          varchar2(200)                   null,
   picurl               varchar2(50)                    null,
   picliteurl           varchar2(50)                    null,
   uploadtime           timestamp                       null,
   constraint PK_PHOTO primary key (photoid)
);

/*==============================================================*/
/* Table: section                                               */
/*==============================================================*/
create table section 
(
   sectionid            numeric                        not null,
   name                 varchar2(20)                    null,
   description          varchar2(500)                   null,
   status               char                           null,
   constraint PK_SECTION primary key (sectionid)
);

/*==============================================================*/
/* Table: sectionuser                                           */
/*==============================================================*/
create table sectionuser 
(
   userid               numeric                        not null,
   sectionid            numeric                        not null
);

/*==============================================================*/
/* Table: topic                                                 */
/*==============================================================*/
create table topic 
(
   topicid              numeric                        not null,
   userid               numeric                        null,
   sectionid            numeric                        null,
   title                varchar2(100)                   null,
   content              varchar2(4000)                  null,
   createtime           timestamp                       null,
   modifytime           timestamp                       null,
   lastreplytime        timestamp                       null,
   status               char                           null,
   constraint PK_TOPIC primary key (topicid)
);

/*==============================================================*/
/* Table: "usercount"                                                */
/*==============================================================*/
create table usercount 
(
   userid               numeric                        not null,
   username                 varchar2(50)                    null,
   pwd                  varchar2(50)                    null,
   power                char                           null,
   classpower           char                           null,
   status               char                           null,
   avatar               varchar2(100)                   null,
   sign                 varchar2(200)                   null,
   constraint PK_USERCount primary key (userid)
);


/*==============================================================*/
/* Table: useractivity                                          */
/*==============================================================*/
create table useractivity 
(
   userid               numeric                        null,
   activityid           numeric                        null
);

/*==============================================================*/
/* Table: userinfo                                              */
/*==============================================================*/
create table userinfo 
(
   userinfoid           numeric                        not null,
   userid               numeric                        null,
   sname                 varchar2(20)                    null,
   sno                varchar2(15)                       null,
   gender               char                           null,
   birthday             date                           null,
   QQ                   varchar2(11)                  null,
   tel                  varchar2(11)                    null,
   email                varchar2(30)                    null,
   classname            varchar2(10)                    null,
   dormitory             varchar2(10)                    null,
   hometown             varchar2(50)                    null,
   constraint PK_USERINFO primary key (userinfoid)
);

alter table album
   add constraint FK_ALBUM_REFERENCE_USER foreign key (userid)
      references usercount (userid);

alter table reply
   add constraint FK_COMMENT_REFERENCE_USER foreign key (userid)
      references usercount (userid);

alter table finance
   add constraint FK_FINANCE_REFERENCE_USERINFO foreign key (userinfoid)
      references userinfo (userinfoid);

alter table msg
   add constraint FK_MSG_FK_MSG_TO_USER foreign key (toid)
      references usercount (userid);

alter table msg
   add constraint FK_MSG_FK_MSG_FR_USER foreign key (fromid)
      references usercount (userid);

alter table photo
   add constraint FK_PHOTO_REFERENCE_ALBUM foreign key (albumid)
      references album (albumid);

alter table sectionuser
   add constraint FK_SECTIONU_REFERENCE_USER foreign key (userid)
      references usercount (userid);

alter table sectionuser
   add constraint FK_SECTIONU_REFERENCE_SECTION foreign key (sectionid)
      references section (sectionid);

alter table topic
   add constraint FK_TOPIC_REFERENCE_USER foreign key (userid)
      references usercount (userid);

alter table useractivity
   add constraint FK_USERACTI_REFERENCE_USER foreign key (userid)
      references usercount (userid);

alter table useractivity
   add constraint FK_USERACTI_REFERENCE_ACTIVITY foreign key (activityid)
      references activity (activityid);

alter table userinfo
   add constraint FK_USERINFO_FK_USERIN_USER foreign key (userid)
      references usercount (userid);
      

create sequence seq_user;
create sequence seq_album;
create sequence seq_finance;
create sequence seq_msg;
create sequence seq_reply;
create sequence seq_section;
create sequence seq_userinfo;
create sequence seq_Cont;

