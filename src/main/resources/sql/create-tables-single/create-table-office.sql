create table offices
(
    office_id int primary key auto_increment,
    office_number int,
    floor int,
    building_number int,
    teacher_id int,
    foreign key (teacher_id) references teachers (teacher_id)
)
    engine = InnoDB
    charset = utf8mb4;
