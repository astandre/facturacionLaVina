/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     9/2/2017 16:46:17                            */
/*==============================================================*/


drop table if exists CATEGORIA;

drop table if exists CLIENTES;

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
/* Table: CLIENTES                                              */
/*==============================================================*/
create table CLIENTES
(
   COD_CLIENTE          int not null,
   CEDULA_CLIENTE       char(10) not null,
   NOMBRE_CLIENTE       char(30) not null,
   APELLIDO_CLIENTE     char(30) not null,
   TELEFONO_FIJO_CLIENTE char(9),
   TELEFONO_MOVIL_CLIENTE char(12),
   EMAIL_CLIENTE        char(60),
   primary key (COD_CLIENTE)
)
auto_increment = cod_cliente;

/*==============================================================*/
/* Table: DIRECCION                                             */
/*==============================================================*/
create table DIRECCION
(
   COD_CLIENTE_DIRECCION int,
   CALLES_DIRECCION     char(40) not null,
   BARRIO_DIRECCION     char(30) not null,
   NUMCASA_DIRECCION    char(5)
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
   PRECIO_TOTAL         float,
   VALOR_EXTRA          float,
   VALOR_TOTAL          float,
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
   TAMANO_PRODUCTO      char(1),
   PRECIO_PRODUCTO      float,
   primary key (COD_PRODUCTO)
);

alter table DIRECCION add constraint FK_VIVEN_EN foreign key (COD_CLIENTE_DIRECCION)
      references CLIENTES (COD_CLIENTE) on delete restrict on update restrict;

alter table FACTURA add constraint FK_CLIENTE_TIENE_FACTURAS foreign key (COD_CLIENTE)
      references CLIENTES (COD_CLIENTE) on delete restrict on update restrict;

alter table ITEMS add constraint FK_FACTURA_TIENE_PRODUCTOS foreign key (COD_FACTURA)
      references FACTURA (COD_FACTURA) on delete restrict on update restrict;

alter table ITEMS add constraint FK_PRODUCTOS_SON_ITEMS foreign key (COD_PRODUCTO)
      references PRODUCTOS (COD_PRODUCTO) on delete restrict on update restrict;

alter table PRODUCTOS add constraint FK_PRODUCTOS_TIENEN_CATEGORIA foreign key (COD_CATEGORIA)
      references CATEGORIA (COD_CATEGORIA) on delete restrict on update restrict;

