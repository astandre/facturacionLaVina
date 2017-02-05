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
 * @author USUARIO
 */
public class DATregistro {
     DAT.DATconexion c = new DATconexion();
     public ResultSet Consultar() throws ClassNotFoundException, SQLException{
    Statement st = c.getConnection().createStatement();
   String sentencia ="SELECT * FROM guarderia";
   ResultSet rs = st.executeQuery(sentencia);
   return rs;
}
    public int instertar(String nombres_padre, String strFechaPadre, 
            String correo_padre,String telefono_padre,String celular_padre,String nombres_nino,String fecha_nacimiento_nino
            ,String tipoSangreNino, int alergias_nino,int vacunas_nino,int medicamentos_nino,String dias,String fecha_registro) throws ClassNotFoundException, SQLException{
        String Sentencia = "INSERT INTO guarderia (nombres_padre, fecha_nacimiento_padre, "
                + "correo_padre, telefono_padre,celular_padre,nombres_nino,"
                + "fecha_nacimiento_nino,tipo_sangre_nino,alergias_nino,vacunas_nino,"
                + "medicamentos_nino,dias,fecha_registro)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps= c.getConnection().prepareStatement(Sentencia);
        ps.setString(1, nombres_padre);
        ps.setString(2, strFechaPadre);
        ps.setString(3, correo_padre);
        ps.setString(4, telefono_padre);
        ps.setString(5, celular_padre);
        ps.setString(6, nombres_nino);
        ps.setString(7, fecha_nacimiento_nino);
        ps.setString(8, tipoSangreNino);
        ps.setInt(9, alergias_nino);
        ps.setInt(10, vacunas_nino);
        ps.setInt(11, medicamentos_nino);
        ps.setString(12, dias);
        
        ps.setString(13, fecha_registro);
       
        return ps.executeUpdate();
    }
    public int delete(String strCondicion) throws ClassNotFoundException, SQLException{
        String Sentencia = "DELETE FROM guarderia WHERE cod_guarderia = ?";
        PreparedStatement ps = c.getConnection().prepareStatement(Sentencia);
        ps.setString(1, strCondicion);
        return ps.executeUpdate();
    }
    public int update(String value,String dbColNames[],int iCol,int id) throws ClassNotFoundException, SQLException{
        String sql = String.format("UPDATE guarderia SET %s = %d WHERE cod_guarderia = %d", 
                dbColNames[iCol], value, id);
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
         return ps.executeUpdate();
    }
}
