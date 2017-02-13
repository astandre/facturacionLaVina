/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.DAT_factura;
import DAT.DAT_items;
import Modelo.Factura;
import Modelo.Items;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Expression Andre is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class BL_factura {

    DAT_factura manejadorFacturas = new DAT_factura();
    DAT_items manejadorItems = new DAT_items();
    
      ArrayList<Factura> lstFacturas;

    public int insertarCategorias(Factura objFactura) throws ClassNotFoundException, SQLException {
        int isCategoriaInserted;
        int isItemsInserted = 0;
        int master = 0;
        ResultSet rs;

        //Insertar cabecera de Categorias
        isCategoriaInserted = manejadorFacturas.insertarFactura(objFactura.getNum_factura(),
                objFactura.getCod_cliente_factura(), objFactura.getFecha(), String.valueOf(objFactura.getMetodo_pago_factura()),
                objFactura.getPrecio_total_factura(), objFactura.getValor_extra_factura(), objFactura.getValor_total_factura());
        System.out.println("FacturaInserted:" + isCategoriaInserted);
        if (isCategoriaInserted == 1) {
            rs = manejadorFacturas.getIdFacturas();
            while (rs.next()) {
                //obtiene el id del registro master 
                master = rs.getInt(1);
            }
        }

        //insert los productos de cada categoria
        for (Items objItems : objFactura.getLst_items_factura()) {
            int cod_producto_items = objItems.getCod_producto_items();
            int cantidad_items = objItems.getCantidad_items();
            double precio_total_item = objItems.getPrecio_total_item();
            String llevar_item = String.valueOf(objItems.getLlevar_item());
            String comentario = objItems.getComentario();

            isItemsInserted = manejadorItems.insertarItems(master, cod_producto_items, cantidad_items, precio_total_item,
                    llevar_item, comentario);
        }
        return isItemsInserted;
    }

    public ArrayList<Factura> consultarFacturas() throws ClassNotFoundException, SQLException, ParseException {
        lstFacturas = new ArrayList<>();

        int columnCount;
        int incremento = 0;
        ResultSet rs;
        rs = manejadorFacturas.consultarFacturas();
        ResultSetMetaData rm = rs.getMetaData();
        columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int j = 1; j < columnCount + 1; j++) {
            String columname = rm.getColumnName(j);
            columnas.add(columname);
        }
              while (rs.next()) {
            Factura m = new Factura();
            for (String columnames : columnas) {
                String value = rs.getString(columnames);
                if (columnames.equals("COD_FACTURA")) {
                    m.setCod_factura(Integer.parseInt(value));
                }
                if (columnames.equals("NUM_FACTURA")) {
                    m.setNum_factura(value);
                }
                 if (columnames.equals("COD_CLIENTE_FACTURA")) {
                    m.setCod_cliente_factura(Integer.parseInt(value));
                }
                  if (columnames.equals("FECHA")) {
                    m.setFecha(Date.valueOf(value));
                }
                   if (columnames.equals("METODO_PAGO_FACTURA")) {
                    m.setMetodo_pago_factura(value.charAt(0));
                }
                    if (columnames.equals("PRECIO_TOTAL_FACTURA")) {
                    m.setPrecio_total_factura(Double.parseDouble(value));
                }
                       if (columnames.equals("VALOR_EXTRA_FACTURA")) {
                    m.setValor_extra_factura(Double.parseDouble(value));
                }

            }
            lstFacturas.add(m);
            incremento = incremento + 1;
        }
        rs = manejadorItems.consultarItems();
        rm = rs.getMetaData();
        columnCount = rm.getColumnCount();
        columnas = new ArrayList<>();
        for (int j = 1; j < columnCount + 1; j++) {
            String columname = rm.getColumnName(j);
            columnas.add(columname);
        }

           ArrayList<Items> lstItemsAux = new ArrayList<>();
        while (rs.next()) {

            Items objItems = new Items();
            for (String columnames : columnas) {
                String value = rs.getString(columnames);
                if (columnames.equals("COD_FACTURA_ITEMS")) {
                    objItems.setCod_factura_items(Integer.parseInt(value));
                }
                if (columnames.equals("COD_PRODUCTO_ITEMS")) {
                    objItems.setCod_producto_items(Integer.parseInt(value));
                }
                if (columnames.equals("CANTIDAD_ITEMS")) {
                    objItems.setCantidad_items(Integer.parseInt(value));
                }
                if (columnames.equals("PRECIO_TOTAL_ITEM")) {
                    objItems.setPrecio_total_item(value.charAt(0));
                }
                if (columnames.equals("LLEVAR_ITEM")) {
                    objItems.setLlevar_item(value.charAt(0));
                }
                if (columnames.equals("COMENTARIO")) {
                    objItems.setComentario(value);
                }

            }
            lstItemsAux.add(objItems);
        }
        //obtener codigos de productos
        int[] codigos_categorias = new int[lstFacturas.size()];
        for (int j = 0; j < lstFacturas.size(); j++) {
            codigos_categorias[j] = lstFacturas.get(j).getCod_factura();
        }
        //organizar en un arraylist temporal con cada producto que coincida con el 
        for (int j = 0; j < lstItemsAux.size(); j++) {
            ArrayList<Items> lstProductosOrdenada = new ArrayList<>();
            for (int k = 0; k < lstItemsAux.size(); k++) {

                if (lstItemsAux.get(k).getCod_factura_items()== codigos_categorias[j]) {
                    lstProductosOrdenada.add(lstItemsAux.get(k));
                }
            }
            lstFacturas.get(j).setLst_items_factura(lstProductosOrdenada);
        }
        return lstFacturas;
    }
    public int insertarItems(Items objItems) throws ClassNotFoundException, SQLException {

        return manejadorItems.insertarItems(objItems.getCod_factura_items(), objItems.getCod_producto_items(),
                objItems.getCantidad_items(), objItems.getPrecio_total_item(),
                String.valueOf(objItems.getLlevar_item()), objItems.getComentario());

    }
}
