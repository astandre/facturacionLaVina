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
        String sentencia = "SELECT * FROM categoria";
        ResultSet rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet getIdCategorias() throws ClassNotFoundException, SQLException {
        String sentencia = "SELECT max(COD_CATEGORIA) FROM categoria";
        PreparedStatement pst = c.getConnection().prepareStatement(sentencia);
        return pst.executeQuery();
    }

    

    public int instertarCategorias(String nombreCategoria) throws ClassNotFoundException, SQLException {
        String Sentencia = "INSERT INTO categoria (NOMBRE_CATEGORIA)"
                + "VALUES (?)";
        PreparedStatement ps = c.getConnection().prepareStatement(Sentencia);
        ps.setString(1, nombreCategoria);
       

        return ps.executeUpdate();
    }
}
