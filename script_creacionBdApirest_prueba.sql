create database lacomerdb;

create table Usuario(
id int not null primary key auto_increment,
nombre varchar(80) not null,
apellidopaterno varchar(80) not null,
apellidomaterno varchar(80) not null,
email varchar(80) not null
);

insert into usuario(nombre, apellidoPaterno,apellidoMaterno, email) values 
("Hector","Benitez","Alvarez","hector.benitez19@gmail.com");

select * from usuario;





