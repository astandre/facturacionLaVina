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
public class DAT_direccion {
     DAT.DAT_conexion conecctionHandler = new DAT_conexion();
public int insertarDireccion(int cod_cliente_direccion, String calles_direccion, String barrio_direccion, String numCasa_direccion) throws ClassNotFoundException, SQLException {
        String sentencia = "INSERT INTO direccion(cod_cliente_direccion, calles_direccion,barrio_direccion,numCasa_direccion) VALUES (?,?,?,?)";
        PreparedStatement ps = conecctionHandler.getConnection().prepareStatement(sentencia);
        ps.setInt(1, cod_cliente_direccion);
        ps.setString(2, calles_direccion);
        ps.setString(3, barrio_direccion);
        ps.setString(4, numCasa_direccion);

        return ps.executeUpdate();
    }
 public ResultSet consultarDireccion() throws ClassNotFoundException, SQLException {
        Statement st = conecctionHandler.getConnection().createStatement();
        String sentencia = "SELECT * FROM direccion";
        ResultSet rs = st.executeQuery(sentencia);
        return rs;
    }
  public int eliminarDireccion(String strCondicion) throws ClassNotFoundException, SQLException{
     String Sentencia = "DELETE FROM direccion WHERE COD_CLIENTE_DIRECCION = ?";
     PreparedStatement ps = conecctionHandler.getConnection().prepareStatement(Sentencia);
     ps.setString(1, strCondicion);
     return ps.executeUpdate();
     }
  public int updateDireccion(String newValue, String dbColNames[], int indexColumn, int cod_cliente_direccion) throws ClassNotFoundException, SQLException {
        String sql = String.format("UPDATE direccion SET %s = '%s' WHERE COD_CLIENTE_DIRECCION = %d",
                dbColNames[indexColumn], newValue, cod_cliente_direccion);
        PreparedStatement ps = conecctionHandler.getConnection().prepareStatement(sql);
        return ps.executeUpdate();
    }
}
