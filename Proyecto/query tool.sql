drop database proyecto;
create database proyecto;
use proyecto;

select * from demo.empleados;
use demo;
-- Inserción en la tabla de administrador
INSERT INTO proyecto.administrador (usuario, contrasena) 
VALUES ('admin', 'admin123');

-- Inserción en la tabla de cliente
INSERT INTO proyecto.cliente (cedula, nombre, apellido, telefono, fecha_nacimiento) 
VALUES 
    (123456789, 'Juan', 'Perez', 1234567890, '1990-05-15'),
    (987654321, 'Maria', 'Lopez', 9876543210, '1985-08-20'),
    (456789123, 'Pedro', 'Garcia', 4567891230, '1978-03-10'),
    (789123456, 'Laura', 'Martinez', 7891234560, '2000-12-25');

-- Inserción en la tabla de bus
INSERT INTO proyecto.bus (matricula, numero_de_puestos) 
VALUES 
    ('BUS001', 30),
    ('BUS002', 35),
    ('BUS003', 25);
    
-- Inserción en la tabla de viaje
INSERT INTO proyecto.viaje (id_viaje, id_bus, destino, hora, fecha, precio, disponibilidad) 
VALUES 
    (1, 'BUS001', 'Ciudad A', '08:00:00', '2024-03-01', 50000, 1),
    (2, 'BUS002', 'Ciudad B', '10:00:00', '2024-03-02', 60000, 1),
    (3, 'BUS003', 'Ciudad C', '12:00:00', '2024-03-03', 55000, 1),
    (4, 'BUS001', 'Ciudad D', '14:00:00', '2024-03-04', 52000, 1);

-- Inserción en la tabla de reserva
INSERT INTO proyecto.reserva (id_reserva, cc_cliente, id_viaje, puesto_asignado, estado_de_pago, fecha_de_reserva) 
VALUES 
    (1, 123456789, 1, 15, 0, '2024-02-26'),
    (2, 987654321, 2, 20, 1, '2024-02-27'),
    (3, 456789123, 3, 10, 1, '2024-02-28'),
    (4, 789123456, 4, 5, 0, '2024-02-29');

delete from proyecto.reserva where reserva.id_reserva = 5;

insert into cliente (cedula, apellido, fecha_nacimiento, nombre, telefono)
values(333, "ortiz", '2003-10-03', "david", 3021029);

delete from proyecto.reserva where reserva.id_reserva = 14;
delete from proyecto.cliente where cliente.cedula = 123;

select * from proyecto.viaje;
select * from proyecto.cliente;
select * from proyecto.bus;
SELECT * FROM proyecto.reserva;
select * from proyecto.administrador;

Select distinct viaje.destino,viaje.hora, viaje.precio, viaje.fecha
from proyecto.viaje
join proyecto.reserva on viaje.id_viaje = reserva.id_viaje and reserva.cc_cliente = 123456789;

select viaje.id_bus, reserva.id_reserva, cliente.nombre, cliente.apellido
from proyecto.reserva
join proyecto.viaje on reserva.id_viaje = viaje.id_viaje
join proyecto.cliente on reserva.cc_cliente = cliente.cedula
where viaje.id_bus = "BUS001";

select reserva.puesto_asignado, viaje.precio, reserva.cc_cliente
from proyecto.reserva
join proyecto.viaje on viaje.id_viaje = reserva.id_viaje and cc_cliente = 123456789;

Select distinct reserva.puesto_asignado, viaje.precio
from proyecto.reserva
join proyecto.viaje on reserva.id_viaje = viaje.id_viaje;

delete from cliente where cliente.cedula = 101010100