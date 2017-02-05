package Modelo;

import java.util.Date;





public class Registro {
    int cod_registro;
    String nombres_padre;
    Date strFechaPadre;

    String correo_padre;
    String telefono_padre;
    String celular_padre;
    String nombres_nino;
    Date fecha_nacimiento_nino;
    String tipoSangreNino;
    int alergias_nino;
    int vacunas_nino;
    int medicamentos_nino;
    String dias;
    Date fecha_registro;

    public Registro(String nombres_padre, Date strFechaPadre, String correo_padre, String telefono_padre, String celular_padre, String nombres_nino, Date fecha_nacimiento_nino, String tipoSangreNino, int alergias_nino, int vacunas_nino, int medicamentos_nino, String dias, Date fecha_registro) {
        this.nombres_padre = nombres_padre;
        this.strFechaPadre = strFechaPadre;
        this.correo_padre = correo_padre;
        this.telefono_padre = telefono_padre;
        this.celular_padre = celular_padre;
        this.nombres_nino = nombres_nino;
        this.fecha_nacimiento_nino = fecha_nacimiento_nino;
        this.tipoSangreNino = tipoSangreNino;
        this.alergias_nino = alergias_nino;
        this.vacunas_nino = vacunas_nino;
        this.medicamentos_nino = medicamentos_nino;
        this.dias = dias;
        this.fecha_registro = fecha_registro;
    }
    public Registro(){
        
    }

    public Registro(int cod_registro, String nombres_padre, String correo_padre, String telefono_padre, String celular_padre, String nombres_nino, String tipoSangreNino, int alergias_nino, int vacunas_nino, int medicamentos_nino, String dias) {
        this.cod_registro = cod_registro;
        this.nombres_padre = nombres_padre;
        this.correo_padre = correo_padre;
        this.telefono_padre = telefono_padre;
        this.celular_padre = celular_padre;
        this.nombres_nino = nombres_nino;
        this.tipoSangreNino = tipoSangreNino;
        this.alergias_nino = alergias_nino;
        this.vacunas_nino = vacunas_nino;
        this.medicamentos_nino = medicamentos_nino;
        this.dias = dias;
    }
    

    public int getCod_registro() {
        return cod_registro;
    }

    public String getNombres_padre() {
        return nombres_padre;
    }

    public Date getStrFechaPadre() {
        return strFechaPadre;
    }

    public String getCorreo_padre() {
        return correo_padre;
    }

    public String getTelefono_padre() {
        return telefono_padre;
    }

    public String getCelular_padre() {
        return celular_padre;
    }

    public String getNombres_nino() {
        return nombres_nino;
    }

    public Date getFecha_nacimiento_nino() {
        return fecha_nacimiento_nino;
    }

    public String getTipoSangreNino() {
        return tipoSangreNino;
    }

    public int getAlergias_nino() {
        return alergias_nino;
    }

    public int getVacunas_nino() {
        return vacunas_nino;
    }

    public int getMedicamentos_nino() {
        return medicamentos_nino;
    }

    public String getDias() {
        return dias;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setNombres_padre(String nombres_padre) {
        this.nombres_padre = nombres_padre;
    }

    public void setStrFechaPadre(Date strFechaPadre) {
        this.strFechaPadre = strFechaPadre;
    }

    public void setCorreo_padre(String correo_padre) {
        this.correo_padre = correo_padre;
    }

    public void setTelefono_padre(String telefono_padre) {
        this.telefono_padre = telefono_padre;
    }

    public void setCelular_padre(String celular_padre) {
        this.celular_padre = celular_padre;
    }

    public void setNombres_nino(String nombres_nino) {
        this.nombres_nino = nombres_nino;
    }

    public void setFecha_nacimiento_nino(Date fecha_nacimiento_nino) {
        this.fecha_nacimiento_nino = fecha_nacimiento_nino;
    }

    public void setTipoSangreNino(String tipoSangreNino) {
        this.tipoSangreNino = tipoSangreNino;
    }

    public void setAlergias_nino(int alergias_nino) {
        this.alergias_nino = alergias_nino;
    }

    public void setVacunas_nino(int vacunas_nino) {
        this.vacunas_nino = vacunas_nino;
    }

    public void setMedicamentos_nino(int medicamentos_nino) {
        this.medicamentos_nino = medicamentos_nino;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public void setCod_registro(int cod_registro) {
        this.cod_registro = cod_registro;
    }

    
}
