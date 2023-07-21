create table tech_personal
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