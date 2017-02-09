package DAT;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAT_clientes {

    DAT.DAT_conexion c = new DAT_conexion();

    public ResultSet consultarClientes() throws ClassNotFoundException, SQLException {
        Statement st = c.getConnection().createStatement();
        String sentencia = "SELECT * FROM clientes";
        ResultSet rs = st.executeQuery(sentencia);
        return rs;
    }

    public ResultSet getIdCliente() throws ClassNotFoundException, SQLException {
        String sentencia = "SELECT max(cod_cliente) FROM clientes";
        PreparedStatement pst = c.getConnection().prepareStatement(sentencia);
        return pst.executeQuery();
    }

    

    public int instertarCliente(String cedula_cliente, String nombre_cliente,
            String apellido_cliente, String telefono_fijo_cliente, String telefono_movil_cliente, String email_cliente) throws ClassNotFoundException, SQLException {
        String Sentencia = "INSERT INTO clientes (cedula_cliente, nombre_cliente, "
                + "apellido_cliente, telefono_fijo_cliente,telefono_movil_cliente,"
                + "email_cliente)"
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = c.getConnection().prepareStatement(Sentencia);
        ps.setString(1, cedula_cliente);
        ps.setString(2, nombre_cliente);
        ps.setString(3, apellido_cliente);
        ps.setString(4, telefono_fijo_cliente);
        ps.setString(5, telefono_movil_cliente);
        ps.setString(6, email_cliente);

        return ps.executeUpdate();
    }
    /*
    INSERT INTO `clientes`( `CEDULA_CLIENTE`, `NOMBRE_CLIENTE`, `APELLIDO_CLIENTE`,
    `TELEFONO_FIJO_CLIENTE`, `TELEFONO_MOVIL_CLIENTE`, `EMAIL_CLIENTE`) 
    VALUES ( "1717836611", "Rommel Andre", "Herrera", "2300211", "0961561342",
    "andreherrera97@hotmail.com")*/
    /*public int delete(String strCondicion) throws ClassNotFoundException, SQLException{
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
     }*/
}
