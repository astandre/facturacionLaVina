package BL;
import DAT.DAT_conexion;
import java.sql.SQLException;
public class BL_conexion {
    DAT_conexion manejadorConexion = new DAT_conexion();
    public void abrirConexion() throws ClassNotFoundException, SQLException{
        manejadorConexion.openConnection();
        
    }
    public void getConexion()throws ClassNotFoundException, SQLException{
        manejadorConexion.getConnection();
    }
    public void cerrarConexion() throws SQLException{
        manejadorConexion.closeConnection();
    }
}
