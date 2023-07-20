drop table if exists student;

-- auto-generated definition
create table students
(
    id         int auto_increment
        primary key,
    student_id varchar(45) not null,
    password varchar(45) not null,
    first_name varchar(45) not null,
    last_name  varchar(45) null,
    email      varchar(45) not null
)
    engine = InnoDB
    charset = latin1;

create table users (
  username varchar(50) not null primary key ,
  password varchar(50) not null,
  enabled tinyint not null
)
    engine = InnoDB default
    charset = latin1;

create table authorities (
    username varchar(50) not null ,
    authority varchar(50) not null,

    unique key authorities_idx_1 (username,authority),
    constraint authorities_ibfk_1
    foreign key (username)
    references users (username)

)
    engine = InnoDB default
    charset = latin1;