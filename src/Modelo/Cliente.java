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
public class Cliente {
    private int cod_cliente;
    private String cedula_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String telefono_fijo_cliente;
    private String telefono_movil_cliente;
    private String email_cliente;
    private Direccion direccion_cliente;
    

    public Cliente(int cod_cliente, String cedula_cliente, String nombre_cliente, String apellido_cliente, String telefono_fijo_cliente, String telefono_movil_cliente, String email_cliente, Direccion direccion_cliente) {
        this.cod_cliente = cod_cliente;
        this.cedula_cliente = cedula_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.telefono_fijo_cliente = telefono_fijo_cliente;
        this.telefono_movil_cliente = telefono_movil_cliente;
        this.email_cliente = email_cliente;
        this.direccion_cliente = direccion_cliente;
    }
     public Cliente( String cedula_cliente, String nombre_cliente, String apellido_cliente, String telefono_fijo_cliente, String telefono_movil_cliente, String email_cliente, Direccion direccion_cliente) {
        
        this.cedula_cliente = cedula_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.telefono_fijo_cliente = telefono_fijo_cliente;
        this.telefono_movil_cliente = telefono_movil_cliente;
        this.email_cliente = email_cliente;
        this.direccion_cliente = direccion_cliente;
    }

    public Cliente() {
    }
     
   
    /**
     * @return the cod_cliente
     */
    public int getCod_cliente() {
        return cod_cliente;
    }

    /**
     * @param cod_cliente the cod_cliente to set
     */
    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    /**
     * @return the cedula_cliente
     */
    public String getCedula_cliente() {
        return cedula_cliente;
    }

    /**
     * @param cedula_cliente the cedula_cliente to set
     */
    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    /**
     * @return the nombre_cliente
     */
    public String getNombre_cliente() {
        return nombre_cliente;
    }

    /**
     * @param nombre_cliente the nombre_cliente to set
     */
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    /**
     * @return the apellido_cliente
     */
    public String getApellido_cliente() {
        return apellido_cliente;
    }

    /**
     * @param apellido_cliente the apellido_cliente to set
     */
    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    /**
     * @return the telefono_fijo_cliente
     */
    public String getTelefono_fijo_cliente() {
        return telefono_fijo_cliente;
    }

    /**
     * @param telefono_fijo_cliente the telefono_fijo_cliente to set
     */
    public void setTelefono_fijo_cliente(String telefono_fijo_cliente) {
        this.telefono_fijo_cliente = telefono_fijo_cliente;
    }

    /**
     * @return the telefono_movil_cliente
     */
    public String getTelefono_movil_cliente() {
        return telefono_movil_cliente;
    }

    /**
     * @param telefono_movil_cliente the telefono_movil_cliente to set
     */
    public void setTelefono_movil_cliente(String telefono_movil_cliente) {
        this.telefono_movil_cliente = telefono_movil_cliente;
    }

    /**
     * @return the email_cliente
     */
    public String getEmail_cliente() {
        return email_cliente;
    }

    /**
     * @param email_cliente the email_cliente to set
     */
    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    /**
     * @return the direccion_cliente
     */
    public Direccion getDireccion_cliente() {
        return direccion_cliente;
    }

    /**
     * @param direccion_cliente the direccion_cliente to set
     */
    public void setDireccion_cliente(Direccion direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }
    
        
    
}
