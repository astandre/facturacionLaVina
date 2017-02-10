/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BL;

import DAT.DAT_direccion;
import Modelo.Direccion;
import java.sql.SQLException;

/**
 *
 * @author Expression Andre is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class BL_direccion {
    DAT_direccion manejadorDireccion = new DAT_direccion();
public int insertarDireccion(Direccion objDireccion) throws ClassNotFoundException, SQLException {

        return manejadorDireccion.insertarDireccion(objDireccion.getCod_cliente_direccion(), objDireccion.getCalles_direccion(),
                objDireccion.getBarrio_direccion(), objDireccion.getNumCasa_direccion());

    }
public int updateDireccion(String newValue, int indexColum, int cod_cliente) throws ClassNotFoundException, SQLException {

        String dbColNames[] = {"COD_CLIENTE_DIRECCION", "CALLES_DIRECCION", 
            "BARRIO_DIRECCION", "NUMCASA_DIRECCION"};
        return manejadorDireccion.updateDireccion(newValue, dbColNames, indexColum, cod_cliente);
    }
}
