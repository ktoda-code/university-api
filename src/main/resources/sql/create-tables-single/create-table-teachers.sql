create table teachers
(
    teacher_id int primary key auto_increment,
    username   varchar(255) unique not null,
    password   varchar(255)        not null,
    first_name varchar(255)        not null,
    last_name  varchar(255)        not null,
    email      varchar(255)        not null,
    active     boolean             not null,
    role       varchar(50)         not null,
    office_id int,
    department_id int,
    foreign key (office_id) references offices (office_id),
    foreign key (department_id) references departments (department_id)

) engine = InnoDB
  charset = latin1;