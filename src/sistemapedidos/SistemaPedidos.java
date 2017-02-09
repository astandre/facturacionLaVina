/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapedidos;
 import DAT.DAT_clientes;
import BL.*;
import Modelo.Cliente;
import Modelo.Direccion;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author USUARIO
 */
public class SistemaPedidos {

   
       public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
            BL_clientes clientesHanlder = new BL_clientes();
            Direccion objDireccion = new Direccion( "Ivan Riofrio", "Jesus del Gran Poder", "56");
            
     /*Cliente objCliente = new Cliente("1717836611",
             "Rommel Andre", 
             "Herrera",
             "2300211", 
             "0961561342", 
             "andreherrera97@hotmail.com",
             objDireccion);
          clientesHanlder.insertarClientes(objCliente);*/
          
           
           ArrayList<Cliente> lstClientes = new  ArrayList<>();
           lstClientes = clientesHanlder.ConsultarClientes();
                      for (int i = 0; i < lstClientes.size(); i++) {
                System.out.println("Nombre "+lstClientes.get(i).getNombre_cliente());
               System.out.println("Casa "+lstClientes.get(i).getDireccion_cliente().getCalles_direccion());
           }
 
           
    }
  
}
