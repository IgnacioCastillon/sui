CREATE DATABASE IF NOT EXISTS Netflix;
USE Netflix;
CREATE TABLE IF NOT EXISTS Peliculas(
    ID int primary key,
    Nombre VARCHAR(30),
    Duracion INT NOT NULL,
    Director VARCHAR(20),
    Genero ENUM ('acción', 'drama', 'comedia'),
    Nota decimal(2,1),
    Protagonista int);
INSERT INTO Peliculas (ID, Nombre, Duracion, Director, Genero, Nota, Protagonista) VALUES(1, 'Bright', 120, 'Fernando', 'acción', 3.1, "1234"),(2, 'Frida', 100, 'Daniel', 'drama', 7.6, "1357"),(3, 'Los dos papas', 160, 'Adrián', 'comedia', 8.3, "1222"),(4, 'Animales nocturnos', 185, 'Tomás', 'drama', 9.5, "1357"),(5, 'Oceans Eleven', 150, 'Nuria', 'acción', 3.5, "1222"),(6, 'Buscando a Nemo', 120, 'Jon', 'comedia', 2.1, "1212"),(7, 'El Hoyo', 110, 'Ivan', 'acción', 9.9, "1265"),(8, 'Diamante en bruto', 140, 'Paola', 'acción', 8.1, "1265");

Delimiter //
create function mostrarInfo() returns varchar(500) no sql
begin
declare peliculasTotales int;
declare mediaDuracion dec(5,2);
declare maximaNota dec(2,1);
declare minimaNota dec(2,1);
declare resultado varchar(500);

set peliculasTotales = (select count(*) from peliculas);
set mediaDuracion = (select avg(duracion) from peliculas);
set maximaNota = (select max(nota) from peliculas limit 1);
set minimaNota = (select min(nota) from peliculas limit 1);
set resultado = concat("La tabla contiene ",peliculasTotales," peliculas; La duración media de todas las peliculas es de",mediaDuracion," minutos; Nota maxima: ",maximaNota,"; Nota minima: ",minimaNota);
return resultado;
end //
select mostrarInfo();

Delimiter //
create function menorPuntuacion(id1 int, id2 int) returns varchar(500) no sql
begin
declare resultado varchar(500);
if id1<id2 then
set resultado = (select nombre from peliculas where id=id1);
else
set resultado = (select nombre from peliculas where id=id2);
end if;
return resultado;
end //
select menorPuntuacion(1,2);

Delimiter // 
create function buscarGenero(genero2 varchar(20)) returns varchar(500) no sql
begin
declare resultado varchar(500);
declare comando varchar(500);
set comando = (select count(*) from peliculas where genero=genero2);
if comando>2 then
set resultado = concat("La cantidad de peliculas de ",genero2," es de ",(select count(*) from peliculas where genero=genero2));
else
set resultado = "Este genero no posee mas de dos peliculas";
end if;
return resultado;
end//

select buscarGenero("drama");

Delimiter //
create function limite(n1 int, n2 int) returns varchar(500) no sql
begin
declare resultado varchar(500);
declare contador int;
declare contador1 int;
declare contador2 int;
set contador = 0;
set contador1 = n1;
set contador2 = 1;
set resultado = "";
while (contador!=n2) do
if contador>0 then
set resultado = concat(resultado,"; ",(select nombre from peliculas limit contador1,1));
else
set resultado = concat((select nombre from peliculas limit contador1,1));
end if;
set contador = contador+1;
set contador1 = contador1+1;
set contador2 = contador2+1;
end while;
return resultado;
end //
select limite(2,4);

Delimiter //
create procedure añadirRegistroPelicula(nombre2 varchar(20), director2 varchar(20), nota2 int)
begin
declare id2 int;
declare id3 int;
declare duracion2 int;
declare duracion3 int;
declare aleatorio2 int;
declare genero2 varchar(200);
declare resultado varchar(400);
set id2 = (select ID from peliculas order by ID desc limit 1);
set id3 = id2+1;
set duracion2 = (select avg(duracion) from peliculas);
set duracion3 = duracion2*0.80;
set aleatorio2 = 3;
if aleatorio2=1 then
set genero2 = "Accion";
elseif aleatorio2=2 then
set genero2 = "Drama";
elseif aleatorio2=3 then
set genero2 = "Comedia";
end if;

insert into peliculas(ID, Nombre, Duracion, Director, Genero, Nota)
values(id3,nombre2,duracion3,director2,genero2,nota2);

select * from peliculas;
end //

call añadirRegistroPelicula("Titanic", "", 8);

Delimiter //
create procedure modificarDirector(id int)
begin
declare nombreDirector varchar(50);
declare directorNombre varchar(40);
set nombreDirector = (select director from peliculas where ID=id limit 1);
set directorNombre = (select reverse(nombreDirector));
update peliculas set director = directorNombre where director=nombreDirector;
select * from peliculas;
end //

call modificarDirector(1);

Delimiter //
create procedure consultaSQL(nombreColumna varchar(20),valorColumna varchar(20))
begin
declare comando varchar(40);
if nombreColumna = "nota" then
select * from peliculas where nota!=valorColumna order by nota desc;
elseif nombreColumna = "nombre" then
select * from peliculas where nombre!=valorColumna order by nombre asc;
elseif nombreColumna = "duracion" then
select * from peliculas where duracion!=valorColumna order by duracion asc;
end if;
end//
call consultaSQL("nombre","Bright");

