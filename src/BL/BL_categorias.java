/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.DAT_categorias;
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

    ArrayList<Categoria> lstCategorias;

    public int insertarCategorias(Categoria objCategoria) throws ClassNotFoundException, SQLException {
        int isCategoriaInserted;
        int isProductoInserted = 0;
        int master = 0;
        ResultSet rs;

        //Insertar cabecera de Clientes
        isCategoriaInserted = manejadorCategorias.instertarCategorias(objCategoria.getNombre_categoria());
        System.out.println("CategoriaInserted:" + isCategoriaInserted);
        if (isCategoriaInserted == 1) {
            rs = manejadorCategorias.getIdCategorias();
            while (rs.next()) {
                //obtiene el id del registro master 
                master = rs.getInt(1);
            }
        }

        //insert la direccion de cliente
        for (Productos Productos : objCategoria.getLst_productos()) {
            String nombre_producto = Productos.getNombre_producto();
            String tamano_producto = String.valueOf(Productos.getTamano_producto());
            double precio_producto = Productos.getPrecio_producto();

            isProductoInserted = manejadorCategorias.insertarProductos(master, nombre_producto, tamano_producto, precio_producto);
        }
        return isProductoInserted;
    }

    public int insertarProductos(Productos objProducto) throws ClassNotFoundException, SQLException {

        return manejadorCategorias.insertarProductos(objProducto.getCod_categoria(), objProducto.getNombre_producto(),
                String.valueOf(objProducto.getTamano_producto()), objProducto.getPrecio_producto());

    }

    public ArrayList<Categoria> Consultar() throws ClassNotFoundException, SQLException, ParseException {
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
                if (columnames.equals("cod_categoria")) {
                    m.setCod_categoria(Integer.parseInt(value));
                }
                if (columnames.equals("nombre_categoria")) {
                    m.setNombre_categoria(value);
                }
                
            }
            lstCategorias.add(m);
            incremento = incremento + 1;
        }
       

        return lstCategorias;
    }
}
