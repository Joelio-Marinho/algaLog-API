create table cliente(
    id bigint not null auto_increment,
    name varchar (100) not null,
    email varchar (60) not null,
    telefone varchar(12) not null,

    primary key (id)
);