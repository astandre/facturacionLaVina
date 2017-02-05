package BL;
import DAT.DATconexion;
import java.sql.SQLException;
public class BLconexion {
    DATconexion manejadorConexion = new DATconexion();
    public void abrirConexion() throws ClassNotFoundException, SQLException{
        manejadorConexion.openConnection();
        
    }
    public void cerrarConexion() throws SQLException{
        manejadorConexion.closeConnection();
    }
}
