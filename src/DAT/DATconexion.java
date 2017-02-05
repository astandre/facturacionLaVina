package DAT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DATconexion {
public Connection con;
public Connection getConnection() throws ClassNotFoundException, SQLException {
    String driver ="com.mysql.jdbc.Driver";
    String url ="jdbc:mysql://localhost:3306/guarderia";
    Class.forName(driver);
    return DriverManager.getConnection(url, "root","");
    
}
public Connection openConnection() throws ClassNotFoundException, SQLException{
    con = getConnection();
    
    return con;
}
public void closeConnection() throws SQLException{
    con.close();
}
}