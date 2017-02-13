/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapedidos;


import BL.*;
import Modelo.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author USUARIO
 */
public class SistemaPedidos {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        BL_categorias categoriasHandler = new BL_categorias();
        Productos objProducto;
       ArrayList<Categoria> lstCategorias = new ArrayList<>();
        
        Categoria objCategoria;
       
         lstCategorias=categoriasHandler.consultarCategorias();
        for (int i = 0; i < lstCategorias.size(); i++) {
            System.out.println(lstCategorias.get(i).getNombre_categoria());
             ArrayList<Productos> lstProductos = new ArrayList<>();
             lstProductos=lstCategorias.get(i).getLst_productos();
             for (int j = 0; j < lstProductos.size(); j++) {
                 System.out.println(lstProductos.get(j).getNombre_producto());
            }
        }
        
       
    }

}
