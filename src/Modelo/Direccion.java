/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Direccion {
    private int cod_direccion;
    private int cod_cliente_direccion;
    private String calles_direccion;
    private String barrio_direccion;
    private String numCasa_direccion;

    
    public Direccion(int cod_direccion, int cod_cliente_direccion, String calles_direccion, String barrio_direccion, String numCasa_direccion) {
        this.cod_direccion = cod_direccion;
        this.cod_cliente_direccion = cod_cliente_direccion;
        this.calles_direccion = calles_direccion;
        this.barrio_direccion = barrio_direccion;
        this.numCasa_direccion = numCasa_direccion;
    }

    /**
     * @return the cod_direccion
     */
    public int getCod_direccion() {
        return cod_direccion;
    }

    /**
     * @param cod_direccion the cod_direccion to set
     */
    public void setCod_direccion(int cod_direccion) {
        this.cod_direccion = cod_direccion;
    }

    /**
     * @return the cod_cliente_direccion
     */
    public int getCod_cliente_direccion() {
        return cod_cliente_direccion;
    }

    /**
     * @param cod_cliente_direccion the cod_cliente_direccion to set
     */
    public void setCod_cliente_direccion(int cod_cliente_direccion) {
        this.cod_cliente_direccion = cod_cliente_direccion;
    }

    /**
     * @return the calles_direccion
     */
    public String getCalles_direccion() {
        return calles_direccion;
    }

    /**
     * @param calles_direccion the calles_direccion to set
     */
    public void setCalles_direccion(String calles_direccion) {
        this.calles_direccion = calles_direccion;
    }

    /**
     * @return the barrio_direccion
     */
    public String getBarrio_direccion() {
        return barrio_direccion;
    }

    /**
     * @param barrio_direccion the barrio_direccion to set
     */
    public void setBarrio_direccion(String barrio_direccion) {
        this.barrio_direccion = barrio_direccion;
    }

    /**
     * @return the numCasa_direccion
     */
    public String getNumCasa_direccion() {
        return numCasa_direccion;
    }

    /**
     * @param numCasa_direccion the numCasa_direccion to set
     */
    public void setNumCasa_direccion(String numCasa_direccion) {
        this.numCasa_direccion = numCasa_direccion;
    }
    
}
