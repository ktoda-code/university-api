create table subjects
(
    subject_id    int primary key auto_increment,
    subject_code  varchar(255) unique not null,
    name          varchar(255) not null,
    description   text,
    teacher_id    int,
    department_id int,
    language      varchar(50),
    foreign key (teacher_id) references teachers (teacher_id),
    foreign key (department_id) references departments (department_id)
)
    engine = InnoDB
    charset = latin1;

