/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAT;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Expression Andre is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class DAT_items {
DAT.DAT_conexion conecctionHandler = new DAT_conexion();
public int insertarItems(int cod_factura_items,int cod_producto_items, int cantidad_items, double precio_total_item, String llevar_item,String comentario) throws ClassNotFoundException, SQLException {
        String sentencia = "INSERT INTO items(COD_FACTURA_ITEMS,COD_PRODUCTO_ITEMS, CANTIDAD_ITEMS,PRECIO_TOTAL_ITEM,LLEVAR_ITEM,COMENTARIO) "
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conecctionHandler.getConnection().prepareStatement(sentencia);
       ps.setInt(1, cod_factura_items);
        ps.setInt(2, cod_producto_items);
        ps.setInt(3, cantidad_items);
        ps.setDouble(4, precio_total_item);
        ps.setString(5, llevar_item);
          ps.setString(6, comentario);

        return ps.executeUpdate();
    }
public ResultSet consultarItems() throws ClassNotFoundException, SQLException {
        Statement st = conecctionHandler.getConnection().createStatement();
        String sentencia = "SELECT * FROM items";
        ResultSet rs = st.executeQuery(sentencia);
        return rs;
    }

}
