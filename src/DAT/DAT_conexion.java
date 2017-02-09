package DAT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAT_conexion {
public Connection dbConecction;
public Connection getConnection() throws ClassNotFoundException, SQLException {
    String driver ="com.mysql.jdbc.Driver";
    String url ="jdbc:mysql://localhost:3306/sistema_pedidos";
    Class.forName(driver);
    return DriverManager.getConnection(url, "root","");
    
}
public Connection openConnection() throws ClassNotFoundException, SQLException{
    dbConecction = getConnection();
    
    return dbConecction;
}
public void closeConnection() throws SQLException{
    dbConecction.close();
}
}