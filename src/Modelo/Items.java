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
public class Items {
    private int cod_factura_items;
    private int cod_producto_items;
    private Productos item;
    private int cantidad_items;
    private double precio_total_item;
    private char llevar_item; 
    private String comentario;//s si n no

    public Items() {
    }

    public Items(int cod_factura_items, int cod_producto_items, Productos item, int cantidad_items, double precio_total_item, char llevar_item, String comentario) {
        this.cod_factura_items = cod_factura_items;
        this.cod_producto_items = cod_producto_items;
        this.item = item;
        this.cantidad_items = cantidad_items;
        this.precio_total_item = precio_total_item;
        this.llevar_item = llevar_item;
        this.comentario = comentario;
    }
       public Items(int cod_producto_items, Productos item, int cantidad_items, double precio_total_item, char llevar_item, String comentario) {
        this.cod_producto_items = cod_producto_items;
        this.item = item;
        this.cantidad_items = cantidad_items;
        this.precio_total_item = precio_total_item;
        this.llevar_item = llevar_item;
        this.comentario = comentario;
    }



    /**
     * @return the cod_factura_items
     */
    public int getCod_factura_items() {
        return cod_factura_items;
    }

    /**
     * @param cod_factura_items the cod_factura_items to set
     */
    public void setCod_factura_items(int cod_factura_items) {
        this.cod_factura_items = cod_factura_items;
    }

    /**
     * @return the cod_producto_items
     */
    public int getCod_producto_items() {
        return cod_producto_items;
    }

    /**
     * @param cod_producto_items the cod_producto_items to set
     */
    public void setCod_producto_items(int cod_producto_items) {
        this.cod_producto_items = cod_producto_items;
    }

    /**
     * @return the item
     */
    public Productos getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Productos item) {
        this.item = item;
    }

    /**
     * @return the cantidad_items
     */
    public int getCantidad_items() {
        return cantidad_items;
    }

    /**
     * @param cantidad_items the cantidad_items to set
     */
    public void setCantidad_items(int cantidad_items) {
        this.cantidad_items = cantidad_items;
    }

    /**
     * @return the precio_total_item
     */
    public double getPrecio_total_item() {
        return precio_total_item;
    }

    /**
     * @param precio_total_item the precio_total_item to set
     */
    public void setPrecio_total_item(double precio_total_item) {
        this.precio_total_item = precio_total_item;
    }

    /**
     * @return the llevar_item
     */
    public char getLlevar_item() {
        return llevar_item;
    }

    /**
     * @param llevar_item the llevar_item to set
     */
    public void setLlevar_item(char llevar_item) {
        this.llevar_item = llevar_item;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
