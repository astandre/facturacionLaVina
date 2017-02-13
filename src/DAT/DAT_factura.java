/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAT;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Expression Andre is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class DAT_factura {
 DAT.DAT_conexion c = new DAT_conexion();

    public ResultSet consultarFacturas() throws ClassNotFoundException, SQLException {
        Statement st = c.getConnection().createStatement();
        String sentencia = "SELECT * FROM facturas";
        ResultSet rs = st.executeQuery(sentencia);
        return rs;
    }
 
    public int insertarFactura(String num_factura, int cod_cliente_factura,
            Date fecha, String metodo_pago_factura, double precio_total_factura, double valor_extra_factura,double valor_total_factura) throws ClassNotFoundException, SQLException {
        String Sentencia = "INSERT INTO facturas ( NUM_FACTURA,COD_CLIENTE_FACTURA, "
                + "FECHA, METODO_PAGO_FACTURA,PRECIO_TOTAL_FACTURA,"
                + "VALOR_EXTRA_FACTURA)"
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = c.getConnection().prepareStatement(Sentencia);
        ps.setString(1, num_factura);
        ps.setInt(2, cod_cliente_factura);
        ps.setDate(3, fecha);
        ps.setString(4, metodo_pago_factura);
        ps.setDouble(5, precio_total_factura);
        ps.setDouble(6, valor_extra_factura);
        ps.setDouble(7, valor_total_factura);

        return ps.executeUpdate();
    }
      public ResultSet getIdFacturas() throws ClassNotFoundException, SQLException {
        String sentencia = "SELECT max(COD_FACTURA) FROM facturas";
        PreparedStatement pst = c.getConnection().prepareStatement(sentencia);
        return pst.executeQuery();
    }


   

   /* public int update(String newValue, String dbColNames[], int indexColumn, int cod_cliente) throws ClassNotFoundException, SQLException {
        String sql = String.format("UPDATE clientes SET %s = '%s' WHERE COD_CLIENTE = %d",
                dbColNames[indexColumn], newValue, cod_cliente);
        PreparedStatement ps = c.getConnection().prepareStatement(sql);
        return ps.executeUpdate();
    }*/
}
