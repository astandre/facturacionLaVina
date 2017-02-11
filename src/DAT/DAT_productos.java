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
public class DAT_productos {
    DAT.DAT_conexion conecctionHandler = new DAT_conexion();
public int insertarProductos(int cod_categoria, String nombre_producto, String tamano_producto, double precio_producto) throws ClassNotFoundException, SQLException {
        String sentencia = "INSERT INTO adm_item_catalogo(itc_cat_id, itc_codigo,itc_nombre,itc_estado) "
                + "VALUES (?,?,?,?)";
        PreparedStatement ps = conecctionHandler.getConnection().prepareStatement(sentencia);
        ps.setInt(1, cod_categoria);
        ps.setString(2, nombre_producto);
        ps.setString(3, tamano_producto);
        ps.setDouble(4, precio_producto);

        return ps.executeUpdate();
    }
public ResultSet consultarProductos() throws ClassNotFoundException, SQLException {
        Statement st = conecctionHandler.getConnection().createStatement();
        String sentencia = "SELECT * FROM productos";
        ResultSet rs = st.executeQuery(sentencia);
        return rs;
    }
 }
