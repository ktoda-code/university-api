create table departments
(
    department_id int primary key auto_increment,
    name          varchar(255) not null,
    description   text         not null
) engine = InnoDB
  charset = latin1;