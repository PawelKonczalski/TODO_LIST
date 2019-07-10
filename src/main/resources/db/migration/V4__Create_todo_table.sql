create table todo (
    id int unsigned primary key auto_increment,
    text varchar(100) not null,
    done bit(1)
);

insert into todo (text, done) values ('Not done yet', 0),('Done', 1);