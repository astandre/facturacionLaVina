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
public class Productos {
    private int cod_producto;
    private int cod_categoria;
    private String nombre_producto;
    private char tamano_producto; //definir characters aceptables
    private double precio_producto;

    public Productos(int cod_producto, int cod_categoria, String nombre_producto, char tamano_producto, double precio_producto) {
        this.cod_producto = cod_producto;
        this.cod_categoria = cod_categoria;
        this.nombre_producto = nombre_producto;
        this.tamano_producto = tamano_producto;
        this.precio_producto = precio_producto;
    }

    public Productos() {
    }

    /**
     * @return the cod_producto
     */
    public int getCod_producto() {
        return cod_producto;
    }

    /**
     * @param cod_producto the cod_producto to set
     */
    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    /**
     * @return the cod_categoria
     */
    public int getCod_categoria() {
        return cod_categoria;
    }

    /**
     * @param cod_categoria the cod_categoria to set
     */
    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    /**
     * @return the nombre_producto
     */
    public String getNombre_producto() {
        return nombre_producto;
    }

    /**
     * @param nombre_producto the nombre_producto to set
     */
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    /**
     * @return the tamano_producto
     */
    public char getTamano_producto() {
        return tamano_producto;
    }

    /**
     * @param tamano_producto the tamano_producto to set
     */
    public void setTamano_producto(char tamano_producto) {
        this.tamano_producto = tamano_producto;
    }

    /**
     * @return the precio_producto
     */
    public double getPrecio_producto() {
        return precio_producto;
    }

    /**
     * @param precio_producto the precio_producto to set
     */
    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }
    
}
