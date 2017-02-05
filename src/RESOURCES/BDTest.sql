/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     5/2/2017 10:51:24                            */
/*==============================================================*/


drop table if exists CATEGORIA;

drop table if exists CLIENTE;

drop table if exists DIRECCION;

drop table if exists FACTURA;

drop table if exists ITEMS;

drop table if exists PRODUCTOS;

/*==============================================================*/
/* Table: CATEGORIA                                             */
/*==============================================================*/
create table CATEGORIA
(
   COD_CATEGORIA        int not null,
   NOMBRE_CATEGORIA     char(20),
   primary key (COD_CATEGORIA)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   COD_CLIENTE          int not null,
   COD_DIRECCION        int,
   CEDULA_CLIENTE       numeric(10,0) not null,
   NOMBRE_CLIENTE       char(30) not null,
   APELLIDO_CLIENTE     char(30) not null,
   TELEFONO_FIJO        numeric(9,0),
   TELEFONO_MOVIL       char(12),
   EMAIL                char(60),
   DIRECCION            char(200),
   primary key (COD_CLIENTE)
);

/*==============================================================*/
/* Table: DIRECCION                                             */
/*==============================================================*/
create table DIRECCION
(
   COD_DIRECCION        int not null,
   CALLES               char(40) not null,
   BARRIO               char(30) not null,
   NUM_CASA             char(5),
   primary key (COD_DIRECCION)
);

/*==============================================================*/
/* Table: FACTURA                                               */
/*==============================================================*/
create table FACTURA
(
   COD_FACTURA          int not null,
   COD_CLIENTE          int,
   FECHA                date,
   METODO_PAGO          char(1),
   PRECIO_TOTAL         float(8,2),
   VALOR_EXTRA          float(8,2),
   VALOR_TOTAL          float(8,2),
   primary key (COD_FACTURA)
);

/*==============================================================*/
/* Table: ITEMS                                                 */
/*==============================================================*/
create table ITEMS
(
   COD_FACTURA          int,
   COD_PRODUCTO         int,
   CANTIDAD_PRODUCTO    numeric(3,0),
   PRECIO_TOTAL_ITEM    float,
   LLEVAR               char(1)
);

/*==============================================================*/
/* Table: PRODUCTOS                                             */
/*==============================================================*/
create table PRODUCTOS
(
   COD_PRODUCTO         int not null,
   COD_CATEGORIA        int,
   NOMBRE_PRODUCTO      char(30) not null,
   TAMANO_PRODUCTO      char(10),
   PRECIO_PRODUCTO      float,
   primary key (COD_PRODUCTO)
);

alter table CLIENTE add constraint FK_VIVE_EN foreign key (COD_DIRECCION)
      references DIRECCION (COD_DIRECCION) on delete restrict on update restrict;

alter table FACTURA add constraint FK_CLIENTE_TIENE_FACTURAS foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE) on delete restrict on update restrict;

alter table ITEMS add constraint FK_FACTURA_TIENE_PRODUCTOS foreign key (COD_FACTURA)
      references FACTURA (COD_FACTURA) on delete restrict on update restrict;

alter table ITEMS add constraint FK_PRODUCTOS_SON_ITEMS foreign key (COD_PRODUCTO)
      references PRODUCTOS (COD_PRODUCTO) on delete restrict on update restrict;

alter table PRODUCTOS add constraint FK_PRODUCTOS_TIENEN_CATEGORIA foreign key (COD_CATEGORIA)
      references CATEGORIA (COD_CATEGORIA) on delete restrict on update restrict;

