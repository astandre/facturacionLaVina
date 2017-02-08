/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.util.ArrayList;



/**
 *
 * @author USUARIO
 */
public class Factura {
    private int cod_factura;
    private int cod_cliente_factura;
    private Cliente cliente_factura;
    private Date fecha;
    private char metodo_pago_factura; //metodo pago aceptara valores:
    private double precio_total_factura;
    private double valor_extra_factura;
    private double valor_total_factura;
     private ArrayList<Items> lst_items_factura;

    public Factura(int cod_factura, int cod_cliente_factura, Cliente cliente_factura, Date fecha, char metodo_pago_factura, double precio_total_factura, double valor_extra_factura, double valor_total_factura, ArrayList<Items> lst_items_factura) {
        this.cod_factura = cod_factura;
        this.cod_cliente_factura = cod_cliente_factura;
        this.cliente_factura = cliente_factura;
        this.fecha = fecha;
        this.metodo_pago_factura = metodo_pago_factura;
        this.precio_total_factura = precio_total_factura;
        this.valor_extra_factura = valor_extra_factura;
        this.valor_total_factura = valor_total_factura;
        this.lst_items_factura = lst_items_factura;
    }

    /**
     * @return the cod_factura
     */
    public int getCod_factura() {
        return cod_factura;
    }

    /**
     * @param cod_factura the cod_factura to set
     */
    public void setCod_factura(int cod_factura) {
        this.cod_factura = cod_factura;
    }

    /**
     * @return the cod_cliente_factura
     */
    public int getCod_cliente_factura() {
        return cod_cliente_factura;
    }

    /**
     * @param cod_cliente_factura the cod_cliente_factura to set
     */
    public void setCod_cliente_factura(int cod_cliente_factura) {
        this.cod_cliente_factura = cod_cliente_factura;
    }

    /**
     * @return the cliente_factura
     */
    public Cliente getCliente_factura() {
        return cliente_factura;
    }

    /**
     * @param cliente_factura the cliente_factura to set
     */
    public void setCliente_factura(Cliente cliente_factura) {
        this.cliente_factura = cliente_factura;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the metodo_pago_factura
     */
    public char getMetodo_pago_factura() {
        return metodo_pago_factura;
    }

    /**
     * @param metodo_pago_factura the metodo_pago_factura to set
     */
    public void setMetodo_pago_factura(char metodo_pago_factura) {
        this.metodo_pago_factura = metodo_pago_factura;
    }

    /**
     * @return the precio_total_factura
     */
    public double getPrecio_total_factura() {
        return precio_total_factura;
    }

    /**
     * @param precio_total_factura the precio_total_factura to set
     */
    public void setPrecio_total_factura(double precio_total_factura) {
        this.precio_total_factura = precio_total_factura;
    }

    /**
     * @return the valor_extra_factura
     */
    public double getValor_extra_factura() {
        return valor_extra_factura;
    }

    /**
     * @param valor_extra_factura the valor_extra_factura to set
     */
    public void setValor_extra_factura(double valor_extra_factura) {
        this.valor_extra_factura = valor_extra_factura;
    }

    /**
     * @return the valor_total_factura
     */
    public double getValor_total_factura() {
        return valor_total_factura;
    }

    /**
     * @param valor_total_factura the valor_total_factura to set
     */
    public void setValor_total_factura(double valor_total_factura) {
        this.valor_total_factura = valor_total_factura;
    }

    /**
     * @return the lst_items_factura
     */
    public ArrayList<Items> getLst_items_factura() {
        return lst_items_factura;
    }

    /**
     * @param lst_items_factura the lst_items_factura to set
     */
    public void setLst_items_factura(ArrayList<Items> lst_items_factura) {
        this.lst_items_factura = lst_items_factura;
    }

    
    
}
