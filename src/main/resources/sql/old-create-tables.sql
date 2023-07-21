# create table teachers
# (
#     id         int auto_increment
#         primary key,
#     personal_id varchar(45) not null,
#     password   varchar(80) not null,
#     first_name varchar(45) not null,
#     last_name  varchar(45) null,
#     email      varchar(45) not null,
#     active boolean not null,
#     role varchar(20) not null
# )
#     engine = InnoDB
#     charset = latin1;
#
# create table tech_personal
# (
#     id         int auto_increment
#         primary key,
#     personal_id varchar(45) not null,
#     password   varchar(80) not null,
#     first_name varchar(45) not null,
#     last_name  varchar(45) null,
#     email      varchar(45) not null,
#     active boolean not null,
#     role varchar(20) not null
# )
#     engine = InnoDB
#     charset = latin1;

# Spring security default scheme
# create table users
# (
#     username varchar(55) not null primary key,
#     password varchar(70) not null,
#     enabled  tinyint     not null
# )
#     engine = InnoDB
#     default
#         charset = latin1;
#
# # Similar as Roles
# create table authorities
# (
#     username  varchar(55) not null,
#     authority varchar(55) not null,
#
#     unique key authorities_idx_1 (username, authority),
#     constraint authorities_ibfk_1
#         foreign key (username)
#             references users (username)
#
# )
#     engine = InnoDB
#     default
#         charset = latin1;