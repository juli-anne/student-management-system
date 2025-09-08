create table if not exists studentDto
(
    id serial primary key,
    first_name text not null,
    last_name text not null,
    program text not null
);