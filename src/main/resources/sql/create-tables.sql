create table if not exists departments
(
    department_id int primary key auto_increment,
    name          varchar(255) not null,
    description   text         not null
) engine = InnoDB
  charset = latin1;

create table if not exists students
(
    student_id int primary key auto_increment,
    username   varchar(255) unique not null,
    password   varchar(255)        not null,
    first_name varchar(255)        not null,
    last_name  varchar(255)        not null,
    email      varchar(255)        not null,
    active     boolean             not null,
    role       varchar(50)         not null,
    grades     double              not null
)
    engine = InnoDB
    charset = latin1;

create table if not exists offices
(
    office_id       int primary key auto_increment,
    office_number   int,
    floor           int,
    building_number int,
    teacher_id      int
)
    engine = InnoDB
    charset = latin1;

create table if not exists teachers
(
    teacher_id    int primary key auto_increment,
    username      varchar(255) unique not null,
    password      varchar(255)        not null,
    first_name    varchar(255)        not null,
    last_name     varchar(255)        not null,
    email         varchar(255)        not null,
    active        boolean             not null,
    role          varchar(50)         not null,
    office_id     int,
    department_id int

) engine = InnoDB
  charset = latin1;

alter table offices add constraint foreign key (teacher_id) references teachers (teacher_id);
alter table teachers add constraint foreign key (office_id) references offices (office_id);
alter table teachers add constraint foreign key (department_id) references departments (department_id);

create table if not exists subjects
(
    subject_id    int primary key auto_increment,
    subject_code  varchar(255) unique not null,
    name          varchar(255)        not null,
    description   text,
    teacher_id    int,
    department_id int,
    language      varchar(50),
    foreign key (teacher_id) references teachers (teacher_id),
    foreign key (department_id) references departments (department_id)
)
    engine = InnoDB
    charset = latin1;

create table if not exists student_subject
(
    student_id int,
    subject_id int,
    primary key (student_id, subject_id),
    foreign key (student_id) references students (student_id),
    foreign key (subject_id) references subjects (subject_id)
)
    engine = InnoDB
    charset = latin1;

create table if not exists tech_personal
(
    id         int primary key auto_increment,
    username   varchar(255) unique not null,
    password   varchar(255)        not null,
    first_name varchar(255)        not null,
    last_name  varchar(255)        not null,
    email      varchar(255)        not null,
    active     boolean             not null,
    role       varchar(50)         not null
)
    engine = InnoDB
    charset = latin1;
