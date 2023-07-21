create table students
(
    student_id int primary key auto_increment,
    username   varchar(255) unique not null,
    password   varchar(255)        not null,
    first_name varchar(255)        not null,
    last_name  varchar(255)        not null,
    email      varchar(255)        not null,
    active     boolean             not null,
    role       varchar(50)         not null,
    grades double not null
)
    engine = InnoDB
    charset = latin1;

create table student_subject
(
    student_id int,
    subject_id int,
    primary key (student_id, subject_id),
    foreign key (student_id) references students (student_id),
    foreign key (subject_id) references subjects (subject_id)
)
    engine = InnoDB
    charset = latin1;
