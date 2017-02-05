/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;


import DAT.DATregistro;
import Modelo.Registro;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class BLregistro {
     DATregistro manejadorRegistro = new DATregistro();
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  
    ArrayList<Registro>  lstRegistros ;
    public int Insertar(Registro objRegistro) throws ClassNotFoundException, SQLException {
        return manejadorRegistro.instertar(objRegistro.getNombres_padre(),
                dateFormat.format(objRegistro.getStrFechaPadre()),
                objRegistro.getCorreo_padre(),
                objRegistro.getTelefono_padre(),
                objRegistro.getCelular_padre(),
                objRegistro.getNombres_nino(),
                dateFormat.format(objRegistro.getFecha_nacimiento_nino()),
                objRegistro.getTipoSangreNino(),
                objRegistro.getAlergias_nino(),
                objRegistro.getVacunas_nino(),
                objRegistro.getMedicamentos_nino(),
                objRegistro.getDias(),
                
                dateFormat.format(objRegistro.getFecha_registro())
                
        );
    }
    public ArrayList<Registro> Consultar() throws ClassNotFoundException, SQLException, ParseException {
        lstRegistros = new ArrayList<>();
        
        int columnCount;
        int incremento = 0;
        ResultSet rs;
        rs = manejadorRegistro.Consultar();
        ResultSetMetaData rm = rs.getMetaData();
        columnCount = rm.getColumnCount();
        ArrayList<String> columnas = new ArrayList<>();
        for (int j = 1; j < columnCount+1; j++) {
            String columname = rm.getColumnName(j);
            columnas.add(columname);
        }
        while (rs.next()) {
            Registro m = new Registro();
            for (String columnames : columnas) {
                String value = rs.getString(columnames);
                if (columnames.equals("cod_guarderia")) {
                    m.setCod_registro(Integer.parseInt(value));
                }
                if (columnames.equals("nombres_padre")) {
                    m.setNombres_padre(value);
                }
                if (columnames.equals("fecha_nacimiento_padre")) {
                    m.setStrFechaPadre( dateFormat.parse(value));
                }
                if (columnames.equals("correo_padre")) {
                    m.setCorreo_padre(value);
                }
                if (columnames.equals("telefono_padre")) {
                    m.setTelefono_padre(value);
                }
                if (columnames.equals("celular_padre")) {
                    m.setCelular_padre(value);

                }
                if (columnames.equals("nombres_nino")) {
                    m.setNombres_nino(value);

                }
                if (columnames.equals("fecha_nacimiento_nino")) {
                    m.setFecha_nacimiento_nino(dateFormat.parse(value));

                }
                if (columnames.equals("tipo_sangre_nino")) {
                    m.setTipoSangreNino(value);

                }
                if (columnames.equals("alergias_nino")) {
                    m.setAlergias_nino(Integer.parseInt(value));

                }
                if (columnames.equals("vacunas_nino")) {
                    m.setVacunas_nino(Integer.parseInt(value));

                }
                if (columnames.equals("medicamentos_nino")) {
                    m.setMedicamentos_nino(Integer.parseInt(value));

                }
                if (columnames.equals("dias")) {
                    m.setDias(value);

                }
                if (columnames.equals("fecha_registro")) {
                    m.setFecha_registro(dateFormat.parse(value));

                }
 
            }
            lstRegistros.add(m);
            incremento = incremento + 1;
        }

        return lstRegistros;
    }

    

    public int Eliminar(String strCondicion) throws ClassNotFoundException, SQLException {
        return manejadorRegistro.delete(strCondicion);
    }
    public int update(String value,int iCol,int id) throws ClassNotFoundException, SQLException{
      
       String dbColNames[]= {"nombres_padre","fecha_nacimiento_padre","correo_padre","telefono_padre","celular_padre"
       ,"nombres_nino","fecha_nacimiento_nino","tipo_sangre_nino","alergias_nino","vacunas_nino","medicamentos_nino","dias","fecha_registro"};
         return manejadorRegistro.update(value,dbColNames,iCol,id);
    }
    
}
