create table proveedores (idproveedor integer not null auto_increment, apellidos varchar(255), fecha date, nif varchar(255), nombre varchar(255), primary key (idproveedor)) engine=InnoDB
alter table proveedores add constraint UK_1r21ysyjna71lu5xyhypti0ph unique (nif)
