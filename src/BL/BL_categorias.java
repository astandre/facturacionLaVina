/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.DAT_categorias;
import DAT.DAT_productos;
import Modelo.Categoria;
import Modelo.Productos;
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
public class BL_categorias {

    DAT_categorias manejadorCategorias = new DAT_categorias();
    DAT_productos manejadorProductos = new DAT_productos();

    ArrayList<Categoria> lstCategorias;

    public int insertarCategorias(Categoria objCategoria) throws ClassNotFoundException, SQLException {
        int isCategoriaInserted;
        int isProductoInserted = 0;
        int master = 0;
        ResultSet rs;

        //Insertar cabecera de Categorias
        isCategoriaInserted = manejadorCategorias.instertarCategorias(objCategoria.getNombre_categoria());
        System.out.println("CategoriaInserted:" + isCategoriaInserted);
        if (isCategoriaInserted == 1) {
            rs = manejadorCategorias.getIdCategorias();
            while (rs.next()) {
                //obtiene el id del registro master 
                master = rs.getInt(1);
            }
        }

        //insert los productos de cada categoria
        for (Productos Productos : objCategoria.getLst_productos()) {
            String nombre_producto = Productos.getNombre_producto();
            String tamano_producto = String.valueOf(Productos.getTamano_producto());
            double precio_producto = Productos.getPrecio_producto();

            isProductoInserted = manejadorProductos.insertarProductos(master, nombre_producto, tamano_producto, precio_producto);
        }
        return isProductoInserted;
    }

    public int insertarProductos(Productos objProducto) throws ClassNotFoundException, SQLException {

        return manejadorProductos.insertarProductos(objProducto.getCod_categoria(), objProducto.getNombre_producto(),
                String.valueOf(objProducto.getTamano_producto()), objProducto.getPrecio_producto());

    }

    public ArrayList<Categoria> consultarCategorias() throws ClassNotFoundException, SQLException, ParseException {
        lstCategorias = new ArrayList<>();

        int columnCount;
        int incremento = 0;
        ResultSet rs;
        rs = manejadorCategorias.consultarCategorias();
        ResultSetMetaData rm = rs.getMetaData();
        columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int j = 1; j < columnCount + 1; j++) {
            String columname = rm.getColumnName(j);
            columnas.add(columname);
        }
        while (rs.next()) {
            Categoria m = new Categoria();
            for (String columnames : columnas) {
                String value = rs.getString(columnames);
                if (columnames.equals("COD_CATEGORIA")) {
                    m.setCod_categoria(Integer.parseInt(value));
                }
                if (columnames.equals("NOMBRE_CATEGORIA")) {
                    m.setNombre_categoria(value);
                }

            }
            lstCategorias.add(m);
            incremento = incremento + 1;
        }
        rs = manejadorProductos.consultarProductos();
        rm = rs.getMetaData();
        columnCount = rm.getColumnCount();
        columnas = new ArrayList<>();
        for (int j = 1; j < columnCount + 1; j++) {
            String columname = rm.getColumnName(j);
            columnas.add(columname);
        }

           ArrayList<Productos> lstProductosAux = new ArrayList<>();
        while (rs.next()) {

            Productos objProducto = new Productos();
            for (String columnames : columnas) {
                String value = rs.getString(columnames);
                if (columnames.equals("COD_PRODUCTO")) {
                    objProducto.setCod_producto(Integer.parseInt(value));
                }
                if (columnames.equals("COD_CATEGORIA")) {
                    objProducto.setCod_categoria(Integer.parseInt(value));
                }
                if (columnames.equals("NOMBRE_PRODUCTO")) {
                    objProducto.setNombre_producto(value);
                }
                if (columnames.equals("TAMANO_PRODUCTO")) {
                    objProducto.setTamano_producto(value.charAt(0));
                }
                if (columnames.equals("PPRECIO_PRODUCTO")) {
                    objProducto.setPrecio_producto(Double.parseDouble(value));
                }

            }
            lstProductosAux.add(objProducto);
        }
        //obtener codigos de productos
        int[] codigos_categorias = new int[lstCategorias.size()];
        for (int j = 0; j < lstCategorias.size(); j++) {
            codigos_categorias[j] = lstCategorias.get(j).getCod_categoria();
        }
        //organizar en un arraylist temporal con cada producto que coincida con el 
        for (int j = 0; j < lstCategorias.size(); j++) {
            ArrayList<Productos> lstProductosOrdenada = new ArrayList<>();
            for (int k = 0; k < lstProductosAux.size(); k++) {

                if (lstProductosAux.get(k).getCod_categoria() == codigos_categorias[j]) {
                    lstProductosOrdenada.add(lstProductosAux.get(k));
                }
            }
            lstCategorias.get(j).setLst_productos(lstProductosOrdenada);
        }
        return lstCategorias;
    }
}
