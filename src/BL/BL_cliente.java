/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.DAT_cliente;

import Modelo.Cliente;
import Modelo.Direccion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Expression Andre is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class BL_cliente {

    DAT_cliente manejadorClientes = new DAT_cliente();

    ArrayList<Cliente> lstClientes;

    public int insertarCliente(Cliente objCliente) throws ClassNotFoundException, SQLException {
        int isClienteInserted;
        int isDireccionInserted = 0;
        int master = 0;
        ResultSet rs;

        //Insertar cabecera de Clientes
        isClienteInserted = manejadorClientes.instertarCliente(objCliente.getCedula_cliente(),
                objCliente.getNombre_cliente(),
                objCliente.getApellido_cliente(),
                objCliente.getTelefono_fijo_cliente(),
                objCliente.getTelefono_movil_cliente(),
                objCliente.getEmail_cliente());
        System.out.println("ClienteInserted:" + isClienteInserted);
        if (isClienteInserted == 1) {
            rs = manejadorClientes.getIdCliente();
            while (rs.next()) {
                //obtiene el id del registro master 
                master = rs.getInt(1);
            }
        }

        //insert la direccion de cliente
        Direccion objDireccion = objCliente.getDireccion_cliente();

        String itc_calle = objDireccion.getCalles_direccion();
        String itc_barrio = objDireccion.getBarrio_direccion();
        String itc_numCasa = objDireccion.getNumCasa_direccion();

        isDireccionInserted = manejadorClientes.insertarDireccion(master, itc_calle, itc_barrio, itc_numCasa);

        return isDireccionInserted;
    }

    public int insertarDireccion(Direccion objDireccion) throws ClassNotFoundException, SQLException {

        return manejadorClientes.insertarDireccion(objDireccion.getCod_cliente_direccion(), objDireccion.getCalles_direccion(),
                objDireccion.getBarrio_direccion(), objDireccion.getNumCasa_direccion());

    }

    public ArrayList<Cliente> Consultar() throws ClassNotFoundException, SQLException, ParseException {
        lstClientes = new ArrayList<>();

        int columnCount;
        int incremento = 0;
        ResultSet rs;
        rs = manejadorClientes.consultarClientes();
        ResultSetMetaData rm = rs.getMetaData();
        columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int j = 1; j < columnCount + 1; j++) {
            String columname = rm.getColumnName(j);
            columnas.add(columname);
        }
        while (rs.next()) {
            Cliente m = new Cliente();
            for (String columnames : columnas) {
                String value = rs.getString(columnames);
                if (columnames.equals("cod_cliente")) {
                    m.setCod_cliente(Integer.parseInt(value));
                }
                if (columnames.equals("cedula_cliente")) {
                    m.setCedula_cliente(value);
                }
                if (columnames.equals("cedula_cliente")) {
                    m.setCedula_cliente(value);
                }
                if (columnames.equals("apellido_cliente")) {
                    m.setApellido_cliente(value);
                }
                if (columnames.equals("telefono_fijo_cliente")) {
                    m.setTelefono_fijo_cliente(value);
                }
                if (columnames.equals("telefono_movil_cliente")) {
                    m.setTelefono_movil_cliente(value);

                }
                if (columnames.equals("email_cliente")) {
                    m.setEmail_cliente(value);

                }

            }
            lstClientes.add(m);
            incremento = incremento + 1;
        }

        return lstClientes;
    }

    /*public int Eliminar(String strCondicion) throws ClassNotFoundException, SQLException {
     return manejadorClientes.delete(strCondicion);
     }

     public int update(String value, int iCol, int id) throws ClassNotFoundException, SQLException {

     String dbColNames[] = {"nombres_padre", "fecha_nacimiento_padre", "correo_padre", "telefono_padre", "celular_padre", "nombres_nino", "fecha_nacimiento_nino", "tipo_sangre_nino", "alergias_nino", "vacunas_nino", "medicamentos_nino", "dias", "fecha_registro"};
     return manejadorClientes.update(value, dbColNames, iCol, id);
     }*/
}
