drop table if exists student;

-- auto-generated definition
create table student
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
