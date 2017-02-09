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
public class DAT_categorias {
DAT.DAT_conexion c = new DAT_conexion();

    public ResultSet consultarCategorias() throws ClassNotFoundException, SQLException {
        Statement st = c.getConnection().createStatement();
        String sentencia = "SELECT * FROM clientes";
        ResultSet rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet getIdCategorias() throws ClassNotFoundException, SQLException {
        String sentencia = "SELECT max(cat_id) FROM clientes";
        PreparedStatement pst = c.getConnection().prepareStatement(sentencia);
        return pst.executeQuery();
    }

    public int insertarProductos(int cod_categoria, String nombre_producto, String tamano_producto, double precio_producto) throws ClassNotFoundException, SQLException {
        String sentencia = "INSERT INTO adm_item_catalogo(itc_cat_id, itc_codigo,itc_nombre,itc_estado) "
                + "VALUES (?,?,?,?)";
        PreparedStatement ps = c.getConnection().prepareStatement(sentencia);
        ps.setInt(1, cod_categoria);
        ps.setString(2, nombre_producto);
        ps.setString(3, tamano_producto);
        ps.setDouble(4, precio_producto);

        return ps.executeUpdate();
    }

    public int instertarCategorias(String nombreCategoria) throws ClassNotFoundException, SQLException {
        String Sentencia = "INSERT INTO cliente (cedula_cliente, nombre_cliente, "
                + "apellido_cliente, telefono_fijo_cliente,telefono_movil_cliente,"
                + "email_cliente"
                + "VALUES (?)";
        PreparedStatement ps = c.getConnection().prepareStatement(Sentencia);
        ps.setString(1, nombreCategoria);
       

        return ps.executeUpdate();
    }
}
