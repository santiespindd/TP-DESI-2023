-- --------- Clientes ------------------ 


INSERT INTO `desi_2023`.`cliente`(`dni`,`apellido`,`domicilio`,`email`,`fecha_nacimiento`,`nombre`,`pasaporte`)
VALUES(37819076,"Espindola","Pje desi 2023","santiago.espindola@gmail.com","1993-10-23","Santiago",346598798);


INSERT INTO `desi_2023`.`cliente`(`dni`,`apellido`,`domicilio`,`email`,`fecha_nacimiento`,`nombre`,`pasaporte`)
VALUES(12345678,"González","Av. Principal 123","gonzalez@gmail.com","1985-05-15","Ana",987654321);


INSERT INTO `desi_2023`.`cliente`(`dni`,`apellido`,`domicilio`,`email`,`fecha_nacimiento`,`nombre`,`pasaporte`)
VALUES(56781234,"Martínez","Calle Secundaria 789","martinez@hotmail.com","1990-12-01","Juan",654321987);


INSERT INTO `desi_2023`.`cliente`(`dni`,`apellido`,`domicilio`,`email`,`fecha_nacimiento`,`nombre`,`pasaporte`)
VALUES(87654321,"López","Ruta 45 Km 67","lopez@yahoo.com","1980-07-08","María",789012345);



#---------------tasas------------------- 

INSERT INTO `desi_2023`.`tasas`
(`id`,`cotizacion_dolar`,`iva`,`tasa_aeroportuaria_internacional`,`tasa_aeroportuaria_nacional`)
VALUES(3,1040,21,200,7000);

INSERT INTO `desi_2023`.`tasas`
(`id`,`cotizacion_dolar`,`iva`,`tasa_aeroportuaria_internacional`,`tasa_aeroportuaria_nacional`)
VALUES(4,1000.80,5,150,6000);

INSERT INTO `desi_2023`.`tasas`
(`id`,`cotizacion_dolar`,`iva`,`tasa_aeroportuaria_internacional`,`tasa_aeroportuaria_nacional`)
VALUES(5,999,20,350,5000);

INSERT INTO `desi_2023`.`tasas`
(`id`,`cotizacion_dolar`,`iva`,`tasa_aeroportuaria_internacional`,`tasa_aeroportuaria_nacional`)
VALUES(6,1100,11,600,7150);


#---------------provincias------------------- 

INSERT INTO `desi_2023`.`provincia`(id,nombre) VALUES(1,'Santa fe');
INSERT INTO `desi_2023`.`provincia`(id,nombre) VALUES(2,'Buenos Aires');
INSERT INTO `desi_2023`.`provincia`(id,nombre) VALUES(3,'Cordoba');
INSERT INTO `desi_2023`.`provincia`(id,nombre) VALUES(4,'Mendoza');
INSERT INTO `desi_2023`.`provincia`(id,nombre) VALUES(5,'Chaco');

INSERT INTO `desi_2023`.`provincia`(id,nombre) VALUES(6,'EE UU');
INSERT INTO `desi_2023`.`provincia`(id,nombre) VALUES(8,'Inglaterra');


#---------------ciudades------------------- 
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(1,'Rosario',1);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(2,'Galvez',1);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(3,'Santa fe',1);

INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(4,'La plata',2);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(5,'Lanus',2);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(6,'Tigre',2);


INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(7,'Carlos Paz',3);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(8,'Villa Maria',3);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(9,'Rio Cuarto',3);

INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(10,'Godoy Cruz',4);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(11,'Mendoza',4);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(12,'San Martin',4);

INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(13,'Resistencia',5);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(14,'El espinillo',5);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(15,'Charata',5);

INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(16,'New York',6);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(17,'Miami',6);
INSERT INTO `desi_2023`.`ciudad`(id,nombre,provincia_id) VALUES(18,'Londres',8);

#----AVIONES

INSERT INTO `desi_2023`.`avion`(`id`,`asientos_por_fila`,`capacidad_filas`,`nombre`)VALUES(1,20,2,'Avion 1');
INSERT INTO `desi_2023`.`avion`(`id`,`asientos_por_fila`,`capacidad_filas`,`nombre`)VALUES(2,50,3,'Avion 2');
INSERT INTO `desi_2023`.`avion`(`id`,`asientos_por_fila`,`capacidad_filas`,`nombre`)VALUES(3,40,3,'Avion 3');
INSERT INTO `desi_2023`.`avion`(`id`,`asientos_por_fila`,`capacidad_filas`,`nombre`)VALUES(4,50,4,'Avion 4');

select * from vuelo;



