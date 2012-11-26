alter table favorite
   drop constraint FK_FAVORITE_REFERENCE_USERCOUN;

alter table favorite_poem
   drop constraint FK_FAVORITE_REFERENCE_POEM;

alter table favorite_poem
   drop constraint FK_FAVORITE_REFERENCE_FAVORITE;

alter table mynewpoem
   drop constraint FK_MYNEWPOE_REFERENCE_USERCOUN;

alter table mynewpoem
   drop constraint FK_MYNEWPOE_REFERENCE_POEM;

alter table poem
   drop constraint FK_POEM_REFERENCE_AUTHOR;

drop table author cascade constraints;

drop table favorite cascade constraints;

drop table favorite_poem cascade constraints;

drop table mynewpoem cascade constraints;

drop table poem cascade constraints;

drop table usercount cascade constraints;

/*==============================================================*/
/* Table: author                                                */
/*==============================================================*/
create table author
(
   aid                NUMBER               not null,
   name               VARCHAR2(20),
   description        VARCHAR2(2000),
   constraint PK_AUTHOR primary key (aid)
);

/*==============================================================*/
/* Table: "favorite"                                            */
/*==============================================================*/
create table favorite 
(
   fid                NUMBER               not null,
   userid             NUMBER,
   name               VARCHAR2(200),
   constraint PK_FAVORITE primary key (fid)
);

/*==============================================================*/
/* Table: favorite_poem                                         */
/*==============================================================*/
create table favorite_poem 
(
   pid                NUMBER,
   fid                NUMBER
);

/*==============================================================*/
/* Table: mynewpoem                                             */
/*==============================================================*/
create table mynewpoem
(
   newpid             NUMBER               not null,
   userid             NUMBER,
   pid                NUMBER,
   createdate         DATE,
   testdate           DATE,
   count              INTEGER,
   constraint PK_MYNEWPOEM primary key (newpid)
);

/*==============================================================*/
/* Table: poem                                                  */
/*==============================================================*/
create table poem 
(
   pid                NUMBER               not null,
   aid                NUMBER,
   title              VARCHAR2(50),
   content            VARCHAR2(2000),
   translation        VARCHAR2(2000),
   explanation        VARCHAR2(2000),
   appreciation       VARCHAR2(2000),
   constraint PK_POEM primary key (pid)
);

/*==============================================================*/
/* Table: usercount                                             */
/*==============================================================*/
create table usercount 
(
   userid                NUMBER               not null,
   name               VARCHAR2(50),
   email              VARCHAR2(50),
   password           VARCHAR2(50),
   constraint PK_USERCOUNT primary key (userid)
);

alter table favorite
   add constraint FK_FAVORITE_REFERENCE_USERCOUN foreign key (userid)
      references usercount (userid);

alter table favorite_poem
   add constraint FK_FAVORITE_REFERENCE_POEM foreign key (pid)
      references poem (pid);

alter table favorite_poem
   add constraint FK_FAVORITE_REFERENCE_FAVORITE foreign key (fid)
      references favorite (fid);

alter table mynewpoem
   add constraint FK_MYNEWPOE_REFERENCE_USERCOUN foreign key (userid)
      references usercount (userid);

alter table mynewpoem
   add constraint FK_MYNEWPOE_REFERENCE_POEM foreign key (pid)
      references poem (pid);

alter table poem
   add constraint FK_POEM_REFERENCE_AUTHOR foreign key (aid)
      references author (aid);
      
create sequence seq_favorite;

create sequence seq_poem;

create sequence seq_usercount;

create sequence seq_author;

create sequence seq_newpoem;
