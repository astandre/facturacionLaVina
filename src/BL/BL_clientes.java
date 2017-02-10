/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.DAT_clientes;
import DAT.DAT_direccion;

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
public class BL_clientes {

    DAT_clientes manejadorClientes = new DAT_clientes();
    DAT_direccion manejadorDireccion = new DAT_direccion();
    ArrayList<Cliente> lstClientes;

    public int insertarClientes(Cliente objCliente) throws ClassNotFoundException, SQLException {
        int isClienteInserted;
        int isDireccionInserted;
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

        isDireccionInserted = manejadorDireccion.insertarDireccion(master, itc_calle, itc_barrio, itc_numCasa);

        return isDireccionInserted;
    }

    public ArrayList<Cliente> ConsultarClientes() throws ClassNotFoundException, SQLException, ParseException {
        lstClientes = new ArrayList<>();

        int columnCount;
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
            Cliente newCliente = new Cliente();
            for (String columnames : columnas) {
                String value = rs.getString(columnames);
                if (columnames.equals("COD_CLIENTE")) {
                    newCliente.setCod_cliente(Integer.parseInt(value));
                }
                if (columnames.equals("CEDULA_CLIENTE")) {
                    newCliente.setCedula_cliente(value);
                }
                if (columnames.equals("NOMBRE_CLIENTE")) {
                    newCliente.setNombre_cliente(value);
                }
                if (columnames.equals("APELLIDO_CLIENTE")) {
                    newCliente.setApellido_cliente(value);
                }
                if (columnames.equals("TELEFONO_FIJO_CLIENTE")) {
                    newCliente.setTelefono_fijo_cliente(value);
                }
                if (columnames.equals("TELEFONO_MOVIL_CLIENTE")) {
                    newCliente.setTelefono_movil_cliente(value);
                }
                if (columnames.equals("EMAIL_CLIENTE")) {
                    newCliente.setEmail_cliente(value);

                }

            }
            lstClientes.add(newCliente);
        }

        rs = manejadorDireccion.consultarDireccion();
        rm = rs.getMetaData();
        columnCount = rm.getColumnCount();
        columnas = new ArrayList<>();
        for (int j = 1; j < columnCount + 1; j++) {
            String columname = rm.getColumnName(j);
            columnas.add(columname);
        }

        int i = 0;
        while (rs.next()) {

            Direccion m = new Direccion();
            for (String columnames : columnas) {
                String value = rs.getString(columnames);
                if (columnames.equals("COD_CLIENTE_DIRECCION")) {
                    m.setCod_cliente_direccion(Integer.parseInt(value));
                }
                if (columnames.equals("CALLES_DIRECCION")) {
                    m.setCalles_direccion(value);
                }
                if (columnames.equals("BARRIO_DIRECCION")) {
                    m.setBarrio_direccion(value);
                }
                if (columnames.equals("NUMCASA_DIRECCION")) {
                    m.setNumCasa_direccion(value);
                }

            }
            lstClientes.get(i).setDireccion_cliente(m);
            i++;
        }
        return lstClientes;
    }

    public int eliminarCliente(String strCondicion) throws ClassNotFoundException, SQLException {
        int a = manejadorDireccion.eliminarDireccion(strCondicion);
        int b = manejadorClientes.eliminarCliente(strCondicion);
        int estado;
        if (a == 1 && b == 1) {
            estado = 1;
        } else {
            estado = 0;
        }
        return estado;
    }

    public int updateClientes(String newValue, int indexColum, int cod_cliente) throws ClassNotFoundException, SQLException {

        String dbColNames[] = {"COD_CLIENTE", "CEDULA_CLIENTE", 
            "NOMBRE_CLIENTE", "APELLIDO_CLIENTE",
            "TELEFONO_FIJO_CLIENTE", "TELEFONO_MOVIL_CLIENTE",
            "EMAIL_CLIENTE"};
        return manejadorClientes.update(newValue, dbColNames, indexColum, cod_cliente);
    }
}
